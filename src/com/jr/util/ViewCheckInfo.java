package com.jr.util;

import java.util.Date;

/**
 * 此类为工具类，用于查询复核视图内的内容
 */
public class ViewCheckInfo {
    private String no;                      //凭证编号
    private String status;                  //票据状态
    private String ename;                   //开单企业名称
    private String esuc;                    //开单企业统一社会信用代码
    private String aname;                   //收单企业名称
    private String asuc;                    //收单企业统一社会信用代码
    private double amount;                  //凭证金额
    private String iname;                   //金融机构名称
    private String createTime;                //开单时间
    private String expiryTime;                //到期时间
    private int timePoor;                   //时间差
    private String paymentInterestType;     //付息方式
    private String ticketRemark;            //开单备注
    private String remark;                  //审核备注
    private String ticketOpenId;            //开单id

    public ViewCheckInfo() {
    }

    public ViewCheckInfo(String no, String status, String ename, String esuc, String aname, String asuc, double amount, String iname, String createTime, String expiryTime, int timePoor, String paymentInterestType, String ticketRemark, String remark, String ticketOpenId) {
        this.no = no;
        this.status = status;
        this.ename = ename;
        this.esuc = esuc;
        this.aname = aname;
        this.asuc = asuc;
        this.amount = amount;
        this.iname = iname;
        this.createTime = createTime;
        this.expiryTime = expiryTime;
        this.timePoor = timePoor;
        this.paymentInterestType = paymentInterestType;
        this.ticketRemark = ticketRemark;
        this.remark = remark;
        this.ticketOpenId = ticketOpenId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getTimePoor() {
        return timePoor;
    }

    public void setTimePoor(int timePoor) {
        this.timePoor = timePoor;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEsuc() {
        return esuc;
    }

    public void setEsuc(String esuc) {
        this.esuc = esuc;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getAsuc() {
        return asuc;
    }

    public void setAsuc(String asuc) {
        this.asuc = asuc;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(String expiryTime) {
        this.expiryTime = expiryTime;
    }

    public String getPaymentInterestType() {
        return paymentInterestType;
    }

    public void setPaymentInterestType(String paymentInterestType) {
        this.paymentInterestType = paymentInterestType;
    }

    public String getTicketRemark() {
        return ticketRemark;
    }

    public void setTicketRemark(String ticketRemark) {
        this.ticketRemark = ticketRemark;
    }

    public String getTicketOpenId() {
        return ticketOpenId;
    }

    public void setTicketOpenId(String ticketOpenId) {
        this.ticketOpenId = ticketOpenId;
    }

    @Override
    public String toString() {
        return "ViewCheckInfo{" +
                "no='" + no + '\'' +
                ", status='" + status + '\'' +
                ", ename='" + ename + '\'' +
                ", esuc='" + esuc + '\'' +
                ", aname='" + aname + '\'' +
                ", asuc='" + asuc + '\'' +
                ", amount=" + amount +
                ", iname='" + iname + '\'' +
                ", createTime=" + createTime +
                ", expiryTime=" + expiryTime +
                ", paymentInterestType='" + paymentInterestType + '\'' +
                ", ticketRemark='" + ticketRemark + '\'' +
                ", ticketOpenId='" + ticketOpenId + '\'' +
                '}';
    }
}
