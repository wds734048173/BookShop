<%@ page import="org.lanqiao.domain.Book" %>
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
    <title>图书信息列表</title>
    <script type="text/javascript" src="js/jquery.min.js" ></script>
    <script type="text/javascript">
        function getBookTypeList(){
            $.ajax({
                url:"/book.do?method=getBookList",
                // data:{"greensClassId":id,"currentPage":currentPage,"searchGreensClassStateId":searchGreensClassStateId,"searchGreensClassName":searchGreensClassName},
                success:function (data) {
                    var bookTypes = eval(data);

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
            window.onload(getBookList())
        })
    </script>
</head>
<body>
<a href="#" role="button" id="addBook" name="addBook">添加图书信息</a>
<table class="table table-hover table-bordered">
    <thead>
    <th>图书编号(主)</th>
    <th>图书类型</th>
    <th>图书名</th>
    <th>出版社</th>
    <th>出版日期</th>
    <th>开本</th>
    <th>版次</th>
    <th>图书作者</th>
    <th>图书译者</th>
    <th>图书ISBN</th>
    <th>图书定价</th>
    <th>图书页码</th>
    <th>图书简介</th>
    <th>图书目录</th>
    <th>市场价</th>
    <th>图书封面图</th>
    <th>图书封面状态</th>
    <th>图书库存量</th>
    <th>入库时间</th>
    <th>封装方式</th>
    <th>操作</th>
    </thead>
    <tbody>
    <%
        List<Book> bookList = (List<Book>)request.getAttribute("bookList");
        for(Book book : bookList){
    %>
    <tr>
        <td><%=book.getBookId()%></td>
        <td><%=book.getBookTypeld()%></td>
        <td><%=book.getBookName()%></td>
        <td><%=book.getBookPress()%></td>
        <td><%=book.getBookPubDate()%></td>
        <td><%=book.getBookSize()%></td>
        <td><%=book.getBookVersion()%></td>
        <td><%=book.getBookAuthor()%></td>
        <td><%=book.getBookTanslor()%></td>
        <td><%=book.getBookisbn()%></td>
        <td><%=book.getBookPrice()%></td>
        <td><%=book.getBookPages()%></td>
        <td><%=book.getBookOutline()%></td>
        <td><%=book.getBookCatalog()%></td>
        <td><%=book.getBookMprice()%></td>
        <td><%=book.getBookPic()%></td>
        <td><%=book.getBookPicStatus()%></td>
        <td><%=book.getBookStoremount()%></td>
        <td><%=book.getBookStoretime()%></td>
        <td><%=book.getBookPackstyle()%></td>
        <td>
            <a class="updateBook" href="#" role="button"  name="updateBook">修改</a>
            <a class="deleteBook" href="#" role="button"  name="deleteBook">删除</a>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>

