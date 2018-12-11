package org.lanqiao.control;

import org.lanqiao.domain.Comment;
import org.lanqiao.service.ICommentService;
import org.lanqiao.service.IjzCommentService;
import org.lanqiao.service.impl.CommentServiceImpl;
import org.lanqiao.service.impl.jzCommentServiceImpl;
import org.lanqiao.utils.PageModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/privateComment.do")
public class privateCommentServlet extends HttpServlet {
    IjzCommentService commentService =new jzCommentServiceImpl();

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
            case "selectByBookId":
                try {
                    selectByBookId(req,resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            case "selectByCustomerId":
                try {
                    selectByCustomerId(req,resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            case "deleteComment":
                try {
                    deleteComment(req,resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            case "updateComment":
                try {
                    updateComment(req,resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "findByGrade":
                try {
                    findByGrade(req,resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "findBybkGrade":
                try {
                    findBybkGrade(req,resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void findBybkGrade(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {

        Comment comment = new Comment();
        String commentgrade = req.getParameter("commentgrade");
        int id = Integer.valueOf(req.getParameter("bookid"));
        comment.setCommentgrade(commentgrade);

        List<Comment> commentList = commentService.findCommentBybkGrade(commentgrade,id);
        req.setAttribute("bkcommentList",commentList);
        req.setAttribute("commentgrade",commentgrade);
        req.setAttribute("bookid",id);

        req.getRequestDispatcher("sale/bookComment.jsp").forward(req,resp);

     }

    private void findByGrade(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        Comment comment = new Comment();
        String commentgrade = req.getParameter("commentgrade");
        int id =  Integer.valueOf(req.getParameter("customerid"));

        comment.setCommentgrade(commentgrade);
        List<Comment> commentList = (List<Comment>) commentService.findCommentByGrade(commentgrade, id);

        req.setAttribute("prcommentList",commentList);
        req.setAttribute("commentgrade",commentgrade);
        req.setAttribute("customerid",id);

        req.getRequestDispatcher("sale/privateComment.jsp").forward(req,resp);
    }

    private void addComment(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {

        Comment comment =new Comment();
        int bookid = Integer.valueOf(req.getParameter("bookid"));
        String bookname = req.getParameter("bookname");
        int id =  Integer.valueOf(req.getParameter("customerid"));
        String username = req.getParameter("username");

        String commentcontent = req.getParameter("commentcontent");
        String commentgrade = req.getParameter("commentgrade");
        comment.setBookId(bookid);
        comment.setBookName(bookname);
        comment.setCommentId(id);
        comment.setUserName(username);
        comment.setCommentcontent(commentcontent);
        comment.setCommentgrade(commentgrade);

        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        comment.setCommentdate(now);
        commentService.addComment(comment);

        selectByCustomerId(req,resp);
    }

    private void updateComment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, SQLException, IOException {
        Comment comment =new Comment();
        String commentid =  req.getParameter("commentid");
        String id= req.getParameter("customerid");
        String commentgrade = req.getParameter("commentgrade");
        String commentcontent = req.getParameter("commentcontent");

        comment.setCommentId(Integer.parseInt(commentid));
        comment.setCommentgrade(commentgrade);
        comment.setCommentcontent(commentcontent);
        req.setAttribute("customerid",id);

        commentService.modifyComment(comment);
        selectByCustomerId(req,resp);
    }



    private void selectByCustomerId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {

        String id =  req.getParameter("customerid");
        if (id!=null){
            List<Comment>  commentList = commentService.findCommentByCustomerId(Integer.parseInt(id));
            req.setAttribute("customerid",id);
            req.setAttribute("prcommentList",commentList);
            req.getRequestDispatcher("sale/privateComment.jsp").forward(req,resp);
        }

    }


    private void selectByBookId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(req.getParameter("bookid"));
        List<Comment> commentList = (List<Comment>) commentService.findCommentByBookId(id);
        req.setAttribute("bkcommentList",commentList);
        req.getRequestDispatcher("sale/bookComment.jsp").forward(req,resp);
    }

    private void deleteComment(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String commentId = req.getParameter("CommentId");
        HttpSession session = req.getSession();
        int no = Integer.parseInt(commentId);
        int id = (int) session.getAttribute("CustomerId");
        commentService.removeComment(no);

        List<Comment>  commentList = commentService.findCommentByCustomerId(Integer.parseInt(String.valueOf(id)));
        req.setAttribute("customerid",id);
        req.setAttribute("prcommentList",commentList);
        req.getRequestDispatcher("sale/privateComment.jsp").forward(req,resp);
    }



}
