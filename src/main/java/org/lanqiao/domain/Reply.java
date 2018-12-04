package org.lanqiao.domain;

import java.util.Date;

public class Reply {
    private int ReplyId;
    private int CustomerId;
    private String ReplyType;
    private String Replytitle;
    private String Replycontent;
    private String Customername;
    private Date Ctime;
    private Date Rtime;

    public Reply() {
    }

    public Reply(int replyId, int customerId, String replyType, String replytitle, String replycontent, String customername, Date ctime, Date rtime) {
        ReplyId = replyId;
        CustomerId = customerId;
        ReplyType = replyType;
        Replytitle = replytitle;
        Replycontent = replycontent;
        Customername = customername;
        Ctime = ctime;
        Rtime = rtime;
    }

    public int getReplyId() {
        return ReplyId;
    }

    public void setReplyId(int replyId) {
        ReplyId = replyId;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public String getReplyType() {
        return ReplyType;
    }

    public void setReplyType(String replyType) {
        ReplyType = replyType;
    }

    public String getReplytitle() {
        return Replytitle;
    }

    public void setReplytitle(String replytitle) {
        Replytitle = replytitle;
    }

    public String getReplycontent() {
        return Replycontent;
    }

    public void setReplycontent(String replycontent) {
        Replycontent = replycontent;
    }

    public String getCustomername() {
        return Customername;
    }

    public void setCustomername(String customername) {
        Customername = customername;
    }

    public Date getCtime() {
        return Ctime;
    }

    public void setCtime(Date ctime) {
        Ctime = ctime;
    }

    public Date getRtime() {
        return Rtime;
    }

    public void setRtime(Date rtime) {
        Rtime = rtime;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "ReplyId=" + ReplyId +
                ", CustomerId=" + CustomerId +
                ", ReplyType='" + ReplyType + '\'' +
                ", Replytitle='" + Replytitle + '\'' +
                ", Replycontent='" + Replycontent + '\'' +
                ", Customername='" + Customername + '\'' +
                ", Ctime=" + Ctime +
                ", Rtime=" + Rtime +
                '}';
    }
}
