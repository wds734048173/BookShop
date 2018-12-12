<%@ page import="org.lanqiao.domain.Manager" %>
<%@ page import="java.util.List" %>
<%@ page import="org.lanqiao.utils.PageModel" %>
<%@ page import="org.lanqiao.domain.Condition" %>
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
    <title>管理员信息列表</title>
    <link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.css">
    <script type="text/javascript" src="js/jquery.min.js" ></script>
    <script type="text/javascript" src="/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $(function () {
            //删除
            $(".deleteManager").click(function () {
                var isDelete = confirm ("确定删除吗？");
                if(isDelete){
                    var id = $(this).parent().parent().children("td:eq(0)").text();
                    //查询条件
                    var searchAdminName = $("#searchAdminName").val();
                    var searchAdminPwd = $("#searchAdminPwd").val();
                    var searchAdminFlag = $("#searchAdminFlag").val();
                    var searchCtime = $("#searchCtime").val();
                    var searchRtime = $("#searchRtime").val();
                    var currentPage = $("#currentPage").val();
                    var url = "/manager.do?method=deleteManager&AdminId=" + id +"&searchAdminName=" + searchAdminName
                        +"&searchAdminPwd=" + searchAdminPwd+"&searchAdminFlag=" + searchAdminFlag
                        +"&searchCtime=" + searchCtime+"&searchRtime=" + searchRtime
                        + "&currentPage=" + currentPage;
                    $(".content").load(url);
                }else{
                    return;
                }
            })
        })


        //查询的手动提交方式
        function managersearch(currentPage) {
            var searchAdminName = $("#searchAdminName").val();
            if(currentPage == null){
                var currentPage = $("#currentPage").val();
            }else{
                var currentPage = currentPage;
            }
            var url = "/manager.do?method=getManagerList&currentPage="+currentPage+"&searchAdminName=" + searchAdminName;
            $(".content").load(url);
        }
    </script>
</head>
<body>
<br>

<%
    Condition condition = (Condition) request.getAttribute("condition");
%>
<input type="hidden" name="currentPage" id="currentPage" value="<%=request.getAttribute("currentPage")%>">
<div class="modal-body">
    <form name="searchForm" id="searchForm">
        <div class="form-group">
            <label for="searchAdminName" class="control-label">管理员姓名:</label>
            <input type="text" class="form-control" id="searchAdminName" name="searchAdminName" value="<%=condition.getName()%>">
        </div>
    </form>
    <div class="form-group">
        <input type="button" class="btn btn-primary" id="search" value="查询" onclick="managersearch(null)"/>
    </div>
</div>

<div class="modal-body">
    <table class="table table-hover table-bordered">
        <thead>
        <th>管理员编号</th>
        <th>管理员名称</th>
        <th>密码</th>
        <th>权限标志</th>
        <th>注册时间</th>
        <th>修改内容</th>
        <th>操作</th>
        </thead>
        <tbody>
        <%
            List<Manager> managerList = (List<Manager>)request.getAttribute("managerList");
            PageModel pm = (PageModel) request.getAttribute("pm");
            for(Manager manager : managerList){
        %>
        <tr>
            <td><%=manager.getAdminId()%></td>
            <td><%=manager.getAdminName()%></td>
            <td><%=manager.getAdminPwd()%></td>
            <td><%=manager.getAdminFlag()%></td>
            <td><%=manager.getCtime()%></td>
            <td><%=manager.getRtime()%></td>
            <td>
                <a class="btn btn-default deleteManager" href="#" role="button"  name="deleteManager">删除</a>
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
            <li  onclick="managersearch(<%=pm.getStartPage()%>)"><a href="javascript:void(0);">首页</a></li>
            <li  onclick="managersearch(<%=pm.getPrePageNum()%>)">
                <a href="javascript:void(0);"  aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <%
                int totalPageNum = pm.getTotalPageNum();
                for(int i = 1; i <= totalPageNum; i++){
            %>
            <li  onclick="managersearch(<%=i%>)"><a href="javascript:void(0);"><span <%if(i==pm.getCurrentPageNum()){out.print("style = 'color:red;'");}%>> <%=i%></span></a></li>
            <%
                }
            %>
            <li onclick="managersearch(<%=pm.getNextPageNum()%>)">
                <a href="#" class="page"  aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
            <%--实现方法一，但是目前不可以--%>
            <li onclick="managersearch(<%=pm.getEndPage()%>)"><a href="javascript:void(0);">尾页</a></li>
        </ul>
    </nav>
</center>
</body>
</html>
