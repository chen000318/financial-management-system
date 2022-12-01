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
                    <a href="javascript:;" class="nav-link tpl-left-nav-link-list ">
                        <i class="am-icon-table"></i>
                        <span>付款管理</span>
                        <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right tpl-left-nav-more-ico-rotate"></i>
                    </a>
                    <ul class="tpl-left-nav-sub-menu">
                        <li>
                            <a href="ticket-open.jsp">
                                <i class="am-icon-angle-right"></i>
                                <span>开具付款凭证</span>
                            </a>
                            <a href="open-list.jsp">
                                <i class="am-icon-angle-right"></i>
                                <span>付款列表</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="tpl-left-nav-item">
                    <a href="javascript:;" class="nav-link tpl-left-nav-link-list active">
                        <i class="am-icon-wpforms"></i>
                        <span>工作台</span>
                        <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                    </a>
                    <ul class="tpl-left-nav-sub-menu" style="display:block">
                        <li>
                            <a href="check-list.jsp" class="active">
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
            付款复核列表
        </div>
        <ol class="am-breadcrumb">
            <li class="am-active"><a style="color: #999999;">工作台</a></li>
            <li class="am-active">付款复核列表</li>
        </ol>
        <div class="tpl-portlet-components">
            <div class="tpl-block">
                <div class="am-g">
                    <div class="am-u-sm-6 am-u-md-3">
                        <div class="am-input-group am-input-group-sm">
                                <span class="am-input-group-btn">
                                    <span style="font-size: 14px;margin-right: 8px;margin-left: 8px">凭证编号</span>
                                </span>
                            <input type="text" class="am-form-field" placeholder="&nbsp;&nbsp;请输入凭证编号"
                                   style="border: 1px solid #c2cad8;width: 77%;border-radius: 3px;">
                        </div>
                    </div>
                    <div class="am-u-sm-6 am-u-md-3">
                        <div class="am-form-group">
                            <span style="font-size: 14px;">收单企业</span>
                            <select data-am-selected="{btnSize: 'sm'}">
                                <option value="">请选择收单企业</option>
                                <option value="a">百度科技有限公司</option>
                                <option value="b">京东集团</option>
                                <option value="c">小米</option>
                            </select>
                        </div>
                    </div>
                    <div class="am-u-sm-6 am-u-md-3">
                        <div class="am-form-group">
                            <span style="font-size: 14px;">开单企业</span>
                            <select class="am-form-field" data-am-selected="{btnSize: 'sm'}">
                                <option value="">请选择开单企业</option>
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
                            <input type="text" class="am-form-field" data-am-datepicker
                                   placeholder="&nbsp;&nbsp;请选择日期"
                                   style="border: 1px solid #c2cad8;width: 68%;border-radius: 3px;">
                        </div>
                    </div>
                </div>
                <div class="am-g">
                    <div class="am-u-sm-6 am-u-md-4">
                        <div class="am-input-group am-input-group-sm">
                                <span class="am-input-group-btn">
                                    <span style="font-size: 14px;margin-right: 8px;margin-left: 8px">凭证金额</span>
                                </span>
                            <input type="text" class="am-form-field" placeholder="&nbsp;&nbsp;最低金额(万)"
                                   style="border: 1px solid #c2cad8;width: 23%;border-radius: 3px;">
                            <div class="am-form-field"
                                 style="width: 0%; border-radius: 3px;border: none;margin-left: 10px;">~
                            </div>
                            <input type="text" class="am-form-field" placeholder="&nbsp;&nbsp;最高金额(万)"
                                   style="border: 1px solid #c2cad8;width: 23%;border-radius: 3px;margin-left: 20px;">
                        </div>
                    </div>
                </div>
            </div>
            <div class="am-g">
                <div class="am-u-sm-12">
                    <form class="am-form">
                        <table class="am-table am-table-striped am-table-hover table-main">
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
                                <th class="table-set">操作</th>
                            </tr>
                            </thead>
                            <tbody id="doc-modal-list">
                            <tr data-id="2">
                                <td class="am-hide-sm-only">N20220328000001</td>
                                <td class="am-hide-sm-only">腾讯科技有限公司</td>
                                <td class="am-hide-sm-only">1,000,000.00</td>
                                <td class="am-hide-sm-only">腾讯科技有限公司</td>
                                <td class="am-hide-sm-only">中国工商银行</td>
                                <td class="am-hide-sm-only">2021-12-31</td>
                                <td class="am-hide-sm-only">2021-12-31</td>
                                <td class="am-hide-sm-only">F64A3FA774552D68</td>
                                <td>
                                    <div class="am-btn-toolbar">
                                        <div class="am-btn-group am-btn-group-xs">
                                            <a href="check-detail.jsp"><span class="am-text-secondary"
                                                                             style="cursor:pointer"><span></span>
                                                        复核</span></a>
                                        </div>
                                    </div>
                                </td>
                            </tr>

                            <tr data-id="2">
                                <td class="am-hide-sm-only">N20220406000002</td>
                                <td class="am-hide-sm-only">腾讯科技有限公司</td>
                                <td class="am-hide-sm-only">1,000,000.00</td>
                                <td class="am-hide-sm-only">腾讯科技有限公司</td>
                                <td class="am-hide-sm-only">中国工商银行</td>
                                <td class="am-hide-sm-only">2021-12-31</td>
                                <td class="am-hide-sm-only">2021-12-31</td>
                                <td class="am-hide-sm-only">F64A3FA774552D69</td>
                                <td>
                                    <div class="am-btn-toolbar">
                                        <div class="am-btn-group am-btn-group-xs">
                                            <a href="check-detail.jsp"><span class="am-text-secondary"
                                                                             style="cursor:pointer"><span></span>
                                                        复核</span></a>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr data-id="2">
                                <td class="am-hide-sm-only">N20220406000003</td>
                                <td class="am-hide-sm-only">腾讯科技有限公司</td>
                                <td class="am-hide-sm-only">1,000,000.00</td>
                                <td class="am-hide-sm-only">腾讯科技有限公司</td>
                                <td class="am-hide-sm-only">中国工商银行</td>
                                <td class="am-hide-sm-only">2021-12-31</td>
                                <td class="am-hide-sm-only">2021-12-31</td>
                                <td class="am-hide-sm-only">F64A3FA774552D70</td>
                                <td>
                                    <div class="am-btn-toolbar">
                                        <div class="am-btn-group am-btn-group-xs">
                                            <a href="check-detail.jsp"><span class="am-text-secondary"
                                                                             style="cursor:pointer"><span></span>
                                                        复核</span></a>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr data-id="2">
                                <td class="am-hide-sm-only">N20220407000004</td>
                                <td class="am-hide-sm-only">腾讯科技有限公司</td>
                                <td class="am-hide-sm-only">1,000,000.00</td>
                                <td class="am-hide-sm-only">腾讯科技有限公司</td>
                                <td class="am-hide-sm-only">中国工商银行</td>
                                <td class="am-hide-sm-only">2021-12-31</td>
                                <td class="am-hide-sm-only">2021-12-31</td>
                                <td class="am-hide-sm-only">F64A3FA774552D71</td>
                                <td>
                                    <div class="am-btn-toolbar">
                                        <div class="am-btn-group am-btn-group-xs">
                                            <a href="check-detail.jsp"><span class="am-text-secondary"
                                                                             style="cursor:pointer"><span></span>
                                                        复核</span></a>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr data-id="2">
                                <td class="am-hide-sm-only">N20220407000005</td>
                                <td class="am-hide-sm-only">腾讯科技有限公司</td>
                                <td class="am-hide-sm-only">1,000,000.00</td>
                                <td class="am-hide-sm-only">腾讯科技有限公司</td>
                                <td class="am-hide-sm-only">中国工商银行</td>
                                <td class="am-hide-sm-only">2021-12-31</td>
                                <td class="am-hide-sm-only">2021-12-31</td>
                                <td class="am-hide-sm-only">F64A3FA774552D72</td>
                                <td>
                                    <div class="am-btn-toolbar">
                                        <div class="am-btn-group am-btn-group-xs">
                                            <a href="check-detail.jsp"><span class="am-text-secondary"
                                                                             style="cursor:pointer"><span></span>
                                                        复核</span></a>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <div class="am-cf">

                            <div class="am-fr">
                                <ul class="am-pagination tpl-pagination">
                                    <li class="am-disabled"><a href="#">«</a></li>
                                    <li class="am-active"><a href="#">1</a></li>
                                    <li><a href="#">2</a></li>
                                    <li><a href="#">3</a></li>
                                    <li><a href="#">4</a></li>
                                    <li><a href="#">5</a></li>
                                    <li><a href="#">»</a></li>
                                </ul>
                            </div>
                        </div>
                        <hr>
                    </form>
                </div>
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