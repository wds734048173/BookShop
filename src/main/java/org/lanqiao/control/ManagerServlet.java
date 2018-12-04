package org.lanqiao.control;

import org.lanqiao.domain.Manager;
import org.lanqiao.service.IManagerService;
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

//管理员信息展示
@WebServlet("/manager.do")
public class ManagerServlet extends HttpServlet {
    IManagerService iManagerService = new ManagerServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json");
        String method = req.getParameter("method");
        switch (method){
            case "getManagerList":
                try {
                    getManagerList(req,resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void getManagerList(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        List<Manager> managerList = iManagerService.getManagerLlist();
        req.setAttribute("ManagerList",managerList);
        try {
            req.getRequestDispatcher("manager/managerList.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
