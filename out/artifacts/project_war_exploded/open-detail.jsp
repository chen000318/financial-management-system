<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>财务支付管理系统</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="stylesheet" href="assets/css/amazeui.min.css"/>
    <link rel="stylesheet" href="assets/css/admin.css">
    <link rel="stylesheet" href="assets/css/app.css">
    <script type="text/javascript" src="assets/js/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            //加载开单信息
            var p="${pageContext.request.getParameter("p")}";
            if(p=="1"){
                $.post("vcs","i=2&eid=${pageContext.request.getParameter('eid')}",function (str) {
                    eval("var viewCheck="+str);
                    $("[name='no']").empty();
                    $("[name='no']")[0].innerText=viewCheck.no;

                    $("[name='e_status']").empty();
                    $("[name='e_status']")[0].innerText="开单中";

                    $("[name='ename']").empty();
                    $("[name='ename']")[0].innerText=viewCheck.ename;

                    $("[name='esuc']").empty();
                    $("[name='esuc']")[0].innerText=viewCheck.esuc;

                    $("[name='aname']").empty();
                    $("[name='aname']")[0].innerText=viewCheck.aname;

                    $("[name='asuc']").empty();
                    $("[name='asuc']")[0].innerText=viewCheck.asuc;

                    $("[name='amount']").empty();
                    $("[name='amount']")[0].innerText=viewCheck.amount+"元";

                    $("[name='iname']").empty();
                    $("[name='iname']")[0].innerText=viewCheck.iname;

                    $("[name='create_time']").empty();
                    $("[name='create_time']")[0].innerText=viewCheck.createTime;

                    $("[name='expiry_time']").empty();
                    $("[name='expiry_time']")[0].innerText=viewCheck.expiryTime;

                    $("[name='pay_type']").empty();
                    $("[name='pay_type']")[0].innerText=viewCheck.paymentInterestType=="A"?"融资方付息":"核心企业付息";

                    $("[name='ticket_remark']").empty();
                    $("[name='ticket_remark']")[0].innerText=viewCheck.ticketRemark;



                })
            }else {
                $.post("vcs","i=1&eid=${pageContext.request.getParameter('eid')}",function (str) {
                    eval("var viewCheck="+str);
                    $("[name='no']").empty();
                    $("[name='no']")[0].innerText=viewCheck.no;

                    $("[name='e_status']").empty();
                    $("[name='e_status']")[0].innerText="开单中";

                    $("[name='ename']").empty();
                    $("[name='ename']")[0].innerText=viewCheck.ename;

                    $("[name='esuc']").empty();
                    $("[name='esuc']")[0].innerText=viewCheck.esuc;

                    $("[name='aname']").empty();
                    $("[name='aname']")[0].innerText=viewCheck.aname;

                    $("[name='asuc']").empty();
                    $("[name='asuc']")[0].innerText=viewCheck.asuc;

                    $("[name='amount']").empty();
                    $("[name='amount']")[0].innerText=viewCheck.amount+"元";

                    $("[name='iname']").empty();
                    $("[name='iname']")[0].innerText=viewCheck.iname;

                    $("[name='create_time']").empty();
                    $("[name='create_time']")[0].innerText=viewCheck.createTime;

                    $("[name='expiry_time']").empty();
                    $("[name='expiry_time']")[0].innerText=viewCheck.expiryTime;

                    $("[name='pay_type']").empty();
                    $("[name='pay_type']")[0].innerText=viewCheck.paymentInterestType=="A"?"融资方付息":"核心企业付息";

                    $("[name='ticket_remark']").empty();
                    $("[name='ticket_remark']")[0].innerText=viewCheck.ticketRemark;

                    $("[name='check_remark']").empty();
                    if(viewCheck.remark==undefined||viewCheck.remark.replace(/^\s*|\s*$/g,"")==""){
                        $("[name='check_remark']")[0].innerText="并没有留下什么审核备注，同意就完事了";
                    }else {
                        $("[name='check_remark']")[0].innerText=viewCheck.remark;
                    }



                })
            }

        })
    </script>
</head>
<body data-type="generalComponents">
<header class="am-topbar am-topbar-inverse admin-header">
    <div class="am-collapse am-topbar-collapse" id="topbar-collapse">
        <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list tpl-header-list">
            <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                    <span class="tpl-header-list-user-nick">禁言小张</span><span class="tpl-header-list-user-ico"> <img
                        src="assets/img/user01.png"></span>
                </a>
                <ul class="am-dropdown-content">
                    <li><a href="login.jsp"><span class="am-icon-power-off"></span> 退出</a></li>
                </ul>
            </li>
        </ul>
    </div>
</header>
<div class="tpl-page-container tpl-page-header-fixed">
    <div class="tpl-left-nav tpl-left-nav-hover">
        <div class="tpl-left-nav-list">
            <ul class="tpl-left-nav-menu">
                <li class="tpl-left-nav-item">
                    <a href="javascript:;" class="nav-link tpl-left-nav-link-list active">
                        <i class="am-icon-table"></i>
                        <span>付款管理</span>
                        <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right tpl-left-nav-more-ico-rotate"></i>
                    </a>
                    <ul class="tpl-left-nav-sub-menu" style="display:block">
                        <li>
                            <a href="ticket-open.jsp">
                                <i class="am-icon-angle-right"></i>
                                <span>开具付款凭证</span>
                            </a>
                            <a href="open-list.jsp" class="active">
                                <i class="am-icon-angle-right"></i>
                                <span>付款列表</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="tpl-left-nav-item">
                    <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-wpforms"></i>
                        <span>工作台</span>
                        <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                    </a>
                    <ul class="tpl-left-nav-sub-menu">
                        <li>
                            <a href="check-list.jsp">
                                <i class="am-icon-angle-right"></i>
                                <span>付款复核</span>
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <div class="tpl-content-wrapper">
        <div class="tpl-content-page-title">
            凭证详情
        </div>
        <ol class="am-breadcrumb">
            <li class="am-active"><a style="color: #999999;">付款管理</a></li>
            <li class="am-active">凭证详情</li>
        </ol>
        <div class="tpl-portlet-components">
            <div class="portlet-title">
                <div class="caption font-green bold">
                    凭证基本信息
                </div>
                <div class="tpl-portlet-input tpl-fz-ml">
                    <div class="portlet-input input-small input-inline">
                        <div class="input-icon right">
                        </div>
                    </div>
                </div>
            </div>
            <div class="tpl-block ">
                <div class="am-g tpl-amazeui-form">
                    <div class="am-u-sm-12 am-u-md-6">
                        <form class="am-form am-form-horizontal">
                            <div class="am-form-group">
                                <label for="user-name" class="am-u-sm-3 am-form-label">凭证编号</label>
                                <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;" name="no">
                                    N20220328000001
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="am-u-sm-12 am-u-md-6">
                        <form class="am-form am-form-horizontal">
                            <div class="am-form-group">
                                <label for="user-name" class="am-u-sm-3 am-form-label">处理状态</label>
                                <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;" name="e_status">
                                    开单中<span style="font-size: 12px;color: #999;margin-left: 5px;"> 内部复核中</span>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="am-u-sm-12 am-u-md-6">
                        <form class="am-form am-form-horizontal">
                            <div class="am-form-group">
                                <label for="user-name" class="am-u-sm-3 am-form-label">开单企业</label>
                                <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;" name="ename">
                                    百度科技有限公司
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="am-u-sm-12 am-u-md-6">
                        <form class="am-form am-form-horizontal">
                            <div class="am-form-group">
                                <label for="user-name" class="am-u-sm-3 am-form-label">统一社会信用代码</label>
                                <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;" name="esuc">
                                    91110000802100XXXX
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="am-u-sm-12 am-u-md-6">
                        <form class="am-form am-form-horizontal">
                            <div class="am-form-group">
                                <label for="user-name" class="am-u-sm-3 am-form-label">收单企业</label>
                                <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;" name="aname">
                                    腾讯科技有限公司
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="am-u-sm-12 am-u-md-6">
                        <form class="am-form am-form-horizontal">
                            <div class="am-form-group">
                                <label for="user-name" class="am-u-sm-3 am-form-label">统一社会信用代码</label>
                                <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;" name="asuc">
                                    91110000802100AAAA
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="am-u-sm-12 am-u-md-6">
                        <form class="am-form am-form-horizontal">
                            <div class="am-form-group">
                                <label for="user-name" class="am-u-sm-3 am-form-label">凭证金额</label>
                                <div class="am-u-sm-9" style="font-size: 19px;color: red;font-weight: 500;" name="amount">
                                    10,000,000.00元
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="am-u-sm-12 am-u-md-6">
                        <form class="am-form am-form-horizontal">
                            <div class="am-form-group">
                                <label for="user-name" class="am-u-sm-3 am-form-label">金融机构</label>
                                <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;" name="iname">
                                    工商银行
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="am-u-sm-12 am-u-md-6">
                        <form class="am-form am-form-horizontal">
                            <div class="am-form-group">
                                <label for="user-name" class="am-u-sm-3 am-form-label">开单日期</label>
                                <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;" name="create_time">
                                    2021-03-28
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="am-u-sm-12 am-u-md-6">
                        <form class="am-form am-form-horizontal">
                            <div class="am-form-group">
                                <label for="user-name" class="am-u-sm-3 am-form-label">到期日期</label>
                                <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;" name="expiry_time">
                                    2021-04-28 <span style="font-size: 12px;color: #999">剩余 10 天</span>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="am-u-sm-12 am-u-md-6">
                        <form class="am-form am-form-horizontal">
                            <div class="am-form-group">
                                <label for="user-name" class="am-u-sm-3 am-form-label">付息方式</label>
                                <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;" name="pay_type">
                                    融资企业付息
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="am-u-sm-12 am-u-md-6">
                        <form class="am-form am-form-horizontal">
                            <div class="am-form-group">
                                <label for="user-name" class="am-u-sm-3 am-form-label">备注</label>
                                <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;" name="ticket_remark">
                                    备注信息备注信息备注信息备注信息备注信息备注信息备注信息
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="am-u-sm-12 am-u-md-6">
                    </div>
                </div>
            </div>
        </div>
        <div class="tpl-portlet-components">
            <div class="portlet-title">
                <div class="caption font-green bold">
                    复核备注
                </div>
                <div class="tpl-portlet-input tpl-fz-ml">
                    <div class="portlet-input input-small input-inline">
                        <div class="input-icon right">
                        </div>
                    </div>
                </div>
            </div>
            <div class="tpl-block ">
                <div class="am-g tpl-amazeui-form">
                    <div class="am-u-sm-12 am-u-md-6">
                        <form class="am-form am-form-horizontal">
                            <div class="am-form-group">
                                <label for="user-name" class="am-u-sm-3 am-form-label">备注</label>
                                <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;">
                                    <textarea disabled class="" rows="4" id="user-intro" placeholder="审核备注" name="check_remark"></textarea>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div style="text-align: center;margin-top:40px">
                <a class="am-btn am-btn-default" href="open-list.jsp">返 回</a>
            </div>
        </div>
    </div>
</div>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/amazeui.min.js"></script>
<script src="assets/js/app.js"></script>
<script>

</script>
</body>

</html>