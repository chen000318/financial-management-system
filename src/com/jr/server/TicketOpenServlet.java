package com.jr.server;

import com.google.gson.Gson;
import com.jr.biz.impl.TicketopenBizImpl;
import com.jr.util.PageHelper;
import com.jr.util.SqlHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TicketOpenServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num=request.getParameter("i");
        if (num.equals("1")){
            getAllTicketopeninfo(request, response);
        }else if (num.equals("2")){
            getTicketopeninfoByconditions(request, response);
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
     * 获取所有ticketopen开单表中的信息
     */
    protected void getAllTicketopeninfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得客户端输入参数：
        String voucher=request.getParameter("voucher number");
        String acquired=request.getParameter("acquired enterprise");
        String enterprise=request.getParameter("enterprise billing");
        String billing=request.getParameter("billing date");
        String divbutton=request.getParameter("divbutton");
        String minimum=request.getParameter("minimum amount");
        String maximum=request.getParameter("maximum amount");
        //使用工具类SqlHelper,将客户传过来的值输入到工具类对象中去：
        SqlHelper sqlHelper=new SqlHelper();
        sqlHelper.setNo(voucher);
        sqlHelper.setAcquirerEnterPriseId(acquired);
        sqlHelper.setEnterPriseId(enterprise);
        sqlHelper.setCreateTime(billing);
        sqlHelper.setStatus(divbutton);
        sqlHelper.setAmountMin(minimum);
        sqlHelper.setAmountMax(maximum);
        String str=sqlHelper.sqlConcat();
        //创建视图对象：




        //获得PageHelper对象并为其赋值：
        PageHelper pageHelper=new PageHelper();
        String string=request.getParameter("index");
        if(string==null){
            pageHelper.setIndexPage(1); //给   当前是第几页   赋值
        }else{
            int i=Integer.parseInt(string);
            pageHelper.setIndexPage(i);
        }
        pageHelper.setTotalCount();//给  一共有多少条数据   赋值
        pageHelper.setPageSize(4);//给  每页显示的条数   赋值
        pageHelper.setPageList(pbi.getBypage(pageHelper));
        Gson gson=new Gson();
        response.getWriter().println( gson.toJson(pageHelper));


    }
/**
 * 获取所有符合条件的ticketopen开单表信息
 * 这里使用前台异步查询,提供了字符串拼接工具类
 * 可以直接在里边拼接所需要属性的字符串
 * */
    protected void getTicketopeninfoByconditions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得客户端输入参数：
        String voucher=request.getParameter("voucher number");
        String acquired=request.getParameter("acquired enterprise");
        String enterprise=request.getParameter("enterprise billing");
        String billing=request.getParameter("billing date");
        String divbutton=request.getParameter("divbutton");
        String minimum=request.getParameter("minimum amount");
        String maximum=request.getParameter("maximum amount");
        //使用工具类SqlHelper,将客户传过来的值输入到工具类对象中去：
        SqlHelper sqlHelper=new SqlHelper();
        sqlHelper.setNo(voucher);
        sqlHelper.setAcquirerEnterPriseId(acquired);
        sqlHelper.setEnterPriseId(enterprise);
        sqlHelper.setCreateTime(billing);
        sqlHelper.setStatus(divbutton);
        sqlHelper.setAmountMin(minimum);
        sqlHelper.setAmountMax(maximum);
        String str=sqlHelper.sqlConcat();
        //创建视图对象：




        //获得PageHelper对象并为其赋值：
        PageHelper pageHelper=new PageHelper();
        String string=request.getParameter("index");
        if(string==null){
            pageHelper.setIndexPage(1); //给   当前是第几页   赋值
        }else{
            int i=Integer.parseInt(string);
            pageHelper.setIndexPage(i);
        }
        pageHelper.setTotalCount();//给  一共有多少条数据   赋值
        pageHelper.setPageSize(4);//给  每页显示的条数   赋值
        pageHelper.setPageList(pbi.getBypage(pageHelper));
        Gson gson=new Gson();
        response.getWriter().println( gson.toJson(pageHelper));













    }

}
