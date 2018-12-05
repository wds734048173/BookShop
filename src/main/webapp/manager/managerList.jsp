<%@ page import="org.lanqiao.domain.Manager" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: joker
  Date: 2018/12/4/004
  Time: 19:41
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
        function getManagerList(){
            $.ajax({
                url:"/manager.do?method=getManagerList",
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
            window.onload(getManagerList())
        })
    </script>
</head>
<body>
<a class="btn btn-default" href="#" role="button" id="addComment" name="addComment">添加评价信息</a>
<br><br>
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
        List<Manager> managerList = (List<Manager>)request.getAttribute("ManagerList");
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
            <a class="updateComment" href="#" role="button"  name="updateComment">修改</a>
            <a class="deleteComment" href="#" role="button"  name="deleteComment">删除</a>
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
