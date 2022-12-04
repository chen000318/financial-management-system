package com.jr.biz.impl;

import com.jr.biz.IViewOpenInfoBiz;
import com.jr.dao.impl.ViewOpenInfoDaoImpl;
import com.jr.util.PageHelper;
import com.jr.util.ViewOpenInfo;

import java.util.List;

public class ViewOpenInfoBizImpl implements IViewOpenInfoBiz {
    ViewOpenInfoDaoImpl viewOpenInfoDao=new ViewOpenInfoDaoImpl();
    /**
     * 根据条件查询数据总条数
     */
    @Override
    public int getTotalNumByConditions(String str) {
        return viewOpenInfoDao.queryTotalNumByConditions(str);
    }

    /**
     * 获取查询数据的总条数
     */
    @Override
    public int getTotalNum() {
        return viewOpenInfoDao.queryTotalNum();
    }

    /**
     * 获取当前页的全部信息(所有状态)
     */
    @Override
    public List<ViewOpenInfo> getAllInfoByCurrentPage(PageHelper pageHelper,String str) {
        return viewOpenInfoDao.queryAllInfoByCurrentPage(pageHelper,str);
    }

    /**
     * 获取当前页的复核信息(开单中)
     */
    @Override
    public List<ViewOpenInfo> getAllOnTheBillByCurrentPage(PageHelper pageHelper,String str) {
        return viewOpenInfoDao.queryAllOnTheBillByCurrentPage(pageHelper,str);
    }
}
