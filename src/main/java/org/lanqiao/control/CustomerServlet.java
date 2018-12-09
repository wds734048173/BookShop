package org.lanqiao.control;

import org.lanqiao.domain.Customer;
import org.lanqiao.service.ICustomerService;
import org.lanqiao.service.impl.CustomerServiceImpl;
import org.lanqiao.utils.MD5Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
            case "addCustomer":
                addCustomer(req, resp);
                break;
            case "getMyInfo":
                getCusInfo(req, resp);
                break;
            case "updateCustomer":
                upadteCusInfo(req, resp);
                break;
        }
    }

    private void upadteCusInfo(HttpServletRequest req, HttpServletResponse resp) {
        Customer customer = new Customer();
        String id = req.getParameter("CustomerId");
        String tel = req.getParameter("tel");
        String email = req.getParameter("email");
        String addr = req.getParameter("addr");
        customer.setCustomerId(Integer.parseInt(id));
        customer.setCustomerTel(tel);
        customer.setCustomerEmail(email);
        customer.setCustomerAddr(addr);
        customerService.updateCustomer(customer);
        getCusInfo(req, resp);
    }

    private void getCusInfo(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        String customerId = req.getParameter("CustomerId");
        Customer customer = new Customer();
        if (id!=null){
            customer = customerService.getCustomerById(Integer.parseInt(id));
        }
        if (customerId != null){
            customer = customerService.getCustomerById(Integer.parseInt(customerId));
        }
        req.setAttribute("Customer",customer);
        try {
            req.getRequestDispatcher("/sale/myInfo.jsp").forward(req,resp);
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
            customer.setCustomerSex(0);
        }else {
            customer.setCustomerSex(1);
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
//    获取全部客户
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
