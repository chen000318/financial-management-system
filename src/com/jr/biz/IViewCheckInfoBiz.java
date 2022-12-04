package com.jr.biz;

import com.jr.entry.Ticketopen;
import com.jr.util.ViewCheckInfo;

import java.util.List;

public interface IViewCheckInfoBiz {
    /*
    * 通过开单id获取某单的详细信息
    * */
    public ViewCheckInfo getDetails(Ticketopen ticketopen);

    /**
     * 通过开单id获取某单的详细信息(已审核)
     */
    public ViewCheckInfo getDetailsChecked(Ticketopen ticketopen);
}
