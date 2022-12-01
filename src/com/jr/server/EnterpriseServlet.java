package com.jr.server;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EnterpriseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
/**
 *通过用户传入进来的企业ID获取企业信息，在填入
 * */
    protected void getEnterpriseInfoByEnterpriseID(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
/**
 * 获取企业的全部信息列表
 * 将列表内企业名称展示在前端下拉框中
 *
 * */
    protected void getAllEnterprise(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
