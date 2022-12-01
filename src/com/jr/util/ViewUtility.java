package com.jr.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewUtility {

    public static void main(String[] args) {
        System.out.println(ViewUtility.sleectInfoView("2"));
    }
    private String ticket_id;
    private String no;
    private String status;
    private String openename;//开单企业
    private String openescu;//开单企业统一社会信用码
    private String receiptename;//收单企业
    private String receiptescu;//
    private String amount;
    private String institutyname;//金融机构
    private String createTime;
    private String expriyTime;
    private String paymentInterestItype;
    private String ticketRemark;

    public ViewUtility() {
    }
    public ViewUtility(String ticket_id, String no, String status,
                       String openename, String openescu, String receiptename,
                       String receiptescu, String amount, String institutyname,
                       String createTime, String expriyTime, String paymentInterestItype,
                       String ticketRemark) {
        this.ticket_id = ticket_id;
        this.no = no;
        this.status = status;
        this.openename = openename;
        this.openescu = openescu;
        this.receiptename = receiptename;
        this.receiptescu = receiptescu;
        this.amount = amount;
        this.institutyname = institutyname;
        this.createTime = createTime;
        this.expriyTime = expriyTime;
        this.paymentInterestItype = paymentInterestItype;
        this.ticketRemark = ticketRemark;
    }

    @Override
    public String toString() {
        return "ViewUtility{" +
                "ticket_id='" + ticket_id + '\'' +
                ", no='" + no + '\'' +
                ", status='" + status + '\'' +
                ", openename='" + openename + '\'' +
                ", openescu='" + openescu + '\'' +
                ", receiptename='" + receiptename + '\'' +
                ", receiptescu='" + receiptescu + '\'' +
                ", amount='" + amount + '\'' +
                ", institutyname='" + institutyname + '\'' +
                ", createTime='" + createTime + '\'' +
                ", expriyTime='" + expriyTime + '\'' +
                ", paymentInterestItype='" + paymentInterestItype + '\'' +
                ", ticketRemark='" + ticketRemark + '\'' +
                '}';
    }

    public static  ViewUtility sleectInfoView(String ticketid) {
        ViewUtility viewUtility1 = null;
        Connection getconn=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
             getconn = DBHelper.getCon();
            String sql = "select * from infoview where  ticket_id=?";
            preparedStatement = getconn.prepareStatement(sql);
            preparedStatement.setString(1, ticketid);
             resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                viewUtility1 = new ViewUtility(
                        resultSet.getString("ticket_id"),
                        resultSet.getString("no"),
                        resultSet.getString("status"),
                        resultSet.getString("openename"),
                        resultSet.getString("openesuc"),
                        resultSet.getString("receiptename"),
                        resultSet.getString("receiptesuc"),
                        resultSet.getString("amount"),
                        resultSet.getString("institutyname"),
                        resultSet.getString("create_time"),
                        resultSet.getString("expiry_time"),
                        resultSet.getString("payment_interest_type"),
                        resultSet.getString("ticket_remark")
                );
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBHelper.closeAll(getconn,preparedStatement,resultSet);
        }
        return viewUtility1;
    }
}
