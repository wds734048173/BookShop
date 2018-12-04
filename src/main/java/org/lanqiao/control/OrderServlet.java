package org.lanqiao.control;

import org.lanqiao.domain.Order;
import org.lanqiao.service.IOrderService;
import org.lanqiao.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/*
* 订单管理
* */
@WebServlet("/order.do")
public class OrderServlet extends HttpServlet {
IOrderService orderService = new OrderServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json");
        String method = req.getParameter("method");
        switch (method){
            case "getOrderlist":
                getOrderlist(req,resp);
                break;
        }
    }

    private void getOrderlist(HttpServletRequest req, HttpServletResponse resp) {
        List<Order> orderList = orderService.getOrderList();

        req.setAttribute("orderList",orderList);
        try {
            req.getRequestDispatcher("manager/orderList.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
