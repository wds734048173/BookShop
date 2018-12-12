<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>图书信息列表</title>
    <link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.css">
    <script type="text/javascript" src="js/jquery.min.js" ></script>
    <script type="text/javascript" src="/bootstrap/js/bootstrap.js"></script>
    <style type="text/css">
        img:hover{
            transform: scale(2);
        }
    </style>
    <script type="text/javascript">
        $(function () {
            //新增,跳转页面
            $("#addBook").click(function () {
                $(".content").load("/manager/addBook.jsp")
            })
            //获取图书详情
            $(".getBookInfo").click(function () {
                var id = $(this).parent().parent().children("td:eq(1)").text();
                $(".content").load("/book.do?method=getBookById&param=getBookInfo&bookId="+id);
            })
            //修改图书信息
            $(".updateBook").click(function () {
                var id = $(this).parent().parent().children("td:eq(1)").text();
                $(".content").load("/book.do?method=getBookById&param=updateBook&bookId="+id);
            })
            //删除
            $(".deleteBook").click(function () {
                var isDelete = confirm ("确定删除吗？");
                if(isDelete){
                    var id = $(this).parent().parent().children("td:eq(1)").text();
                    //查询条件
                    var searchBookTypeId = $("#searchBookTypeId").val();
                    var searchBookName = $("#searchBookName").val();
                    var searchBookAuthor = $("#searchBookAuthor").val();
                    var currentPage = $("#currentPage").val();
                    var url = "/book.do?method=deleteBook&bookId=" + id + "&currentPage="+currentPage+"&searchBookTypeId="+searchBookTypeId+"&searchBookName="+searchBookName+"&searchBookAuthor="+searchBookAuthor;
                    $(".content").load(url);
                }else{
                    return;
                }
            })
        })

        //查询的手动提交方式
        function search(currentPage) {
            var searchBookTypeId = $("#searchBookTypeId").val();
            var searchBookName = $("#searchBookName").val();
            var searchBookAuthor = $("#searchBookAuthor").val();
            if(currentPage == null){
                var currentPage = $("#currentPage").val();
            }else{
                var currentPage = currentPage;
            }
            var url = "/book.do?method=getBooklist&currentPage="+currentPage+"&searchBookTypeId="+searchBookTypeId+"&searchBookName="+searchBookName+"&searchBookAuthor="+searchBookAuthor;
            $(".content").load(url);
        }
    </script>
</head>
<body>
<br><br>
<div class="modal-body">
    <a class="btn btn-default" href="#" role="button"  id="addBook" name="addBook">添加图书信息</a>
</div>
<input type="hidden" name="currentPage" id="currentPage" value="${currentPage}">
<div class="modal-body">
    <form name="searchForm" id="searchForm">
        <div class="form-group">
            <label for="searchBookTypeId" class="control-label">图书分类:</label>
            <select type="select" class="form-control" id="searchBookTypeId" name="searchBookTypeId">

            </select>
        </div>
        <div class="form-group">
            <label for="searchBookName" class="control-label">图书名称:</label>
            <input type="text" class="form-control" id="searchBookName" name="searchBookName" value="${condition.name}">
        </div>
        <div class="form-group">
            <label for="searchBookAuthor" class="control-label">图书作者:</label>
            <input type="text" class="form-control" id="searchBookAuthor" name="searchBookAuthor" value="${condition.state}">
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
            <th>图书图片</th>
            <th>图书编号(主)</th>
            <th>图书类型</th>
            <th>图书名</th>
            <th>图书作者</th>
            <th>图书定价</th>
            <th>市场价</th>
            <th>操作</th>
        </thead>
        <tbody>
        <c:forEach begin="0" end="${bookList.size()}" var="book" items="${bookList}" step="1">
            <tr>
                <td><img src="${book.bookPic}" style="width: 100px;height: 100px;"></td>
                <td>${book.bookId}</td>
                <td>${book.bookTypeid}</td>
                <td>${book.bookName}</td>
                <td>${book.bookAuthor}</td>
                <td>${book.bookPrice}</td>
                <td>${book.bookMprice}</td>
                <td>
                    <a class="btn btn-default updateBook" href="#" role="button"  name="updateBook">修改</a>
                    <a class="btn btn-default getBookInfo" href="#" role="button"  name="getBookInfo">查看详情</a>
                    <a class="btn btn-default deleteBook" href="#" role="button"  name="deleteBook">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<c:if test="${bookList.size() != 0}">
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
<script type="text/javascript">
    $(function(){
        $("#searchBookTypeId").append("<option value=''>全部</option>")
        //获取图书分类
        $.ajax({
            url:"/bookType.do?method=getBookTypeForSelect",
            success:function (data) {
                var bookTypeList = eval(data);
                $.each(bookTypeList,function (index,obj) {
                    var bookType = eval(obj);
                    var  str = "<option value="+bookType.bookTypeId +">"+bookType.bookTypeName+"</option>";
                    $("#searchBookTypeId").append(str);
                    $("#bookTypeId").append(str);
                });
            }
        })
    })
</script>
</html>

