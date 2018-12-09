<%@ page import="org.lanqiao.domain.Reply" %>
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
    <title>信息反馈列表</title>
    <link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.css">
    <script type="text/javascript" src="js/jquery.min.js" ></script>
    <script type="text/javascript" src="/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $(function () {
            //删除
            $(".deleteReply").click(function () {
                var isDelete = confirm ("确定删除吗？");
                if(isDelete){
                    var id = $(this).parent().parent().children("td:eq(0)").text();
                    //查询条件
                    var searchCustomerId = $("#searchCustomerId").val();
                    var searchReplyType = $("#searchReplyType").val();
                    var searchReplytitle = $("#searchReplytitle").val();
                    var searchCustomername = $("#searchCustomername").val();
                    var searchReplycontent = $("#searchReplycontent").val();
                    var searchCtime = $("#searchCtime").val();
                    var searchRtime = $("#searchRtime").val();
                    var currentPage = $("#currentPage").val();
                    var url = "/reply.do?method=deleteReply&ReplyId=" + id +"&searchCustomerId=" + searchCustomerId+"&searchReplyType=" + searchReplyType
                        +"&searchReplytitle=" + searchReplytitle+"&searchCustomername=" + searchCustomername
                        +"&searchReplycontent=" + searchReplycontent+"&searchCtime=" + searchCtime+"&searchRtime=" + searchRtime
                        + "&currentPage=" + currentPage;
                    $(".content").load(url);
                }else{
                    return;
                }
            })
        })

        //查询的手动提交方式
        function search(currentPage) {
            var searchCustomerId = $("#searchCustomerId").val();
            var searchReplyType = $("#searchReplyType option:selected").text();
            var searchReplycontent = $("#searchReplycontent").val();
            if(currentPage == null){
                var currentPage = $("#currentPage").val();
            }else{
                var currentPage = currentPage;
            }
            var url = "/reply.do?method=getReplylist&currentPage="+currentPage+"&searchCustomerId=" + searchCustomerId+"&searchReplyType=" + searchReplyType
                +"&searchReplycontent=" + searchReplycontent;
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
            <label for="searchCustomerId" class="control-label">留言客户:</label>
            <input type="text" class="form-control" id="searchCustomerId" name="searchCustomerId" value="<%=condition.getBookTypeId()%>">

            <label for="searchReplyType" class="control-label">留言类型:</label>
            <select id="searchReplyType" name="searchReplyType"  class="form-control">
                <option value="-1" <%if(("全部").equals(condition.getState())){out.print("selected");}%>>全部</option>
                <option value="0" <%if(("赞美").equals(condition.getState())){out.print("selected");}%>>赞美</option>
                <option value="1" <%if(("批评").equals(condition.getState())){out.print("selected");}%>>批评</option>
                <option value="2" <%if(("鼓励").equals(condition.getState())){out.print("selected");}%>>鼓励</option>
            </select>
            <label for="searchReplycontent" class="control-label">留言内容:</label>
            <input type="text" class="form-control" id="searchReplycontent" name="searchReplycontent" value="<%=condition.getName()%>">
        </div>
    </form>
    <div class="form-group">
        <input type="button" class="btn btn-primary" id="search" value="查询" onclick="search(null)"/>
    </div>
</div>

<div class="modal-body">
    <table class="table table-hover table-bordered">
        <thead>
        <th>信息反馈id</th>
        <th>留言类型</th>
        <th>留言主题</th>
        <th>留言内容</th>
        <th>留言客户名</th>
        <th>留言日期</th>
        <th>操作</th>
        </thead>
        <tbody>
        <%
            List<Reply> replyList = (List<Reply>)request.getAttribute("replyList");
            PageModel pm = (PageModel) request.getAttribute("pm");
            for(Reply reply : replyList){
        %>
        <tr>
            <td><%=reply.getReplyId()%></td>
            <td><%=reply.getReplyType()%></td>
            <td><%=reply.getReplytitle()%></td>
            <td><%=reply.getReplycontent()%></td>
            <td><%=reply.getCustomername()%></td>
            <td><%=reply.getCtime()%></td>
            <td>
                <a class="btn btn-default deleteReply" href="#" role="button"  name="deleteReply">删除</a>
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
            <%--实现方法一，但是目前不可以--%>
            <li onclick="search(<%=pm.getEndPage()%>)"><a href="javascript:void(0);">尾页</a></li>
        </ul>
    </nav>
</center>
</body>
</html>
