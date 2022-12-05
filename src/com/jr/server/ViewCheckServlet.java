package com.jr.server;

import com.google.gson.Gson;
import com.jr.biz.impl.ViewCheckInfoBizImpl;
import com.jr.dao.impl.ViewCheckInfoDaoImpl;
import com.jr.entry.Ticketopen;
import com.jr.util.ViewCheckInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/vcs")
public class ViewCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String i = request.getParameter("i");
        if("1".equals(i)){
            request.getRequestDispatcher("check-detail.jsp").forward(request,response);
        }
        if("2".equals(i)){
            request.getRequestDispatcher("open-detail.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String i = request.getParameter("i");
        if("1".equals(i)){
            queryDetails(request,response);
        }
        if("2".equals(i)){
            queryDetailsAll(request,response);
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    /**
     * 查询所有状态的某一个开单信息详情
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void queryDetailsAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String eid = request.getParameter("eid");
        ViewCheckInfoBizImpl viewCheckInfoBiz = new ViewCheckInfoBizImpl();
        Ticketopen ticketopen = new Ticketopen();
        ticketopen.setId(Integer.parseInt(eid));
        ViewCheckInfo viewCheckInfo = viewCheckInfoBiz.getDetails(ticketopen);
        Gson gson = new Gson();
        response.getWriter().println(gson.toJson(viewCheckInfo));
    }

    /**
     * 查询已完成审核的某一个开单信息详情
     */
    protected void queryDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String eid = request.getParameter("eid");
        ViewCheckInfoBizImpl viewCheckInfoBiz = new ViewCheckInfoBizImpl();
        Ticketopen ticketopen = new Ticketopen();
        ticketopen.setId(Integer.parseInt(eid));
        ViewCheckInfo viewCheckInfo = viewCheckInfoBiz.getDetailsChecked(ticketopen);
        System.out.println(viewCheckInfo);
        Gson gson = new Gson();
        response.getWriter().println(gson.toJson(viewCheckInfo));
    }
}
