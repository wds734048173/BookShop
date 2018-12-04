package org.lanqiao.service.impl;

import org.lanqiao.dao.IBookDao;
import org.lanqiao.dao.impl.BookDaoImpl;
import org.lanqiao.domain.Book;
import org.lanqiao.service.IBookService;

import java.util.List;

public class BookServiceImpl implements IBookService {
    IBookDao bookDao = new BookDaoImpl();
    @Override
    public List<Book> getBookList() {
        return bookDao.getBookList();
    }
}
