package com.cqupt.test;

public class CountOperate extends Thread {
	
    public CountOperate() {
		System.out.println("=========CountOperate start============");
		System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
		System.out.println("Thread.currentThread().isAlive() = " + Thread.currentThread().isAlive());
		System.out.println("this.getName() = " + this.getName());
		System.out.println("this.isAlive() = " + this.isAlive());
		System.out.println("this.currentThread().getName() = " + this.currentThread().getName());
		System.out.println("this.currentThread().isAlive() = " + this.currentThread().isAlive());
		System.out.println("=========CountOperate end  ============");
	}
 
	@Override
	public void run() {
		System.out.println("=========run start============");
		System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
		System.out.println("Thread.currentThread().isAlive() = " + Thread.currentThread().isAlive());
		System.out.println("this.getName() = " + this.getName());
		System.out.println("this.isAlive() = " + this.isAlive());
		System.out.println("Thread.currentThread() == this " + (Thread.currentThread() == this));
		System.out.println("Thread.currentThread() == this aaa " + (Thread.currentThread() == this.currentThread()));
		System.out.println("this.currentThread().getName() = " + this.currentThread().getName());
		System.out.println("this.currentThread().isAlive() = " + this.currentThread().isAlive());
		System.out.println("=========run end  ============");
		System.out.println(this.currentThread());
		System.out.println(Thread.currentThread());
	}	
}