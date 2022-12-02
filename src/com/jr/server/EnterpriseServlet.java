package com.jr.server;

import com.google.gson.Gson;
import com.jr.biz.impl.EnterpriseBizImpl;
import com.jr.entry.Enterprise;
import com.jr.entry.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/es")

@WebServlet("/es")
public class EnterpriseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer i = Integer.parseInt(request.getParameter("i"));
        if(i==1){
            getEnterpriseInfoByEnterpriseID(request,response);
        }
        if(i==2){
            getAllEnterprise(request,response);
        }
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
    protected void getEnterpriseInfoByEnterpriseID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user =(User) request.getSession().getAttribute("user");
        EnterpriseBizImpl enterpriseBiz = new EnterpriseBizImpl();
        Enterprise enterprise = enterpriseBiz.getEnterpriseInfo(user.getId());
        Gson gson = new Gson();
        response.getWriter().println(gson.toJson(enterprise));
    }
/**
 * 获取企业的全部信息列表
 * 将列表内企业名称展示在前端下拉框中
 *
 * */
    protected void getAllEnterprise(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EnterpriseBizImpl enterpriseBiz = new EnterpriseBizImpl();
        List<Enterprise> list = enterpriseBiz.getAllEnterpriseNames();
        System.out.println(list);
        Gson gson = new Gson();
        response.getWriter().println(gson.toJson(list));
    }
}
