package org.lanqiao.control;

import org.lanqiao.domain.Book;
import org.lanqiao.service.IBookService;
import org.lanqiao.service.impl.BookServiceImpl;

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
                getBooklist(req,resp);
                break;
        }
    }

    private void getBooklist(HttpServletRequest req, HttpServletResponse resp) {
        /*List<BookType> bookTypeList = bookTypeService.getBookTypeList();
        try {
            req.getRequestDispatcher("manager/bookTypeList.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        List<Book> bookList = bookService.getBookList();

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
