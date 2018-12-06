package org.lanqiao.service;

import org.lanqiao.domain.Book;
import org.lanqiao.domain.BookType;
import org.lanqiao.domain.Condition;

import java.util.List;

public interface IBookTypeService {
    public List<BookType> getBookTypeList(Condition condition);
    public int getBookTypeCount(Condition condition);
    public void addBookType(BookType bookType);
    public void updateBookType(BookType bookType);
    public void deleteBookType(int bookTypeId);
    public BookType getBookTypeById(int bookTypeId);

}
