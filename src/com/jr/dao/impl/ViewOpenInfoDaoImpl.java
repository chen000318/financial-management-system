package com.jr.dao.impl;

import com.jr.dao.IViewOpenInfoDao;
import com.jr.util.DBHelper;
import com.jr.util.PageHelper;
import com.jr.util.ViewOpenInfo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ViewOpenInfoDaoImpl implements IViewOpenInfoDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    /**
     * 查询数据的总条数
     */
    @Override
    public int queryTotalNum() {
        int num = 0;
        try {
            String sql = "SELECT count(id) FROM openinfo";
            con = DBHelper.getCon();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.next();
            num = rs.getInt("count(id)");
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

    /**
     * 查询当前页的数据信息(所有状态)
     */
    @Override
    public List<ViewOpenInfo> queryAllInfoByCurrentPage(PageHelper pageHelper,String str) {
        List<ViewOpenInfo> list = new ArrayList<>();

        try {
            String sql = "SELECT no,aname,amount,ename,iname,create_time,expiry_time,uplink_address,status FROM openinfo WHERE id is not null "+str+" limit ?,?";
            System.out.println(sql);
            System.out.println(pageHelper.getStartNum());
            System.out.println(pageHelper.getPageSize());
            con = DBHelper.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1,pageHelper.getStartNum());
            ps.setInt(2,pageHelper.getPageSize());
            rs = ps.executeQuery();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            while (rs.next()){
                ViewOpenInfo viewOpenInfo = new ViewOpenInfo();
                viewOpenInfo.setNo(rs.getString("no"));
                viewOpenInfo.setAname(rs.getString("aname"));
                viewOpenInfo.setAmount(rs.getDouble("amount"));
                viewOpenInfo.setEname(rs.getString("ename"));
                viewOpenInfo.setIname(rs.getString("iname"));
                viewOpenInfo.setCreateTime(simpleDateFormat.format(rs.getDate("create_time")));
                viewOpenInfo.setExpiryTime(simpleDateFormat.format(rs.getDate("expiry_time")));
                viewOpenInfo.setUpLinkAddress(rs.getString("uplink_address"));
                viewOpenInfo.setStatus(rs.getString("status"));
                list.add(viewOpenInfo);
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
     * 查询当前页的数据信息(开单中)
     */
    @Override
    public List<ViewOpenInfo> queryAllOnTheBillByCurrentPage(PageHelper pageHelper,String str) {
        List<ViewOpenInfo> list = new ArrayList<>();

        try {
            String sql = "SELECT no,aname,amount,ename,iname,create_time,expiry_time,uplink_address,status FROM openinfo WHERE status='B'"+str+" limit ?,?";
            con = DBHelper.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1,pageHelper.getStartNum());
            ps.setInt(2,pageHelper.getPageSize());
            rs = ps.executeQuery();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            while (rs.next()){
                ViewOpenInfo viewOpenInfo = new ViewOpenInfo();
                viewOpenInfo.setNo(rs.getString("no"));
                viewOpenInfo.setAname(rs.getString("aname"));
                viewOpenInfo.setAmount(rs.getDouble("amount"));
                viewOpenInfo.setEname(rs.getString("ename"));
                viewOpenInfo.setIname(rs.getString("iname"));
                viewOpenInfo.setCreateTime(simpleDateFormat.format(rs.getDate("create_time")));
                viewOpenInfo.setExpiryTime(simpleDateFormat.format(rs.getDate("expiry_time")));
                viewOpenInfo.setUpLinkAddress(rs.getString("uplink_address"));
                viewOpenInfo.setStatus("status");
                list.add(viewOpenInfo);
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
