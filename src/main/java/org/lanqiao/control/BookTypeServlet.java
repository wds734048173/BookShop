package org.lanqiao.control;

import com.alibaba.fastjson.JSON;
import org.lanqiao.domain.BookType;
import org.lanqiao.domain.Condition;
import org.lanqiao.service.IBookTypeService;
import org.lanqiao.service.impl.BookTypeServiceImpl;
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

@WebServlet("/bookType.do")
public class BookTypeServlet extends HttpServlet {
    IBookTypeService bookTypeService = new BookTypeServiceImpl();

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
        switch (method){
            case "getBookTypelist":
                getBookTypelist(req,resp,null);
                break;
            case "addBookType":
                addBookType(req,resp);
                break;
            case "deleteBookType":
                deleteBookType(req,resp);
                break;
            case "getBookTypeById"://修改数据获取
                getBookTypeById(req,resp);
                break;
            case "getBookTypeForSelect":
                getBookTypeForSelect(req,resp);
                break;
        }
    }

    private void getBookTypeForSelect(HttpServletRequest req, HttpServletResponse resp) {
        List<BookType> bookTypeList = bookTypeService.getBookTypeList(null);
        try {
            PrintWriter out = resp.getWriter();
            String bookTypeListJson = JSON.toJSONString(bookTypeList);
            out.print(bookTypeListJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getBookTypeById(HttpServletRequest req, HttpServletResponse resp) {
        int bookTypeId = Integer.valueOf(req.getParameter("bookTypeId"));
        BookType bookType = bookTypeService.getBookTypeById(bookTypeId);
        try {
            PrintWriter out = resp.getWriter();
            String bookTypeJson = JSON.toJSONString(bookType);
            out.print(bookTypeJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteBookType(HttpServletRequest req, HttpServletResponse resp) {
        int bookTypeId = Integer.valueOf(req.getParameter("bookTypeId"));
        bookTypeService.deleteBookType(bookTypeId);
        getBookTypelist(req,resp,"delete");
    }

    private void addBookType(HttpServletRequest req, HttpServletResponse resp) {
        String mark = null;
        BookType bookType = new BookType();
        String bookTypeName = req.getParameter("bookTypeName");
        bookType.setBookTypeName(bookTypeName);
        String bookTypeId = req.getParameter("bookTypeId");
        if(bookTypeId == null || "".equals(bookTypeId)){
            mark = "add";
            bookTypeService.addBookType(bookType);
        }else{
            mark = "update";
            bookType.setBookTypeId(Integer.valueOf(bookTypeId));
            bookTypeService.updateBookType(bookType);
        }
        getBookTypelist(req, resp, mark);
    }

    private void getBookTypelist(HttpServletRequest req, HttpServletResponse resp, String mark) {
        int pageNum = 1;
        if(req.getParameter("currentPage") != null){
            pageNum = Integer.valueOf(req.getParameter("currentPage"));
        }
        int pageSize = 5;
        if(req.getParameter("pageSize") != null){
            pageSize = Integer.valueOf(req.getParameter("pageSize"));
        }

        //查询条件
        String searchBookTypeName = "";
        if(req.getParameter("searchBookTypeName") != null){
            searchBookTypeName = req.getParameter("searchBookTypeName");
        }
        Condition condition = new Condition();
        condition.setName(searchBookTypeName);
        int totalRecords = bookTypeService.getBookTypeCount(condition);
        //不同操作，不同的当前页设置
        PageModel pm = new PageModel(pageNum,totalRecords,pageSize);
        if("add".equals(mark)){
            pageNum = pm.getEndPage();
        }else if("update".equals(mark)){
            pageNum = Integer.valueOf(req.getParameter("currentPage"));
        }else{
            pageNum = Integer.valueOf(req.getParameter("currentPage"));
            if(pageNum > pm.getTotalPageNum()){
                pageNum = pm.getTotalPageNum();
            }
        }
        PageModel pageModel = new PageModel(pageNum,totalRecords,pageSize);
        //分页条件封装
        condition.setCurrentPage(pageModel.getStartIndex());
        condition.setPageSize(pageModel.getPageSize());
        List<BookType> bookTypeList = bookTypeService.getBookTypeList(condition);
        req.setAttribute("currentPage",pageNum);
        pageModel.setRecords(bookTypeList);
        req.setAttribute("pm",pageModel);
        req.setAttribute("condition",condition);
        req.setAttribute("bookTypeList",bookTypeList);
        try {
            req.getRequestDispatcher("manager/bookTypeList.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
