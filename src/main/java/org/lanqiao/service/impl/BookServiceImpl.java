package org.lanqiao.service.impl;

import org.lanqiao.dao.IBookDao;
import org.lanqiao.dao.impl.BookDaoImpl;
import org.lanqiao.domain.Book;
import org.lanqiao.domain.Condition;
import org.lanqiao.service.IBookService;

import java.util.List;

public class BookServiceImpl implements IBookService {
    IBookDao bookDao = new BookDaoImpl();
    @Override
    public List<Book> getBookList(Condition condition) {
        return bookDao.getBookList(condition);
    }

    @Override
    public int getBookCount(Condition condition) {
        return Integer.valueOf(bookDao.getBookCount(condition).toString());
    }

    @Override
    public void deleteBookById(int bookId) {
        bookDao.deleteBookById(bookId);
    }

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public Book getBookById(int bookId) {
        return bookDao.getBookById(bookId);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }
}
