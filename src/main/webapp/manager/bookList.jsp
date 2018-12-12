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
            /*$(".updateBookType").click(function () {
                var id = $(this).parent().parent().children("td:eq(1)").text();
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
                $('#bookInfoModel').modal({
                    keyboard: false,
                    show:true
                })
            })*/
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
            <td><img src="<%=book.getBookPic()%>" style="width: 100px;height: 100px;" a></td>
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
<%--<div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel" id="bookInfoModel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="gridSystemModalLabel">新增图书信息</h4>
            </div>
            <div class="modal-body">
                <form method="post" action="/book.do?method=addBook" id="addForm">
                    <div class="form-group hidden">
                        <label for="bookId" class="control-label">图书名称:</label>
                        <input type="text" class="form-control" id="bookId" name="bookId">
                    </div>
                    <div class="form-group">
                        <label for="bookName" class="control-label">图书名称:</label>
                        <input type="text" class="form-control" id="bookName" name="bookName">
                    </div>
                    <div class="form-group">
                        <label for="bookTypeId" class="control-label">图书分类:</label>
                        <input type="text" class="form-control" id="bookTypeId" name="bookTypeId">
                    </div>
                    <div class="form-group">
                        <label for="bookPress" class="control-label">出版社:</label>
                        <input type="text" class="form-control" id="bookPress" name="bookPress">
                    </div>
                    <div class="form-group">
                        <label for="bookSize" class="control-label">开本:</label>
                        <input type="text" class="form-control" id="bookSize" name="bookSize">
                    </div>
                    <div class="form-group">
                        <label for="bookVersion" class="control-label">版次:</label>
                        <input type="text" class="form-control" id="bookVersion" name="bookVersion">
                    </div>
                    <div class="form-group">
                        <label for="bookAuthor" class="control-label">图书作者:</label>
                        <input type="text" class="form-control" id="bookAuthor" name="bookAuthor">
                    </div>
                    <div class="form-group">
                        <label for="bookTanslor" class="control-label">图书译者:</label>
                        <input type="text" class="form-control" id="bookTanslor" name="bookTanslor">
                    </div>
                    <div class="form-group">
                        <label for="bookisbn" class="control-label">图书ISBN:</label>
                        <input type="text" class="form-control" id="bookisbn" name="bookisbn">
                    </div>
                    <div class="form-group">
                        <label for="bookPrice" class="control-label">图书定价:</label>
                        <input type="text" class="form-control" id="bookPrice" name="bookPrice">
                    </div>
                    <div class="form-group">
                        <label for="bookMprice" class="control-label">市场价:</label>
                        <input type="text" class="form-control" id="bookMprice" name="bookMprice">
                    </div>
                    <div class="form-group">
                        <label for="bookPages" class="control-label">图书页码:</label>
                        <input type="text" class="form-control" id="bookPages" name="bookPages">
                    </div>
                    <div class="form-group">
                        <label for="bookOutline" class="control-label">图书简介:</label>
                        <input type="text" class="form-control" id="bookOutline" name="bookOutline">
                    </div>
                    <div class="form-group">
                        <label for="bookCatalog" class="control-label">图书目录:</label>
                        <input type="text" class="form-control" id="bookCatalog" name="bookCatalog">
                    </div>
                    <div class="form-group">
                        <label class="control-label"for="bookPic">图书封面图:</label>
                        <img src="" id="bookPic" name="bookPic" class="form-control">
                    </div>

                    <div class="form-group">
                        <label for="bookStoremount" class="control-label">图书库存量:</label>
                        <input type="text" class="form-control" id="bookStoremount" name="bookStoremount">
                    </div>
                    <div class="form-group">
                        <label for="bookPackstyle" class="control-label">封装方法:</label>
                        <input type="text" class="form-control" id="bookPackstyle" name="bookPackstyle">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>--%><!-- /.modal -->
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
                    var  str = "<option value="+bookType.bookTypeId +">"+bookType.bookTypeName+"</option>";
                    $("#searchBookTypeId").append(str);
                    $("#bookTypeId").append(str);
                });
            }
        })
    })
</script>
</html>

