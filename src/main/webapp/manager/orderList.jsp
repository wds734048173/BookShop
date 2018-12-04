<%@ page import="org.lanqiao.domain.Order" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: WDS
  Date: 2018/12/3
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单列表</title>
    <script type="text/javascript" src="js/jquery.min.js" ></script>
    <script type="text/javascript">
        function getReplyList(){
            $.ajax({
                url:"/order.do?method=getOrderList",
                // data:{"greensClassId":id,"currentPage":currentPage,"searchGreensClassStateId":searchGreensClassStateId,"searchGreensClassName":searchGreensClassName},
                success:function (data) {
                    var orders = eval(data);

                    // var resultMap  = eval(data);
                    // var result = 0;
                    // var pageNum = 1;
                    // $.each(resultMap,function (name,value) {
                    //     if(name == "result"){
                    //         result = eval(value);
                    //     }else if (name == "pageNum"){
                    //         pageNum = eval(value);
                    //     }
                    // })
                    // if(result == 1){
                    //     alert("删除成功");
                    // }else{
                    //     alert("删除失败");
                    // }
                    window.location.href="/greensClass.do?method=getGreensClassList&searchGreensClassStateId="+searchGreensClassStateId+"&searchGreensClassName="+searchGreensClassName+"&currentPage="+pageNum;
                }
            })
        }
        $(function () {
            window.onload(getOrderList())
        })
    </script>
</head>
<body>
<a href="#" role="button" id="addOrder" name="addOrder">添加订单信息</a>
<table class="table table-hover table-bordered">
    <thead>
    <th>订单id</th>
    <th>订单编号</th>
    <th>原价</th>
    <th>运费</th>
    <th>实付金额</th>
    <th>状态</th>
    <th>收货人姓名</th>
    <th>收货人电话</th>
    <th>收货人地址</th>
    <th>创建时间</th>
    <th>修改时间</th>
    <th>客户id</th>
    <th>操作</th>
    </thead>
    <tbody>
    <%
        List<Order> orderList = (List<Order>)request.getAttribute("orderList");
        for(Order order : orderList){
    %>
    <tr>
        <td><%=order.getId()%></td>
        <td><%=order.getNo()%></td>
        <td><%=order.getPrice()%></td>
        <td><%=order.getFreight()%></td>
        <td><%=order.getMoney()%></td>
        <td><%=order.getState()%></td>
        <td><%=order.getName()%></td>
        <td><%=order.getPhone()%></td>
        <td><%=order.getAddress()%></td>
        <td><%=order.getCtime()%></td>
        <td><%=order.getRtime()%></td>
        <td><%=order.getCustomerId()%></td>
        <td>
            <a class="updateOrder" href="#" role="button"  name="updateOrder">修改</a>
            <a class="deleteOrder" href="#" role="button"  name="deleteOrder">删除</a>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>

