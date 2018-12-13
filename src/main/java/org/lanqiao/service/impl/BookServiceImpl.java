package org.lanqiao.service.impl;

import org.lanqiao.dao.IBookDao;
import org.lanqiao.dao.impl.BookDaoImpl;
import org.lanqiao.domain.Book;
import org.lanqiao.domain.Condition;
import org.lanqiao.service.IBookService;
import org.lanqiao.utils.DataMap;

import java.util.List;
import java.util.Map;

public class BookServiceImpl implements IBookService {
    IBookDao bookDao = new BookDaoImpl();
    @Override
    public List<Book> getBookList(Condition condition) {
        List<Book> bookList = bookDao.getBookList(condition);
        Map<Integer,String> map = DataMap.getBookTypeIdNameMap();
        for (int i = 0; i < bookList.size(); i++) {
            int bookTypeId = bookList.get(i).getBookTypeid();
            if(map.containsKey(bookTypeId)){
                bookList.get(i).setBookTypeName(map.get(bookTypeId));
            }
        }
        return bookList;
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
