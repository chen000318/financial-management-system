package com.jr.biz;

import com.jr.entry.Ticketopen;

import java.util.List;

public interface ITicketopenBiz {
    /*
    * 获取符合条件的所有状态的开单信息（开单）
    * */
    public List<Ticketopen> getAllByConditions(String str);

    /*
    * 获取符合条件的开单中的开单信息（复核）
    * */
    public List<Ticketopen> getAllByConditionsOnTheBill(String str);

    /*
    * 添加开单信息
    * */
    public int addTicket(Ticketopen ticketopen);

    /**
     * 更新开单状态
     */
    public int updateTicketopenStatus(Ticketopen ticketopen);
}
