package org.lanqiao.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.lanqiao.dao.IBookDao;
import org.lanqiao.domain.Book;
import org.lanqiao.domain.Condition;
import org.lanqiao.utils.jdbcUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements IBookDao {
    private QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
    @Override
    public List<Book> getBookList(Condition condition) {
        StringBuffer sql = new StringBuffer("select BookId,BookTypeid,BookName,BookAuthor,BookPrice,BookMprice,BookPic from tb_bookinfo where 1 = 1 ");
        List<Book> bookList = null;
        List<Object> search = new ArrayList<>();
        if(condition.getName() != null && !"".equals(condition.getName())){
            sql.append(" and BookName like ? ");
            search.add("%" + condition.getName() + "%");
        }
        if(condition.getState() != null && !"".equals(condition.getState())){
            sql.append(" and BookAuthor like ? ");
            search.add("%" + condition.getState() + "%");
        }
        if(condition.getBookTypeId() != null && !"".equals(condition.getBookTypeId())){
            sql.append(" and BookTypeid = ? ");
            search.add(condition.getBookTypeId());
        }
        sql.append(" limit ?,?");
        search.add(condition.getCurrentPage());
        search.add(condition.getPageSize());
        try {
            bookList = qr.query(sql.toString(), new BeanListHandler<Book>(Book.class),search.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    @Override
    public Long getBookCount(Condition condition) {
        StringBuffer sql = new StringBuffer("SELECT count(1) from tb_bookinfo where 1 = 1 ");
        List<Object> search = new ArrayList<>();
        if(condition.getName() != null && !"".equals(condition.getName())){
            sql.append(" and BookName like ? ");
            search.add("%" + condition.getName() + "%");
        }
        if(condition.getState() != null && !"".equals(condition.getState())){
            sql.append(" and BookAuthor like ? ");
            search.add("%" + condition.getState() + "%");
        }
        if(condition.getBookTypeId() != null && !"".equals(condition.getBookTypeId())){
            sql.append(" and BookTypeid = ? ");
            search.add(condition.getBookTypeId());
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

