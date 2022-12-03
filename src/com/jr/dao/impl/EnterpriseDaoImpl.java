package com.jr.dao.impl;

import com.jr.dao.IEnterpriseDao;
import com.jr.entry.Enterprise;
import com.jr.util.DBHelper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnterpriseDaoImpl implements IEnterpriseDao {
    /**
     * 为连接数据库做准备
     */
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    /**
     * 根据用户id查询企业信息
     * */
    @Override
    public Enterprise queryByUid(int uid) {
        Enterprise enterprise = null;
        try {
            String sql = "SELECT tp.name,tp.social_uniform_code FROM t_enterprise tp WHERE id=(SELECT enterprise_id FROM t_user WHERE id=?)";
            con = DBHelper.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1,uid);
            rs = ps.executeQuery();
            if(rs.next()){
                enterprise = new Enterprise();
                enterprise.setName(rs.getString(1));
                enterprise.setSocialUniformCcode(rs.getString(2));
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
        return enterprise;
    }

    /**
     *查询所有企业信息
     * */
    @Override
    public List<Enterprise> queryAllEnterpriseNames() {
        List<Enterprise> list = new ArrayList<>();
        try {
            String sql = "SELECT id,name,social_uniform_code FROM t_enterprise";
            con = DBHelper.getCon();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Enterprise enterprise = new Enterprise();
                enterprise.setId(rs.getInt(1));
                enterprise.setName(rs.getString(2));
                enterprise.setSocialUniformCcode(rs.getString(3));
                list.add(enterprise);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Enterprise queryEnterpriseInfoByid(int id) {
        return null;
    }
}
