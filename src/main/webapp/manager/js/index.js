function pageClick(k) {
	$(k).parent().find("div").removeClass("active");
	$(k).addClass("active");
	var text = $(k).text();
	$("#flTitle").text(text);
	var url = "";
	if(text == "分类管理"){
		url = "bookTypeList.jsp";
	}else if(text == "图书管理"){
        url = "bookList.jsp";
	}else if(text == "订单管理"){
        url = "orderList.jsp";
    }else if(text == "评价管理"){
        url = "";
    }else if(text == "用户管理"){
        url = "userList.jsp";
    }else if(text == "客户管理"){
        url = "customerList.jsp";
    }else if(text == "店铺管理"){
        url = "";
    }else if(text == "分类管理"){
        url = "";
    }
	$(".content").load(url);
}
