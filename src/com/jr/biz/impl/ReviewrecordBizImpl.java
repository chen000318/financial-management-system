package com.jr.biz.impl;

import com.jr.biz.IReviewrecordBiz;
import com.jr.dao.impl.ReviewrecordDaoImpl;
import com.jr.entry.Reviewrecord;

public class ReviewrecordBizImpl implements IReviewrecordBiz {
    ReviewrecordDaoImpl reviewrecordDao=new ReviewrecordDaoImpl();
    /**
     * 添加审核记录
     * @param reviewrecord
     * @return
     */
    @Override
    public int addReviewrecord(Reviewrecord reviewrecord) {
        return reviewrecordDao.insertReviewrecord(reviewrecord);
    }

    /**
     * 根据开单id获取审核记录信息
     * @param ticketId
     * @return
     */
    @Override
    public Reviewrecord getReviewrecord(int ticketId) {
        return reviewrecordDao.queryReviewrecord(ticketId);
    }


}
