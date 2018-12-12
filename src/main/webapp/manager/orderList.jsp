<%@ page import="org.lanqiao.domain.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="org.lanqiao.domain.Condition" %>
<%@ page import="org.lanqiao.utils.PageModel" %>
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
    <link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.css">
    <script type="text/javascript" src="js/jquery.min.js" ></script>
    <script type="text/javascript" src="/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        //修改订单状态
        function updateOrderState(orderId,state) {
            if(state == 3){
                var isUpdate = confirm("确定发货吗？");
            }else if(state == 6){
                var isUpdate = confirm("确定作废吗？");
            }
            if (isUpdate) {
                //查询条件
                var searchOrderNo = $("#searchOrderNo").val();
                var searchOrderState = $("#searchOrderState").val();
                var currentPage = $("#currentPage").val();
                var url = "/order.do?method=updateOrderState&orderId=" + orderId + "&state=" + state + "&searchOrderNo=" + searchOrderNo + "&searchOrderState=" + searchOrderState + "&currentPage=" + currentPage;
                $(".content").load(url);
            } else {
                return;
            }
        }

        //查看订单详情
        function getOrderInfo(orderId) {
            var url = "/order.do?method=getOrderInfo&orderId=" + orderId;
            $(".content").load(url);
        }

        //查询的手动提交方式
        function search(currentPage) {
            var searchOrderNo = $("#searchOrderNo").val();
            var searchOrderState = $("#searchOrderState").val();
            if(currentPage == null){
                var currentPage = $("#currentPage").val();
            }else{
                var currentPage = currentPage;
            }
            var url = "/order.do?method=getOrderlist&currentPage="+currentPage+"&searchOrderNo="+searchOrderNo+"&searchOrderState="+searchOrderState;
            $(".content").load(url);
        }
    </script>
</head>
<body>
<%
    Condition condition = (Condition) request.getAttribute("condition");
%>
<input type="hidden" name="currentPage" id="currentPage" value="<%=request.getAttribute("currentPage")%>">
<div class="modal-body">
    <form name="searchForm" id="searchForm">
        <div class="form-group">
            <label for="searchOrderNo" class="control-label">订单编号:</label>
            <input type="text" class="form-control" id="searchOrderNo" name="searchOrderNo" value="<%=condition.getName()%>">
        </div>
        <%--  <div class="form-group">
            <label for="searchOrderCtime" class="control-label">下单日期:</label>
            <input type="text" class="form-control" id="searchOrderCtime" name="searchOrderCtime" value="<%=condition.getDate()%>">
        </div>--%>
        <div class="form-group">
            <label for="searchOrderState" class="control-label">订单状态:</label>
            <%--<input type="text" class="form-control" id="searchOrderState" name="searchOrderState" value="<%=%>">--%>
            <select id="searchOrderState" name="searchOrderState" class="form-control">
                <option value="" <%if("".equals(condition.getState()))out.print(" selected ");%>>全部</option>
                <option value="1" <%if("1".equals(condition.getState()))out.print(" selected ");%>>未付款</option>
                <option value="2" <%if("2".equals(condition.getState()))out.print(" selected ");%>>已付款</option>
                <option value="3" <%if("3".equals(condition.getState()))out.print(" selected ");%>>已发货</option>
                <option value="4" <%if("4".equals(condition.getState()))out.print(" selected ");%>>已收货</option>
                <option value="5" <%if("5".equals(condition.getState()))out.print(" selected ");%>>已评价</option>
                <option value="6" <%if("6".equals(condition.getState()))out.print(" selected ");%>>已作废</option>
            </select>
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
        <th>订单id</th>
        <th>订单编号</th>
        <th>原价</th>
        <th>运费</th>
        <th>实付金额</th>
        <th>状态</th>
        <th>创建时间</th>
        <th>修改时间</th>
        <th>客户id</th>
        <th>操作</th>
        </thead>
        <tbody>
        <%
            List<Order> orderList = (List<Order>)request.getAttribute("orderList");
            PageModel pm = (PageModel) request.getAttribute("pm");
            for(Order order : orderList){
        %>
        <tr>
            <td><%=order.getId()%></td>
            <td><%=order.getNo()%></td>
            <td><%=order.getPrice()%></td>
            <td><%=order.getFreight()%></td>
            <td><%=order.getMoney()%></td>
            <td><%=order.getStateStr()%></td>
            <td><%=order.getCtime()%></td>
            <td><%=order.getRtime()%></td>
            <td><%=order.getCustomerName()%></td>
            <td>
                <a class="btn btn-default getOrderInfo" href="#" role="button"  name="getOrderInfo"  onclick="getOrderInfo(<%=order.getId()%>)">订单详情</a>

                <%if(order.getState() == 2){
                    %>
                <%--已付款的订单可发货--%>
                <a class="btn btn-default updateOrderState" href="#" role="button"  name="updateOrderState" onclick="updateOrderState(<%=order.getId()%>,3)">发货</a>
                <%
                }else if(order.getState() == 1){
                    %>
                <%--未付款的订单可取消订单--%>
                <a class="btn btn-default updateOrderState" href="#" role="button"  name="updateOrderState" onclick="updateOrderState(<%=order.getId()%>,6)">作废</a>
                <%
                }%>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
<%--分页插件--%>
<center>
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li  onclick="search(<%=pm.getStartPage()%>)"><a href="javascript:void(0);">首页</a></li>
            <li  onclick="search(<%=pm.getPrePageNum()%>)">
                <a href="javascript:void(0);"  aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <%
                int totalPageNum = pm.getTotalPageNum();
                for(int i = 1; i <= totalPageNum; i++){
            %>
            <li  onclick="search(<%=i%>)"><a href="javascript:void(0);"><span <%if(i==pm.getCurrentPageNum()){out.print("style = 'color:red;'");}%>> <%=i%></span></a></li>
            <%
                }
            %>
            <li onclick="search(<%=pm.getNextPageNum()%>)">
                <a href="#" class="page"  aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
            <li onclick="search(<%=pm.getEndPage()%>)"><a href="javascript:void(0);">尾页</a></li>
        </ul>
    </nav>
</center>
</body>
</html>

