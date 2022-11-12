package com.tms.bean;

public class Vendor {

    private int vId;
    private String vName;
    private  String  vEmail;
    private  String  vPassword;
    private int vmobile;
    private String vaddress;

    @Override
    public String toString() {
        return "Vendor{" +
                "vId=" + vId +
                ", vName='" + vName + '\'' +
                ", vEmail='" + vEmail + '\'' +
                ", vPassword='" + vPassword + '\'' +
                ", vmobile=" + vmobile +
                ", vaddress='" + vaddress + '\'' +
                '}';
    }

    public Vendor(int vId, String vName, String vEmail, String vPassword, int vmobile, String vaddress) {
        this.vId = vId;
        this.vName = vName;
        this.vEmail = vEmail;
        this.vPassword = vPassword;
        this.vmobile = vmobile;
        this.vaddress = vaddress;
    }

    public int getvId() {
        return vId;
    }

    public void setvId(int vId) {
        this.vId = vId;
    }

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    public String getvEmail() {
        return vEmail;
    }

    public void setvEmail(String vEmail) {
        this.vEmail = vEmail;
    }

    public String getvPassword() {
        return vPassword;
    }

    public void setvPassword(String vPassword) {
        this.vPassword = vPassword;
    }

    public int getVmobile() {
        return vmobile;
    }

    public void setVmobile(int vmobile) {
        this.vmobile = vmobile;
    }

    public String getVaddress() {
        return vaddress;
    }

    public void setVaddress(String vaddress) {
        this.vaddress = vaddress;
    }
}
