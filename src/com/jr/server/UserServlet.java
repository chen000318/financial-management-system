package com.jr.server;

import com.jr.biz.impl.UserBizImpl;
import com.jr.entry.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/us")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        login(request,response);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    /**
     * 使用sesson存储用户登录后返回的对象
     * */
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserBizImpl userBiz = new UserBizImpl();
        User user = new User();
        user.setAccount(username);
        user.setPassword(password);
        User user1 = userBiz.login(user);
        if(user1!=null){
            request.getSession().setAttribute("user",user1);
            response.sendRedirect("ticket-open.jsp?p=0");
        }else {
            response.getWriter().println("<script>alert('用户名或密码错误');location.href='login.jsp'</script>");
        }
    }
}
