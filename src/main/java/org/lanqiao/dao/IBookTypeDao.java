package org.lanqiao.dao;

import org.lanqiao.domain.BookType;

import java.sql.SQLException;
import java.util.List;

public interface IBookTypeDao {
    //查
    public List<BookType> findAll() throws SQLException;
    public String selectByTypeId(int bookTypeId) throws SQLException;
    //增
    public void addBookType(BookType type) throws SQLException;
    //删
    public void delType(int bookTypeId) throws SQLException;
}
