package org.lanqiao.control;

import org.lanqiao.domain.Comment;
import org.lanqiao.service.ICommentService;
import org.lanqiao.service.impl.CommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
@WebServlet("/comment.do")
public class CommentServlet extends HttpServlet {
    ICommentService commentService = new CommentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req,resp);
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
            case "getCommentlist":
                getCommentlist(req,resp);
                break;
        }

    }

    private void getCommentlist(HttpServletRequest req, HttpServletResponse resp) {
        List<Comment> commentList = commentService.getCommentList();

        req.setAttribute("commentList",commentList);
        try {
            req.getRequestDispatcher("manager/commentList.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
