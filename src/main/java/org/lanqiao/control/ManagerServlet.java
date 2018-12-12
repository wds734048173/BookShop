package org.lanqiao.control;

import org.lanqiao.domain.Condition;
import org.lanqiao.domain.Manager;
import org.lanqiao.service.IManagerService;
import org.lanqiao.service.impl.ManagerServiceImpl;
import org.lanqiao.utils.PageModel;

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
                    getManagerList(req,resp,null);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "deleteManager":
                try {
                    deleteManager(req,resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void deleteManager(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        int adminId = Integer.valueOf(req.getParameter("AdminId"));
        iManagerService.deleteManager(adminId);
        getManagerList(req,resp,"delete");

    }

    private void getManagerList(HttpServletRequest req, HttpServletResponse resp,String mark) throws SQLException {
        int pageNum = 1;
        if(req.getParameter("currentPage") != null){
            pageNum = Integer.valueOf(req.getParameter("currentPage"));
        }
        int pageSize = 5;
        if(req.getParameter("pageSize") != null){
            pageSize = Integer.valueOf(req.getParameter("pageSize"));
        }

        //查询条件
        String searchAdminName = "";
        if(req.getParameter("searchAdminName") != null){
            searchAdminName = req.getParameter("searchAdminName");
        }

        Condition condition = new Condition();
        condition.setName(searchAdminName);

        int totalRecords = iManagerService.getManagerCount(condition);
        //不同操作，不同的当前页设置
        PageModel pm = new PageModel(pageNum,totalRecords,pageSize);

        if(pageNum > pm.getTotalPageNum()){
            pageNum = pm.getTotalPageNum();
        }
        PageModel pageModel = new PageModel(pageNum,totalRecords,pageSize);
        //分页条件封装
        condition.setCurrentPage(pageModel.getStartIndex());
        condition.setPageSize(pageModel.getPageSize());
        List<Manager> managerList = iManagerService.getManagerLlist(condition);
        req.setAttribute("currentPage",pageNum);
        pageModel.setRecords(managerList);
        req.setAttribute("pm",pageModel);
        req.setAttribute("condition",condition);
        req.setAttribute("managerList",managerList);
        try {
            req.getRequestDispatcher("manager/managerList.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
