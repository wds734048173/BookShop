package org.lanqiao.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.lanqiao.dao.IReplyDao;
import org.lanqiao.domain.Condition;
import org.lanqiao.domain.Reply;
import org.lanqiao.utils.jdbcUtils;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReplyDaoImpl implements IReplyDao {
    private QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
    @Override
    public List<Reply> getReplyList(Condition condition) {
        List<Reply> replyList = null;
        StringBuffer sql = new StringBuffer("SELECT * from tb_reply where 1 = 1 ");
        List<Object> search = new ArrayList<>();
        if(condition.getName() != null && !"".equals(condition.getName())){
            sql.append(" and Replycontent like ? ");
            search.add("%" + condition.getName() + "%");
        }
        if(condition.getState() != null && !"".equals(condition.getState()) && !"全部".equals(condition.getState())){
            sql.append(" and ReplyType = ? ");
            search.add( condition.getState() );
        }
        if(condition.getBookTypeId() != null && !"".equals(condition.getBookTypeId())){
            sql.append(" and Customername like ? ");
            search.add("%" + condition.getBookTypeId() + "%");
        }
        sql.append(" limit ?,?");
        search.add(condition.getCurrentPage());
        search.add(condition.getPageSize());
        try {
            replyList = qr.query(sql.toString(),new BeanListHandler<>(Reply.class),search.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return replyList;
    }

    @Override
    public List<Reply> getList()  {
        String sql= "SELECT * from tb_reply";
        List<Reply> replies =null;
        try {
            replies=qr.query(sql,new BeanListHandler<>(Reply.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return replies;
    }


    @Override
    public Reply getReplyById(int ReplyId) {
        Reply reply = null;
        String sql = "SELECT * from tb_reply where ReplyId = ?";
        try {
            reply = qr.query(sql,new BeanHandler<>(Reply.class),ReplyId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reply;
    }

    @Override
    public List<Reply> getReplyByCustomerId(int CustomerId) {
        String sql = "select * from tb_reply where CustomerId=?";
        List<Reply> replyList = null;
        try {
            replyList=qr.query(sql,new BeanListHandler<>(Reply.class),CustomerId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return replyList;
    }

    @Override
    public void addReply(Reply reply) {
        String sql = "INSERT INTO tb_reply (Ctime,Rtime,CustomerId,ReplyType,Replytitle,Replycontent,Customername) VALUES (?,?,?,?,?,?,?)";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            qr.execute(sql,format.format(new Date()),format.format(new Date()),reply.getCustomerId(),reply.getReplyType(),reply.getReplytitle(),reply.getReplycontent(),reply.getCustomername());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteReplyById(int ReplyId) {
        String sql = "DELETE FROM tb_reply WHERE ReplyId = ?";
        try {
            qr.execute(sql,ReplyId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateReply(Reply reply) {
        String sql = "UPDATE tb_reply SET CustomerId = ?,ReplyType = ?,Replytitle = ?,Replycontent = ?,Customername = ?,Ctime = ?,Rtime = ? WHERE ReplyId = ?";
        try {
            qr.execute(sql,reply.getCustomerId(),reply.getReplyType(),reply.getReplytitle(),reply.getReplycontent(),reply.getCustomername(),reply.getRtime(),reply.getCtime());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Long getReplyCount(Condition condition) {
        StringBuffer sql = new StringBuffer("SELECT count(1) from tb_reply where 1 = 1 ");
        List<Object> search = new ArrayList<>();
        if(condition.getName() != null && !"".equals(condition.getName())){
            sql.append(" and Replycontent like ? ");
            search.add("%" + condition.getName() + "%");
        }
        if(condition.getState() != null && !"".equals(condition.getState()) && !"全部".equals(condition.getState())){
            sql.append(" and ReplyType = ? ");
            search.add( condition.getState() );
        }
        if(condition.getBookTypeId() != null && !"".equals(condition.getBookTypeId())){
            sql.append(" and Customername like ? ");
            search.add("%" + condition.getBookTypeId() + "%");
        }
        Long count = 0L;
        try {
            count = qr.query(sql.toString(),new ScalarHandler<>(1),search.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }


}
