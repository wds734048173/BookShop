<%--
  Created by IntelliJ IDEA.
  User: WDS
  Date: 2018/12/8
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!--引入CSS-->
    <link rel="stylesheet" type="text/css" href="/manager/css/webuploader.css">

    <!--引入JS-->
    <script type="text/javascript" src="/manager/js/jquery.min.js"></script>
    <script type="text/javascript" src="/manager/js/webuploader.js"></script>

</head>
<body>
<!--dom结构部分-->
<form action="/book.do?method=addBook" method="post">
    <div id="uploader-demo">
        <!--用来存放item-->
        <div id="fileList" class="uploader-list"></div>
        <div id="filePicker">选择图片</div>
    </div>
    <input type="submit" value="保存">
</form>
</body>
<script type="text/javascript" src="/manager/js/picture.js"></script>
</html>
