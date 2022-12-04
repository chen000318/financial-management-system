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
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public ViewCheckInfo queryDetails(Ticketopen ticketopen) {
        ViewCheckInfo viewCheckInfo = null;
        try {
            String sql = "SELECT * FROM infoview WHERE id=?";
            con = DBHelper.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1,ticketopen.getId());
            rs = ps.executeQuery();
            if (rs.next()){
                viewCheckInfo = new ViewCheckInfo();
                viewCheckInfo.setNo(rs.getString("no"));
                viewCheckInfo.setStatus(rs.getString("status"));
                viewCheckInfo.setEname(rs.getString("ename"));
                String esuc = rs.getString("esuc").replace("\\s","");
                esuc = esuc.replace("\n","");
                String asuc = rs.getString("esuc").replace("\\s","");
                asuc = asuc.replace("\n","");
                viewCheckInfo.setEsuc(esuc);
                viewCheckInfo.setAname(rs.getString("aname"));
                viewCheckInfo.setAsuc(asuc);
                viewCheckInfo.setAmount(rs.getDouble("amount"));
                viewCheckInfo.setIname(rs.getString("iname"));
                SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
                viewCheckInfo.setCreateTime(s.format(rs.getDate("create_time")));
                viewCheckInfo.setExpiryTime(s.format(rs.getDate("expiry_time")));
                viewCheckInfo.setTimePoor(rs.getInt("time_poor"));
                viewCheckInfo.setPaymentInterestType(rs.getString("payment_interest_type"));
                viewCheckInfo.setTicketRemark(rs.getString("ticket_remark"));
                viewCheckInfo.setTicketOpenId(rs.getString("id"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeAll(con,ps,rs);
        }
        return viewCheckInfo;
    }

    /**
     * 通过开单id查询某单的详细信息(已审核)
     */
    @Override
    public ViewCheckInfo queryDetailsChecked(Ticketopen ticketopen) {
        ViewCheckInfo viewCheckInfo = null;
        try {
            String sql = "SELECT * FROM infoview_success WHERE id=?";
            con = DBHelper.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1,ticketopen.getId());
            rs = ps.executeQuery();
            if (rs.next()){
                viewCheckInfo = new ViewCheckInfo();
                viewCheckInfo.setNo(rs.getString("no"));
                viewCheckInfo.setStatus(rs.getString("status"));
                viewCheckInfo.setEname(rs.getString("ename"));
                String esuc = rs.getString("esuc").replace("\\s","");
                esuc = esuc.replace("\n","");
                String asuc = rs.getString("esuc").replace("\\s","");
                asuc = asuc.replace("\n","");
                viewCheckInfo.setEsuc(esuc);
                viewCheckInfo.setAname(rs.getString("aname"));
                viewCheckInfo.setAsuc(asuc);
                viewCheckInfo.setAmount(rs.getDouble("amount"));
                viewCheckInfo.setIname(rs.getString("iname"));
                SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
                viewCheckInfo.setCreateTime(s.format(rs.getDate("create_time")));
                viewCheckInfo.setExpiryTime(s.format(rs.getDate("expiry_time")));
                viewCheckInfo.setTimePoor(rs.getInt("time_poor"));
                viewCheckInfo.setPaymentInterestType(rs.getString("payment_interest_type"));
                viewCheckInfo.setTicketRemark(rs.getString("ticket_remark"));
                viewCheckInfo.setRemark(rs.getString("remark"));
                viewCheckInfo.setTicketOpenId(rs.getString("id"));
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
        return viewCheckInfo;
    }
}
