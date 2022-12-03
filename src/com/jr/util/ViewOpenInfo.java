package com.jr.util;

import java.util.Date;

/**
 * 此类为工具类，用于查询开单视图内的内容
 */
public class ViewOpenInfo {
    private String no;                      //凭证编号
    private String aname;                   //收单企业名称
    private double amount;                  //凭证金额
    private String ename;                   //开单企业名称
    private String iname;                   //金融机构名称
    private String createTime;              //开单日期
    private String expiryTime;              //到期日期
    private String upLinkAddress;           //上链地址
    private String status;                  //处理状态
    private String acquirerEnterpriseId;    //收单企业id
    private String enterPriseId;            //开单企业id
    private String id;                      //开单id

    public ViewOpenInfo() {
    }

    public ViewOpenInfo(String no, String aname, double amount, String ename, String iname, String createTime, String expiryTime, String upLinkAddress, String status, String acquirerEnterpriseId, String enterPriseId, String id) {
        this.no = no;
        this.aname = aname;
        this.amount = amount;
        this.ename = ename;
        this.iname = iname;
        this.createTime = createTime;
        this.expiryTime = expiryTime;
        this.upLinkAddress = upLinkAddress;
        this.status = status;
        this.acquirerEnterpriseId = acquirerEnterpriseId;
        this.enterPriseId = enterPriseId;
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
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

    public String getUpLinkAddress() {
        return upLinkAddress;
    }

    public void setUpLinkAddress(String upLinkAddress) {
        this.upLinkAddress = upLinkAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAcquirerEnterpriseId() {
        return acquirerEnterpriseId;
    }

    public void setAcquirerEnterpriseId(String acquirerEnterpriseId) {
        this.acquirerEnterpriseId = acquirerEnterpriseId;
    }

    public String getEnterPriseId() {
        return enterPriseId;
    }

    public void setEnterPriseId(String enterPriseId) {
        this.enterPriseId = enterPriseId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ViewOpenInfo{" +
                "no='" + no + '\'' +
                ", aname='" + aname + '\'' +
                ", amount='" + amount + '\'' +
                ", ename='" + ename + '\'' +
                ", iname='" + iname + '\'' +
                ", createTime='" + createTime + '\'' +
                ", expiryTime='" + expiryTime + '\'' +
                ", upLinkAddress='" + upLinkAddress + '\'' +
                ", status='" + status + '\'' +
                ", acquirerEnterpriseId='" + acquirerEnterpriseId + '\'' +
                ", enterPriseId='" + enterPriseId + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
