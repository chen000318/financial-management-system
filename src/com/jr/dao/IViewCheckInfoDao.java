package com.jr.dao;

import com.jr.entry.Ticketopen;
import com.jr.util.ViewCheckInfo;

import java.util.List;

public interface IViewCheckInfoDao {
    /**
     * 通过开单id查询某个开单的详细信息(利用视图工具类ViewCheckInfo)
     */
    public List<ViewCheckInfo> queryDetails(Ticketopen ticketopen);
}
