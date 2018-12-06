<%@ page import="org.lanqiao.domain.BookType" %>
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
    <title>图书分类列表</title>
    <link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.css">
    <script type="text/javascript" src="js/jquery.min.js" ></script>
    <script type="text/javascript" src="/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $(function () {
            //新增
            $("#addBookType").click(function () {
                $('#addBookTypeModel').modal({
                    keyboard: false,
                    show:true
                })
            })
            //保存
            $("#save").click(function () {
                // $('#addBookTypeModel').modal({
                //     keyboard: true,
                //     show:false
                // })
                //方法一：可以成功，但是跳转页面有问题
                // $("#addForm").submit();
                // 方法二
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
                document.getElementById("gridSystemModalLabel").innerHTML = "修改书籍分类";
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
            $(".deleteBookType").click(function () {
                var isDelete = confirm ("确定删除吗？");
                if(isDelete){
                    var id = $(this).parent().parent().children("td:eq(0)").text();
                    //查询条件
                    var searchBookTypeName = $("#searchBookTypeName").val();
                    var currentPage = $("#currentPage").val();
                    var url = "/bookType.do?method=deleteBookType&bookTypeId=" + id + "&searchBookTypeName=" + searchBookTypeName + "&currentPage=" + currentPage;
                    $(".content").load(url);
                }else{
                    return;
                }
            })
        })

        //查询的手动提交方式
        function search(currentPage) {
            var name = $("#searchBookTypeName").val();
            if(currentPage == null){
                var currentPage = $("#currentPage").val();
            }else{
                var currentPage = currentPage;
            }
            var url = "/bookType.do?method=getBookTypelist&currentPage="+currentPage+"&searchBookTypeName="+name;
            $(".content").load(url);
        }
    </script>
</head>
<body>
<br><br>
<div class="modal-body">
    <a class="btn btn-default" href="#" role="button"  id="addBookType" name="addBookType">添加图书分类</a>
</div>
<%
    Condition condition = (Condition) request.getAttribute("condition");
%>
<input type="hidden" name="currentPage" id="currentPage" value="<%=request.getAttribute("currentPage")%>">
<div class="modal-body">
    <form name="searchForm" id="searchForm">
        <div class="form-group">
            <label for="searchBookTypeName" class="control-label">图书分类名称:</label>
            <input type="text" class="form-control" id="searchBookTypeName" name="searchBookTypeName" value="<%=condition.getName()%>">
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
            <th>图书分类id</th>
            <th>图书分类名称</th>
            <th>操作</th>
        </thead>
        <tbody>
            <%
            List<BookType> bookTypeList = (List<BookType>)request.getAttribute("bookTypeList");
            PageModel pm = (PageModel) request.getAttribute("pm");
            for(BookType bookType : bookTypeList){
        %>
        <tr>
            <td><%=bookType.getBookTypeId()%></td>
            <td><%=bookType.getBookTypeName()%></td>
            <td>
                <a class="btn btn-default updateBookType" href="#" role="button"  name="updateBookType">修改</a>
                <a class="btn btn-default deleteBookType" href="#" role="button"  name="deleteBookType">删除</a>
            </td>
        </tr>
            <%
            }
        %>
        </tbody>
    </table>
</div>
<%--新增模态框插件--%>
<div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel" id="addBookTypeModel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="gridSystemModalLabel">新增分类</h4>
            </div>
            <div class="modal-body">
                <form method="post" action="/bookType.do?method=addBookType" id="addForm">
                    <div class="form-group hidden">
                        <label for="bookTypeId" class="control-label">分类id:</label>
                        <input type="text" class="form-control" id="bookTypeId" name="bookTypeId">
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
            <%--实现方法一，但是目前不可以--%>
            <li onclick="search(<%=pm.getEndPage()%>)"><a href="javascript:void(0);">尾页</a></li>
        </ul>
    </nav>
</center>
</body>
</html>
