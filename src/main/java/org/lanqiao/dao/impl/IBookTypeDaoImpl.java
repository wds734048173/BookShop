package org.lanqiao.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.dao.IBookTypeDao;
import org.lanqiao.domain.BookType;
import org.lanqiao.utils.jdbcUtils;

import java.sql.SQLException;
import java.util.List;

public class IBookTypeDaoImpl implements IBookTypeDao {
    QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());

    @Override
    public List<BookType> getBookTypeList() {
        String sql ="select * from tb_booktypeinfo ";
        List<BookType> typeList = null;
        try {
            typeList = qr.query(sql,new BeanListHandler<>(BookType.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeList;
    }

    @Override
    public BookType getBookTypeById(int bookTypeId) {
        String sql ="select BookTypeName from tb_booktypeinfo where BookTypeId=?";
        BookType bookType= null;
        try {
            bookType = qr.query(sql,new BeanHandler<>(BookType.class),bookTypeId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookType;
    }

    @Override
    public void addBookType(BookType bookType) {
        String sql="insert into tb_booktypeinfo values(?,?)";
        try {
            qr.execute(sql,bookType.getBookTypeId(),bookType.getBookTypeName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBookTypeById(int bookTypeId) {
        String sql="delete from tb_booktypeinfo where BookTypeId=?";
        try {
            qr.execute(sql,bookTypeId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateBookType(BookType bookType) {

    }
}
