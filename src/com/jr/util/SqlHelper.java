package com.jr.util;

import java.util.Date;

public class SqlHelper {
    private String no;     //凭证编号
    private String acquirerEnterPriseId;       //收单企业id
    private String enterPriseId;        //开单企业id
    private String createTime;            //开单日期
    private String status;              //票据状态
    private String amountMax;         //最高凭证金额
    private String amountMin;         //最低凭证金额

    public SqlHelper() {
    }

    /**
     *
     * @param no    //初始化编号
     * @param acquirerEnterPriseId      //初始化企业id
     * @param enterPriseId      //初始化开单企业id
     * @param createTime        //初始化开单日期
     * @param status            //初始化票据状态
     * @param amountMax         //初始化最高凭证金额
     * @param amountMin         //初始化最低凭证金额
     */
    public SqlHelper(String no, String acquirerEnterPriseId, String enterPriseId, String createTime, String status, String amountMax, String amountMin) {
        this.no = no;
        this.acquirerEnterPriseId = acquirerEnterPriseId;
        this.enterPriseId = enterPriseId;
        this.createTime = createTime;
        this.status = status;
        this.amountMax = amountMax;
        this.amountMin = amountMin;
    }
    public String sqlConcat(){
        return (no==null||no==""?"":" AND no="+no)+(acquirerEnterPriseId==null||acquirerEnterPriseId==""?"":" AND acquirer_enterprise_id="+acquirerEnterPriseId)+
                (enterPriseId==null||enterPriseId==""?"":" AND enterprise_id="+enterPriseId)+(createTime==null||createTime==""?"":" AND create_time="+createTime)+
                (status==null||status==""?"":" AND status="+status)+(amountMax==null||amountMax==""?"":" AND amount<="+amountMax)+
                (amountMin==null||amountMin==""?"":" AND amount>="+amountMin);
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getAcquirerEnterPriseId() {
        return acquirerEnterPriseId;
    }

    public void setAcquirerEnterPriseId(String acquirerEnterPriseId) {
        this.acquirerEnterPriseId = acquirerEnterPriseId;
    }

    public String getEnterPriseId() {
        return enterPriseId;
    }

    public void setEnterPriseId(String enterPriseId) {
        this.enterPriseId = enterPriseId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAmountMax() {
        return amountMax;
    }

    public void setAmountMax(String amountMax) {
        this.amountMax = amountMax;
    }

    public String getAmountMin() {
        return amountMin;
    }

    public void setAmountMin(String amountMin) {
        this.amountMin = amountMin;
    }

    @Override
    public String toString() {
        return "SqlHelper{" +
                "no=" + no +
                ", acquirerEnterPriseId='" + acquirerEnterPriseId + '\'' +
                ", enterPriseId='" + enterPriseId + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                ", amountMax=" + amountMax +
                ", amountMin=" + amountMin +
                '}';
    }
}
