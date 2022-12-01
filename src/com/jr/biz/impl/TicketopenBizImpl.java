package com.jr.biz.impl;

import com.jr.biz.ITicketopenBiz;
import com.jr.entry.Ticketopen;

import java.util.List;

public class TicketopenBizImpl implements ITicketopenBiz {
    /**
     * 获取符合条件的所有状态的开单信息（开单）
     * @param str
     * @return
     */
    @Override
    public List<Ticketopen> getAllByConditions(String str) {
        return null;
    }

    /**
     * 获取符合条件的开单中的开单信息（复核）
     * @param str
     * @return
     */
    @Override
    public List<Ticketopen> getAllByConditionsOnTheBill(String str) {
        return null;
    }

    /**
     * 添加开单信息
     * @param ticketopen
     * @return
     */
    @Override
    public int addTicket(Ticketopen ticketopen) {
        return 0;
    }

    /**
     * 更新开单状态
     * @param ticketopen
     * @return
     */
    @Override
    public int updateTicketopenStatus(Ticketopen ticketopen) {
        return 0;
    }
}
