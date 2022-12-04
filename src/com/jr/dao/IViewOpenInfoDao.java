package com.jr.dao;

import com.jr.entry.Ticketopen;
import com.jr.util.PageHelper;
import com.jr.util.ViewOpenInfo;

import java.util.List;

public interface IViewOpenInfoDao {
    /**
     * 根据条件查询数据总条数
     */
    public int queryTotalNumByConditions(String str);

    /**
     * 根据条件查询开单中状态的数据总条数
     */
    public int queryTotalNumByStatus(String str);

    /**
     * 查询当前页的数据信息(所有状态)
     */
    public List<ViewOpenInfo> queryAllInfoByCurrentPage(PageHelper pageHelper,String str);

    /**
     * 查询当前页的复核信息(状态为开单中)
     */
    public List<ViewOpenInfo> queryAllOnTheBillByCurrentPage(PageHelper pageHelper,String str);

    /**
     * 根据开单id查询某一条信息
     */
    public ViewOpenInfo getInfoById(int id);

}
