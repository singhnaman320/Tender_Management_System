package com.tms.bean;

public class TenderStatus {

    private int vendorId;
    private String vendorName;
    private int tenderId;
    private String tenderName;
    private int tenderAmount;
    private String statusBid;

    @Override
    public String toString() {
        return "Status{" +
                "venderiId=" + vendorId +
                ", venderName='" + vendorName + '\'' +
                ", tenderId=" + tenderId +
                ", tenderName='" + tenderName + '\'' +
                ", tenderAmount=" + tenderAmount +
                ", statusBid='" + statusBid + '\'' +
                '}';
    }
    public TenderStatus(){

    };

    public TenderStatus(int vendorId, String vendorName, int tenderId, String tenderName, int tenderAmount, String statusBid) {
        this.vendorId = vendorId;
        this.vendorName = vendorName;
        this.tenderId = tenderId;
        this.tenderName = tenderName;
        this.tenderAmount = tenderAmount;
        this.statusBid = statusBid;
    }

    public int getVenderiId() {
        return vendorId;
    }

    public void setVenderiId(int venderiId) {
        this.vendorId = venderiId;
    }

    public String getVenderName() {
        return vendorName;
    }

    public void setVenderName(String venderName) {
        this.vendorName = venderName;
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
