<%@ page import="org.lanqiao.domain.BookType" %>
<%@ page import="java.util.List" %>
<%@ page import="org.lanqiao.domain.Book" %>
<%@ page import="org.lanqiao.domain.Customer" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/6/006
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
    <link rel="stylesheet" type="text/css" href="./css/style.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript">

    </script>
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
                    <%
                        String name = (String) session.getAttribute("name");
                        if (name == null){
                    %>
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
    <%--导航栏--%>
    <div class="banner_y center" style="background: url('imges/1.jpg')">
        <div class="nav">
            <ul>
                <%
                    List<BookType> typeList = (List<BookType>) request.getAttribute("typeList");
                    List<Book> bookList = (List<Book>) request.getAttribute("bookList");

                    for (BookType bookType:typeList){
                %>
                <li>
                    <a href="/home.do?method=booklist&typeId=<%=bookType.getBookTypeId()%>&typename=<%=bookType.getBookTypeName()%>"><%=bookType.getBookTypeName()%></a>
                    <div class="pop">
                        <div class="left fl">
                            <%
                                for (Book book:bookList){
                                    if (book.getBookTypeid() == bookType.getBookTypeId()){
                            %>
                            <div>
                                <div class="xuangou_left fl">
                                    <a href="">
                                        <div class="img fl"><img src="<%=book.getBookPic()%>" alt=""></div>
                                        <span class="fl"><%=book.getBookName()%></span>
                                        <div class="clear"></div>
                                    </a>
                                </div>
                                <div class="xuangou_right fr"><a href="/bookinfo.do?method=detail&bookId=<%=book.getBookId()%>" target="_blank">选购</a></div>
                                <div class="clear"></div>
                            </div>
                            <%
                                    }
                                }
                            %>
                        </div>
                        <div class="clear"></div>
                    </div>

                </li>
                <%
                    }
                %>
            </ul>

        </div>
    </div>
    <div class="danpin center">

        <div class="biaoti center">好书推荐</div>
        <div class="main center">
            <%
                for (int i=0;i<5;i++){
                   Book book= bookList.get(i);
            %>
            <div class="mingxing fl">
                <div class="sub_mingxing"><a href="/bookinfo.do?method=detail&bookId=<%=book.getBookId()%>"><img src="<%=book.getBookPic()%>" alt=""></a></div>
                <div class="pinpai"><a href="/bookinfo.do?method=detail&bookId=<%=book.getBookId()%>"><%=book.getBookName()%></a></div>
                <div class="youhui"><%=book.getBookOutline().substring(0,9)%></div>
                <div class="jiage"><%=book.getBookPrice()%>元起</div>
            </div>
            <%
                }
            %>
            <div class="clear"></div>
        </div>
        <div class="main center">
            <%
                for (int i=5;i<10;i++){
                    Book book= bookList.get(i);
            %>
            <div class="mingxing fl">
                <div class="sub_mingxing"></div>
                <div class="pinpai"><a href="/bookinfo.do?method=detail&bookId=<%=book.getBookId()%>"><%=book.getBookName()%></a></div>
                <div class="youhui"><%=book.getBookOutline().substring(0,9)%></div>
                <div class="jiage"><%=book.getBookPrice()%>元</div>
            </div>
            <%
                }
            %>
            <div class="clear"></div>
        </div>
    </div>

    <footer class="mt20 center">

    </footer>
</body>
</html>
