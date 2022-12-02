package com.jr.biz.impl;

import com.jr.biz.IViewOpenInfoBiz;
import com.jr.util.PageHelper;
import com.jr.util.ViewOpenInfo;

import java.util.List;

public class ViewOpenInfoBizImpl implements IViewOpenInfoBiz {
    /**
     * 获取查询数据的总条数
     */
    @Override
    public int getTotalNum() {
        return 0;
    }

    /**
     * 获取当前页的全部信息(所有状态)
     */
    @Override
    public List<ViewOpenInfo> getAllInfoByCurrentPage(PageHelper pageHelper) {
        return null;
    }

    /**
     * 获取当前页的复核信息(开单中)
     */
    @Override
    public List<ViewOpenInfo> getAllOnTheBillByCurrentPage(PageHelper pageHelper) {
        return null;
    }
}
