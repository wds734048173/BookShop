package org.lanqiao.service.impl;

import org.lanqiao.dao.IBookTypeDao;
import org.lanqiao.dao.impl.BookTypeDaoImpl;
import org.lanqiao.domain.BookType;
import org.lanqiao.domain.Condition;
import org.lanqiao.service.IBookTypeService;

import java.util.List;

public class BookTypeServiceImpl implements IBookTypeService {
    IBookTypeDao bookTypeDao = new BookTypeDaoImpl();

    @Override
    public List<BookType> getBookTypeList(Condition condition) {
        return bookTypeDao.getBookTypeList(condition);
    }

    @Override
    public int getBookTypeCount(Condition condition) {
        return Integer.valueOf(bookTypeDao.getBookTypeCount(condition).toString());
    }

    @Override
    public void addBookType(BookType bookType) {
        bookTypeDao.addBookType(bookType);
    }

    @Override
    public void updateBookType(BookType bookType) {
        bookTypeDao.updateBookType(bookType);
    }

    @Override
    public void deleteBookType(int bookTypeId) {
        bookTypeDao.deleteBookTypeById(bookTypeId);
    }

    @Override
    public BookType getBookTypeById(int bookTypeId) {
        return bookTypeDao.getBookTypeById(bookTypeId);
    }
}
