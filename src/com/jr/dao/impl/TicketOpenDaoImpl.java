package com.jr.dao.impl;

import com.jr.dao.ITicketOpenDao;
import com.jr.entry.Ticketopen;
import com.jr.util.DBHelper;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketOpenDaoImpl implements ITicketOpenDao {

    /**
     *创建数据库连接对象
     */
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    /*
     * 添加开单信息
     * */
    @Override
    public int insertTicket(Ticketopen ticketopen) {
        String sql = "insert into t_ticket_open values(null,?,?,?,?,?,?,?,?,?,?,?)";
        int num = upd(sql,ticketopen.getNo(),ticketopen.getEnterPriseId(),
                ticketopen.getAcquirerEnterPriseId(),ticketopen.getAmount(),ticketopen.getInstitutyId(),
                ticketopen.getCreateTime(),ticketopen.getExpiryTime(),ticketopen.getPaymentInterestType(),
                ticketopen.getStatus(),ticketopen.getUplinkAddress(),ticketopen.getTicketRemark());
        return num;
    }

    /**
     * 根据开单id更改票据状态
     */
    @Override
    public int alertTicketStatus(Ticketopen ticketopen) {
        return 0;
    }

    /**
     * 根据开单表查询所有付息方式
     */
    @Override
    public List<Ticketopen> selectAllPayment() {
        List<Ticketopen> list = new ArrayList<>();
        String sql = "SELECT DISTINCT payment_interest_type FROM t_ticket_open";
        try {
            con = DBHelper.getCon();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Ticketopen ticketopen = new Ticketopen();
                //ticketopen.setId(rs.getInt(1));
                ticketopen.setPaymentInterestType(rs.getString(1));
                list.add(ticketopen);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.closeAll(con,ps,rs);
        }
        return list;
    }

    /**
     *
     * 查询开单表最大id
     */
    @Override
    public int selectMaxId() {
        String sql = "SELECT MAX(id) max FROM t_ticket_open";
        int  num = 0;
        try {
            con = DBHelper.getCon();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()){
                num = rs.getInt(1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.closeAll(con,ps,rs);
        }
        return num;
    }

    @Override
    public int upd(String sql, Object... objects) {
        int num = 0 ;
        try {
            con = DBHelper.getCon();
            ps = con.prepareStatement(sql);
            for (int i = 0; i < objects.length; i++) {
                ps.setObject(i+1,objects[i]);
            }
            num = ps.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.closeAll(con,ps,rs);
        }
        return  num;
    }

}
