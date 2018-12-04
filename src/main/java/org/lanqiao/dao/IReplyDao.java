package org.lanqiao.dao;

import org.lanqiao.domain.Reply;

import java.util.List;

public interface IReplyDao {
    //获取信息反馈列表
    public List<Reply> getReplyList();
    //通过信息反馈编号id获取详情
    public Reply getReplyById(int ReplyId);
    //新增信息反馈信息
    public void addReply(Reply reply);
    //删除信息反馈信息
    public void deleteReplyById(int ReplyId);
    //修改信息反馈信息
    public void updateReply(Reply reply);
}
