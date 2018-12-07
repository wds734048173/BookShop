package org.lanqiao.control;

import org.lanqiao.domain.Customer;
import org.lanqiao.domain.Manager;
import org.lanqiao.service.ICustomerService;
import org.lanqiao.service.IManagerService;
import org.lanqiao.service.impl.CustomerServiceImpl;
import org.lanqiao.service.impl.ManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

/*
* 登录
* */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {

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
        switch(method){
            case "login":
                userLogin(req,resp);
                break;
        }

    }

    private void userLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        ICustomerService iCustomerService = new CustomerServiceImpl();
        IManagerService iManagerService = new ManagerServiceImpl();
        List<Customer> customerList = iCustomerService.getCustomerList();
        List<Manager> managerList =null;
        try {
             managerList = iManagerService.getManagerLlist();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Manager manager:managerList){
            if (username.equalsIgnoreCase(manager.getAdminName())){
                if(password.equalsIgnoreCase(manager.getAdminPwd())){
                    req.setAttribute("username",username);
                    req.getRequestDispatcher("manager/index.jsp").forward(req,resp);
                }
            }
        }
        for (Customer customer:customerList){
            if (username.equalsIgnoreCase(customer.getUserName())){
                if (password.equalsIgnoreCase(customer.getPassword())){
                    req.setAttribute("username",username);
                    req.getRequestDispatcher("").forward(req,resp);
                }
            }
        }
    }

}
