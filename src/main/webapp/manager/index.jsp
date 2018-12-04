<%--
  Created by IntelliJ IDEA.
  User: WDS
  Date: 2018/12/3
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="utf-8" />
        <title>首页</title>
        <link rel="stylesheet" href="css/page.css" />
        <script type="text/javascript" src="js/jquery.min.js" ></script>
        <script type="text/javascript" src="js/index.js" ></script>
    </head>
    <body>
        <div class="left">
            <div class="bigTitle">网上书店后台管理系统</div>
            <div class="lines">
                <div onclick="pageClick(this)" class="active"><img src="img/icon-1.png" />分类管理</div>
                <div onclick="pageClick(this)"><img src="img/icon-2.png" />图书管理</div>
                <div onclick="pageClick(this)"><img src="img/icon-3.png" />订单管理</div>
                <div onclick="pageClick(this)"><img src="img/icon-4.png" />管理员信息管理</div>
                <div onclick="pageClick(this)"><img src="img/icon-4.png" />评价管理</div>
                <div onclick="pageClick(this)"><img src="img/icon-5.png" />用户管理</div>
                <div onclick="pageClick(this)"><img src="img/icon-5.png" />评价信息</div>
                <div onclick="pageClick(this)"><img src="img/icon-5.png" />信息反馈</div>
            </div>
        </div>
        <div class="top">
            <div class="leftTiyle" id="flTitle">分类管理</div>
            <div class="thisUser">当前用户：小UU</div>
        </div>
        <div class="content"></div>
        <div style="text-align:center;"></div>
    </body>
    <%--<script type="text/javascript">
        $(function(){
            $("#content").load("/bookType.do?method=getBookTypelist");
        })
    </script>--%>
</html>