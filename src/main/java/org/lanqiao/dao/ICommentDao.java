package org.lanqiao.dao;

import org.lanqiao.domain.Comment;

import java.util.List;

public interface ICommentDao {
    //获取信息反馈列表
    public List<Comment> getCommentList();
}
