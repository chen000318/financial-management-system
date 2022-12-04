package com.jr.dao;

import com.jr.entry.Ticketopen;
import com.jr.util.ViewCheckInfo;

import java.util.List;

public interface IViewCheckInfoDao {
    /**
     * 通过开单id查询某个开单的详细信息(利用视图工具类ViewCheckInfo)
     */
    public ViewCheckInfo queryDetails(Ticketopen ticketopen);

    /**
     * 通过开单id查询某单的详细信息(已审核)
     */
    public ViewCheckInfo queryDetailsChecked(Ticketopen ticketopen);
}
