<%--
  Created by IntelliJ IDEA.
  User: lyj
  Date: 2018/12/6
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/bookshop.do?method=getCartItemList" method="post">
        用户名:<input type="text" name="CustomerId" ><br><br>
        <input type="submit" value="我的购物车">
    </form>
</body>
</html>
