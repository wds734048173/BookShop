package org.lanqiao.control;

import org.lanqiao.domain.Book;
import org.lanqiao.domain.BookType;
import org.lanqiao.domain.Condition;
import org.lanqiao.service.IBookInfoService;
import org.lanqiao.service.IBookService;
import org.lanqiao.service.IBookTypeService;
import org.lanqiao.service.impl.BookInfoServiceImpl;
import org.lanqiao.service.impl.BookServiceImpl;
import org.lanqiao.service.impl.BookTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/home.do")
public class HomeServlet extends HttpServlet {
    IBookService bookService = new BookServiceImpl();
    IBookTypeService bookTypeService = new BookTypeServiceImpl();
    IBookInfoService bookInfoService=new BookInfoServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method=req.getParameter("method");
        switch (method){
            case "homeList":
                getHomeList(req,resp);
                break;
            case "booklist":
                getBookList(req, resp);
                break;
        }
    }



    private void getHomeList(HttpServletRequest req, HttpServletResponse resp){

        List<Book> bookList = bookInfoService.findAll();
        Condition condition= new Condition();
        condition.setName(null);
        condition.setCurrentPage(0);
        condition.setPageSize(10);
        List<BookType> typeList = bookTypeService.getBookTypeList(condition);

        req.setAttribute("bookList",bookList);
        req.setAttribute("typeList",typeList);

        try {
            req.getRequestDispatcher("sale/home.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getBookList(HttpServletRequest req, HttpServletResponse resp) {
        //根据typeid获取书的详细信息
        String typeid= (String) req.getParameter("typeId");
        List<Book> bookList = bookInfoService.selectByTypeId(Integer.parseInt(typeid));
        req.setAttribute("books",bookList);

        try {
            req.getRequestDispatcher("sale/booklist.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
