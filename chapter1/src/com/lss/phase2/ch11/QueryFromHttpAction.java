package com.lss.phase2.ch11;

/**
 * @author LiSheng
 * @date 2020/6/27 15:26
 */
public class QueryFromHttpAction {
    public void execute() {
        Context context = ActionContext2.getActionContext().getContext();
        String cardId = getCardId(context.getName());
        context.setCardId(cardId);
    }

    private String getCardId(String name) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "23456789" + name;
    }
}
