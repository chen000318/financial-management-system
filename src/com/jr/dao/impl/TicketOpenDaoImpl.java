package com.jr.dao.impl;

import com.jr.dao.ITicketOpenDao;
import com.jr.entry.Ticketopen;

import java.util.List;

public class TicketOpenDaoImpl implements ITicketOpenDao {
    /*
     * 查询符合条件的所有状态的开单信息（开单）
     * 这里利用SqlHelper工具类返回的字符串进行查询
     * where后面需要加上一个 id is not null
     * */
    @Override
    public List<Ticketopen> queryAllByConditions(String str) {
        return null;
    }

    /*
     * 查询符合条件的开单中的开单信息（复核）
     * 这里利用SqlHelper工具类返回的字符串进行查询
     * where后面加上status='开单中'
     * */
    @Override
    public List<Ticketopen> queryAllByConditionsOnTheBill(String str) {
        return null;
    }

    /*
     * 添加开单信息
     * */
    @Override
    public int insertTicket(Ticketopen ticketopen) {
        return 0;
    }

    /**
     * 根据开单id更改票据状态
     */
    @Override
    public int alertTicketStatus(Ticketopen ticketopen) {
        return 0;
    }
}
