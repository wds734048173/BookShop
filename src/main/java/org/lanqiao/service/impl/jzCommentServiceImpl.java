package org.lanqiao.service.impl;

import org.lanqiao.dao.ICommentDao;
import org.lanqiao.dao.IjzCommentDao;
import org.lanqiao.dao.impl.CommentDaoImpl;
import org.lanqiao.dao.impl.jzCommentDaoIpml;
import org.lanqiao.domain.Comment;
import org.lanqiao.service.IjzCommentService;

import java.sql.SQLException;
import java.util.List;

public class jzCommentServiceImpl implements IjzCommentService {

    IjzCommentDao commentDao = new jzCommentDaoIpml();
    @Override
    public void addComment(Comment comment) {
        try {
            commentDao.insertComment(comment);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void removeComment(int CommentId){
        try {
            commentDao.deleteComment(CommentId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Comment> findCommentByCustomerId(int CustomerId) throws SQLException {
        return (List<Comment>) commentDao.selectCommentByCustomerId(CustomerId);
    }

    @Override
    public List<Comment> findCommentByBookId(int BookId) throws SQLException {
        return (List<Comment>) commentDao.selectCommentByBookId(BookId);
    }

    @Override
    public List<Comment> findCommentByGrade(String Commentgrade, int CustomerId) throws SQLException {
        return commentDao.selectByCommentgrade(Commentgrade,CustomerId);
    }

    @Override
    public List<Comment> findCommentBybkGrade(String Commentgrade, int BookId) throws SQLException {
        return commentDao.selectBybkCommentgrade(Commentgrade,BookId);
    }


    @Override
    public void modifyComment(Comment comment) throws SQLException {
        commentDao.updateComment(comment);
    }

}
