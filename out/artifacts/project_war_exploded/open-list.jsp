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
    <script src="assets/js/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        var butt=null;
        $(document).on("click","button",function () {
            butt = $(this).val();
            var url = "i=1&vouchernumber="+$("[name='voucher number']").val()+
                         "&acquiredenterprise="+$("[name='acquired enterprise']").val()+
                         "&enterprisebilling="+$("[name='enterprise billing']").val()+
                         "&billingdate="+$("[name='billing date']").val()+
                         "&button="+$(this).val()+
                         "&minimum="+$("[name='minimum amount']").val()+
                         "&maximum="+$("[name='maximum amount']").val();
            $.get("tos",url,function (str) {
                eval("var pageHelper="+str);
                $("[id='doc-modal-list']").empty();
                for(var i=0;i<pageHelper.pageList.length;i++){
                    var a = pageHelper.pageList[i].status=="A"?"成功":(pageHelper.pageList[i].status=="B"?"开单中": (pageHelper.pageList[i].status=="C"?"已撤销":"复核未通过"));
                    var b = pageHelper.pageList[i].status=="A"?"<a href='open-detail.jsp'>详情</a>":
                           (pageHelper.pageList[i].status=="B"?"<a href='open-detail.jsp'>详情</a> <a >撤销</a>":
                           (pageHelper.pageList[i].status=="C"?"<a href='open-detail.jsp'>详情</a> <a href='ticket-open.jsp'>重新申请</a>":
                                "<a href='open-detail.jsp'>详情</a> <a href='ticket-open.jsp'>重新申请</a>"));
                    var obj="<tr>" +
                        "<td>"+pageHelper.pageList[i].no+"</td>" +
                        "<td>"+pageHelper.pageList[i].aname+"</td>" +
                        "<td>"+pageHelper.pageList[i].amount+"</td>" +
                        "<td>"+pageHelper.pageList[i].ename+"</td>" +
                        "<td>"+pageHelper.pageList[i].iname+"</td>" +
                        "<td>"+pageHelper.pageList[i].createTime+"</td>" +
                        "<td>"+pageHelper.pageList[i].expiryTime+"</td>" +
                        "<td>"+pageHelper.pageList[i].upLinkAddress+"</td>" +
                        "<td>"+a+"</td>"+
                        "<td>"+b+"</td>"+
                        "</tr>";
                    $(obj).appendTo($("[name='showtable']"));
                }
            })
        })
        $(document).ready(function () {
            $.get("tos","i=1",function (str) {
                eval("var pageHelper="+str);
                if(pageHelper.totalPage>5){
                    for (var i=5;i>=2;i--){
                        $("[name='page']").after("<li><a value="+i+">"+i+"</a></li>")
                    }
                }else {
                    for (var i=pageHelper.totalPage;i>=2;i--){
                        $("[name='page']").after("<li><a value="+i+">"+i+"</a></li>")
                    }
                }

            })

            $("[name='voucher number']").blur(function () {
                var url = "i=1&vouchernumber="+$("[name='voucher number']").val()+
                             "&acquiredenterprise="+$("[name='acquired enterprise']").val()+
                             "&enterprisebilling="+$("[name='enterprise billing']").val()+
                             "&billingdate="+$("[name='billing date']").val()+
                             "&button="+butt+
                             "&minimum="+$("[name='minimum amount']").val()+
                             "&maximum="+$("[name='maximum amount']").val();
                $.post("tos",url,function (str) {
                    eval("var pageHelper="+str);
                    $("[id='doc-modal-list']").empty();
                    for(var i=0;i<pageHelper.pageList.length;i++){
                        var a = pageHelper.pageList[i].status=="A"?"成功":(pageHelper.pageList[i].status=="B"?"开单中": (pageHelper.pageList[i].status=="C"?"已撤销":"复核未通过"));
                        var b = pageHelper.pageList[i].status=="A"?"<a href='open-detail.jsp'>详情</a>":
                               (pageHelper.pageList[i].status=="B"?"<a href='open-detail.jsp'>详情</a> <a >撤销</a>":
                               (pageHelper.pageList[i].status=="C"?"<a href='open-detail.jsp'>详情</a> <a href='ticket-open.jsp'>重新申请</a>":
                                    "<a href='open-detail.jsp'>详情</a> <a href='ticket-open.jsp'>重新申请</a>"));
                        var obj="<tr>" +
                            "<td>"+pageHelper.pageList[i].no+"</td>" +
                            "<td>"+pageHelper.pageList[i].aname+"</td>" +
                            "<td>"+pageHelper.pageList[i].amount+"</td>" +
                            "<td>"+pageHelper.pageList[i].ename+"</td>" +
                            "<td>"+pageHelper.pageList[i].iname+"</td>" +
                            "<td>"+pageHelper.pageList[i].createTime+"</td>" +
                            "<td>"+pageHelper.pageList[i].expiryTime+"</td>" +
                            "<td>"+pageHelper.pageList[i].upLinkAddress+"</td>" +
                            "<td>"+a+"</td>"+
                            "<td>"+b+"</td>"+
                            "</tr>";
                        $(obj).appendTo($("[name='showtable']"));
                    }
                })
            })
            $.post("tos","i=3",function (str) {
                $("[name='acquired enterprise']")[0].options.length=1;
                eval("var list="+str)
                for(var i=0;i<list.length;i++){
                    var obj="<option value='"+list[i].id+"'>"+list[i].name+"</option>";
                    $(obj).appendTo("[name='acquired enterprise']");
                }
            })

            $("[name='acquired enterprise']").change(function () {
                var url = "i=1&vouchernumber="+$("[name='voucher number']").val()+
                             "&acquiredenterprise="+$("[name='acquired enterprise']").val()+
                             "&enterprisebilling="+$("[name='enterprise billing']").val()+
                             "&billingdate="+$("[name='billing date']").val()+
                             "&button="+butt+
                             "&minimum="+$("[name='minimum amount']").val()+
                             "&maximum="+$("[name='maximum amount']").val();
                $.post("tos",url,function (str) {
                    eval("var pageHelper="+str);
                    $("[id='doc-modal-list']").empty();
                    for(var i=0;i<pageHelper.pageList.length;i++){
                        var a = pageHelper.pageList[i].status=="A"?"成功":(pageHelper.pageList[i].status=="B"?"开单中": (pageHelper.pageList[i].status=="C"?"已撤销":"复核未通过"));
                        var b = pageHelper.pageList[i].status=="A"?"<a href='open-detail.jsp'>详情</a>":
                               (pageHelper.pageList[i].status=="B"?"<a href='open-detail.jsp'>详情</a> <a >撤销</a>":
                               (pageHelper.pageList[i].status=="C"?"<a href='open-detail.jsp'>详情</a> <a href='ticket-open.jsp'>重新申请</a>":
                                    "<a href='open-detail.jsp'>详情</a> <a href='ticket-open.jsp'>重新申请</a>"));
                        var obj="<tr>" +
                            "<td>"+pageHelper.pageList[i].no+"</td>" +
                            "<td>"+pageHelper.pageList[i].aname+"</td>" +
                            "<td>"+pageHelper.pageList[i].amount+"</td>" +
                            "<td>"+pageHelper.pageList[i].ename+"</td>" +
                            "<td>"+pageHelper.pageList[i].iname+"</td>" +
                            "<td>"+pageHelper.pageList[i].createTime+"</td>" +
                            "<td>"+pageHelper.pageList[i].expiryTime+"</td>" +
                            "<td>"+pageHelper.pageList[i].upLinkAddress+"</td>" +
                            "<td>"+a+"</td>"+
                            "<td>"+b+"</td>"+
                            "</tr>";
                        $(obj).appendTo($("[name='showtable']"));
                    }
                })
            })
            $.post("tos","i=3",function (str) {
                $("[name='enterprise billing']")[0].options.length=1;
                eval("var list="+str)
                for(var i=0;i<list.length;i++){
                    var obj="<option value='"+list[i].id+"'>"+list[i].name+"</option>";
                    $(obj).appendTo("[name='enterprise billing']");
                }
            })
            $("[name='enterprise billing']").change(function () {
                var url = "i=1&vouchernumber="+$("[name='voucher number']").val()+
                             "&acquiredenterprise="+$("[name='acquired enterprise']").val()+
                             "&enterprisebilling="+$("[name='enterprise billing']").val()+
                             "&billingdate="+$("[name='billing date']").val()+
                             "&button="+butt+
                             "&minimum="+$("[name='minimum amount']").val()+
                             "&maximum="+$("[name='maximum amount']").val();

                $.post("tos",url,function (str) {
                    eval("var pageHelper="+str);
                    $("[id='doc-modal-list']").empty();
                    for(var i=0;i<pageHelper.pageList.length;i++){
                        var a = pageHelper.pageList[i].status=="A"?"成功":(pageHelper.pageList[i].status=="B"?"开单中": (pageHelper.pageList[i].status=="C"?"已撤销":"复核未通过"));
                        var b = pageHelper.pageList[i].status=="A"?"<a href='open-detail.jsp'>详情</a>":
                               (pageHelper.pageList[i].status=="B"?"<a href='open-detail.jsp'>详情</a> <a >撤销</a>":
                               (pageHelper.pageList[i].status=="C"?"<a href='open-detail.jsp'>详情</a> <a href='ticket-open.jsp'>重新申请</a>":
                                    "<a href='open-detail.jsp'>详情</a> <a href='ticket-open.jsp'>重新申请</a>"));
                        var obj="<tr>" +
                            "<td>"+pageHelper.pageList[i].no+"</td>" +
                            "<td>"+pageHelper.pageList[i].aname+"</td>" +
                            "<td>"+pageHelper.pageList[i].amount+"</td>" +
                            "<td>"+pageHelper.pageList[i].ename+"</td>" +
                            "<td>"+pageHelper.pageList[i].iname+"</td>" +
                            "<td>"+pageHelper.pageList[i].createTime+"</td>" +
                            "<td>"+pageHelper.pageList[i].expiryTime+"</td>" +
                            "<td>"+pageHelper.pageList[i].upLinkAddress+"</td>" +
                            "<td>"+a+"</td>"+
                            "<td>"+b+"</td>"+
                            "</tr>";
                        $(obj).appendTo($("[name='showtable']"));
                    }
                })
            })
            $("[name='billing date']").change(function () {
                var url = "i=1&vouchernumber="+$("[name='voucher number']").val()+
                             "&acquiredenterprise="+$("[name='acquired enterprise']").val()+
                             "&enterprisebilling="+$("[name='enterprise billing']").val()+
                             "&billingdate="+$("[name='billing date']").val()+
                             "&button="+butt+
                             "&minimum="+$("[name='minimum amount']").val()+
                             "&maximum="+$("[name='maximum amount']").val();
                $.post("tos",url,function (str) {
                    eval("var pageHelper="+str);
                    $("[id='doc-modal-list']").empty();
                    for(var i=0;i<pageHelper.pageList.length;i++){
                        var a = pageHelper.pageList[i].status=="A"?"成功":(pageHelper.pageList[i].status=="B"?"开单中": (pageHelper.pageList[i].status=="C"?"已撤销":"复核未通过"));
                        var b = pageHelper.pageList[i].status=="A"?"<a href='open-detail.jsp'>详情</a>":
                               (pageHelper.pageList[i].status=="B"?"<a href='open-detail.jsp'>详情</a> <a >撤销</a>":
                               (pageHelper.pageList[i].status=="C"?"<a href='open-detail.jsp'>详情</a> <a href='ticket-open.jsp'>重新申请</a>":
                                    "<a href='open-detail.jsp'>详情</a> <a href='ticket-open.jsp'>重新申请</a>"));
                        var obj="<tr>" +
                            "<td>"+pageHelper.pageList[i].no+"</td>" +
                            "<td>"+pageHelper.pageList[i].aname+"</td>" +
                            "<td>"+pageHelper.pageList[i].amount+"</td>" +
                            "<td>"+pageHelper.pageList[i].ename+"</td>" +
                            "<td>"+pageHelper.pageList[i].iname+"</td>" +
                            "<td>"+pageHelper.pageList[i].createTime+"</td>" +
                            "<td>"+pageHelper.pageList[i].expiryTime+"</td>" +
                            "<td>"+pageHelper.pageList[i].upLinkAddress+"</td>" +
                            "<td>"+a+"</td>"+
                            "<td>"+b+"</td>"+
                            "</tr>";
                        $(obj).appendTo($("[name='showtable']"));
                    }
                })
            })
            // $("[name='divbutton']>button").click(function () {
            //     var url = "i=1&vouchernumber="+$("[name='voucher number']").val()+"&acquiredenterprise="+$("[name='acquired enterprise']").val()+
            //         "&enterprisebilling="+$("[name='enterprise billing']").val()+"&billingdate="+$("[name='billing date']").val()+
            //         "&button="+$("[name='divbutton']>button").val()+"&minimum="+$("[name='minimum amount']").val()+"&maximum="+$("[name='maximum amount']").val();
            //     alert($("[name='divbutton']>button").val());
            //     $.post("tos",url,function (str) {
            //         eval("var pageHelper="+str);
            //         $("[id='doc-modal-list']").empty();
            //         for(var i=0;i<pageHelper.pageList.length;i++){
            //             var a = pageHelper.pageList[i].status=="A"?"成功":(pageHelper.pageList[i].status=="B"?"开单中": (pageHelper.pageList[i].status=="C"?"已撤销":"复核未通过"));
            //             var b = pageHelper.pageList[i].status=="A"?"<a href='open-detail.jsp'>详情</a>":
            //                    (pageHelper.pageList[i].status=="B"?"<a href='open-detail.jsp'>详情</a> <a >撤销</a>":
            //                    (pageHelper.pageList[i].status=="C"?"<a href='open-detail.jsp'>详情</a> <a href='ticket-open.jsp'>重新申请</a>":
            //                         "<a href='open-detail.jsp'>详情</a> <a href='ticket-open.jsp'>重新申请</a>"));
            //             var obj="<tr>" +
            //                 "<td>"+pageHelper.pageList[i].no+"</td>" +
            //                 "<td>"+pageHelper.pageList[i].aname+"</td>" +
            //                 "<td>"+pageHelper.pageList[i].amount+"</td>" +
            //                 "<td>"+pageHelper.pageList[i].ename+"</td>" +
            //                 "<td>"+pageHelper.pageList[i].iname+"</td>" +
            //                 "<td>"+pageHelper.pageList[i].createTime+"</td>" +
            //                 "<td>"+pageHelper.pageList[i].expiryTime+"</td>" +
            //                 "<td>"+pageHelper.pageList[i].upLinkAddress+"</td>" +
            //                 "<td>"+a+"</td>"+
            //                 "<td>"+b+"</td>"+
            //                 "</tr>";
            //             $(obj).appendTo("table");
            //         }
            //     })
            // })
            $("[name='minimum amount']").blur(function() {
                var url = "i=1&vouchernumber="+$("[name='voucher number']").val()+
                             "&acquiredenterprise="+$("[name='acquired enterprise']").val()+
                             "&enterprisebilling="+$("[name='enterprise billing']").val()+
                             "&billingdate="+$("[name='billing date']").val()+
                             "&button="+butt+
                             "&minimum="+$("[name='minimum amount']").val()+
                             "&maximum="+$("[name='maximum amount']").val();
                $.post("tos",url,function (str) {
                    eval("var pageHelper="+str);
                    $("[id='doc-modal-list']").empty();
                    for(var i=0;i<pageHelper.pageList.length;i++){
                        var a = pageHelper.pageList[i].status=="A"?"成功":(pageHelper.pageList[i].status=="B"?"开单中": (pageHelper.pageList[i].status=="C"?"已撤销":"复核未通过"));
                        var b = pageHelper.pageList[i].status=="A"?"<a href='open-detail.jsp'>详情</a>":
                               (pageHelper.pageList[i].status=="B"?"<a href='open-detail.jsp'>详情</a> <a >撤销</a>":
                               (pageHelper.pageList[i].status=="C"?"<a href='open-detail.jsp'>详情</a> <a href='ticket-open.jsp'>重新申请</a>":
                                    "<a href='open-detail.jsp'>详情</a> <a href='ticket-open.jsp'>重新申请</a>"));
                        var obj="<tr>" +
                            "<td>"+pageHelper.pageList[i].no+"</td>" +
                            "<td>"+pageHelper.pageList[i].aname+"</td>" +
                            "<td>"+pageHelper.pageList[i].amount+"</td>" +
                            "<td>"+pageHelper.pageList[i].ename+"</td>" +
                            "<td>"+pageHelper.pageList[i].iname+"</td>" +
                            "<td>"+pageHelper.pageList[i].createTime+"</td>" +
                            "<td>"+pageHelper.pageList[i].expiryTime+"</td>" +
                            "<td>"+pageHelper.pageList[i].upLinkAddress+"</td>" +
                            "<td>"+a+"</td>"+
                            "<td>"+b+"</td>"+
                            "</tr>";
                        $(obj).appendTo($("[name='showtable']"));

                    }
                })
            })
            $("[name='maximum amount']").blur(function () {
                var url = "i=1&vouchernumber="+$("[name='voucher number']").val()+
                             "&acquiredenterprise="+$("[name='acquired enterprise']").val()+
                             "&enterprisebilling="+$("[name='enterprise billing']").val()+
                             "&billingdate="+$("[name='billing date']").val()+
                             "&button="+butt+
                             "&minimum="+$("[name='minimum amount']").val()+
                             "&maximum="+$("[name='maximum amount']").val();
                $.post("tos",url,function (str) {
                    eval("var pageHelper="+str);
                    $("[id='doc-modal-list']").empty();
                    for(var i=0;i<pageHelper.pageList.length;i++){
                        var a = pageHelper.pageList[i].status=="A"?"成功":(pageHelper.pageList[i].status=="B"?"开单中": (pageHelper.pageList[i].status=="C"?"已撤销":"复核未通过"));
                        var b = pageHelper.pageList[i].status=="A"?"<a href='open-detail.jsp'>详情</a>":
                               (pageHelper.pageList[i].status=="B"?"<a href='open-detail.jsp'>详情</a> <a >撤销</a>":
                               (pageHelper.pageList[i].status=="C"?"<a href='open-detail.jsp'>详情</a> <a href='ticket-open.jsp'>重新申请</a>":
                                    "<a href='open-detail.jsp'>详情</a> <a href='ticket-open.jsp'>重新申请</a>"));
                        var obj="<tr>" +
                            "<td>"+pageHelper.pageList[i].no+"</td>" +
                            "<td>"+pageHelper.pageList[i].aname+"</td>" +
                            "<td>"+pageHelper.pageList[i].amount+"</td>" +
                            "<td>"+pageHelper.pageList[i].ename+"</td>" +
                            "<td>"+pageHelper.pageList[i].iname+"</td>" +
                            "<td>"+pageHelper.pageList[i].createTime+"</td>" +
                            "<td>"+pageHelper.pageList[i].expiryTime+"</td>" +
                            "<td>"+pageHelper.pageList[i].upLinkAddress+"</td>" +
                            "<td>"+a+"</td>"+
                            "<td>"+b+"</td>"+
                            "</tr>";
                        $(obj).appendTo($("[name='showtable']"));
                    }
                })
            })
            $(document).on("click","#page_ul",function () {
                var val=$(this)[0].getAttribute("value");
                $.post("tos","i=1&index="+val,function (str) {
                    eval("var pageHelper="+str);
                    $("[id='doc-modal-list']").empty();
                    for(var i=0;i<pageHelper.pageList.length;i++){
                        var a = pageHelper.pageList[i].status=="A"?"成功":(pageHelper.pageList[i].status=="B"?"开单中": (pageHelper.pageList[i].status=="C"?"已撤销":"复核未通过"));
                        var b = pageHelper.pageList[i].status=="A"?"<a href='open-detail.jsp'>详情</a>":
                               (pageHelper.pageList[i].status=="B"?"<a href='open-detail.jsp'>详情</a> <a >撤销</a>":
                               (pageHelper.pageList[i].status=="C"?"<a href='open-detail.jsp'>详情</a> <a href='ticket-open.jsp'>重新申请</a>":
                                    "<a href='open-detail.jsp'>详情</a> <a href='ticket-open.jsp'>重新申请</a>"));
                        var obj="<tr>" +
                            "<td>"+pageHelper.pageList[i].no+"</td>" +
                            "<td>"+pageHelper.pageList[i].aname+"</td>" +
                            "<td>"+pageHelper.pageList[i].amount+"</td>" +
                            "<td>"+pageHelper.pageList[i].ename+"</td>" +
                            "<td>"+pageHelper.pageList[i].iname+"</td>" +
                            "<td>"+pageHelper.pageList[i].createTime+"</td>" +
                            "<td>"+pageHelper.pageList[i].expiryTime+"</td>" +
                            "<td>"+pageHelper.pageList[i].upLinkAddress+"</td>" +
                            "<td>"+a+"</td>"+
                            "<td>"+b+"</td>"+
                            "</tr>";
                        $(obj).appendTo("[id='doc-modal-list']");
                    }
                });
            });
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
    <style>
        .ele-dot-text {
            width: 45px;
            display: inline-block;
            margin-left: 20px;
        }

        .ele-dot-status {

            width: 8px;
            height: 8px;
            display: inline-block;
            border-radius: 50%;
            line-height: 10px;
        }

        .ele-dot-status-success {
            background: #52c41a;
        }

        .ele-dot-status-error {
            background: #ff4d4f;
        }

        .ele-dot-status-info {
            background: #1890ff;
        }
    </style>
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
            付款列表
        </div>
        <ol class="am-breadcrumb">
            <li class="am-active"><a style="color: #999999;">付款管理</a></li>
            <li class="am-active">付款列表</li>
        </ol>
        <div class="tpl-portlet-components">
            <div class="tpl-block">
                <div class="am-g">
                    <div class="am-u-sm-6 am-u-md-3">
                        <div class="am-input-group am-input-group-sm">
                                <span class="am-input-group-btn">
                                    <span style="font-size: 14px;margin-right: 8px;margin-left: 8px">凭证编号</span>
                                </span>
                            <input type="text" name="voucher number" class="am-form-field" placeholder="&nbsp;&nbsp;请输入凭证编号"
                                   style="border: 1px solid #c2cad8;width: 84%;border-radius: 3px;">
                        </div>
                    </div>
                    <div class="am-u-sm-6 am-u-md-3">
                        <div class="am-form-group">
                            <span style="font-size: 14px;">收单企业</span>
                            <select data-am-selected="{btnSize: 'sm'}" name="acquired enterprise">
                                <option value="null">请选择收单企业</option>
                                <option value="a">百度科技有限公司</option>
                                <option value="b">京东集团</option>
                                <option value="c">小米</option>
                            </select>
                        </div>
                    </div>
                    <div class="am-u-sm-6 am-u-md-3">
                        <div class="am-form-group">
                            <span style="font-size: 14px;">开单企业</span>
                            <select class="am-form-field" data-am-selected="{btnSize: 'sm'}" name="enterprise billing">
                                <option value="null">请选择开单企业</option>
                                <option value="a">腾讯科技有限公司</option>
                                <option value="b">隆基股份有限公司</option>
                            </select>
                        </div>
                    </div>
                    <div class="am-u-sm-6 am-u-md-3">
                        <div class="am-input-group am-input-group-sm">
                                <span class="am-input-group-btn">
                                    <span style="font-size: 14px;margin-right: 8px;margin-left: 8px">开单日期</span>
                                </span>
                            <input type="text" name="billing date" class="am-form-field" data-am-datepicker
                                   placeholder="&nbsp;&nbsp;请选择日期"
                                   style="border: 1px solid #c2cad8;width: 68%;border-radius: 3px;">
                        </div>
                    </div>
                </div>
                <div class="am-g">
                    <div class="am-u-sm-6 am-u-md-3">
                        <div class="am-input-group am-input-group-sm">
                                <span class="am-input-group-btn">
                                    <span style="font-size: 14px;margin-right: 8px;margin-left: 8px">处理状态</span>
                                </span>
                            <div class="am-btn-group am-btn-group-sm status-type" name="divbutton">
                                <button type="button" class="am-btn am-btn-primary am-radius">全部</button>
                                <button type="button" class="am-btn am-btn-default" value="A">成功</button>
                                <button type="button" class="am-btn am-btn-default" value="B">开单中</button>
                                <button type="button" class="am-btn am-btn-default" value="D">失败</button>
                            </div>
                        </div>
                    </div>
                    <div class="am-u-sm-6 am-u-md-4" style="margin-left: -10px;">
                        <div class="am-input-group am-input-group-sm">
                                <span class="am-input-group-btn">
                                    <span style="font-size: 14px;margin-right: 8px;margin-left: 8px">凭证金额</span>
                                </span>
                            <input type="text" name="minimum amount" class="am-form-field" placeholder="&nbsp;&nbsp;最低金额(万)"
                                   style="border: 1px solid #c2cad8;width: 23%;border-radius: 3px;">
                            <div class="am-form-field"
                                 style="width: 0%; border-radius: 3px;border: none;margin-left: 10px;">~
                            </div>
                            <input type="text" name="maximum amount" class="am-form-field" placeholder="&nbsp;&nbsp;最高金额(万)"
                                   style="border: 1px solid #c2cad8;width: 23%;border-radius: 3px;margin-left: 20px;">
                        </div>
                    </div>
                    <div style="float:right;margin-right:20px">
                        <a class="am-btn am-btn-primary" href="ticket-open.jsp">去开单</a>
                    </div>
                </div>
            </div>
            <div class="am-g">
                <div class="am-u-sm-12">
                    <form class="am-form">
                        <table class="am-table am-table-striped am-table-hover table-main" name="showtable">
                            <thead>
                            <tr>
                                <th class="table-title">凭证编号</th>
                                <th class="table-type">收单企业</th>
                                <th class="table-author am-hide-sm-only">凭证金额（元）</th>
                                <th class="table-date am-hide-sm-only">开单企业</th>
                                <th class="table-date am-hide-sm-only">金融机构</th>
                                <th class="table-date am-hide-sm-only">开单日期</th>
                                <th class="table-date am-hide-sm-only">到期日期</th>
                                <th class="table-date am-hide-sm-only">上链地址</th>
                                <th class="table-date am-hide-sm-only">处理状态</th>
                                <th class="table-set">操作</th>
                            </tr>
                            </thead>
                            <tbody id="doc-modal-list">
                            <tr data-id="2">
                                <td class="am-hide-sm-only">N20220328000001</td>
                                <td class="am-hide-sm-only">百度科技有限公司</td>
                                <td class="am-hide-sm-only">1,000,000.00</td>
                                <td class="am-hide-sm-only">腾讯科技有限公司</td>
                                <td class="am-hide-sm-only">中国工商银行</td>
                                <td class="am-hide-sm-only">2021-12-31</td>
                                <td class="am-hide-sm-only">2021-12-31</td>
                                <td class="am-hide-sm-only">F64A3FA774552D72</td>
                                <td class="am-hide-sm-only">
                                            <span class="ele-dot-status ele-dot-status-success"><span>
                                            <span class="ele-dot-text" style="width: 80px;">成功</span>
                                <td>
                                    <div class="am-btn-toolbar">
                                        <div class="am-btn-group am-btn-group-xs">
                                            <a href="open-detail.jsp"><span class="am-text-secondary"
                                                                            style="cursor:pointer"><span></span>
                                                        详情</span></a>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr data-id="2">
                                <td class="am-hide-sm-only">N20220406000002</td>
                                <td class="am-hide-sm-only">百度科技有限公司</td>
                                <td class="am-hide-sm-only">1,000,000.00</td>
                                <td class="am-hide-sm-only">腾讯科技有限公司</td>
                                <td class="am-hide-sm-only">中国工商银行</td>
                                <td class="am-hide-sm-only">2021-12-31</td>
                                <td class="am-hide-sm-only">2021-12-31</td>
                                <td class="am-hide-sm-only">F64A3FA774552D68</td>
                                <td class="am-hide-sm-only">
                                            <span class="ele-dot-status ele-dot-status-info"><span>
                                            <span class="ele-dot-text" style="width: 80px;">开单中</span>
                                <td>
                                    <div class="am-btn-toolbar">
                                        <div class="am-btn-group am-btn-group-xs">
                                            <a href="open-detail.jsp"><span class="am-text-secondary"
                                                                            style="cursor:pointer"><span></span>
                                                        详情</span></a>
                                            <span class="am-text-secondary am-icon"
                                                  style="cursor:pointer"><span></span>
                                                            撤销</span>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr data-id="2">
                                <td class="am-hide-sm-only">N20220407000004</td>
                                <td class="am-hide-sm-only">百度科技有限公司</td>
                                <td class="am-hide-sm-only">1,000,000.00</td>
                                <td class="am-hide-sm-only">腾讯科技有限公司</td>
                                <td class="am-hide-sm-only">中国工商银行</td>
                                <td class="am-hide-sm-only">2021-12-31</td>
                                <td class="am-hide-sm-only">2021-12-31</td>
                                <td class="am-hide-sm-only">F64A3FA774552D70</td>
                                <td class="am-hide-sm-only">
                                            <span class="ele-dot-status ele-dot-status-error"><span>
                                            <span class="ele-dot-text" style="width: 80px;">复核未通过</span>
                                <td>
                                    <div class="am-btn-toolbar">
                                        <div class="am-btn-group am-btn-group-xs">
                                            <a href="open-detail.jsp"><span class="am-text-secondary"
                                                                            style="cursor:pointer"><span></span>
                                                        详情</span></a>
                                            <a href="ticket-open.jsp"><span class="am-text-secondary"
                                                                            style="cursor:pointer"><span></span>
                                                        重新申请</span></a>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr data-id="2">
                                <td class="am-hide-sm-only">N20220407000004</td>
                                <td class="am-hide-sm-only">百度科技有限公司</td>
                                <td class="am-hide-sm-only">1,000,000.00</td>
                                <td class="am-hide-sm-only">腾讯科技有限公司</td>
                                <td class="am-hide-sm-only">中国工商银行</td>
                                <td class="am-hide-sm-only">2021-12-31</td>
                                <td class="am-hide-sm-only">2021-12-31</td>
                                <td class="am-hide-sm-only">F64A3FA774552D70</td>
                                <td class="am-hide-sm-only">
                                            <span class="ele-dot-status ele-dot-status-error"><span>
                                            <span class="ele-dot-text" style="width: 80px;">已撤销</span>
                                <td>
                                    <div class="am-btn-toolbar">
                                        <div class="am-btn-group am-btn-group-xs">
                                            <a href="open-detail.jsp"><span class="am-text-secondary"
                                                                            style="cursor:pointer"><span></span>
                                                        详情</span></a>
                                            <a href="ticket-open.jsp"><span class="am-text-secondary"
                                                                            style="cursor:pointer"><span></span>
                                                        重新申请</span></a>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <div class="am-cf">

                            <div class="am-fr">
                                <ul class="am-pagination tpl-pagination" id="page_ul">
                                    <li class="am-disabled"><a href="#" >«</a></li>
                                    <li class="am-active" name="page"><a href="#" value="1">1</a></li>
<%--                                    <li><a href="#">2</a></li>--%>
<%--                                    <li><a href="#">3</a></li>--%>
<%--                                    <li><a href="#">4</a></li>--%>
<%--                                    <li><a href="#">5</a></li>--%>
                                    <li><a href="#">»</a></li>
                                </ul>
                            </div>
                        </div>
                        <hr>
                    </form>
                </div>
                <!-- 撤销二次确认弹出框 -->
                <div class="am-modal am-modal-confirm" tabindex="-1" id="my-confirm">
                    <div class="am-modal-dialog" style="font-size: 16px;">
                        <div class="am-modal-hd">提示</div>
                        <div class="am-modal-bd">
                            将进行撤销，是否继续？
                        </div>
                        <div class="am-modal-footer">
                            <span class="am-modal-btn" data-am-modal-cancel>取消</span>
                            <span class="am-modal-btn" data-am-modal-confirm>确定</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="tpl-alert"></div>
    </div>
</div>

<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/amazeui.min.js"></script>
<script src="assets/js/app.js"></script>
<script>
    // 撤销二次确认
    $(function () {
        //状态按钮样式切换
        $('.status-type').find('button').on('click', function () {
            let statusTypeBtnArr = $('.status-type').find('button');
            for (let i = 0; i < statusTypeBtnArr.length; i++) {
                statusTypeBtnArr.eq(i).removeClass('am-btn-primary');
            }
            $(this).addClass('am-btn-primary');
        });
        $('#doc-modal-list').find('.am-icon').add('#doc-confirm-toggle').on('click', function () {
            $('#my-confirm').modal({
                relatedTarget: this,
                onConfirm: function (options) {
                    //点击确认调用函数
                    alert("点击了确认");
                },
                onCancel: function () {
                    //点击取消调用函数
                    alert("点击了取消")
                }
            });
        });
    });
</script>
</body>

</html>