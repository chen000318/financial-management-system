package com.jr.dao.impl;

import com.jr.dao.ITicketOpenDao;
import com.jr.entry.Ticketopen;
import com.jr.util.DBHelper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TicketOpenDaoImpl implements ITicketOpenDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    /*
     * 查询符合条件的所有状态的开单信息（开单）
     * 这里利用SqlHelper工具类返回的字符串进行查询
     * where后面需要加上一个 id is not null
     * */

    /*
     * 查询符合条件的开单中的开单信息（复核）
     * 这里利用SqlHelper工具类返回的字符串进行查询
     * where后面加上status='开单中'


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
        int i=0;
        try {
            con=DBHelper.getCon();
            String sql="UPDATE status FROM t_ticket_open WHERE id=?";
            ps=con.prepareStatement(sql);
            ps.setObject(1,ticketopen.getId());
            i=ps.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.closeAll(con,ps, rs);
        }
        return i;
    }
}
