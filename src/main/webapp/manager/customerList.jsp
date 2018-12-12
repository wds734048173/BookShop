<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        //查询的手动提交方式
        function search(currentPage) {
            var name = $("#searchCustomerName").val();
            if(currentPage == null){
                var currentPage = $("#currentPage").val();
            }else{
                var currentPage = currentPage;
            }
            var url = "/customer.do?method=getCustomerlist&currentPage="+currentPage+"&searchCustomerName="+name;
            $(".content").load(url);
        }
    </script>
</head>
<body>
<input type="hidden" name="currentPage" id="currentPage" value="${currentPage}">
<div class="modal-body">
    <form name="searchForm" id="searchForm">
        <div class="form-7">
            <label for="searchCustomerName" class="control-label">客户姓名:</label>
            <input type="text" class="form-control" id="searchCustomerName" name="searchCustomerName" value="${condition.name}">
        </div>
    </form>
    <div class="form-group">
        <input type="button" class="btn btn-primary" id="search" value="查询" onclick="search(null)"/>
    </div>
</div>

<br><br>
<div class="modal-body">
    <table class="table table-hover table-bordered">
        <thead>
        <th>客户编号</th>
        <th>客户姓名</th>
        <th>真实姓名</th>
        <th>性别</th>
        <th>客户电话</th>
        <th>E-mail</th>
        <th>地址</th>
        <th>注册时间</th>
        <th>修改时间</th>
        <th>提示问题</th>
        <th>问题答案</th>
        <th>登录次数</th>
        <th>最近登录时间</th>
        </thead>
        <tbody>
        <%--<%--%>
            <%--List<Customer> customerList = (List<Customer>)request.getAttribute("customerList");--%>
            <%--PageModel pm = (PageModel) request.getAttribute("pm");--%>
            <%--for(Customer customer : customerList){--%>
        <%--%>--%>
        <%--<tr>--%>
            <%--<td><%=customer.getCustomerId()%></td>--%>
            <%--<td><%=customer.getCustomerName()%></td>--%>
            <%--<td><%=customer.getCustomertruename()%></td>--%>
            <%--<td><%=customer.getCustomerSex()%></td>--%>
            <%--<td><%=customer.getCustomerTel()%></td>--%>
            <%--<td><%=customer.getCustomerEmail()%></td>--%>
            <%--<td><%=customer.getCustomerAddr()%></td>--%>
            <%--<td><%=customer.getCTime()%></td>--%>
            <%--<td><%=customer.getRTime()%></td>--%>
            <%--<td><%=customer.getCustomerQues()%></td>--%>
            <%--<td><%=customer.getCustomerAnswer()%></td>--%>
            <%--<td><%=customer.getCustomerLogTime()%></td>--%>
            <%--<td><%=customer.getCustomerLastLogT()%></td>--%>

        <%--</tr>--%>
        <c:forEach begin="0" end="${customerList.size()}" var="customer" items="${customerList}" step="1">
            <tr>
                <td>${customer.customerId}</td>
                <td>${customer.customerName}</td>
                <td>${customer.customertruename}</td>
                <td>${customer.customerSex}</td>
                <td>${customer.customerTel}</td>
                <td>${customer.customerEmail}</td>
                <td>${customer.customerAddr}</td>
                <td>${customer.CTime}</td>
                <td>${customer.CTime}</td>
                <td>${customer.customerQues}</td>
                <td>${customer.customerAnswer}</td>
                <td>${customer.customerLogTime}</td>
                <td>${customer.customerLastLogT}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%--分页插件--%>
<center>
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li  onclick="search(${pm.startPage})"><a href="javascript:void(0);">首页</a></li>
            <li  onclick="search(${pm.prePageNum})">
                <a href="javascript:void(0);"  aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <c:forEach step="1" var="i" begin="1" end="${pm.totalPageNum}">
                <li  onclick="search(${i})"><a href="javascript:void(0);"><span <c:if test="${i==pm.currentPageNum}"> style = 'color:red;' </c:if>> ${i}</span></a></li>
            </c:forEach>
            <li onclick="search(${pm.nextPageNum})">
                <a href="#" class="page"  aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
            <%--实现方法一，但是目前不可以--%>
            <li onclick="search(${pm.endPage})"><a href="javascript:void(0);">尾页</a></li>
        </ul>
    </nav>
</center>
</body>
</html>
