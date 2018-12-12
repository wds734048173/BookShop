package org.lanqiao.control;

import com.alibaba.fastjson.JSON;
import org.lanqiao.domain.BookType;
import org.lanqiao.domain.Comment;
import org.lanqiao.domain.Condition;
import org.lanqiao.service.ICommentService;
import org.lanqiao.service.impl.CommentServiceImpl;
import org.lanqiao.utils.PageModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
                getCommentlistCur(req,resp,null);
                break;
            case "addComment":
                try {
                    addComment(req,resp);
                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "deleteComment":
                try {
                    delComment(req, resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "getCommentById":
                try {
                    getCommentById(req,resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }

    }
    //通过commentId获取一条评语
    private void getCommentById(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        int commentId = Integer.parseInt(req.getParameter("commentId"));
        Comment commentById = commentService.selectOne(commentId);
        PrintWriter out = resp.getWriter();
        String comment = JSON.toJSONString(commentById);
        out.print(comment);
    }


    //获取全部评语
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
    //删除
    public void delComment(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        int commentId = Integer.valueOf(req.getParameter("bookId"));
        commentService.delComment(commentId);
        getCommentlistCur(req,resp,"delete");
    }
    private void addComment(HttpServletRequest req, HttpServletResponse resp) throws ParseException, SQLException, ServletException, IOException {
        String mark = null;
        String commentId = req.getParameter("commentId");
        String BookId = req.getParameter("BookId");
        String BookName = req.getParameter("BookName");//图书名
        String CustomerId = req.getParameter("CustomerId");
        String UserName = req.getParameter("UserName");//用户名
        String commentContent = req.getParameter("commentContent");//评语
        String commentGrade = req.getParameter("commentGrade");//评论等级
        int BookIdInt = Integer.parseInt(BookId);//图书id
        int CustomerIdInt = Integer.parseInt(CustomerId);//客户id
        Date commentdate = new Date();//评论日期
        Comment comment = new Comment(BookIdInt,BookName,CustomerIdInt,UserName,commentdate,commentContent,commentGrade);
        ICommentService iCommentService = new CommentServiceImpl();
        if(commentId == null || "".equals(commentId)){
            mark = "add";
            iCommentService.addComment(comment);
        }else{
            mark = "update";
            comment.setCommentId(Integer.parseInt(req.getParameter("commentId")));
            commentService.updateComment(comment);
        }
        getCommentlistCur(req,resp,mark);
    }
    private void getCommentlistCur(HttpServletRequest req, HttpServletResponse resp, String mark) {
        int pageNum = 1;
        if(req.getParameter("currentPage") != null){
            pageNum = Integer.valueOf(req.getParameter("currentPage"));
        }
        int pageSize = 5;
        if(req.getParameter("pageSize") != null){
            pageSize = Integer.valueOf(req.getParameter("pageSize"));
        }

        //查询条件
        String searchBookName = "";
        if(req.getParameter("searchBookName") != null){
            searchBookName = req.getParameter("searchBookName");
        }
        Condition condition = new Condition();
        condition.setName(searchBookName);
        int totalRecords = commentService.getCommentCount(condition);
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
        List<Comment> commentListCur= commentService.getCommentListCur(condition);
        req.setAttribute("currentPage",pageNum);
        pageModel.setRecords(commentListCur);
        req.setAttribute("pm",pageModel);
        req.setAttribute("condition",condition);
        req.setAttribute("commentListCur",commentListCur);
        try {
            req.getRequestDispatcher("manager/commentList.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}
