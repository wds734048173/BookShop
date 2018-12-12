<%@ page import="org.lanqiao.domain.Order" %>
<%@ page import="org.lanqiao.domain.OrderItem" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: WDS
  Date: 2018/12/10
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单详情</title>
    <link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.css">
    <script type="text/javascript" src="js/jquery.min.js" ></script>
    <script type="text/javascript" src="/bootstrap/js/bootstrap.js"></script>
</head>
<body>
<%Order order = (Order) request.getAttribute("order");%>
<div class="modal-body">
    <div class="col-xs-6">
        <label for="orderNo" class="control-label">订单编号:</label>
        <input type="text" class="form-control" id="orderNo" name="orderNo" value="<%=order.getId()%>" disabled>
    </div>
    <div class="col-xs-6">
        <label for="price" class="control-label">商品原价:</label>
        <input type="text" class="form-control" id="price" name="price" value="<%=order.getPrice()%>" disabled>
    </div>
    <br>
    <br>
    <div class="col-xs-6">
        <label for="freight" class="control-label">运费:</label>
        <input type="text" class="form-control" id="freight" name="freight" value="<%=order.getFreight()%>" disabled>
    </div>
    <div class="col-xs-6">
        <label for="money" class="control-label">商品实付金额:</label>
        <input type="text" class="form-control" id="money" name="money" value="<%=order.getMoney()%>" disabled>
    </div>
    <br>
    <br>
    <div class="col-xs-6">
        <label for="stateStr" class="control-label">状态:</label>
        <input type="text" class="form-control" id="stateStr" name="stateStr" value="<%=order.getStateStr()%>" disabled>
    </div>
    <div class="col-xs-6">
        <label for="ctime" class="control-label">创建时间:</label>
        <input type="text" class="form-control" id="ctime" name="ctime" value="<%=order.getCtime()%>" disabled>
    </div>
    <br>
    <br>
    <div class="col-xs-6">
        <label for="rtime" class="control-label">修改时间:</label>
        <input type="text" class="form-control" id="rtime" name="rtime" value="<%=order.getRtime()%>" disabled>
    </div>
    <div class="col-xs-6">
        <label for="name" class="control-label">收货人姓名:</label>
        <input type="text" class="form-control" id="name" name="name" value="<%=order.getName()%>" disabled>
    </div>
    <br>
    <br>
    <div class="col-xs-6">
        <label for="phone" class="control-label">收货人电话:</label>
        <input type="text" class="form-control" id="phone" name="phone" value="<%=order.getPhone()%>" disabled>
    </div>
    <div class="col-xs-6">
        <label for="address" class="control-label">收货人地址:</label>
        <input type="text" class="form-control" id="address" name="address" value="<%=order.getAddress()%>" disabled>
    </div>
</div>
<div class="modal-body" style="margin-top: 150px;">
    <table class="table table-hover table-bordered">
        <thead>
        <th>订单子表id</th>
        <th>商品名称</th>
        <th>原价</th>
        <th>售价</th>
        <th>数量</th>
        </thead>
        <tbody>
        <%
            List<OrderItem> orderItemList = (List<OrderItem>)request.getAttribute("orderItemList");
            for(OrderItem orderItem : orderItemList){
        %>
        <th><%=orderItem.getId()%></th>
        <th><%=orderItem.getBookName()%></th>
        <th><%=orderItem.getMprice()%></th>
        <th><%=orderItem.getPrice()%></th>
        <th><%=orderItem.getNum()%></th>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
