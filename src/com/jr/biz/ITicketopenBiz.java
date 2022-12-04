package com.jr.biz;

import com.jr.entry.Ticketopen;

import java.util.List;

public interface ITicketopenBiz {
    /*
    * 添加开单信息
    * */
    public boolean addTicket(Ticketopen ticketopen);

    /**
     * 更新开单状态
     */
    public int updateTicketopenStatus(Ticketopen ticketopen,String str);

    /**
     * 查询开单表最大id
     */
    public int queryMaxId();

    /**
     * 查询开单里面的所有付息方式
     */
    public List<Ticketopen> queryAllPayment();

    /**
     * 根据开单id获取企业id
     */
    public int getEnterpriseIdByOpenId(int oid);
}
