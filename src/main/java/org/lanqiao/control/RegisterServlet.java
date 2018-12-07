package org.lanqiao.control;

import org.lanqiao.domain.Manager;
import org.lanqiao.service.IManagerService;
import org.lanqiao.service.impl.ManagerServiceImpl;
import org.lanqiao.utils.MD5Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/*
* 注册
* */
@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
    IManagerService managerService = new ManagerServiceImpl();

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
        switch (method) {
            case "register":
                register(req, resp);
                break;
        }
    }

    private void register(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String passwordMd5 = MD5Utils.MD5(password);
        Manager manager = new Manager();
        manager.setAdminName(username);
        manager.setAdminPwd(passwordMd5);
        int result = managerService.addManager(manager);
        if(result == 1){
            try {
                resp.sendRedirect("/manager/login.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
