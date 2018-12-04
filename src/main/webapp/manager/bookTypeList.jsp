<%@ page import="org.lanqiao.domain.BookType" %>
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
    <title>图书分类列表</title>
    <script type="text/javascript" src="js/jquery.min.js" ></script>
    <script type="text/javascript">
        function getBookTypeList(){
            $.ajax({
                url:"/bookType.do?method=getBookTypeList",
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
            window.onload(getBookTypeList())
        })
    </script>
</head>
<body>
<a href="#" role="button" id="addBookType" name="addBookType">添加图书分类</a>
<table class="table table-hover table-bordered">
    <thead>
        <th>图书分类id</th>
        <th>图书分类名称</th>
        <th>操作</th>
    </thead>
    <tbody>
        <%
        List<BookType> bookTypeList = (List<BookType>)request.getAttribute("bookTypeList");
        for(BookType bookType : bookTypeList){
    %>
    <tr>
        <td><%=bookType.getBookTypeId()%></td>
        <td><%=bookType.getBookTypeName()%></td>
        <td>
            <a class="updateBookType" href="#" role="button"  name="updateBookType">修改</a>
            <a class="deleteBookType" href="#" role="button"  name="deleteBookType">删除</a>
        </td>
    </tr>
        <%
        }
    %>
    </tbody>
</table>
</body>
</html>
