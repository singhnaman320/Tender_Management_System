package com.tms.bean;

public class Tender {
    private int tenderId;
    private String category;
    private String deadline;
    private int amount;

    @Override
    public String toString() {
        return "Tender{" +
                "tenderId=" + tenderId +
                ", category='" + category + '\'' +
                ", deadline='" + deadline + '\'' +
                ", amount=" + amount +
                '}';
    }

    public Tender(int tenderId, String category, String deadline, int amount) {
        this.tenderId = tenderId;
        this.category = category;
        this.deadline = deadline;
        this.amount = amount;
    }

    public int getTenderId() {
        return tenderId;
    }

    public void setTenderId(int tenderId) {
        this.tenderId = tenderId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Tender(String category, int ammount) {
        super();
        this.category = category;
        this.amount = ammount;
    }

}
