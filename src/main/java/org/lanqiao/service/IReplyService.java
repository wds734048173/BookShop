package org.lanqiao.service;

import org.lanqiao.domain.Condition;
import org.lanqiao.domain.Reply;

import java.util.List;

public interface IReplyService {
    public List<Reply> getReplyList(Condition condition);
    public List<Reply> getList();
    public int getReplyCount(Condition condition);
    public void addReply(Reply reply);
    public void updateReply(Reply reply);
    public void deleteReply(int ReplyId);
    public Reply getReplyById(int ReplyId);
    public List<Reply> getReplyByCustomerId(int CustomerId);
}
