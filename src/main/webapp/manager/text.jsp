<%--
  Created by IntelliJ IDEA.
  User: WDS
  Date: 2018/12/5
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function modifyItem() {
            if (trim(document.getElementById("itemName").value) == "") {
                alert("物料名称不能为空！");
                document.getElementById("itemName").focus();
                return;
            }
            with (document.getElementById("itemForm")) {
                method = "post";
                action = "item.do?command=modify&pageNo=${itemForm.pageNo}";
                submit();
            }
        }
        //返回
        function goBack() {
            window.self.location = "item.do?command=list&pageNo=${itemForm.pageNo}";
        }
    </script>
</head>
<body>

<span style="font-size:24px;">
<form name="itemForm" id="itemForm">
      <input name="itemNo" type="text"   id="itemNo" value="${ item.itemNo }" >
      <input name="itemName" type="text"   id="itemName" value="${ item.itemName }" >
     <input name="btnModify"  type="button" id="btnModify" value=“修改" onclick="modifyItem()">
</form>
</body>
</html>
