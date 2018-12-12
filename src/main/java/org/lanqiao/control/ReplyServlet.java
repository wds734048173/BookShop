package org.lanqiao.control;

import com.alibaba.fastjson.JSON;
import org.lanqiao.domain.Condition;
import org.lanqiao.domain.Reply;
import org.lanqiao.service.IReplyService;
import org.lanqiao.service.impl.ReplyServiceImpl;
import org.lanqiao.utils.PageModel;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
@WebServlet("/reply.do")
public class ReplyServlet extends HttpServlet {
    IReplyService replyService = new ReplyServiceImpl();
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
            case "getReplylist":
                getReplylist(req,resp,null);
                break;
            case "deleteReply":
                deleteReply(req,resp);
                break;
            case "getReplyById":
                getReplyById(req,resp);
                break;
            case "getHomeList":
                getHomeList(req, resp);
                break;
            case "myReply":
                getCustomerList(req, resp);
                break;
            case "deleteMyReply":
                deleteMyReply(req, resp);
                break;
            case "addReply":
                addReply(req, resp);
                break;
        }
    }




    private void getReplyById(HttpServletRequest req, HttpServletResponse resp) {
        int replyId = Integer.valueOf(req.getParameter("ReplyId"));
        Reply reply = replyService.getReplyById(replyId);
        try {
            PrintWriter out = resp.getWriter();
            String replyJson = JSON.toJSONString(reply);
            out.print(replyJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void deleteReply(HttpServletRequest req, HttpServletResponse resp) {
        int replyId = Integer.valueOf(req.getParameter("ReplyId"));
        replyService.deleteReply(replyId);
        getReplylist(req,resp,"delete");
    }

    private void getReplylist(HttpServletRequest req, HttpServletResponse resp,String mark) {
        int pageNum = 1;
        if(req.getParameter("currentPage") != null){
            pageNum = Integer.valueOf(req.getParameter("currentPage"));
        }
        int pageSize = 5;
        if(req.getParameter("pageSize") != null){
            pageSize = Integer.valueOf(req.getParameter("pageSize"));
        }

        //查询条件
        String searchCustomerId = "";
        if(req.getParameter("searchCustomerId") != null){
            searchCustomerId = req.getParameter("searchCustomerId");
        }

        String searchReplycontent = "";
        if(req.getParameter("searchReplycontent") != null){
            searchReplycontent = req.getParameter("searchReplycontent");
        }
        String searchReplyType = "";
        if(req.getParameter("searchReplyType") != null){
            searchReplyType = req.getParameter("searchReplyType");
        }
        Condition condition = new Condition();
        condition.setBookTypeId(searchCustomerId);
        condition.setName(searchReplycontent);
        condition.setState(searchReplyType);
        int totalRecords = replyService.getReplyCount(condition);
        //不同操作，不同的当前页设置
        PageModel pm = new PageModel(pageNum,totalRecords,pageSize);
        if(pageNum > pm.getTotalPageNum()){
            pageNum = pm.getTotalPageNum();
        }

        PageModel pageModel = new PageModel(pageNum,totalRecords,pageSize);
        //分页条件封装
        condition.setCurrentPage(pageModel.getStartIndex());
        condition.setPageSize(pageModel.getPageSize());
        List<Reply> replyList = replyService.getReplyList(condition);
        req.setAttribute("currentPage",pageNum);
        pageModel.setRecords(replyList);
        req.setAttribute("pm",pageModel);
        req.setAttribute("condition",condition);
        req.setAttribute("replyList",replyList);
        try {
            req.getRequestDispatcher("manager/replyList.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //查找所有反馈到前端
    private void getHomeList(HttpServletRequest req, HttpServletResponse resp) {
        List<Reply> replyList = replyService.getList();

        req.setAttribute("replyList",replyList);
        try {
            req.getRequestDispatcher("sale/reply.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //查找用户的反馈信息
    private void getCustomerList(HttpServletRequest req, HttpServletResponse resp){
        HttpSession session = req.getSession();
        int id = (int) session.getAttribute("CustomerId");
        List<Reply> replyList = replyService.getReplyByCustomerId(id);
        req.setAttribute("replyList",replyList);
        try {
            req.getRequestDispatcher("sale/myReply.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteMyReply(HttpServletRequest req, HttpServletResponse resp) {

        String replyId = req.getParameter("replyId");
        System.out.println(replyId);
        replyService.deleteReply(Integer.parseInt(replyId));
        getCustomerList(req, resp);
    }

    private void addReply(HttpServletRequest req, HttpServletResponse resp){
        Reply reply = new Reply();
        HttpSession session = req.getSession();
        String type=req.getParameter("type");
        String title=req.getParameter("title");
        String content=req.getParameter("content");
        String name = req.getParameter("name");
        reply.setCustomerId((Integer) session.getAttribute("CustomerId"));
        reply.setCustomername(name);
        reply.setReplyType(type);
        reply.setReplytitle(title);
        reply.setReplycontent(content);
        System.out.println(reply);
        replyService.addReply(reply);
        getCustomerList(req, resp);
    }
}
