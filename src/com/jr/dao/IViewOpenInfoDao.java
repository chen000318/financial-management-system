package com.jr.dao;

import com.jr.util.PageHelper;
import com.jr.util.ViewOpenInfo;

import java.util.List;

public interface IViewOpenInfoDao {
    /**
     * 查询数据的总条数
     */
    public int queryTotalNum();

    /**
     * 查询当前页的数据信息(所有状态)
     */
    public List<ViewOpenInfo> queryAllInfoByCurrentPage(PageHelper pageHelper,String str);

    /**
     * 查询当前页的复核信息(状态为开单中)
     */
    public List<ViewOpenInfo> queryAllOnTheBillByCurrentPage(PageHelper pageHelper,String str);
}
