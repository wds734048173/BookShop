package org.lanqiao.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.lanqiao.dao.IBookTypeDao;
import org.lanqiao.domain.BookType;
import org.lanqiao.domain.Condition;
import org.lanqiao.utils.jdbcUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookTypeDaoImpl implements IBookTypeDao {
    private QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
    @Override
    public List<BookType> getBookTypeList(Condition condition) {
        List<BookType> bookTypeList = null;
        StringBuffer sql = new StringBuffer("SELECT * from tb_booktypeinfo where 1 = 1 ");
        List<Object> search = new ArrayList<>();
        if(condition.getName() != null && !"".equals(condition.getName())){
            sql.append(" and bookTypeName like ? ");
            search.add("%" + condition.getName() + "%");
        }
        sql.append(" limit ?,?");
        search.add(condition.getCurrentPage());
        search.add(condition.getPageSize());
        try {
            bookTypeList = qr.query(sql.toString(),new BeanListHandler<>(BookType.class),search.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookTypeList;
    }

    @Override
    public BookType getBookTypeById(int bookTypeId) {
        BookType bookType = null;
        String sql = "SELECT * from tb_booktypeinfo where bookTypeId = ?";
        try {
            bookType = qr.query(sql,new BeanHandler<>(BookType.class),bookTypeId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookType;
    }

    @Override
    public void addBookType(BookType bookType) {
        String sql = "INSERT INTO tb_booktypeinfo (bookTypeName) VALUES (?)";
        try {
            qr.execute(sql,bookType.getBookTypeName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBookTypeById(int bookTypeId) {
        String sql = "DELETE FROM tb_booktypeinfo WHERE bookTypeId = ?";
        try {
            qr.execute(sql,bookTypeId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateBookType(BookType bookType) {
        String sql = "UPDATE tb_booktypeinfo SET bookTypeName = ? WHERE bookTypeId = ?";
        try {
            qr.execute(sql,bookType.getBookTypeName(),bookType.getBookTypeId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Long getBookTypeCount(Condition condition) {
        StringBuffer sql = new StringBuffer("SELECT count(1) from tb_booktypeinfo where 1 = 1 ");
        List<Object> search = new ArrayList<>();
        if(condition.getName() != null && !"".equals(condition.getName())){
            sql.append(" and bookTypeName like ? ");
            search.add("%" + condition.getName() + "%");
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
