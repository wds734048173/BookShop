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
    <link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap-datetimepicker.min.css">
    <script type="text/javascript" src="/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
    <script type="text/javascript" src="/bootstrap/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
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
        <center>
            <form method="post" action="/book.do?method=addBook" id="addForm">
                <div class="form-group hidden">
                    <label for="bookId" class="control-label ">图书&nbsp&nbspid:</label>
                    <input type="number" class=" myinput" id="bookId" name="bookId">
                </div>
                <div class="col-xs-6">
                    <label for="bookName">图书名称:</label>
                    <input type="text" class=" myinput" id="bookName" name="bookName">
                </div>
                <div class="col-xs-6">
                    <label for="bookTypeId">图书分类:</label>
                    <%--<input type="text" class="form-control" id="bookTypeId" name="bookTypeId">--%>
                    <select type="select" class="myinput" id="bookTypeId" name="bookTypeId">

                    </select>
                </div>
                <br>
                <br>
                <div class="col-xs-6">
                    <label for="bookPress" >出 &nbsp版 &nbsp社:</label>
                    <input type="text" class="myinput" id="bookPress" name="bookPress">
                </div>
                <div class="col-xs-6">
                    <label for="bookPubDate" >出版日期:</label>
                    <input type="text" class="myinput" id="bookPubDate" name="bookPubDate">
                </div>
                <br>
                <br>
                <div class="col-xs-6">
                    <label for="bookSize" >开&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp本:</label>
                    <input type="text" class="myinput" id="bookSize" name="bookSize">
                </div>
                <div class="col-xs-6">
                    <label for="bookVersion" >版&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp次:</label>
                    <input type="text" class="myinput" id="bookVersion" name="bookVersion">
                </div>
                <br>
                <br>
                <div class="col-xs-6">
                    <label for="bookAuthor" >图书作者:</label>
                    <input type="text" class="myinput" id="bookAuthor" name="bookAuthor">
                </div>
                <div class="col-xs-6">
                    <label for="bookTanslor" >图书译者:</label>
                    <input type="text" class="myinput" id="bookTanslor" name="bookTanslor">
                </div>
                <br>
                <br>
                <div class="col-xs-6">
                    <label for="bookisbn" >图书ISBN:</label>
                    <input type="text" class="myinput" id="bookisbn" name="bookisbn">
                </div>
                <div class="col-xs-6">
                    <label for="bookPrice" >图书定价:</label>
                    <input type="number" class="myinput" id="bookPrice" name="bookPrice" onkeyup="this.value=this.value.replace(/\D/g,'')">
                </div>
                <br>
                <br>
                <div class="col-xs-6">
                    <label for="bookMprice" >市 场 价:</label>
                    <input type="number" class="myinput" id="bookMprice" name="bookMprice" onkeyup="this.value=this.value.replace(/\D/g,'')">
                </div>
                <div class="col-xs-6">
                    <label for="bookPages" >图书页码:</label>
                    <input type="number" class="myinput" id="bookPages" name="bookPages" onkeyup="this.value=this.value.replace(/\D/g,'')">
                </div>
                <br>
                <br>
                <div class="col-xs-6">
                    <label for="bookOutline" >图书简介:</label>
                    <input type="text" class="myinput" id="bookOutline" name="bookOutline">
                </div>
                <div class="col-xs-6">
                    <label for="bookCatalog" >图书目录:</label>
                    <input type="text" class="myinput" id="bookCatalog" name="bookCatalog">
                </div>
                <br>
                <br>

                <div class="col-xs-6">
                    <label for="bookStoremount">图书库存:</label>
                    <input type="number" class="myinput" id="bookStoremount" name="bookStoremount" onkeyup="this.value=this.value.replace(/\D/g,'')">
                </div>
                <div class="col-xs-6">
                    <label for="bookPackstyle">封装方法:</label>
                    <input type="text" class="myinput" id="bookPackstyle" name="bookPackstyle">
                </div>
                <br>
                <br>
                <div >
                    <label >图书封面:</label>
                    <div id="uploader-demo" CLASS="myinput">
                        <!--用来存放item-->
                        <div id="fileList" class="uploader-list"></div>
                        <div id="filePicker">选择图片</div>
                    </div>
                </div>
                <button type="button" class="btn btn-primary" id="save" onclick="addBook()">保存</button>
            </form>
        </center>
        <center>
            <div class="modal-footer">
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
