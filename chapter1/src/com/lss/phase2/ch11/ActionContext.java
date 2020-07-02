package com.lss.phase2.ch11;

/**
 * @author LiSheng
 * @date 2020/6/27 15:44
 */
public class ActionContext {
    private static final ThreadLocal<Context> threadLocal = ThreadLocal.withInitial(Context::new);

    private static class InnerActionContext {
        private static ActionContext actionContext = new ActionContext();
    }

    public static ActionContext getActionContext() {
        return InnerActionContext.actionContext;
    }

    public Context getContext() {
        return threadLocal.get();
    }
}
