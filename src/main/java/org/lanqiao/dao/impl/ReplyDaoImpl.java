package org.lanqiao.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.dao.IReplyDao;
import org.lanqiao.domain.Reply;
import org.lanqiao.utils.jdbcUtils;

import java.sql.SQLException;
import java.util.List;

public class ReplyDaoImpl implements IReplyDao {
    private QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
    @Override
    public List<Reply> getReplyList() {
        List<Reply> replyList = null;
        String sql = "SELECT * from tb_reply";
        try {
            replyList = qr.query(sql,new BeanListHandler<>(Reply.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return replyList;
    }

    @Override
    public Reply getReplyById(int ReplyId) {
        return null;
    }

    @Override
    public void addReply(Reply reply) {

    }

    @Override
    public void deleteReplyById(int ReplyId) {

    }

    @Override
    public void updateReply(Reply reply) {

    }
}
