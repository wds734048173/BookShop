<%@ page import="org.lanqiao.domain.Comment" %>
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
    <title>评价信息列表</title>
    <link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.css">
    <script type="text/javascript" src="js/jquery.min.js" ></script>
    <script type="text/javascript" src="/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        function getReplyList(){
            $.ajax({
                url:"/comment.do?method=getCommentList",
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
            window.onload(getCommentList())
        })
    </script>
</head>
<body>
<a class="btn btn-default" href="#" role="button" id="addComment" name="addComment">添加评价信息</a>
<br><br>
<table class="table table-hover table-bordered">
    <thead>
    <th>订单评价id</th>
    <th>图书编号</th>
    <th>评论客服编号</th>
    <th>评论客服名</th>
    <th>评论时间</th>
    <th>评论内容</th>
    <th>评论等级</th>
    <th>操作</th>
    </thead>
    <tbody>
    <%
        List<Comment> commentList = (List<Comment>)request.getAttribute("commentList");
        for(Comment comment : commentList){
    %>
    <tr>
        <td><%=comment.getCommentId()%></td>
        <td><%=comment.getBookId()%></td>
        <td><%=comment.getCustomerId()%></td>
        <td><%=comment.getUserName()%></td>
        <td><%=comment.getCommentdate()%></td>
        <td><%=comment.getCommentcontent()%></td>
        <td><%=comment.getCommentgrade()%></td>
        <td>
            <a class="btn btn-default updateComment" href="#" role="button"  name="updateComment">修改</a>
            <a class="btn btn-default deleteComment" href="#" role="button"  name="deleteComment">删除</a>
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
