package com.jr.server;

import com.google.gson.Gson;
import com.jr.biz.impl.EnterpriseBizImpl;
import com.jr.biz.impl.TicketopenBizImpl;
import com.jr.biz.impl.ViewOpenInfoBizImpl;
import com.jr.util.PageHelper;
import com.jr.util.SqlHelper;
import com.jr.entry.Ticketopen;
import com.jr.entry.User;
import com.jr.util.ViewOpenInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

@WebServlet("/tos")
public class TicketOpenServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num=request.getParameter("i");
        if (num.equals("1")){
            getAllTicketOpenInfo(request, response);
        }
        if (num.equals("2")){
            getTicketopeninfoByconditions(request, response);
        }
        if (num.equals("3")){
            enterprisequery(request, response);
        }
        if(num.equals("4")){
            updateStatus(request,response);
        }
        if("5".equals(num)){
            getPayment(request,response);
        }
        if("6".equals(num)){
            try {
                addTicketOpenInFo(request,response);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if("7".equals(num)){
            showTicketOpenInfo(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    /**
     * ??????????????????????????????????????????
     */
    protected boolean verify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String oid = request.getParameter("oid");
        User user = (User) request.getSession().getAttribute("user");
        TicketopenBizImpl ticketopenBiz = new TicketopenBizImpl();
        String eid = String.valueOf(ticketopenBiz.getEnterpriseIdByOpenId(Integer.parseInt(oid)));
        if(user.getEnterPriseId().equals(eid)){
            return true;
        }else {
            return false;
        }
    }

    /**
     * ??????????????????????????????(????????????)
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void showTicketOpenInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String oid = request.getParameter("oid");
        ViewOpenInfoBizImpl viewOpenInfoBiz = new ViewOpenInfoBizImpl();
        ViewOpenInfo viewOpenInfo = viewOpenInfoBiz.getInfoById(Integer.parseInt(oid));
        System.out.println(viewOpenInfo);
        Gson gson = new Gson();
        response.getWriter().println(gson.toJson(viewOpenInfo));

    }

    //??????????????????
    protected void updateStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String eid = request.getParameter("eid");
        Ticketopen ticketopen = new Ticketopen();
        ticketopen.setId(Integer.parseInt(eid));
        TicketopenBizImpl ticketopenBiz = new TicketopenBizImpl();
        ticketopenBiz.updateTicketopenStatus(ticketopen,"C");
        response.sendRedirect("open-list.jsp");
    }

    /**
     * ??????????????????
     */
    protected void addTicketOpenInFo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        User user =(User) request.getSession().getAttribute("user");
        TicketopenBizImpl ticketopenBiz = new TicketopenBizImpl();
        Ticketopen ticketopen = new Ticketopen();
        String enterPriseId = Integer.toString(user.getId());
        ticketopen.setNo(certificateID());
        ticketopen.setEnterPriseId(enterPriseId);
        ticketopen.setAcquirerEnterPriseId(request.getParameter("acquirer_enterprise_id"));
        ticketopen.setAmount(Double.parseDouble(request.getParameter("amount")));
        ticketopen.setInstitutyId(Integer.parseInt(request.getParameter("instiuty_name")));
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        ticketopen.setCreateTime(date.parse(request.getParameter("creat_time")));
        ticketopen.setExpiryTime(date.parse(request.getParameter("expiry_time")));
        ticketopen.setPaymentInterestType(request.getParameter("payment_interest_type"));
        ticketopen.setStatus("B");
        ticketopen.setUplinkAddress(upLinkAddress());
        ticketopen.setTicketRemark(request.getParameter("ticketRemark"));
        if (!ticketopenBiz.addTicket(ticketopen)){
            request.getRequestDispatcher("ticket-open.jsp").forward(request,response);
        }
    }
    /**
     * ????????????ticketopen?????????????????????
     */
    protected void getAllTicketOpenInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //??????????????????????????????
        String voucher=request.getParameter("vouchernumber");
        String acquired=request.getParameter("acquiredenterprise");
        String enterprise=request.getParameter("enterprisebilling");
        String billing=request.getParameter("billingdate");
        String divbutton=request.getParameter("button");
        String minimum=request.getParameter("minimum");
        String maximum=request.getParameter("maximum");
        //???????????????SqlHelper,?????????????????????????????????????????????????????????
        SqlHelper sqlHelper=new SqlHelper();
        sqlHelper.setNo(voucher);
        sqlHelper.setAcquirerEnterPriseId(acquired);
        sqlHelper.setEnterPriseId(enterprise);
        sqlHelper.setCreateTime(billing);
        sqlHelper.setStatus(divbutton);
        sqlHelper.setAmountMin(minimum);
        sqlHelper.setAmountMax(maximum);
        String str=sqlHelper.sqlConcat();
        //?????????????????????
        ViewOpenInfoBizImpl viewOpenInfoBiz=new ViewOpenInfoBizImpl();

        //??????PageHelper????????????????????????
        PageHelper pageHelper=new PageHelper();
        String string=request.getParameter("index");
        if(string==null||"".equals(string)||"null".equals(string)){
            pageHelper.setIndexPage(1); //???   ??????????????????   ??????
        }else{
            int i=Integer.parseInt(string);
            pageHelper.setIndexPage(i);
        }
        pageHelper.setTotalCount(viewOpenInfoBiz.getTotalNumByConditions(str));//???  ????????????????????????   ??????
        pageHelper.setPageSize(4);//???  ?????????????????????   ??????
        pageHelper.setPageList(viewOpenInfoBiz.getAllInfoByCurrentPage(pageHelper,str));
        pageHelper.setTotalPage();
        Gson gson=new Gson();
        response.getWriter().println(gson.toJson(pageHelper));

    }
    /**
     * ????????????????????????
     */
    protected void getPayment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TicketopenBizImpl  ticketopenBiz = new TicketopenBizImpl();
        List<Ticketopen> list =  ticketopenBiz.queryAllPayment();
        Gson gson = new Gson();
        response.getWriter().println(gson.toJson(list));
    }

    /**
     * ???????????????????????????ticketopen???????????????
     * ??????????????????????????????,?????????????????????????????????
     * ??????????????????????????????????????????????????????
     * */
    protected void getTicketopeninfoByconditions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //??????????????????????????????
        String voucher=request.getParameter("vouchernumber");
        String acquired=request.getParameter("acquiredenterprise");
        String enterprise=request.getParameter("enterprisebilling");
        String billing=request.getParameter("billingdate");
        String minimum=request.getParameter("minimum");
        String maximum=request.getParameter("maximum");
        //???????????????SqlHelper,?????????????????????????????????????????????????????????
        SqlHelper sqlHelper=new SqlHelper();
        sqlHelper.setNo(voucher);
        sqlHelper.setAcquirerEnterPriseId(acquired);
        sqlHelper.setEnterPriseId(enterprise);
        sqlHelper.setCreateTime(billing);
        sqlHelper.setAmountMin(minimum);
        sqlHelper.setAmountMax(maximum);
        String str=sqlHelper.sqlConcat();
        //?????????????????????
        ViewOpenInfoBizImpl viewOpenInfoBiz=new ViewOpenInfoBizImpl();

        //??????PageHelper????????????????????????
        PageHelper pageHelper=new PageHelper();
        String string=request.getParameter("index");
        if(string==null){
            pageHelper.setIndexPage(1); //???   ??????????????????   ??????
        }else{
            int i=Integer.parseInt(string);
            pageHelper.setIndexPage(i);
        }
        pageHelper.setTotalCount(viewOpenInfoBiz.getTotalNumByStatus(str));//???  ????????????????????????   ??????
        pageHelper.setPageSize(5);//???  ?????????????????????   ??????
        pageHelper.setPageList(viewOpenInfoBiz.getAllOnTheBillByCurrentPage(pageHelper,str));
        pageHelper.setTotalPage();
        Gson gson=new Gson();
        response.getWriter().println(gson.toJson(pageHelper));
    }

    /**
     * ??????????????????
     * @return
     */
    public String certificateID(){
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH)+1;
        int date = cal.get(Calendar.DATE);
        String str = null;
        if(date<10){
            str = "0" + date;
        }else {
            str = Integer.toString(date);
        }
        String str1 = "N" + year + month + str + serialId();
        return str1;
    }


    /**
     * ?????????????????????
     * @return
     */

    public String  serialId() {
        TicketopenBizImpl ticketopenBiz = new TicketopenBizImpl();
        String str = Integer.toString(ticketopenBiz.queryMaxId()+1);
        char []serial = str.toCharArray();
        char []serialAll = new char[6];
        int num = serialAll.length - serial.length;
        for (int i = 0,j = 0; i < serialAll.length; i++,j++) {
            if(i<num){
                serialAll[i] = '0';
            }else {
                serialAll[i] = serial[j-num];
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < serialAll.length; i++) {
            sb.append(serialAll[i]);
        }
        String str1 = new String(sb);
        return str1;
    }

    /**
     * ??????????????????
     * @return
     */
    private String upLinkAddress() {
        StringBuilder sb = new StringBuilder();
        //??????16??????????????????
        Random rd = new SecureRandom();
        for (int i = 0; i < 16; i++) {
            //??????0-2???3????????????
            int type = rd.nextInt(3);
            switch (type){
                case 0:
                    //0-9????????????
                    sb.append(rd.nextInt(10));
                    break;
                case 1:
                    //ASCII???65-90???????????????,??????????????????
                    sb.append((char)(rd.nextInt(25)+65));
                    break;
                case 2:
                    //ASCII???97-122????????????????????????????????????
                    sb.append((char)(rd.nextInt(25)+97));
                    break;
                default:
                    break;
            }
        }
        return sb.toString();
    }

    protected void enterprisequery(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        //??????????????????????????????????????????????????????????????????????????????
        EnterpriseBizImpl enterpriseBiz=new EnterpriseBizImpl();
        List list=enterpriseBiz.getAllEnterpriseNames(0);
        Gson gson=new Gson();
        response.getWriter().println(gson.toJson(list));
    }
}

