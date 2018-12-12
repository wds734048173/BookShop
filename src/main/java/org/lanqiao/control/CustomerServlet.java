package org.lanqiao.control;

import com.alibaba.fastjson.JSON;
import org.lanqiao.domain.Condition;
import org.lanqiao.domain.Customer;
import org.lanqiao.service.ICustomerService;
import org.lanqiao.service.impl.CustomerServiceImpl;
import org.lanqiao.utils.MD5Utils;
import org.lanqiao.utils.PageModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
            case "getMyInfo":
                getMyInfo(req, resp);
                break;
            case "addCustomer":
                addCustomer(req, resp);
                break;
        }
    }

    private void getMyInfo(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        if (session.getAttribute("CustomerId") == null){
            try {
                req.getRequestDispatcher("sale/login.jsp").forward(req,resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        int id = (int) session.getAttribute("CustomerId");
        Customer customer = customerService.getCustomerById(id);

        req.setAttribute("Customer",customer);
        try {
            req.getRequestDispatcher("sale/myInfo.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void addCustomer(HttpServletRequest req, HttpServletResponse resp) {
        Customer customer = new Customer();
        //设置用户名
        customer.setCustomerName(req.getParameter("username"));
        //设置密码
        String pwd = req.getParameter("password");
        customer.setCustomerPwd(MD5Utils.MD5(pwd));
        //设置真实姓名
        customer.setCustomertruename(req.getParameter("name"));
        //设置电话
        customer.setCustomerTel(req.getParameter("tel"));
        //设置邮箱
        customer.setCustomerEmail(req.getParameter("email"));
        //设置地址
        customer.setCustomerAddr(req.getParameter("addr"));
        //设置性别
        String sex=req.getParameter("radio1");
        if (sex.equals("男")){
            customer.setCustomerSex("0");
        }else {
            customer.setCustomerSex("1");
        }
        System.out.println(customer);
        customerService.addCustomer(customer);
        try {
            req.setAttribute("success","success");
            req.getRequestDispatcher("/sale/login.jsp").forward(req,resp);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
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

        PageModel pm = new PageModel(pageNum,totalRecords,pageSize);
        //如果当前页大于总页数，但是排除查询不到数据的情况。当前页等于最大页
        if(pageNum > pm.getTotalPageNum() && pm.getTotalPageNum() != 0){
            pageNum = pm.getTotalPageNum();
        }

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
