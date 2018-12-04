package org.lanqiao.control;

import org.lanqiao.domain.BookType;
import org.lanqiao.service.IBookTypeService;
import org.lanqiao.service.impl.BookTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
                getBookTypelist(req,resp);
                break;
        }
    }

    private void getBookTypelist(HttpServletRequest req, HttpServletResponse resp) {
        List<BookType> bookTypeList = bookTypeService.getBookTypeList();
        /*try {
            PrintWriter out = resp.getWriter();
            String bookTypes = JSON.toJSONString(bookTypeList);
            out.print(bookTypes);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

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
