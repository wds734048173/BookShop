package org.lanqiao.control;

import org.lanqiao.domain.Reply;
import org.lanqiao.service.IReplyService;
import org.lanqiao.service.impl.ReplyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
                getReplylist(req,resp);
                break;
        }

    }

    private void getReplylist(HttpServletRequest req, HttpServletResponse resp) {
        List<Reply> replyList = replyService.getReplyList();

        req.setAttribute("replyList",replyList);
        try {
            req.getRequestDispatcher("manager/replyList.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
