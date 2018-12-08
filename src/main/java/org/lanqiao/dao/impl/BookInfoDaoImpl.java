package org.lanqiao.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.dao.IBookInfoDao;
import org.lanqiao.domain.Book;
import org.lanqiao.utils.jdbcUtils;

import java.sql.SQLException;
import java.util.List;

public class BookInfoDaoImpl implements IBookInfoDao {
    @Override
    public List<Book> findAll() {
        QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
        String sql = "select * from tb_bookinfo";
        List<Book> books= null;
        try {
            books = qr.query(sql,new BeanListHandler<>(Book.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public Book selectById(int bookId){
        QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
        String sql = "select * from tb_bookinfo where bookid=?";
        Book book = null;
        try {
            book = qr.query(sql,new BeanHandler<>(Book.class),bookId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public List<Book> selectByTypeId(int bookTypeId)  {
        QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
        String sql="select * from tb_bookinfo where BookTypeid=?";
        List<Book> books = null;
        try {
            books = qr.query(sql,new BeanListHandler<>(Book.class),bookTypeId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public Book selectByName(String bookName)  {
        QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
        String sql="select * from tb_bookinfo where bookname=?";
        Book book = null;
        try {
            book = qr.query(sql,new BeanHandler<>(Book.class),bookName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public List<Book> selectByAuthor(String Author)  {
        QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
        String sql="select * from tb_bookinfo where bookauthor=?";
        List<Book> books = null;
        try {
            books = qr.query(sql,new BeanListHandler<>(Book.class),Author);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public List<Book> selectByPrice(int MaxPrice, int minPrice)  {
        QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
        String sql="select * from tb_bookinfo where price between ? and ?";
        List<Book> books = null;
        try {
            books = qr.query(sql,new BeanListHandler<>(Book.class),minPrice,MaxPrice);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public void addBook(Book book)  {
        QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
        String sql="insert into tb_bookinfo values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
        try {
            qr.execute(sql,book.getBookId(),book.getBookTypeid(),book.getBookName(),book.getBookPress(),book.getBookPubDate(),book.getBookSize(),book.getBookVersion(),book.getBookAuthor(),book.getBookTanslor(),book.getBookisbn(),book.getBookPrice(),book.getBookPages(),book.getBookOutline(),book.getBookCatalog(),book.getBookMprice(),book.getBookPic(),book.getBookPicStatus(),book.getBookStoremount(),book.getBookStoretime(),book.getBookPackstyle());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delById(int bookId)  {
        QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
        String sql = "delete from tb_bookinfo where bookid=? ";
        try {
            qr.execute(sql,bookId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changeBook(Book book) {
        QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
        String sql ="update tb_bookinfo set BookId = ?," +
                "BookTypeId= ?," +
                "BookName= ?," +
                "BookType= ?," +
                "BookPress= ?," +
                "BookPubDate = ?," +
                "BookSize= ?," +
                "BookVersion= ?," +
                "BookAuthor= ?," +
                "BookTanslor= ?," +
                "Bookisbn= ?," +
                "Price= ?," +
                "BookPages= ?," +
                "BookOutline= ?," +
                "BookCatalog= ?," +
                "Mprice= ?," +
                "BookPic= ?," +
                "BookPicStatus= ?," +
                "BookStoremount= ?," +
                "BookStoretime= ?," +
                "BookPackstyle = ?";
        try {
            qr.execute(sql,book.getBookId(),book.getBookTypeid(),book.getBookName(),book.getBookPress(),book.getBookPubDate(),book.getBookSize(),book.getBookVersion(),book.getBookAuthor(),book.getBookTanslor(),book.getBookisbn(),book.getBookPrice(),book.getBookPages(),book.getBookOutline(),book.getBookCatalog(),book.getBookMprice(),book.getBookPic(),book.getBookPicStatus(),book.getBookStoremount(),book.getBookStoretime(),book.getBookPackstyle());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void changeType(int bookId, int typeId)  {
        QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
        String sql="update tb_bookinfo set BookTypeId=? where BookId=";
        try {
            qr.execute(sql,typeId,bookId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changeStore(int bookId, int bookstore)  {
        QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
        String sql="update tb_bookinfo set BookStoremount=? where BookId=";
        try {
            qr.execute(sql,bookstore,bookId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
