<%@ page import="org.lanqiao.domain.Condition" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<input type="hidden" name="currentPage" id="currentPage" value="${currentPage}">
<div class="modal-body">
    <div class="form-group row">
        <div class="col-xs-3">
            <label for="searchCustomerId" >留言客户:</label>
            <input type="text" class="myinput"  placeholder="" id="searchCustomerId" name="searchCustomerId" value="${condition.bookTypeId}">
        </div>
        <div class="col-xs-3">
            <label for="searchReplycontent" >留言内容:</label>
            <input type="text" class="myinput"  placeholder="" id="searchReplycontent" name="searchReplycontent" value="${condition.name}">
        </div>
        <div class="col-xs-2">
            <label for="searchReplyType">留言类型</label>
            <select class=" myinput" name="searchReplyType" id="searchReplyType">
                <option value="" <c:if test="${empty condition.state}" > selected </c:if> >全部</option>
                <option value="0" <c:if test="${condition.state} == 0" > selected </c:if> >赞美</option>
                <option value="1" <c:if test="${condition.state} == 1" > selected </c:if> >批评</option>
                <option value="2" <c:if test="${condition.state} == 2" > selected </c:if> >鼓励</option>
            </select>
        </div>
    </div>
    <div class="form-group">
        <input type="button" class="btn btn-primary" id="search" value="查询" onclick="search(null)"/>
    </div>
</div>

<div class="modal-body">
    <table class="table table-hover table-bordered">
        <thead>
            <th hidden>信息反馈id</th>
            <th>留言类型</th>
            <th>留言主题</th>
            <th>留言内容</th>
            <th>留言客户名</th>
            <th>留言日期</th>
        </thead>
        <tbody>
        <c:forEach begin="0" end="${replyList.size()}" var="reply" items="${replyList}" step="1">
            <tr>
                <td hidden>${reply.replyId}</td>
                <td>${reply.replyType}</td>
                <td>${reply.replytitle}</td>
                <td>${reply.replycontent}</td>
                <td>${reply.customername}</td>
                <td><fmt:formatDate value="${reply.ctime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%--分页插件--%>
<c:if test="${replyList.size() != 0}">
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
</c:if>
</body>
</html>
