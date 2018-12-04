function pageClick(k) {
	$(k).parent().find("div").removeClass("active");
	$(k).addClass("active");
	var text = $(k).text();
	$("#flTitle").text($(k).text());
    var url = "";
    if (text == "分类管理") {
        url = "/bookType.do?method=getBookTypelist";

    } else if (text == "图书管理") {
        url = "";
    } else if (text == "") {
        url = "";
    } else if (text == "评价管理") {
        url = "";
    } else if (text == "用户管理") {
        url = "userList.jsp";
    } else if (text == "客户管理") {
        url = "customerList.jsp";
    } else if (text == "评价信息") {
        url = "/comment.do?method=getCommentlist";
    } else if (text == "信息反馈") {
        url = "/reply.do?method=getReplylist";
    }



    $(".content").load(url);
}
