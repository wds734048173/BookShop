package org.lanqiao.control;

import com.alibaba.fastjson.JSON;
import org.lanqiao.domain.Condition;
import org.lanqiao.domain.Customer;
import org.lanqiao.service.ICustomerService;
import org.lanqiao.service.impl.CustomerServiceImpl;
import org.lanqiao.utils.PageModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

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
            case "getCustomerById":
                getCustomerById(req,resp);
                break;
        }
    }

    private void getCustomerById(HttpServletRequest req, HttpServletResponse resp) {
        int customerId = Integer.valueOf(req.getParameter("CustomerId"));
        Customer customer = customerService.getCustomerById(customerId);
        try {
            PrintWriter out = resp.getWriter();
            String customerJson = JSON.toJSONString(customer);
            out.print(customerJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void getCustomerlist(HttpServletRequest req, HttpServletResponse resp) {
        int pageNum = 1;
        if(req.getParameter("currentPage") != null){
            pageNum = Integer.valueOf(req.getParameter("currentPage"));
        }
        int pageSize = 5;
        if(req.getParameter("pageSize") != null){
            pageSize = Integer.valueOf(req.getParameter("pageSize"));
        }

        //查询条件
        String searchCustomerName = "";
        if(req.getParameter("searchCustomerName") != null){
            searchCustomerName = req.getParameter("searchCustomerName");
        }
        Condition condition = new Condition();
        condition.setName(searchCustomerName);
        int totalRecords = customerService.getCustomerCount(condition);
        PageModel pageModel = new PageModel(pageNum,totalRecords,pageSize);
        //分页条件封装
        condition.setCurrentPage(pageModel.getStartIndex());
        condition.setPageSize(pageModel.getPageSize());
        List<Customer> customerList = customerService.getCustomerList(condition);
        req.setAttribute("currentPage",pageNum);
        pageModel.setRecords(customerList);
        req.setAttribute("pm",pageModel);
        req.setAttribute("condition",condition);
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
