package org.lanqiao.control;

import org.lanqiao.domain.Customer;
import org.lanqiao.service.ICustomerService;
import org.lanqiao.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
@WebServlet("/customer.do")
public class CustomerServlet extends HttpServlet {
    ICustomerService customerService = new CustomerServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);

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
            case "getCustomerlist":
                getCustomerlist(req,resp);
                break;
        }
    }

    private void getCustomerlist(HttpServletRequest req, HttpServletResponse resp) {
        List<Customer> customerList = customerService.getCustomerList();

        req.setAttribute("customerList",customerList);
        try {
            req.getRequestDispatcher("manager/customerList.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
