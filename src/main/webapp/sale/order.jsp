<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/10/010
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的订单</title>
    <link rel="shortcut icon" type="image/x-icon" href="../sale/imges/book.ico">
    <link rel="stylesheet" type="text/css" href="../sale/css/style.css">
    <script type="text/javascript" src="../sale/js/jquery.min.js"></script>
    <script type="text/javascript" src="../sale/js/order.js"></script>
    <script type="text/javascript">
        $(function () {
        })
    </script>
</head>
<body>
    <header>
        <div class="top center">
            <div class="left fl">
                <ul>
                    <%--点击进入反馈页面--%>
                    <li><a href="/reply.do?method=getHomeList">问题反馈</a></li>
                    <div class="clear"></div>
                </ul>
            </div>
            <div class="right fr">
                <%
                    String name = (String) session.getAttribute("name");
                %>
                <div class="gouwuche fr"><a href="/bookshop.do?method=getCartItemList&id=<%=session.getAttribute("CustomerId")%>">购物车</a></div>
                <div class="fr">
                    <ul>
                        <li>欢迎您：<%=name%></li>
                        <li>|</li>
                        <li><a href="/logout.do">退出登录</a></li>
                    </ul>
                </div>
                <div class="clear"></div>
            </div>
            <div class="clear"></div>
        </div>
    </header>
    <div class="xiantiao"></div>

    <div class="grzxbj">
        <div class="selfinfo center">
            <div class="lfnav fl">
                <div class="ddzx">个人中心</div>
                <div class="subddzx">
                    <li class="ml40"><a href="/customer.do?method=getMyInfo">返回个人中心</a></li>
                </div>
                <div class="ddzx">订单中心</div>
                <div class="subddzx">
                    <ul id="hear" class="fl">
                        <!--带action的会默认选中-->
                        <li class="action" style="color: #FF4200;border-bottom: 1px solid #FF4200;"> 全部订单</li>
                        <li>未发货</li>
                        <li>已发货</li>
                        <li>已收货</li>
                        <li>已评价</li>
                        <li>已作废</li>
                    </ul>
                </div>
            </div>
            <div class="rtcont fr">
                <div class="ddzxbt">交易订单</div>
                <ul id="content"> <!--选项卡内容列表-->
                    <li class="action" id="content1">
                        第一页内容
                    </li>
                    <li id="content2"> 第二页内容 </li>
                    <li id="content3"> 第三页内容 </li>
                    <li id="content4">第四页内容</li>
                    <li id="content5">第五页内容</li>
                    <li id="content6">第六页内容</li>
                </ul>

        </div>
    </div>
</body>
</html>
