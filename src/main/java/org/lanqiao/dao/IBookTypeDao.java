package org.lanqiao.dao;

import org.lanqiao.domain.BookType;

import java.util.List;

/*
* 书籍分类接口
* */
public interface IBookTypeDao {
    //获取书籍分类列表
    public List<BookType> getBookTypeList();
    //通过书籍分类id获取详情
    public BookType getBookTypeById(int bookTypeId);
    //新增书籍分类
    public void addBookType(BookType bookType);
    //删除书籍分类
    public void deleteBookTypeById(int bookTypeId);
    //修改书籍分类
    public void updateBookType(BookType bookType);
}
