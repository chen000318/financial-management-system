package com.jr.biz;

import com.jr.entry.Ticketopen;
import com.jr.util.PageHelper;
import com.jr.util.ViewOpenInfo;

import java.util.List;

public interface IViewOpenInfoBiz {
    /**
     * 根据条件获取数据总条数
     */
    public int getTotalNumByConditions(String str);


    /**
     * 根据条件获取开单中状态的数据总条数
     */
    public int getTotalNumByStatus(String str);

    /**
     * 获取当前页的全部信息(所有状态)
     */
    public List<ViewOpenInfo> getAllInfoByCurrentPage(PageHelper pageHelper,String str);

    /**
     * 获取当前页的复核信息(状态为开单中)
     */
    public List<ViewOpenInfo> getAllOnTheBillByCurrentPage(PageHelper pageHelper,String str);

    /**
     * 根据开单id获取某一条信息
     */
    public ViewOpenInfo getInfoById(int id);
}
