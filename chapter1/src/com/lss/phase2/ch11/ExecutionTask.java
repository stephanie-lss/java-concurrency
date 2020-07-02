package com.lss.phase2.ch11;

/**
 * @author LiSheng
 * @date 2020/6/27 15:14
 */
public class ExecutionTask implements Runnable {

    private QueryFromDBAction queryAction = new QueryFromDBAction();

    private QueryFromHttpAction httpAction = new QueryFromHttpAction();

    @Override
    public void run() {
        queryAction.execute();
        httpAction.execute();

        Context context = ActionContext.getActionContext().getContext();
        System.out.println("The Name is " + context.getName() + " and CardId is " + context.getCardId());
    }
}
