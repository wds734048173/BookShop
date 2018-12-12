package org.lanqiao.dao;

import org.lanqiao.domain.Comment;

import java.sql.SQLException;
import java.util.List;

public interface IjzCommentDao {

    //根据用户查找个人评论
    public List<Comment> selectCommentByCustomerId(int customerId) throws SQLException;
    //根据书籍id查找
    public List<Comment> selectCommentByBookId(int bookId) throws SQLException;
    //按照评价等级查询评论
    public List<Comment> selectByCommentgrade (String Commentgrade ,int CustomerId) throws SQLException;
    //按评价等级查询书籍评论
    public List<Comment> selectBybkCommentgrade(String Commentgrade,int BookId) throws SQLException;
    //用户删除评论
    public void deleteComment(int CommentId) throws SQLException;
    //用户添加评论
    public void insertComment (Comment comment) throws SQLException;
    //修改评论
    public void updateComment(Comment comment) throws SQLException;

}
