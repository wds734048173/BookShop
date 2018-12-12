<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: WDS
  Date: 2018/12/10
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改图书信息</title>
    <link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.css">
    <script type="text/javascript" src="js/jquery.min.js" ></script>
    <script type="text/javascript" src="/bootstrap/js/bootstrap.js"></script>
    <link rel="stylesheet" type="text/css" href="/manager/css/webuploader.css">
    <script type="text/javascript" src="/manager/js/webuploader.js"></script>
    <link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap-datetimepicker.min.css">
    <script type="text/javascript" src="/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
    <script type="text/javascript" src="/bootstrap/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
    <script type="text/javascript">
        //要想绑定页面必须使用js提交。
        function updateBook() {
            //对传入的参数进行验证
            var bookId = $("#bookId").val();
            var bookName = $("#bookName").val();
            if (bookName == null || bookName == "") {
                alert("图书名称不能为空，请重新输入");
                return;
            }
            var bookTypeId = $("#bookTypeId").val();
            var bookPress = $("#bookPress").val();
            var bookPubDate = $("#bookPubDate").val();
            var bookSize = $("#bookSize").val();
            var bookVersion = $("#bookVersion").val();
            var bookAuthor = $("#bookAuthor").val();
            var bookTanslor = $("#bookTanslor").val();
            var bookisbn = $("#bookisbn").val();
            var bookPrice = $("#bookPrice").val();
            var bookMprice = $("#bookMprice").val();
            var bookPages = $("#bookPages").val();
            var bookOutline = $("#bookOutline").val();
            var bookCatalog = $("#bookCatalog").val();
            var bookStoremount = $("#bookStoremount").val();
            var bookPackstyle = $("#bookPackstyle").val();
            var url = "/book.do?method=updateBook&bookName=" + bookName + "&bookId=" + bookId + "&bookTypeId=" + bookTypeId + "&bookPress=" + bookPress + "&bookPubDate=" + bookPubDate
                + "&bookSize=" + bookSize + "&bookVersion=" + bookVersion + "&bookAuthor=" + bookAuthor + "&bookTanslor=" + bookTanslor + "&bookisbn=" + bookisbn
                + "&bookPrice=" + bookPrice + "&bookMprice=" + bookMprice + "&bookPages=" + bookPages + "&bookOutline=" + bookOutline + "&bookCatalog=" + bookCatalog
                + "&bookStoremount=" + bookStoremount + "&bookPackstyle=" + bookPackstyle;
            $(".content").load(url)
        }

        $('#bookPubDate').datetimepicker({
            format: 'yyyy-mm-dd',
            language:"zh-CN",
            minView:"month",
            autoclose:true,
            todayBtn:true
        })
    </script>
</head>
<body>
<div class="modal-body">
    <form method="post" action="/book.do?method=addBook" id="addForm">
        <div class="form-group hidden">
            <label for="bookId" class="control-label">图书id:</label>
            <input type="text" class="form-control" id="bookId" name="bookId"  value="${book.bookId}">
        </div>
        <div class="col-xs-6">
            <label for="bookName" class="control-label">图书名称:</label>
            <input type="text" class="form-control" id="bookName" name="bookName"  value="${book.bookName}">
        </div>
        <div class="col-xs-6">
            <label for="bookTypeId" class="control-label">图书分类:</label>
            <%--<input type="text" class="form-control" id="bookTypeId" name="bookTypeId"   value="${book.bookTypeName}">--%>
            <select type="select" class="form-control" id="bookTypeId" name="bookTypeId">

            </select>
        </div>
        <br>
        <br>
        <div class="col-xs-6">
            <label for="bookPress" class="control-label">出版社:</label>
            <input type="text" class="form-control" id="bookPress" name="bookPress"  value="${book.bookPress}">
        </div>
        <div class="col-xs-6">
            <label for="bookPubDate" class="control-label">出版日期</label>
            <input class="form-control" id="bookPubDate" size="16" name="hiredate" value="<fmt:formatDate value="${book.bookPubDate}" pattern="yyyy-MM-dd"></fmt:formatDate>" readonly>
        </div>
        <br>
        <br>
        <div class="col-xs-6">
            <label for="bookSize" class="control-label">开本:</label>
            <input type="text" class="form-control" id="bookSize" name="bookSize"  value="${book.bookSize}">
        </div>
        <div class="col-xs-6">
            <label for="bookVersion" class="control-label">版次:</label>
            <input type="text" class="form-control" id="bookVersion" name="bookVersion"  value="${book.bookVersion}">
        </div>
        <br>
        <br>
        <div class="col-xs-6">
            <label for="bookAuthor" class="control-label">图书作者:</label>
            <input type="text" class="form-control" id="bookAuthor" name="bookAuthor"  value="${book.bookAuthor}">
        </div>
        <div class="col-xs-6">
            <label for="bookTanslor" class="control-label">图书译者:</label>
            <input type="text" class="form-control" id="bookTanslor" name="bookTanslor"  value="${book.bookTanslor}">
        </div>
        <br>
        <br>
        <div class="col-xs-6">
            <label for="bookisbn" class="control-label">图书ISBN:</label>
            <input type="text" class="form-control" id="bookisbn" name="bookisbn"  value="${book.bookisbn}">
        </div>
        <div class="col-xs-6">
            <label for="bookPrice" class="control-label">图书定价:</label>
            <input type="number" class="form-control" id="bookPrice" name="bookPrice"  value="${book.bookPrice}" onkeyup="this.value=this.value.replace(/\D/g,'')">
        </div>
        <br>
        <br>
        <div class="col-xs-6">
            <label for="bookMprice" class="control-label">市场价:</label>
            <input type="number" class="form-control" id="bookMprice" name="bookMprice"  value="${book.bookMprice}" onkeyup="this.value=this.value.replace(/\D/g,'')">
        </div>
        <div class="col-xs-6">
            <label for="bookPages" class="control-label">图书页码:</label>
            <input type="number" class="form-control" id="bookPages" name="bookPages"  value="${book.bookPages}" onkeyup="this.value=this.value.replace(/\D/g,'')">
        </div>
        <br>
        <br>
        <div class="col-xs-6">
            <label for="bookOutline" class="control-label">图书简介:</label>
            <input type="text" class="form-control" id="bookOutline" name="bookOutline"  value="${book.bookOutline}">
        </div>
        <div class="col-xs-6">
            <label for="bookCatalog" class="control-label">图书目录:</label>
            <input type="text" class="form-control" id="bookCatalog" name="bookCatalog"  value="${book.bookCatalog}">
        </div>
        <br>
        <br>
        <div class="col-xs-6">
            <label for="bookStoremount" class="control-label">图书库存量:</label>
            <input type="number" class="form-control" id="bookStoremount" name="bookStoremount"  value="${book.bookStoremount}" onkeyup="this.value=this.value.replace(/\D/g,'')">
        </div>
        <div class="col-xs-6">
            <label for="bookPackstyle" class="control-label">封装方法:</label>
            <input type="text" class="form-control" id="bookPackstyle" name="bookPackstyle"   value="${book.bookPackstyle}">
        </div>
        <br>
        <br>
        <div class="col-xs-6">
            <label class="control-label">图书封面图:</label>
            <img src="${book.bookPic}">
            <div id="uploader-demo">
                <!--用来存放item-->
                <div id="fileList" class="uploader-list"></div>
                <div id="filePicker">选择图片</div>
            </div>
        </div>
    </form>
    <center>
        <div class="modal-footer">
            <button type="button" class="btn btn-primary" id="save" onclick="updateBook()">保存</button>
        </div>
    </center>
</div>
</body>
<script type="text/javascript" src="/manager/js/picture.js"></script>
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
