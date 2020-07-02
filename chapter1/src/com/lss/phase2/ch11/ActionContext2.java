package com.lss.phase2.ch11;

/**
 * @author LiSheng
 * @date 2020/6/27 15:44
 */
public class ActionContext2 {
    private static final ThreadLocal<Context> threadLocal = ThreadLocal.withInitial(Context::new);

    public static ActionContext2 getActionContext() {
        return new ActionContext2();
    }

    public Context getContext() {
        return threadLocal.get();
    }
}
