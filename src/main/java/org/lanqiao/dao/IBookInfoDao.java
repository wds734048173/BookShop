package org.lanqiao.dao;

import org.lanqiao.domain.Book;
import java.sql.SQLException;
import java.util.List;

public interface IBookInfoDao {
    //查
    public List<Book> findAll();
    public Book selectById(int bookId);
    public List<Book> selectByTypeId(int bookTypeId) ;
    public Book selectByName(String bookName) ;
    public List<Book> selectByAuthor(String Author) ;
    public List<Book> selectByPrice(int MaxPrice,int minPrice);

    //增
    public void addBook(Book book);
    //删
    public void delById(int bookId);
    //改
    public void changeBook(Book book);
    public void changeType(int bookId,int typeId) ;
    public void changeStore(int bookId,int bookstore) ;
}
