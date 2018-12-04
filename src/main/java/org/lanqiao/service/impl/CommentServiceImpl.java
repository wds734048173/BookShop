package org.lanqiao.service.impl;

import org.lanqiao.dao.ICommentDao;
import org.lanqiao.dao.impl.CommentDaoImpl;
import org.lanqiao.domain.Comment;
import org.lanqiao.service.ICommentService;

import java.util.List;

public class CommentServiceImpl implements ICommentService {
    ICommentDao commentDao = new CommentDaoImpl();
    @Override
    public List<Comment> getCommentList() {
        return commentDao.getCommentList();
    }
}
