<%@ page import="org.lanqiao.domain.Book" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/6/006
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Book book = (Book) request.getAttribute("bookDetail");
%>
<html>
<head>
    <title><%=book.getBookName()%></title>
    <link rel="stylesheet" type="text/css" href="../sale/css/style.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
    <header>
        <div class="top center">
            <div class="left fl">
                <ul>
                    <%--点击进入反馈页面--%>
                    <li><a href="">问题反馈</a></li>
                    <div class="clear"></div>
                </ul>
            </div>
            <div class="right fr">
                <%--购物车页面--%>
                <div class="gouwuche fr"><a href="">购物车</a></div>
                <div class="fr">
                    <ul>
                        <%--登录页面--%>
                        <li><a href="./login.jsp" target="_blank">登录</a></li>
                        <li>|</li>
                        <%--注册页面--%>
                        <li><a href="./register.jsp" target="_blank" >注册</a></li>
                    </ul>
                </div>
                <div class="clear"></div>
            </div>
            <div class="clear"></div>
        </div>
    </header>
    <form action="post" method="">
        <div class="xiangqing">
            <div class="neirong w">
                <div class="xiaomi6 fl"><%=book.getBookName()%></div>
                <nav class="fr">
                    <%--点击进入用户评价--%>
                    <li><a href="">用户评价</a></li>
                    <div class="clear"></div>
                </nav>
                <div class="clear"></div>
            </div>
        </div>

        <div class="jieshao mt20 w">
            <div class="left fl"><img src="<%=book.getBookPic()%>"></div>
            <div class="right fr">
                <div class="h3 ml20 mt20"><%=book.getBookName()%></div>
                <div class="jianjie mr40 ml20 mt10"><%=book.getBookOutline()%></div>
                <div class="jianjie mr40 ml20">作者：<%=book.getBookAuthor()%></div>
                <div class="jianjie mr40 ml20">出版社：<%=book.getBookPress()%></div>
                <div class="jianjie mr40 ml20">出版时间：<%=book.getBookPubDate()%></div>
                <div class="jiage ml20 mt10">售价：<%=book.getBookPrice()%></div>
                <div class="jianjie mr40 ml20">原价:<%=book.getBookMprice()%></div>
                <div class="xiadan ml20 mt20">
                    <input class="jrgwc"  type="button" name="jrgwc" value="立即选购" />
                    <input class="jrgwc" type="button" name="jrgwc" value="加入购物车" />
                </div>
            </div>
            <div class="clear"></div>
        </div>
    </form>
    <div >
        <div class="xiangqing">
            <div class="neirong w">
                <div class="xiaomi6 fl">概述</div>
            </div>
        </div>
        <div class="w"><%=book.getBookCatalog()%></div>
    </div>
    <footer class="mt20 center">

    </footer>
</body>
</html>
