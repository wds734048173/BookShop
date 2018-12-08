package org.lanqiao.control;

import org.lanqiao.domain.Book;
import org.lanqiao.service.IBookInfoService;
import org.lanqiao.service.impl.BookInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/bookinfo.do")
public class BookInfoServlet extends HttpServlet {
    IBookInfoService service = new BookInfoServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        switch (method){
            case "detail":
                getDetail(req, resp);
                break;
        }
    }
    //取得对应书籍的数据
    private void getDetail(HttpServletRequest req, HttpServletResponse resp) {
        String bookId = req.getParameter("bookId");
        System.out.println(Integer.parseInt(bookId));
        Book book = service.selectById(Integer.parseInt(bookId));
        req.setAttribute("bookDetail",book);
        try {
            req.getRequestDispatcher("sale/detail.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
