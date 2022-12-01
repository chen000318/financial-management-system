package com.jr.biz;

import com.jr.entry.Reviewrecord;

public interface IReviewrecordBiz {
    /*
    * 添加审核记录
    * */
    public int addReviewrecord(Reviewrecord reviewrecord);

    /*
    * 根据开单id获取审核记录信息
    * */
    public Reviewrecord getReviewrecord(int ticketId);
}
