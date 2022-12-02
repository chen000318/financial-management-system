package com.jr.biz.impl;

import com.jr.biz.ITicketopenBiz;
import com.jr.dao.impl.TicketOpenDaoImpl;
import com.jr.entry.Ticketopen;

import java.util.List;

public class TicketopenBizImpl implements ITicketopenBiz {
    TicketOpenDaoImpl ticketOpenDao=new TicketOpenDaoImpl();
    /**
     * 添加开单信息
     * @param ticketopen
     * @return
     */
    @Override
    public int addTicket(Ticketopen ticketopen) {
        return ticketOpenDao.insertTicket(ticketopen);
    }

    /**
     * 更新开单状态
     * @param ticketopen
     * @return
     */
    @Override
    public int updateTicketopenStatus(Ticketopen ticketopen) {
        return ticketOpenDao.alertTicketStatus(ticketopen);
    }
}
