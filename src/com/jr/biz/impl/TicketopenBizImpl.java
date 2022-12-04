package com.jr.biz.impl;

import com.jr.biz.ITicketopenBiz;
import com.jr.dao.impl.TicketOpenDaoImpl;
import com.jr.entry.Ticketopen;

import java.util.List;

public class TicketopenBizImpl implements ITicketopenBiz {

    /**
     * 创建一个TicketOpenDaoImpl对象
     */
    TicketOpenDaoImpl ticketOpenDao = new TicketOpenDaoImpl();

    /**
     * 添加开单信息
     * @param ticketopen
     * @return
     */
    @Override
    public boolean addTicket(Ticketopen ticketopen) {

        return ticketOpenDao.insertTicket(ticketopen)>0?true:false;
    }

    /**
     * 更新开单状态
     * @param ticketopen
     * @return
     */
    @Override
    public int updateTicketopenStatus(Ticketopen ticketopen,String str) {
        return ticketOpenDao.alertTicketStatus(ticketopen,str);
    }

    /**
     *
     * 查询开单表最大id
     */
    @Override
    public int queryMaxId() {
        return ticketOpenDao.selectMaxId();
    }

    //获取所有付息方式
    @Override
    public List<Ticketopen> queryAllPayment() {
        return ticketOpenDao.selectAllPayment();
    }

    /**
     * 根据开单id获取企业id
     */
    @Override
    public int getEnterpriseIdByOpenId(int oid) {
        return ticketOpenDao.queryEnterpriseIdByOpenId(oid);
    }


}
