package com.jr.dao.impl;

import com.jr.dao.IReviewrecordDao;
import com.jr.entry.Reviewrecord;
import com.jr.util.DBHelper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewrecordDaoImpl implements IReviewrecordDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    /*
     * 插入审核记录
     * */
    @Override
    public int insertReviewrecord(Reviewrecord reviewrecord) {
        int i=0;
        try {
            con= DBHelper.getCon();
            String sql="INSERT INTO t_review_record VALUES(null,?,?,?,?,?)";
            ps=con.prepareStatement(sql);
            ps.setObject(1,reviewrecord.getTicketOpenId());
            ps.setObject(2,reviewrecord.getCreatorId());
            ps.setObject(3,reviewrecord.getCreateTime());
            ps.setObject(4,reviewrecord.getReviewStatus());
            ps.setObject(5,reviewrecord.getRemark());
            i=ps.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.closeAll(con,ps,rs);
        }
        return i;
    }

    /*
     * 根据开单id查询审核记录信息
     * */
    @Override
    public Reviewrecord queryReviewrecord(int ticketId) {
        Reviewrecord reviewrecord=null;
        try {
            con=DBHelper.getCon();
            String sql="SELECT FROM t_review_record WHERE ticketOpenId=?";
            ps=con.prepareStatement(sql);
            ps.setObject(1,ticketId);
            rs=ps.executeQuery();
            while (rs.next()){
                reviewrecord=new Reviewrecord();
                reviewrecord.setId(rs.getInt(1));
                reviewrecord.setTicketOpenId(rs.getInt(2));
                reviewrecord.setCreatorId(rs.getInt(3));
                reviewrecord.setCreateTime(rs.getTime(4));
                reviewrecord.setReviewStatus(rs.getString(5));
                reviewrecord.setRemark(rs.getString(6));
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
        return reviewrecord;
    }
}
