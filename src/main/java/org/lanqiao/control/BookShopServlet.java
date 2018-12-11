package org.lanqiao.control;

import org.lanqiao.domain.CartItem;
import org.lanqiao.domain.OrderItem;
import org.lanqiao.service.ICartItemService;
import org.lanqiao.service.ICustomerService;
import org.lanqiao.service.IOrderService;
import org.lanqiao.service.impl.CartItemServiceImpl;
import org.lanqiao.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Service;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/bookshop.do")
public class BookShopServlet extends HttpServlet {

    ICartItemService service = new CartItemServiceImpl();
    ICartItemService iCartItem = new CartItemServiceImpl() ;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        switch(method){
            //删除商品
            case  "delByCustomerId":

                delByCustomerId(request,response);
                break;
                //获取列表
            case  "getCartItemList":
                getCartItemList(request,response);
                break;
            case "addToList":
                addToCarList(request, response);
                break;
            case "findByCustomerId":
                findByCusId(request, response);
                break;
            case "findByOrderId":
                findByOrderId(request,response);
                break;
        }

//        request.getRequestDispatcher("/sale/bookshop.jsp").forward(request,response);
    }

    private void findByOrderId(HttpServletRequest request, HttpServletResponse response) {
        int orderid =0;
        String id = request.getParameter("id");
        if (id!=null){
            orderid = Integer.parseInt(id);
        }
        id = (String) request.getAttribute("id");
        if (id != null){
            orderid = Integer.parseInt(id);
        }
        IOrderService service = new OrderServiceImpl();
        List<OrderItem> cartItems=service.getOrderItemList(orderid);
        request.setAttribute("cartItems",cartItems);
        try {
            request.getRequestDispatcher("sale/orderItem.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void findByCusId(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("CustomerId");
        List<CartItem> cartItems=null;
        try {
            cartItems=service.findByCustomerId(id);
            request.setAttribute("cartItems",cartItems);
            request.getRequestDispatcher("sale/pay.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addToCarList(HttpServletRequest request, HttpServletResponse response) {
        String bookId = request.getParameter("bookId");
        String CustomerId = request.getParameter("customerId");
        String num = request.getParameter("num");
        service.addToCarList(Integer.parseInt(CustomerId),Integer.parseInt(bookId),Integer.parseInt(num));
        try {
            request.getRequestDispatcher("/bookinfo.do?method=detail&bookId="+ bookId +"").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getCartItemList(HttpServletRequest request, HttpServletResponse response) {
        int total = 0;
        HttpSession session = request.getSession();
        int cutomcatid= (int) session.getAttribute("CustomerId");

        if (request.getAttribute("CustomerId")!= null){
            cutomcatid= (int) request.getAttribute("CustomerId");
        }

        List<CartItem> cartItemList = null;
        try {
            cartItemList = iCartItem.findByCustomerId(cutomcatid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (CartItem c:cartItemList ){
            total += c.getBookPrice()*c.getOrdermount();
        }
        request.setAttribute("total",total);
        request.setAttribute("cartItemList",cartItemList);
        try {
            request.getRequestDispatcher("/sale/bookshop.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    private void delByCustomerId(HttpServletRequest req, HttpServletResponse resp) {
//        int CustomerId = Integer.valueOf(req.getParameter("CustomerId"));
//        service.removeCartItem(CustomerId);
//        service(req,resp,"delete");
//
//    }



    public void delByCustomerId(HttpServletRequest request, HttpServletResponse response) {
        String CustomerId = request.getParameter("CustomerId");
        String BookId = request.getParameter("BookId");
        int CId = Integer.parseInt(CustomerId);
        int BId = Integer.parseInt(BookId);
        service.removeCartItem(CId,BId);
        getCartItemList(request, response);
    }
}
