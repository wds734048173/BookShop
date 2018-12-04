package org.lanqiao.service.impl;

import org.lanqiao.dao.IBookTypeDao;
import org.lanqiao.dao.impl.BookTypeDaoImpl;
import org.lanqiao.domain.BookType;
import org.lanqiao.service.IBookTypeService;

import java.util.List;

public class BookTypeServiceImpl implements IBookTypeService {
    IBookTypeDao bookTypeDao = new BookTypeDaoImpl();

    @Override
    public List<BookType> getBookTypeList() {
        return bookTypeDao.getBookTypeList();
    }
}
