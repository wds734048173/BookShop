package org.lanqiao.control;

import org.lanqiao.domain.Book;
import org.lanqiao.domain.BookType;
import org.lanqiao.domain.Condition;
import org.lanqiao.service.IBookService;
import org.lanqiao.service.impl.BookServiceImpl;
import org.lanqiao.utils.PageModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/*
* 书籍管理
* */

@WebServlet("/book.do")
public class BookServlet extends HttpServlet {

    IBookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        switch (method){
            case "getBooklist":
                getBooklist(req,resp,null);
                break;
            case "addBook":
                addBook(req,resp);
                break;
        }
    }


    private void addBook(HttpServletRequest req, HttpServletResponse resp) {
        String picUrl = req.getSession().getAttribute("picUrl").toString();
        System.out.println("picUrl=============="+picUrl);
    }

    private void getBooklist(HttpServletRequest req, HttpServletResponse resp,String mark) {
        int pageNum = 1;
        if(req.getParameter("currentPage") != null){
            pageNum = Integer.valueOf(req.getParameter("currentPage"));
        }
        int pageSize = 5;
        if(req.getParameter("pageSize") != null){
            pageSize = Integer.valueOf(req.getParameter("pageSize"));
        }

        //查询条件
        String searchBookTypeId = "";
        if(req.getParameter("searchBookTypeId") != null){
            searchBookTypeId = req.getParameter("searchBookTypeId");
        }
        String searchBookName = "";
        if(req.getParameter("searchBookName") != null){
            searchBookName = req.getParameter("searchBookName");
        }
        String searchBookAuthor = "";
        if(req.getParameter("searchBookAuthor") != null){
            searchBookAuthor = req.getParameter("searchBookAuthor");
        }
        Condition condition = new Condition();
        condition.setName(searchBookName);
        condition.setBookTypeId(searchBookTypeId);
        condition.setState(searchBookAuthor);

        int totalRecords = bookService.getBookCount(condition);
        //不同操作，不同的当前页设置
        PageModel pm = new PageModel(pageNum,totalRecords,pageSize);
        if("add".equals(mark)){
            pageNum = pm.getEndPage();
        }else if("update".equals(mark)){
            pageNum = Integer.valueOf(req.getParameter("currentPage"));
        }else if("delete".equals(mark)){
            pageNum = Integer.valueOf(req.getParameter("currentPage"));
            if(pageNum > pm.getTotalPageNum()){
                pageNum = pm.getTotalPageNum();
            }
        }
        PageModel pageModel = new PageModel(pageNum,totalRecords,pageSize);
        //分页条件封装
        condition.setCurrentPage(pageModel.getStartIndex());
        condition.setPageSize(pageModel.getPageSize());
        List<Book> bookList = bookService.getBookList(condition);
        req.setAttribute("currentPage",pageNum);
        pageModel.setRecords(bookList);
        req.setAttribute("pm",pageModel);
        req.setAttribute("condition",condition);
        req.setAttribute("bookList",bookList);
        try {
            req.getRequestDispatcher("manager/bookList.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
