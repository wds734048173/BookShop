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
    <title>添加图书信息</title>
    <link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.css">
    <script type="text/javascript" src="js/jquery.min.js" ></script>
    <script type="text/javascript" src="/bootstrap/js/bootstrap.js"></script>
    <link rel="stylesheet" type="text/css" href="/manager/css/webuploader.css">
    <script type="text/javascript" src="/manager/js/webuploader.js"></script>
    <script type="text/javascript">
        //要想绑定页面必须使用js提交。
        function addBook() {
            //对传入的参数进行验证
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
            var url = "/book.do?method=addBook&bookName=" + bookName + "&bookTypeId=" + bookTypeId + "&bookPress=" + bookPress + "&bookPubDate=" + bookPubDate
                + "&bookSize=" + bookSize + "&bookVersion=" + bookVersion + "&bookAuthor=" + bookAuthor + "&bookTanslor=" + bookTanslor + "&bookisbn=" + bookisbn
                + "&bookPrice=" + bookPrice + "&bookMprice=" + bookMprice + "&bookPages=" + bookPages + "&bookOutline=" + bookOutline + "&bookCatalog=" + bookCatalog
                + "&bookStoremount=" + bookStoremount + "&bookPackstyle=" + bookPackstyle;
            $(".content").load(url)
        }
    </script>
</head>
<body>
    <div class="modal-body">
        <form method="post" action="/book.do?method=addBook" id="addForm">
            <div class="form-group hidden">
                <label for="bookId" class="control-label">图书id:</label>
                <input type="number" class="form-control" id="bookId" name="bookId" >
            </div>
            <div class="form-group">
                <label for="bookName" class="control-label">图书名称:</label>
                <input type="text" class="form-control" id="bookName" name="bookName" placeholder="请输入图书名称" required >
            </div>
            <div class="form-group">
                <label for="bookTypeId" class="control-label">图书分类:</label>
                <%--<input type="text" class="form-control" id="bookTypeId" name="bookTypeId">--%>
                <select type="select" class="form-control" id="bookTypeId" name="bookTypeId">

                </select>
            </div>
            <div class="form-group">
                <label for="bookPress" class="control-label">出版社:</label>
                <input type="text" class="form-control" id="bookPress" name="bookPress">
            </div>
            <div class="form-group">
                <label for="bookPubDate" class="control-label">出版日期:</label>
                <input type="text" class="form-control" id="bookPubDate" name="bookPubDate">
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
                <input type="number" class="form-control" id="bookPrice" name="bookPrice" onkeyup="this.value=this.value.replace(/\D/g,'')">
            </div>
            <div class="form-group">
                <label for="bookMprice" class="control-label">市场价:</label>
                <input type="number" class="form-control" id="bookMprice" name="bookMprice" onkeyup="this.value=this.value.replace(/\D/g,'')">
            </div>
            <div class="form-group">
                <label for="bookPages" class="control-label">图书页码:</label>
                <input type="number" class="form-control" id="bookPages" name="bookPages" onkeyup="this.value=this.value.replace(/\D/g,'')">
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
                <label class="control-label">图书封面图:</label>
                <div id="uploader-demo">
                    <!--用来存放item-->
                    <div id="fileList" class="uploader-list"></div>
                    <div id="filePicker">选择图片</div>
                </div>
            </div>

            <div class="form-group">
                <label for="bookStoremount" class="control-label">图书库存量:</label>
                <input type="number" class="form-control" id="bookStoremount" name="bookStoremount" onkeyup="this.value=this.value.replace(/\D/g,'')">
            </div>
            <div class="form-group">
                <label for="bookPackstyle" class="control-label">封装方法:</label>
                <input type="text" class="form-control" id="bookPackstyle" name="bookPackstyle">
            </div>
        </form>
        <center>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="save" onclick="addBook()">保存</button>
            </div>
        </center>
    </div>

</body>
<script type="text/javascript">
    $(function(){
        //获取图书分类
        $.ajax({
            url:"/bookType.do?method=getBookTypeForSelect",
            success:function (data) {
                var bookTypeList = eval(data);
                $.each(bookTypeList,function (index,obj) {
                    var bookType = eval(obj);
                    var  str = "<option value="+bookType.bookTypeId +">"+bookType.bookTypeName+"</option>";
                    $("#bookTypeId").append(str);
                });
            }
        })
    })
</script>
<script type="text/javascript" src="/manager/js/picture.js"></script>
</html>
