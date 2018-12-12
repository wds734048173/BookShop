package org.lanqiao.dao;

import org.lanqiao.domain.Book;
import org.lanqiao.domain.Condition;

import java.util.List;

public interface IBookDao {
    public List<Book> getBookList(Condition condition);
    public Long getBookCount(Condition condition);
    public void deleteBookById(int bookId);
    public void addBook(Book book);
    public Book getBookById(int bookId);
    public void updateBook(Book book);
}
