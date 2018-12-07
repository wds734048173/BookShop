package org.lanqiao.service.impl;

import org.lanqiao.dao.IBookInfoDao;
import org.lanqiao.dao.impl.BookInfoDaoImpl;
import org.lanqiao.domain.Book;
import org.lanqiao.service.IBookInfoService;

import java.util.List;

public class BookInfoServiceImpl implements IBookInfoService {
    IBookInfoDao dao = new BookInfoDaoImpl();
    @Override
    public List<Book> findAll() {
        return dao.findAll();
    }

    @Override
    public Book selectById(int bookId) {
        return dao.selectById(bookId);
    }

    @Override
    public List<Book> selectByTypeId(int bookTypeId) {
        return dao.selectByTypeId(bookTypeId);
    }

    @Override
    public Book selectByName(String bookName) {
        return dao.selectByName(bookName);
    }

    @Override
    public List<Book> selectByAuthor(String Author) {
        return dao.selectByAuthor(Author);
    }

    @Override
    public List<Book> selectByPrice(int MaxPrice, int minPrice) {
        return selectByPrice(MaxPrice,minPrice);
    }

    @Override
    public void addBook(Book book) {
        dao.addBook(book);
    }

    @Override
    public void delById(int bookId) {
        dao.delById(bookId);
    }

    @Override
    public void changeBook(Book book) {
        dao.changeBook(book);
    }

    @Override
    public void changeType(int bookId, int typeId) {
        dao.changeType(bookId,typeId);
    }

    @Override
    public void changeStore(int bookId, int bookstore) {
        dao.changeStore(bookId,bookstore);
    }
}
