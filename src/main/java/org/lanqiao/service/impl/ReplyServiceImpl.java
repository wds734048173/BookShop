package org.lanqiao.service.impl;

import org.lanqiao.dao.IReplyDao;
import org.lanqiao.dao.impl.ReplyDaoImpl;
import org.lanqiao.domain.Reply;
import org.lanqiao.service.IReplyService;

import java.util.List;

public class ReplyServiceImpl implements IReplyService {
    IReplyDao replyDao = new ReplyDaoImpl();
    @Override
    public List<Reply> getReplyList() {
        return replyDao.getReplyList();
    }
}
