<%@ page import="org.lanqiao.domain.Book" %>
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
    <title>图书信息列表</title>
    <link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.css">
    <script type="text/javascript" src="js/jquery.min.js" ></script>
    <script type="text/javascript" src="/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $(function () {
            //新增
            $("#addBook").click(function () {
                $('#addBookModel').modal({
                    keyboard: false,
                    show:true
                })
            })
            //保存
            $("#save").click(function () {
                var bookTypeId = $("#bookTypeId").val();
                var bookTypeName = $("#bookTypeName").val();
                //查询条件
                var searchBookTypeName = $("#searchBookTypeName").val();
                var currentPage = $("#currentPage").val();
                var url = "/bookType.do?method=addBookType&currentPage="+currentPage+"&searchBookTypeName="+searchBookTypeName+"&bookTypeId="+bookTypeId+"&bookTypeName="+bookTypeName;
                $(".content").load(url);
                $(".modal-backdrop").remove();
            })
            //修改
            $(".updateBookType").click(function () {
                var id = $(this).parent().parent().children("td:eq(0)").text();
                $("#gridSystemModalLabel").innerHTML = "修改图书信息";
                $.ajax({
                    //通过id获取餐桌信息
                    url:"/bookType.do?method=getBookTypeById&bookTypeId=" + id,
                    success:function (data) {
                        var bookType = eval(data);
                        $("#bookTypeId").val(bookType.bookTypeId);
                        $("#bookTypeName").val(bookType.bookTypeName);
                    }
                })
                $('#addBookTypeModel').modal({
                    keyboard: false,
                    show:true
                })
            })
            //删除
            $(".deleteBook").click(function () {
                var isDelete = confirm ("确定删除吗？");
                if(isDelete){
                    var id = $(this).parent().parent().children("td:eq(0)").text();
                    //查询条件
                    var searchBookName = $("#searchBookName").val();
                    var currentPage = $("#currentPage").val();
                    var url = "/book.do?method=deleteBook&bookId=" + id + "&searchBookName=" + searchBookName + "&currentPage=" + currentPage;
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
<%
    Condition condition = (Condition) request.getAttribute("condition");
%>
<input type="hidden" name="currentPage" id="currentPage" value="<%=request.getAttribute("currentPage")%>">
<div class="modal-body">
    <form name="searchForm" id="searchForm">
        <div class="form-group">
            <label for="searchBookTypeId" class="control-label">图书分类:</label>
            <select type="select" class="form-control" id="searchBookTypeId" name="searchBookTypeId">

            </select>
        </div>
        <div class="form-group">
            <label for="searchBookName" class="control-label">图书名称:</label>
            <input type="text" class="form-control" id="searchBookName" name="searchBookName" value="<%=condition.getName()%>">
        </div>
        <div class="form-group">
            <label for="searchBookAuthor" class="control-label">图书作者:</label>
            <input type="text" class="form-control" id="searchBookAuthor" name="searchBookAuthor" value="<%=condition.getState()%>">
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
        <%
            List<Book> bookList = (List<Book>)request.getAttribute("bookList");
            PageModel pm = (PageModel) request.getAttribute("pm");
            for(Book book : bookList){
        %>
        <tr>
            <td><%=book.getBookPic()%></td>
            <td><%=book.getBookId()%></td>
            <td><%=book.getBookTypeid()%></td>
            <td><%=book.getBookName()%></td>
            <td><%=book.getBookAuthor()%></td>
            <td><%=book.getBookPrice()%></td>
            <td><%=book.getBookMprice()%></td>
            <td>
                <a class="btn btn-default updateBook" href="#" role="button"  name="updateBook">修改</a>
                <a class="btn btn-default getBookInfo" href="#" role="button"  name="getBookInfo">查看详情</a>
                <a class="btn btn-default deleteBook" href="#" role="button"  name="deleteBook">删除</a>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
<%--新增模态框插件--%>
<div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel" id="addBookModel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="gridSystemModalLabel">新增图书信息</h4>
            </div>
            <div class="modal-body">
                <form method="post" action="/bookType.do?method=addBookType" id="addForm">
                    <div class="form-group hidden">
                        <label for="addBookTypeId" class="control-label">分类id:</label>
                        <input type="text" class="form-control" id="addBookTypeId" name="addBookTypeId">
                    </div>
                    <div class="form-group">
                        <label for="bookTypeName" class="control-label">分类名称:</label>
                        <input type="text" class="form-control" id="bookTypeName" name="bookTypeName">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="save">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
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
                    var str = "";
                    if(searchBookTypeIdHidden == bookType.bookTypeId){
                        str = "<option value="+bookType.bookTypeId +" selected >"+bookType.bookTypeName+"</option>";
                    }else{
                        str = "<option value="+bookType.bookTypeId +">"+bookType.bookTypeName+"</option>";
                    }
                    $("#searchBookTypeId").append(str);
                });
            }
        })
    })
</script>
</html>

