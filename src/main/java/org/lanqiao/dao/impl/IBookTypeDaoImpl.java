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
    @Override
    public List<BookType> findAll() throws SQLException {
        QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
        String sql ="select * from tb_booktypeinfo ";
        List<BookType> typeList = qr.query(sql,new BeanListHandler<>(BookType.class));
        return typeList;
    }

    @Override
    public String selectByTypeId(int bookTypeId) throws SQLException {
        QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
        String sql ="select BookTypeName from tb_booktypeinfo where BookTypeId=?";
        BookType typeName= qr.query(sql,new BeanHandler<>(BookType.class),bookTypeId);
        return typeName.getBookTypeName();
    }

    @Override
    public void addBookType(BookType type) throws SQLException {
        QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
        String sql="insert into tb_booktypeinfo values(?,?)";
        qr.execute(sql,type.getBookTypeId(),type.getBookTypeName());
    }

    @Override
    public void delType(int bookTypeId) throws SQLException {
        QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
        String sql="delete from tb_booktypeinfo where BookTypeId=?";
        qr.execute(sql,bookTypeId);
    }
}
