package com.tms.bean;

public class Bid {

    private int bid;
    private int btid;
    private int amount;
    private int status;

    @Override
    public String toString() {
        return "Bid{" +
                "bid=" + bid +
                ", btid=" + btid +
                ", amount=" + amount +
                ", status=" + status +
                '}';
    }

    public Bid(int bid, int btid, int amount, int status) {
        this.bid = bid;
        this.btid = btid;
        this.amount = amount;
        this.status = status;
    }

    public Bid() {
        super();
    }
    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getBtid() {
        return btid;
    }

    public void setBtid(int btid) {
        this.btid = btid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
