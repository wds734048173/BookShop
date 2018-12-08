<%@ page import="org.lanqiao.domain.CartItem" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: lyj
  Date: 2018/12/6
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>购物车</title>
    <link rel="stylesheet" href="../bootstrap/css/bookshop.css"/>
    <%--<script type="text/javascript" src="../bootstrap/js/bookshop.js"></script>--%>
    <script type="text/javascript">
    $(function(){
        //删除
        $(".delete").click(function () {
            var  isDelete = confirm("确定删除吗?");
            if (isDelete) {
                var id = $(this).parent().parent().children("td:eq(0)").text();

            }
        })
    })
    </script>
</head>
<body>

<div class="catbox">

    <table id="cartTable">
        <thead>
        <tr>
            <th>商品名称</th>
            <th>商品图片</th>
            <th>价格</th>
            <th>原价</th>
            <th>商品ID</th>
            <th>数量</th>
            <th>小计</th>
            <th>操作</th>
        </tr>
        <%
            List<CartItem> cartItemList=(List<CartItem>) request.getAttribute("cartItemList");
            for(CartItem cu:cartItemList){%>
        <tr>
            <td class="goods"><%= cu.getBookName()%></td>
            <td class="pic"><%=cu.getBookPic()%></td>
            <td class="price"><%=cu.getBookPrice()%></td>
            <td><%=cu.getBookMprice()%></td>
            <td><%=cu.getBookId()%></td>
            <td class="count"><%=cu.getOrdermount()%></td>
            <td class="subtotal"><%=cu.getBookPrice()*cu.getOrdermount()%></td>
            <td class="operation"><span class="delete"><a class="btn btn-default delete" href="/bookshop.do?method=delByCustomerId&CustomerId=<%=cu.getCustomerId()%>&BookId=<%=cu.getBookId()%>" role="button" name="delete">删除</a></span></td>


        </tr>
        <%}%>
        </thead>
    </table>
    <div class="foot" id="foot">
        <div class="fr closing"><a href="#">结 算</a></div>
        <div class="fr total">合计：￥<span id="priceTotal"><%=request.getAttribute("total")%></span></div>
        <%--<div class="fr selected" id="selected">已选商品<span id="selectedTotal">0</span>件<span class="arrow up"></span><span class="arrow down"></span></div>--%>
        <%--<div class="selected-view">--%>
            <%--<div id="selectedViewList" class="clearfix">--%>
                <%--<div><img src=""></div>--%>
            <%--</div>--%>
            <%--<span class="arrow"><span></span></span>--%>
        <%--</div>--%>
    <%--</div>--%>

<%--</div>--%>
</body>
</html>