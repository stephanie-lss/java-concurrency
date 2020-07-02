package com.lss.phase2.ch11;

/**
 * @author LiSheng
 * @date 2020/6/27 15:15
 */
public class QueryFromDBAction {

    public void execute() {
        try {
            Thread.sleep(1000L);
            String name = "Alex" + Thread.currentThread().getName();
            ActionContext.getActionContext().getContext().setName(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
