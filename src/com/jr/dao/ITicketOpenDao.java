package com.jr.dao;


import com.jr.entry.Ticketopen;

import java.util.List;

public interface ITicketOpenDao {
    /*
     * 查询符合条件的所有状态的开单信息（开单）
     * */
    public List<Ticketopen> queryAllByConditions(String str);

    /*
     * 查询符合条件的开单中的开单信息（复核）
     * */
    public List<Ticketopen> queryAllByConditionsOnTheBill(String str);

    /*
     * 添加开单信息
     * */
    public int insertTicket(Ticketopen ticketopen);

    /**
     * 根据开单id更改票据状态
     */
    public int alertTicketStatus(Ticketopen ticketopen);
}
