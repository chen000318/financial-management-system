package com.jr.util;

import com.mysql.cj.conf.ConnectionPropertiesTransform;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBHelper {
    public static Connection getCon() throws IOException, ClassNotFoundException, SQLException {
        InputStream is = ConnectionPropertiesTransform.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties p = new Properties();
        p.load(is);

        String url = p.getProperty("url");
        String user = p.getProperty("user");
        String password = p.getProperty("password");
        String dClass = p.getProperty("dClass");

        Class.forName(dClass);
        Connection con = DriverManager.getConnection(url,user,password);
        return con;
    }

    public static void closeAll(Connection con , PreparedStatement ps, ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
