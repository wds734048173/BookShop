package org.lanqiao.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.dao.IBookTypeDao;
import org.lanqiao.domain.BookType;
import org.lanqiao.utils.jdbcUtils;

import java.sql.SQLException;
import java.util.List;

public class BookTypeDaoImpl implements IBookTypeDao {
    private QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
    @Override
    public List<BookType> getBookTypeList() {
        List<BookType> bookTypeList = null;
        String sql = "SELECT * from tb_booktypeinfo";
        try {
            bookTypeList = qr.query(sql,new BeanListHandler<>(BookType.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookTypeList;
    }

    @Override
    public BookType getBookTypeById(int bookTypeId) {
        return null;
    }

    @Override
    public void addBookType(BookType bookType) {

    }

    @Override
    public void deleteBookTypeById(int bookTypeId) {

    }

    @Override
    public void updateBookType(BookType bookType) {

    }
}
