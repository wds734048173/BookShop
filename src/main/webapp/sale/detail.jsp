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
    <script type="text/javascript" src="../sale/js/jquery.min.js"></script>
</head>
<body>
    <header>
        <div class="top center">
            <div class="left fl">
                <ul>
                    <li><a href="sale/index.jsp">返回首页</a></li>
                    <li>|</li>
                    <%--点击进入反馈页面--%>
                    <li><a href="">问题反馈</a></li>
                    <div class="clear"></div>
                </ul>
            </div>
            <div class="right fr">
                    <%
                        String name = (String) session.getAttribute("name");
                        if (name == null){
                    %>
                <%--购物车页面--%>
                    <div class="gouwuche fr"><a href="/sale/login.jsp">购物车</a></div>
                    <div class="fr">
                        <ul>
                            <%--登录页面--%>
                            <li><a href="./login.jsp" target="_blank">登录</a></li>
                            <li>|</li>
                            <%--注册页面--%>
                            <li><a href="./register.jsp" target="_blank" >注册</a></li>
                        </ul>
                    </div>
                    <%
                    }else {
                    %>
                    <div class="gouwuche fr"><a href="/bookshop.do?method=getCartItemList&CustomerId=<%=session.getAttribute("CustomerId")%>">购物车</a></div>
                    <div class="fr">
                        <ul>
                            <li>欢迎您：<%=name%></li>
                            <li>|</li>
                            <li><a href="/logout.do">退出登录</a></li>
                        </ul>
                    </div>
                    <%
                        }
                    %>
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
                    <li><a href="/sale/privateComment.do?bookid=<%=book.getBookId()%>">用户评价</a></li>
                    <div class="clear"></div>
                </nav>
                <div class="clear"></div>
            </div>
        </div>

        <div class="jieshao mt20 w">
            <div class="left fl"><img src="<%=book.getBookPic()%>" style="background-size:cover;width: 500px;height: 500px;margin: 30px 0 0 30px"></div>
            <div class="right fr">
                <div class="h3 ml20 mt20">《<%=book.getBookName()%>》</div>
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
    <div style="height: 200px">
        <div class="xiangqing">
            <div class="neirong w">
                <div class="xiaomi6 fl">概述</div>
            </div>
        </div>
        <div class="w f1">
            <div class="ml40 ftbc" style="color: #011737;float: left" ><%=book.getBookCatalog()%></div>
        </div>
    </div>
    <footer class="mt20 center">

    </footer>
</body>
</html>
