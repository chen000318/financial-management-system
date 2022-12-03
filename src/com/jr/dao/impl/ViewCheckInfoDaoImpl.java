package com.jr.dao.impl;

import com.jr.dao.IViewCheckInfoDao;
import com.jr.entry.Ticketopen;
import com.jr.util.DBHelper;
import com.jr.util.ViewCheckInfo;
import com.jr.util.ViewOpenInfo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViewCheckInfoDaoImpl implements IViewCheckInfoDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    /**
     * 通过开单id查询某个开单的详细信息(利用视图工具类ViewCheckInfo)
     */
    @Override
    public List<ViewCheckInfo> queryDetails(Ticketopen ticketopen) {
        List<ViewCheckInfo> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM infoview WHERE id=?";
            con = DBHelper.getCon();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                ViewCheckInfo viewCheckInfo = new ViewCheckInfo();
                viewCheckInfo.setNo(rs.getString("no"));
                viewCheckInfo.setStatus(rs.getString("status"));
                viewCheckInfo.setEname(rs.getString("ename"));
                viewCheckInfo.setEsuc(rs.getString("esuc"));
                viewCheckInfo.setAname(rs.getString("aname"));
                viewCheckInfo.setAsuc(rs.getString("asuc"));
                viewCheckInfo.setAmount(rs.getDouble("amount"));
                viewCheckInfo.setIname(rs.getString("iname"));
                viewCheckInfo.setCreateTime(rs.getDate("create_time"));
                viewCheckInfo.setExpiryTime(rs.getDate("expiry_time"));
                viewCheckInfo.setTimePoor(rs.getInt("time_poor"));
                viewCheckInfo.setPaymentInterestType(rs.getString("payment_interest_type"));
                viewCheckInfo.setTicketRemark(rs.getString("ticket_remark"));
                viewCheckInfo.setTicketOpenId(rs.getString("id"));
                list.add(viewCheckInfo);
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
}
