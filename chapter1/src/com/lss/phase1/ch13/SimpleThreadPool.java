package com.lss.phase1.ch13;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author LiSheng
 * @date 2020/6/18 19:10
 */
public class SimpleThreadPool extends Thread {

    //线程池线程数目
    private int size;

    //拒绝策略阈值
    private final int queueSize;

    private static final int DEFAULT_TASK_QUEUE_SIZE = 2000;

    private static volatile int seq = 0;

    //线程前缀
    private static final String THREAD_PREFIX = "SIMPLE_THREAD_POOL-";

    //线程组
    private static final ThreadGroup GROUP = new ThreadGroup("Pool_Group");

    //任务队列
    private final static LinkedList<Runnable> TASK_QUEUE = new LinkedList<>();

    private static final List<WorkerTask> THREAD_QUEUE = new ArrayList<>();

    private final DiscardPolicy discardPolicy;

    //min <= active <= max
    private int min;

    private int max;

    private int active;

    //默认拒绝策略
    public final static DiscardPolicy DEFAULT_DISCARD_POLICY = () -> {
        throw new DiscardException("Discard This Task.");
    };

    private volatile boolean destroy = false;

    //构造函数-（初始化线程数，初始化任务数，拒绝策略）
    public SimpleThreadPool() {
        this(4, 8, 12, DEFAULT_TASK_QUEUE_SIZE, DEFAULT_DISCARD_POLICY);
    }

    public SimpleThreadPool(int min, int active, int max, int queueSize, DiscardPolicy discardPolicy) {
        this.min = min;
        this.active = active;
        this.max = max;
        this.queueSize = queueSize;
        this.discardPolicy = discardPolicy;
        //初始化线程池
        init();
    }

    //pool
    private void init() {
        //创建线程
        /*for (int i = 0; i < size; i++) {
            createWorkTask();
        }*/
        for (int i = 0; i < this.min; i++) {
            createWorkTask();
        }
        this.size = min;
        this.start();
    }

    //提交任务
    //pool
    public void submit(Runnable runnable) {
        if (destroy) {
            throw new IllegalStateException("The thread pool already destroy and not allow submit task.");
        }

        //写操作
        synchronized (TASK_QUEUE) {
            if (TASK_QUEUE.size() > queueSize) {
                discardPolicy.discard();
            }
            TASK_QUEUE.addLast(runnable);
            TASK_QUEUE.notifyAll();
        }
    }

    @Override
    public void run() {
        while (!destroy) {
            System.out.printf("Pool Min:%d, Active:%d, Max:%d, Current:%d, QueueSize:%d\n",
                    this.min, this.active, this.max, this.size, TASK_QUEUE.size());
            try {
                Thread.sleep(5_000);
                if (TASK_QUEUE.size() > active && size < active) {
                    for (int i = size; i < active; i++) {
                        createWorkTask();
                    }
                    System.out.println("The pool incremented.");
                    this.size = active;
                } else if (TASK_QUEUE.size() > max && size < max) {
                    for (int i = size; i < max; i++) {
                        createWorkTask();
                    }
                    System.out.println("The pool increment to max.");
                    this.size = max;
                }

                if (TASK_QUEUE.isEmpty() && this.size > active) {
                    System.out.println("**********REDUCE-THREAD********");
                    synchronized (THREAD_QUEUE) {
                        int releaseSize = size - active;
                        for (Iterator<WorkerTask> it = THREAD_QUEUE.iterator(); it.hasNext(); ) {
                            if (releaseSize <= 0) {
                                break;
                            }
                            WorkerTask task = it.next();
                            task.close();
                            task.interrupt();
                            it.remove();
                            releaseSize--;
                        }
                        this.size = active;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //在线程池中创建线程
    //pool
    private void createWorkTask() {
        WorkerTask task = new WorkerTask(GROUP, THREAD_PREFIX + (seq++));
        task.start();
        THREAD_QUEUE.add(task);
    }

    //pool
    public void shutdown() throws InterruptedException {
        while (!TASK_QUEUE.isEmpty()) {
            Thread.sleep(50);
        }

        int initVal = THREAD_QUEUE.size();
        while (initVal > 0) {
            for (WorkerTask task : THREAD_QUEUE) {
                if (task.getTaskState() == TaskState.BLOCKED) {
                    task.interrupt();
                    task.close();
                    initVal--;
                } else {
                    Thread.sleep(10);
                }
            }
        }

        System.out.println(GROUP.activeCount());

        this.destroy = true;
        System.out.println("The thread pool disposed.");
    }

    public int getSize() {
        return size;
    }

    public int getQueueSize() {
        return queueSize;
    }

    public boolean isDestroy() {
        return this.destroy;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getActive() {
        return active;
    }

    //线程状态枚举类
    private enum TaskState {
        FREE, RUNNING, BLOCKED, DEAD
    }

    //自定义异常
    private static class DiscardException extends RuntimeException {
        public DiscardException(String message) {
            super(message);
        }
    }

    //拒绝策略
    public interface DiscardPolicy {

        void discard() throws DiscardException;
    }

    private static class WorkerTask extends Thread {
        //线程默认状态下为Free
        private volatile TaskState taskState = TaskState.FREE;

        //如果调用此构造函数表示将该名字为name的线程放入group线程组中
        public WorkerTask(ThreadGroup group, String name) {
            super(group, name);
        }

        //获取线程状态
        public TaskState getTaskState() {
            return this.taskState;
        }

        @Override
        public void run() {
            //只要线程状态不为DEAD
            OUTER:
            while (this.taskState != TaskState.DEAD) {
                Runnable runnable;
                //从任务队列中取任务 -> 读操作
                synchronized (TASK_QUEUE) {
                    while (TASK_QUEUE.isEmpty()) {
                        try {
                            taskState = TaskState.BLOCKED;
                            TASK_QUEUE.wait();
                        } catch (InterruptedException e) {
                            System.out.println("Closed.");
                            break OUTER;
                        }
                    }
                    runnable = TASK_QUEUE.removeFirst();
                }
                //执行任务的时候不需要锁，不然会长时间持有锁而导致提交任务的方法无法抢到锁
                if (runnable != null) {
                    taskState = TaskState.RUNNING;
                    //执行任务
                    runnable.run();
                    taskState = TaskState.FREE;
                }
            }
        }

        //关闭线程
        public void close() {
            this.taskState = TaskState.DEAD;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleThreadPool threadPool = new SimpleThreadPool();
        IntStream.rangeClosed(0, 100).forEach(i -> {
            threadPool.submit(() -> {
                System.out.println("The runnable " + i + " be serviced by " + Thread.currentThread().getName() + " start.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("The runnable " + i + " be serviced by " + Thread.currentThread().getName() + " finished.");
            });
        });
        Thread.sleep(10000);
        threadPool.shutdown();
/*        threadPool.submit(() -> {
            System.out.println("runnable..");
        });*/
    }
}
