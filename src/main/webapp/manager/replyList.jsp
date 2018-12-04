<%@ page import="org.lanqiao.domain.Reply" %>
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
    <title>信息反馈列表</title>
    <script type="text/javascript" src="js/jquery.min.js" ></script>
    <script type="text/javascript">
        function getReplyList(){
            $.ajax({
                url:"/reply.do?method=getReplyList",
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
            window.onload(getReplyList())
        })
    </script>
</head>
<body>
<a href="#" role="button" id="addReply" name="addReply">添加信息反馈</a>
<table class="table table-hover table-bordered">
    <thead>
    <th>信息反馈id</th>
    <th>留言客户编号</th>
    <th>留言类型</th>
    <th>留言主题</th>
    <th>留言内容</th>
    <th>留言客户名</th>
    <th>留言日期</th>
    <th>修改日期</th>
    <th>操作</th>
    </thead>
    <tbody>
    <%
        List<Reply> replyList = (List<Reply>)request.getAttribute("replyList");
        for(Reply reply : replyList){
    %>
    <tr>
        <td><%=reply.getReplyId()%></td>
        <td><%=reply.getCustomerId()%></td>
        <td><%=reply.getReplyType()%></td>
        <td><%=reply.getReplytitle()%></td>
        <td><%=reply.getReplycontent()%></td>
        <td><%=reply.getCustomername()%></td>
        <td><%=reply.getCtime()%></td>
        <td><%=reply.getRtime()%></td>
        <td>
            <a class="updateReply" href="#" role="button"  name="updateReply">修改</a>
            <a class="deleteReply" href="#" role="button"  name="deleteReply">删除</a>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>
