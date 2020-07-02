package com.lss.phase2.ch11;

/**
 * @author LiSheng
 * @date 2020/6/27 15:16
 */
public class Context {
    private String name;

    protected String cardId;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCardId() {
        return cardId;
    }
}
