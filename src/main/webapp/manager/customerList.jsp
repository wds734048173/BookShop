<%@ page import="org.lanqiao.domain.Customer" %>
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
    <title>客户信息列表</title>
    <link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.css">
    <script type="text/javascript" src="js/jquery.min.js" ></script>
    <script type="text/javascript" src="/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        function getReplyList(){
            $.ajax({
                url:"/customer.do?method=getCustomerList",
                // data:{"greensClassId":id,"currentPage":currentPage,"searchGreensClassStateId":searchGreensClassStateId,"searchGreensClassName":searchGreensClassName},
                success:function (data) {
                    var replys = eval(data);

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
            window.onload(getCustomerList())
        })
    </script>
</head>
<body>
<a class="btn btn-default" href="#" role="button" id="addCustomer" name="addCustomer">添加客服信息</a>
<br><br>
<table class="table table-hover table-bordered">
    <thead>
    <th>客户编号</th>
    <th>客户姓名</th>
    <th>客户密码</th>
    <th>真实姓名</th>
    <th>0表示男,1表示女</th>
    <th>客户电话</th>
    <th>E-mail</th>
    <th>地址</th>
    <th>注册时间</th>
    <th>修改时间</th>
    <th>提示问题</th>
    <th>问题答案</th>
    <th>登录次数</th>
    <th>最近登录时间</th>
    <th>操作</th>
    </thead>
    <tbody>
    <%
        List<Customer> customerList = (List<Customer>)request.getAttribute("customerList");
        for(Customer customer : customerList){
    %>
    <tr>
        <td><%=customer.getCustomerId()%></td>
        <td><%=customer.getUserName()%></td>
        <td><%=customer.getPassword()%></td>
        <td><%=customer.getName()%></td>
        <td><%=customer.getCustomerSex()%></td>
        <td><%=customer.getCustomerTel()%></td>
        <td><%=customer.getCustomerEmail()%></td>
        <td><%=customer.getCustomerAddr()%></td>
        <td><%=customer.getCTime()%></td>
        <td><%=customer.getRTime()%></td>
        <td><%=customer.getCustomerQues()%></td>
        <td><%=customer.getCustomerAnswer()%></td>
        <td><%=customer.getCustomerLogTime()%></td>
        <td><%=customer.getCustomerLastLogT()%></td>
        <td>
            <a class="updateCustomer" href="#" role="button"  name="updateCustomer">修改</a>
            <a class="deleteCustomer" href="#" role="button"  name="deleteCustomer">删除</a>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<br><br>
</body>
</html>
