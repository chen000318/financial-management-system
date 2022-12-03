package com.jr.biz.impl;

import com.jr.biz.IViewCheckInfoBiz;
import com.jr.dao.impl.ViewCheckInfoDaoImpl;
import com.jr.entry.Ticketopen;
import com.jr.util.ViewCheckInfo;

import java.util.List;

public class ViewCheckInfoBizImpl implements IViewCheckInfoBiz {
    ViewCheckInfoDaoImpl viewCheckInfoDao = new ViewCheckInfoDaoImpl();

    /*
     * 通过开单id获取某单的详细信息
     * */
    @Override
    public List<ViewCheckInfo> getDetails(Ticketopen ticketopen) {
        return viewCheckInfoDao.queryDetails(ticketopen);
    }
}
