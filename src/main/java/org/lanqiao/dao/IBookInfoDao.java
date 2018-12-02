package org.lanqiao.dao;

import org.lanqiao.domain.Book;
import java.sql.SQLException;
import java.util.List;

public interface IBookInfoDao {
    //查
    public List<Book> findAll() throws SQLException;
    public Book selectById(int bookId) throws SQLException;
    public List<Book> selectByTypeId(int bookTypeId) throws SQLException;
    public Book selectByName(String bookName) throws SQLException;
    public List<Book> selectByAuthor(String Author) throws SQLException;
    public List<Book> selectByPrice(int MaxPrice,int minPrice) throws SQLException;

    //增
    public void addBook(Book book) throws SQLException;
    //删
    public void delById(int bookId) throws SQLException;
    //改
    public void changeBook(Book book) throws SQLException;
    public void changeType(int bookId,int typeId) throws SQLException;
    public void changeStore(int bookId,int bookstore) throws SQLException;
}
