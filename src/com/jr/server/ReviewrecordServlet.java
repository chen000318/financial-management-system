package com.jr.server;

import com.jr.biz.impl.ReviewrecordBizImpl;
import com.jr.biz.impl.TicketopenBizImpl;
import com.jr.entry.Reviewrecord;
import com.jr.entry.Ticketopen;
import com.jr.entry.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/rs")
public class ReviewrecordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String i = request.getParameter("i");
        if("1".equals(i)){
            insertReviewrecord(request,response);
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

    //插入审核记录
    protected void insertReviewrecord (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Reviewrecord reviewrecord = new Reviewrecord();
        String status = request.getParameter("status");
        String remark = request.getParameter("check_remark");
        int eid = Integer.parseInt(request.getParameter("eid"));
        User user = (User) request.getSession().getAttribute("user");
        TicketopenBizImpl ticketopenBiz = new TicketopenBizImpl();
        Ticketopen ticketopen = new Ticketopen();

        ticketopen.setId(eid);

        reviewrecord.setTicketOpenId(eid);
        reviewrecord.setCreatorId(user.getId());
        reviewrecord.setCreateTime(new Date());
        reviewrecord.setReviewStatus(status);
        reviewrecord.setRemark(remark);

        if("B".equals(status)){
            ticketopenBiz.updateTicketopenStatus(ticketopen,"A");
        }
        if("C".equals(status)){
            ticketopenBiz.updateTicketopenStatus(ticketopen,"D");
        }

        ReviewrecordBizImpl reviewrecordBiz = new ReviewrecordBizImpl();
        reviewrecordBiz.addReviewrecord(reviewrecord);
    }


}
