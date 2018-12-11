package org.lanqiao.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.dao.IjzCommentDao;
import org.lanqiao.domain.Comment;
import org.lanqiao.utils.jdbcUtils;

import java.sql.SQLException;
import java.util.List;

public class jzCommentDaoIpml implements IjzCommentDao {
    private QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());


    @Override
    public List<Comment> selectCommentByCustomerId(int customerId) throws SQLException {
        String sql = "select * from tb_comment where CustomerId=? ";
        return qr.query(sql,new BeanListHandler<>(Comment.class),customerId);
    }

    @Override
    public List<Comment> selectCommentByBookId(int bookId) throws SQLException {
        String sql = "select * from tb_comment where BookId=? ";
        return qr.query(sql,new BeanListHandler<>(Comment.class),bookId);
    }

    @Override
    public List<Comment> selectByCommentgrade(String Commentgrade,int CustomerId) throws SQLException {
        String sql ="select * from tb_comment WHERE Commentgrade = ? AND CustomerId = ? ";
        return qr.query(sql,new BeanListHandler<>(Comment.class),Commentgrade,CustomerId);
    }

    @Override
    public List<Comment> selectBybkCommentgrade(String Commentgrade, int BookId) throws SQLException {
        String sql = "select * from tb_comment WHERE Commentgrade = ? AND BookId = ? ";
        return qr.query(sql,new BeanListHandler<>(Comment.class),Commentgrade,BookId);
    }


    @Override
    public void deleteComment(int CommentId) throws SQLException {
        String sql = "delete  from tb_comment where CommentId=?";
        qr.update(sql,CommentId);
    }

    @Override
    public void insertComment(Comment comment) throws SQLException {
        String sql = "insert into tb_comment(BookId,BookName,CustomerId,UserName,Commentdate,Commentcontent,Commentgrade) values (?,?,?,?,?,?,?)";
        qr.update(sql,comment.getBookId(),comment.getBookName(),comment.getCustomerId(),comment.getUserName(),comment.getCommentdate(),comment.getCommentcontent(),comment.getCommentgrade());
    }

    @Override
    public void updateComment(Comment comment) throws SQLException {
        String sql = "update tb_comment set Commentgrade=?,Commentcontent = ? where CommentId =?";
        qr.update(sql,comment.getCommentgrade(),comment.getCommentcontent(),comment.getCommentId());
    }
}
