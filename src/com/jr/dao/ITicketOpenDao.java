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

    /**
     * 根据开单表查询所有付息方式
     */
    public List<Ticketopen> selectAllPayment();

    /**
     * 查询开单表里的最大id
     */
    public int selectMaxId();

    /**
     * 添加通用方法
     */
    public int upd(String sql,Object...objects);
}
