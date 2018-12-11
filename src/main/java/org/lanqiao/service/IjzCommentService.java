package org.lanqiao.service;

import org.lanqiao.domain.Comment;

import java.sql.SQLException;
import java.util.List;

public interface IjzCommentService {
    public void addComment (Comment comment);
    public void removeComment(int CommentId) throws SQLException;
    public List<Comment> findCommentByCustomerId(int CustomerId) throws SQLException;
    public List<Comment> findCommentByBookId(int BookId) throws SQLException;
    public List<Comment> findCommentByGrade(String Commentgrade,int CustomerId) throws SQLException;
    public List<Comment> findCommentBybkGrade(String Commentgrade,int BookId) throws SQLException;
    public void modifyComment(Comment comment) throws SQLException;
}
