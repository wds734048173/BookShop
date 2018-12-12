package org.lanqiao.service.impl;

import org.lanqiao.dao.IReplyDao;
import org.lanqiao.dao.impl.ReplyDaoImpl;
import org.lanqiao.domain.Condition;
import org.lanqiao.domain.Reply;
import org.lanqiao.service.IReplyService;

import java.util.List;

public class ReplyServiceImpl implements IReplyService {
    IReplyDao replyDao = new ReplyDaoImpl();

    @Override
    public List<Reply> getReplyList(Condition condition) {
        return replyDao.getReplyList(condition);
    }

    @Override
    public List<Reply> getList() {
        return replyDao.getList();
    }

    @Override
    public int getReplyCount(Condition condition) {
        return Integer.valueOf(replyDao.getReplyCount(condition).toString());
    }

    @Override
    public void addReply(Reply reply) {
        replyDao.addReply(reply);
    }

    @Override
    public void updateReply(Reply reply) {
        replyDao.updateReply(reply);
    }

    @Override
    public void deleteReply(int ReplyId) {
        replyDao.deleteReplyById(ReplyId);
    }

    @Override
    public Reply getReplyById(int ReplyId) {
        return replyDao.getReplyById(ReplyId);

    }

    @Override
    public List<Reply> getReplyByCustomerId(int CustomerId) {
        return replyDao.getReplyByCustomerId(CustomerId);
    }
}
