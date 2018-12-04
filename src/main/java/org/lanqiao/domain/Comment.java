package org.lanqiao.domain;

import java.util.Date;

public class Comment {
    private int CommentId;
    private int BookId;
    private int CustomerId;
    private String UserName;
    private Date Commentdate;
    private String Commentcontent;
    private String Commentgrade;

    public Comment() {
    }

    public Comment(int commentId, int bookId, int customerId, String userName, Date commentdate, String commentcontent, String commentgrade) {
        CommentId = commentId;
        BookId = bookId;
        CustomerId = customerId;
        UserName = userName;
        Commentdate = commentdate;
        Commentcontent = commentcontent;
        Commentgrade = commentgrade;
    }

    public int getCommentId() {
        return CommentId;
    }

    public void setCommentId(int commentId) {
        CommentId = commentId;
    }

    public int getBookId() {
        return BookId;
    }

    public void setBookId(int bookId) {
        BookId = bookId;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public Date getCommentdate() {
        return Commentdate;
    }

    public void setCommentdate(Date commentdate) {
        Commentdate = commentdate;
    }

    public String getCommentcontent() {
        return Commentcontent;
    }

    public void setCommentcontent(String commentcontent) {
        Commentcontent = commentcontent;
    }

    public String getCommentgrade() {
        return Commentgrade;
    }

    public void setCommentgrade(String commentgrade) {
        Commentgrade = commentgrade;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "CommentId=" + CommentId +
                ", BookId=" + BookId +
                ", CustomerId=" + CustomerId +
                ", UserName='" + UserName + '\'' +
                ", Commentdate=" + Commentdate +
                ", Commentcontent='" + Commentcontent + '\'' +
                ", Commentgrade='" + Commentgrade + '\'' +
                '}';
    }
}
