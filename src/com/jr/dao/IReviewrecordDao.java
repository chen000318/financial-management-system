package com.jr.dao;

import com.jr.entry.Reviewrecord;

public interface IReviewrecordDao {
    /*
     * 插入审核记录
     * */
    public int insertReviewrecord(Reviewrecord reviewrecord);

    /*
     * 根据开单id查询审核记录信息
     * */
    public Reviewrecord queryReviewrecord(int ticketId);

}
