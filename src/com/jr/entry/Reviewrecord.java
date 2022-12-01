package com.jr.entry;

import java.util.Date;

public class Reviewrecord {
    private int id;
    private int ticketOpenId;
    private int creatorId;
    private Date createTime;
    private String reviewStatus;
    private String remark;

    public Reviewrecord(int id, int ticketOpenId, int creatorId, Date createTime, String reviewStatus, String remark) {
        this.id = id;
        this.ticketOpenId = ticketOpenId;
        this.creatorId = creatorId;
        this.createTime = createTime;
        this.reviewStatus = reviewStatus;
        this.remark = remark;
    }

    public Reviewrecord() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTicketOpenId() {
        return ticketOpenId;
    }

    public void setTicketOpenId(int ticketOpenId) {
        this.ticketOpenId = ticketOpenId;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(String reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Reviewrecord{" +
                "id=" + id +
                ", ticketOpenId=" + ticketOpenId +
                ", creatorId=" + creatorId +
                ", createTime=" + createTime +
                ", reviewStatus='" + reviewStatus + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
