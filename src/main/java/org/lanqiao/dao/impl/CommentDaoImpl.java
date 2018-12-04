package org.lanqiao.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.dao.ICommentDao;
import org.lanqiao.domain.Comment;
import org.lanqiao.utils.jdbcUtils;

import java.sql.SQLException;
import java.util.List;

public class CommentDaoImpl implements ICommentDao {
    private QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
    @Override
    public List<Comment> getCommentList() {
        List<Comment> commentList = null;
        String sql = "SELECT * from tb_comment";
        try {
            commentList = qr.query(sql,new BeanListHandler<>(Comment.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commentList;
    }
}
