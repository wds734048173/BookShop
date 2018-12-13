package org.lanqiao.domain;

import java.util.Date;

public class Comment {
    private int CommentId;
    private int BookId;
    private String BookName;
    private int CustomerId;
    private String UserName;
    private Date Commentdate;
    private String Commentcontent;
    private String Commentgrade;//0"好评",1"一般",2"差评"
    private String CommentgradeStr;

    public Comment() {
    }

    public Comment(int commentId, int bookId, String bookName, int customerId, String userName, Date commentdate, String commentcontent, String commentgrade, String commentgradeStr) {
        CommentId = commentId;
        BookId = bookId;
        BookName = bookName;
        CustomerId = customerId;
        UserName = userName;
        Commentdate = commentdate;
        Commentcontent = commentcontent;
        Commentgrade = commentgrade;
        CommentgradeStr = commentgradeStr;
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

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
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

    public String getCommentgradeStr() {
        return CommentgradeStr;
    }

    public void setCommentgradeStr(String commentgradeStr) {
        CommentgradeStr = commentgradeStr;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "CommentId=" + CommentId +
                ", BookId=" + BookId +
                ", BookName='" + BookName + '\'' +
                ", CustomerId=" + CustomerId +
                ", UserName='" + UserName + '\'' +
                ", Commentdate=" + Commentdate +
                ", Commentcontent='" + Commentcontent + '\'' +
                ", Commentgrade='" + Commentgrade + '\'' +
                ", CommentgradeStr='" + CommentgradeStr + '\'' +
                '}';
    }
}
