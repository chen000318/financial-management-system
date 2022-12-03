package com.jr.server;

import com.google.gson.Gson;
import com.jr.biz.impl.InstitutyBizImpl;
import com.jr.entry.Instituty;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/is")
public class InstitutyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getAllInstituties(request,response);
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
 * 获取金融机构列表
 * 可将金融机构名称展示在下拉框上，具体看前端代码，
 * 注：使用ajax技术
 * */
    protected void getAllInstituties(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InstitutyBizImpl institutyBiz = new InstitutyBizImpl();
        List<Instituty> list =  institutyBiz.getAllNames();
        Gson gson = new Gson();
        response.getWriter().println(gson.toJson(list));
    }
}
