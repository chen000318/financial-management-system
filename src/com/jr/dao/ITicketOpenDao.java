package com.jr.dao;


import com.jr.entry.Ticketopen;

import java.util.List;

public interface ITicketOpenDao {
    /*
     * 添加开单信息
     * */
    public int insertTicket(Ticketopen ticketopen);

    /**
     * 根据开单id更改票据状态
     */
    public int alertTicketStatus(Ticketopen ticketopen);
}
