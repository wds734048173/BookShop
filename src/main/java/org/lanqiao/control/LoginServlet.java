package org.lanqiao.control;

import org.lanqiao.domain.Manager;
import org.lanqiao.service.IManagerService;
import org.lanqiao.service.impl.ManagerServiceImpl;
import org.lanqiao.utils.MD5Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

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
        String passwordMd5 = MD5Utils.MD5(password);
        IManagerService managerService = new ManagerServiceImpl();
        Manager manager = managerService.getManager(username,passwordMd5);
        if(manager == null){
            String message = "用户名或密码错误";
            resp.sendRedirect("/manager/login.jsp");
        }else{
            String name = manager.getAdminName();
            HttpSession session = req.getSession();
            session.setAttribute("username",name);
            Cookie cookie = new Cookie("JSESSIONID",session.getId());
            cookie.setMaxAge(7 * 24 * 60 * 60);
            resp.addCookie(cookie);
            resp.sendRedirect("/manager/index.jsp");
        }
    }

}
