package com.jr.biz;

import com.jr.util.PageHelper;
import com.jr.util.ViewOpenInfo;

import java.util.List;

public interface IViewOpenInfoBiz {
    /**
     * 获取查询数据的总条数
     */
    public int getTotalNum();

    /**
     * 获取当前页的全部信息(所有状态)
     */
    public List<ViewOpenInfo> getAllInfoByCurrentPage(PageHelper pageHelper,String str);

    /**
     * 获取当前页的复核信息(状态为开单中)
     */
    public List<ViewOpenInfo> getAllOnTheBillByCurrentPage(PageHelper pageHelper,String str);
}
