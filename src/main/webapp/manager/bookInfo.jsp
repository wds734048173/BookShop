<%@ page import="org.lanqiao.domain.Book" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%--
  Created by IntelliJ IDEA.
  User: WDS
  Date: 2018/12/10
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书详情信息</title>
    <link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.css">
    <script type="text/javascript" src="js/jquery.min.js" ></script>
    <script type="text/javascript" src="/bootstrap/js/bootstrap.js"></script>
</head>
<body>
<%Book book = (Book) request.getAttribute("book");%>
<div class="modal-body">
    <form method="post" action="/book.do?method=addBook" id="addForm">
        <div class="form-group hidden">
            <label for="bookId" class="control-label">图书id:</label>
            <input type="text" class="form-control" id="bookId" name="bookId" disabled value="<%=book.getBookId()%>">
        </div>
        <div class="form-group">
            <label for="bookName" class="control-label">图书名称:</label>
            <input type="text" class="form-control" id="bookName" name="bookName" disabled value="<%=book.getBookName()%>">
        </div>
        <div class="form-group">
            <label for="bookTypeId" class="control-label">图书分类:</label>
            <input type="text" class="form-control" id="bookTypeId" name="bookTypeId"  disabled value="<%=book.getBookTypeName()%>">
        </div>
        <div class="form-group">
            <label for="bookPress" class="control-label">出版社:</label>
            <input type="text" class="form-control" id="bookPress" name="bookPress" disabled value="<%=book.getBookPress()%>">
        </div>
        <div class="form-group">
            <label for="bookPubDate" class="control-label">出版日期:</label>
            <%SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");%>
            <input type="text" class="form-control" id="bookPubDate" name="bookPubDate"  value="<%=sdf.format(book.getBookPubDate())%>">
        </div>
        <div class="form-group">
            <label for="bookSize" class="control-label">开本:</label>
            <input type="text" class="form-control" id="bookSize" name="bookSize" disabled value="<%=book.getBookSize()%>">
        </div>
        <div class="form-group">
            <label for="bookVersion" class="control-label">版次:</label>
            <input type="text" class="form-control" id="bookVersion" name="bookVersion" disabled value="<%=book.getBookVersion()%>">
        </div>
        <div class="form-group">
            <label for="bookAuthor" class="control-label">图书作者:</label>
            <input type="text" class="form-control" id="bookAuthor" name="bookAuthor" disabled value="<%=book.getBookAuthor()%>">
        </div>
        <div class="form-group">
            <label for="bookTanslor" class="control-label">图书译者:</label>
            <input type="text" class="form-control" id="bookTanslor" name="bookTanslor" disabled value="<%=book.getBookTanslor()%>">
        </div>
        <div class="form-group">
            <label for="bookisbn" class="control-label">图书ISBN:</label>
            <input type="text" class="form-control" id="bookisbn" name="bookisbn" disabled value="<%=book.getBookisbn()%>">
        </div>
        <div class="form-group">
            <label for="bookPrice" class="control-label">图书定价:</label>
            <input type="number" class="form-control" id="bookPrice" name="bookPrice" disabled value="<%=book.getBookPrice()%>">
        </div>
        <div class="form-group">
            <label for="bookMprice" class="control-label">市场价:</label>
            <input type="number" class="form-control" id="bookMprice" name="bookMprice" disabled value="<%=book.getBookMprice()%>">
        </div>
        <div class="form-group">
            <label for="bookPages" class="control-label">图书页码:</label>
            <input type="number" class="form-control" id="bookPages" name="bookPages" disabled value="<%=book.getBookPages()%>">
        </div>
        <div class="form-group">
            <label for="bookOutline" class="control-label">图书简介:</label>
            <input type="text" class="form-control" id="bookOutline" name="bookOutline" disabled value="<%=book.getBookOutline()%>">
        </div>
        <div class="form-group">
            <label for="bookCatalog" class="control-label">图书目录:</label>
            <input type="text" class="form-control" id="bookCatalog" name="bookCatalog" disabled value="<%=book.getBookCatalog()%>">
        </div>
        <div class="form-group">
            <label class="control-label">图书封面图:</label>
            <img src="<%=book.getBookPic()%>">
        </div>
        <div class="form-group">
            <label for="bookStoremount" class="control-label">图书库存量:</label>
            <input type="number" class="form-control" id="bookStoremount" name="bookStoremount" disabled value="<%=book.getBookStoremount()%>">
        </div>
        <div class="form-group">
            <label for="bookPackstyle" class="control-label">封装方法:</label>
            <input type="text" class="form-control" id="bookPackstyle" name="bookPackstyle"  disabled value="<%=book.getBookPackstyle()%>">
        </div>
    </form>
</div>
</body>
</html>
