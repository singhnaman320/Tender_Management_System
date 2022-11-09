package com.tms.bean;

public class Status {

    private int venderiId;
    private String venderName;
    private int tenderId;
    private String tenderName;
    private int tenderAmount;
    private String statusBid;

    @Override
    public String toString() {
        return "Status{" +
                "venderiId=" + venderiId +
                ", venderName='" + venderName + '\'' +
                ", tenderId=" + tenderId +
                ", tenderName='" + tenderName + '\'' +
                ", tenderAmount=" + tenderAmount +
                ", statusBid='" + statusBid + '\'' +
                '}';
    }
    public Status(){

    };

    public Status(int venderiId, String venderName, int tenderId, String tenderName, int tenderAmount, String statusBid) {
        this.venderiId = venderiId;
        this.venderName = venderName;
        this.tenderId = tenderId;
        this.tenderName = tenderName;
        this.tenderAmount = tenderAmount;
        this.statusBid = statusBid;
    }

    public int getVenderiId() {
        return venderiId;
    }

    public void setVenderiId(int venderiId) {
        this.venderiId = venderiId;
    }

    public String getVenderName() {
        return venderName;
    }

    public void setVenderName(String venderName) {
        this.venderName = venderName;
    }

    public int getTenderId() {
        return tenderId;
    }

    public void setTenderId(int tenderId) {
        this.tenderId = tenderId;
    }

    public String getTenderName() {
        return tenderName;
    }

    public void setTenderName(String tenderName) {
        this.tenderName = tenderName;
    }

    public int getTenderAmount() {
        return tenderAmount;
    }

    public void setTenderAmount(int tenderAmount) {
        this.tenderAmount = tenderAmount;
    }

    public String getStatusBid() {
        return statusBid;
    }

    public void setStatusBid(String statusBid) {
        this.statusBid = statusBid;
    }
}
