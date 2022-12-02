package com.jr.dao.impl;

import com.jr.dao.IUserDao;
import com.jr.entry.User;
import com.jr.util.DBHelper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements IUserDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    /**
     * 通过用户账号和用户密码查询指定用户
     */
    @Override
    public User queryByAccountAndPassword(User user) {
        User user1 = null;
        try {
            String sql = "SELECT * FROM t_user WHERE account=? AND password=?";
            con = DBHelper.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1,user.getAccount());
            ps.setString(2,user.getPassword());
            rs = ps.executeQuery();
            if(rs.next()){
                user1 = new User();
                user1.setId(rs.getInt("id"));
                user1.setName(rs.getString("name"));
                user1.setAccount(rs.getString("account"));
                user1.setPassword(rs.getString("password"));
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
        return user1;
    }
}
