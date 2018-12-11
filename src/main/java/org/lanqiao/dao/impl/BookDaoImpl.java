package org.lanqiao.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.lanqiao.dao.IBookDao;
import org.lanqiao.domain.Book;
import org.lanqiao.domain.Condition;
import org.lanqiao.utils.jdbcUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements IBookDao {
    private QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
    @Override
    public List<Book> getBookList(Condition condition) {
        StringBuffer sql = new StringBuffer("select BookId,BookTypeid,BookName,BookAuthor,BookPrice,BookMprice,BookPic from tb_bookinfo where 1 = 1 ");
        List<Book> bookList = null;
        List<Object> search = new ArrayList<>();
        if(condition.getName() != null && !"".equals(condition.getName())){
            sql.append(" and BookName like ? ");
            search.add("%" + condition.getName() + "%");
        }
        if(condition.getState() != null && !"".equals(condition.getState())){
            sql.append(" and BookAuthor like ? ");
            search.add("%" + condition.getState() + "%");
        }
        if(condition.getBookTypeId() != null && !"".equals(condition.getBookTypeId())){
            sql.append(" and BookTypeid = ? ");
            search.add(condition.getBookTypeId());
        }
        sql.append(" limit ?,?");
        search.add(condition.getCurrentPage());
        search.add(condition.getPageSize());
        try {
            bookList = qr.query(sql.toString(), new BeanListHandler<Book>(Book.class),search.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    @Override
    public Long getBookCount(Condition condition) {
        StringBuffer sql = new StringBuffer("SELECT count(1) from tb_bookinfo where 1 = 1 ");
        List<Object> search = new ArrayList<>();
        if(condition.getName() != null && !"".equals(condition.getName())){
            sql.append(" and BookName like ? ");
            search.add("%" + condition.getName() + "%");
        }
        if(condition.getState() != null && !"".equals(condition.getState())){
            sql.append(" and BookAuthor like ? ");
            search.add("%" + condition.getState() + "%");
        }
        if(condition.getBookTypeId() != null && !"".equals(condition.getBookTypeId())){
            sql.append(" and BookTypeid = ? ");
            search.add(condition.getBookTypeId());
        }
        Long count = 0L;
        try {
            count = qr.query(sql.toString(),new ScalarHandler<>(1),search.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public void deleteBookById(int bookId) {
        String sql = "DELETE FROM tb_bookinfo WHERE BookId = ?";
        try {
            qr.execute(sql,bookId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addBook(Book book) {
        String sql = "INSERT INTO tb_bookinfo (BookTypeid,BookName,BookPress,BookPubDate,BookSize,BookVersion,BookAuthor,BookTanslor,Bookisbn,BookPrice," +
                "BookPages,BookOutline,BookCatalog,BookMprice,BookPic,BookPicStatus,BookStoremount,BookStoretime,BookPackstyle) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,now(),?)";
        try {
            qr.execute(sql,book.getBookTypeid(),book.getBookName(),book.getBookPress(),book.getBookPubDate(),book.getBookSize(),book.getBookVersion(),book.getBookAuthor(),book.getBookTanslor(),book.getBookisbn(),book.getBookPrice(),
            book.getBookPages(),book.getBookOutline(),book.getBookCatalog(),book.getBookMprice(),book.getBookPic(),book.getBookPicStatus(),book.getBookStoremount(),book.getBookPackstyle());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Book getBookById(int bookId) {
        String sql = "select * from tb_bookinfo where BookId = ?";
        Book book = null;
        try {
            book = qr.query(sql,new BeanHandler<>(Book.class),bookId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public void updateBook(Book book) {
        String sql = "update tb_bookinfo set BookTypeid = ?,BookName = ?,BookPress = ?,BookPubDate = ?,BookSize = ?,BookVersion = ?,BookAuthor = ?,BookTanslor = ?,Bookisbn = ?,BookPrice = ?," +
                "BookPages = ?,BookOutline = ?,BookCatalog = ?,BookMprice = ?,BookPic = ?,BookPicStatus = ?,BookStoremount = ?,BookPackstyle = ? where BookId = ?";
        try {
            qr.execute(sql,book.getBookTypeid(),book.getBookName(),book.getBookPress(),book.getBookPubDate(),book.getBookSize(),book.getBookVersion(),book.getBookAuthor(),book.getBookTanslor(),book.getBookisbn(),book.getBookPrice(),
                    book.getBookPages(),book.getBookOutline(),book.getBookCatalog(),book.getBookMprice(),book.getBookPic(),book.getBookPicStatus(),book.getBookStoremount(),book.getBookPackstyle(),book.getBookId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

