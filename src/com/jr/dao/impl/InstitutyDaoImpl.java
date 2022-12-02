package com.jr.dao.impl;

import com.jr.dao.IInstitutyDao;
import com.jr.entry.Instituty;
import com.jr.util.DBHelper;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InstitutyDaoImpl implements IInstitutyDao {
    /*
     *查询所有金融机构名称
     * */
    @Override
    public List<Instituty> queryAllNames() {
        List<Instituty> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT id,name FROM t_instituty ";
        try {
            con = DBHelper.getCon();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Instituty instituty = new Instituty();
                instituty.setId(rs.getInt(1));
                instituty.setName(rs.getString(2));
                list.add(instituty);
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
