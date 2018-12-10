package org.lanqiao.service;

import org.lanqiao.domain.Book;
import org.lanqiao.domain.Condition;

import java.util.List;

public interface IBookService {
    public List<Book> getBookList(Condition condition);
    public int getBookCount(Condition condition);
}
