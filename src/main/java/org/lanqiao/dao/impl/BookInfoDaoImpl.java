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
    public List<Book> findAll() throws SQLException {
        QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
        String sql = "select * from tb_bookinfo";
        List<Book> books=qr.query(sql,new BeanListHandler<>(Book.class));
        return books;
    }

    @Override
    public Book selectById(int bookId) throws SQLException {
        QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
        String sql = "select * from tb_bookinfo where bookid=?";
        Book book = qr.query(sql,new BeanHandler<>(Book.class),bookId);
        return book;
    }

    @Override
    public List<Book> selectByTypeId(int bookTypeId) throws SQLException {
        QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
        String sql="select * from tb_bookinfo where booktypeid=?";
        List<Book> books = qr.query(sql,new BeanListHandler<>(Book.class),bookTypeId);
        return books;
    }

    @Override
    public Book selectByName(String bookName) throws SQLException {
        QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
        String sql="select * from tb_bookinfo where bookname=?";
        Book book = qr.query(sql,new BeanHandler<>(Book.class),bookName);
        return book;
    }

    @Override
    public List<Book> selectByAuthor(String Author) throws SQLException {
        QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
        String sql="select * from tb_bookinfo where bookauthor=?";
        List<Book> books = qr.query(sql,new BeanListHandler<>(Book.class),Author);
        return books;
    }

    @Override
    public List<Book> selectByPrice(int MaxPrice, int minPrice) throws SQLException {
        QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
        String sql="select * from tb_bookinfo where price between ? and ?";
        List<Book> books = qr.query(sql,new BeanListHandler<>(Book.class),minPrice,MaxPrice);
        return books;
    }

    @Override
    public void addBook(Book book) throws SQLException {
        QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
        String sql="insert into tb_bookinfo values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
        qr.execute(sql,book.getBookId(),book.getBookTypeld(),book.getBookName(),book.getBookPress(),book.getBookPubDate(),book.getBookSize(),book.getBookVersion(),book.getBookAuthor(),book.getBookTanslor(),book.getBookisbn(),book.getBookPrice(),book.getBookPages(),book.getBookOutline(),book.getBookCatalog(),book.getBookMprice(),book.getBookPic(),book.getBookPicStatus(),book.getBookStoremount(),book.getBookStoretime(),book.getBookPackstyle());
    }

    @Override
    public void delById(int bookId) throws SQLException {
        QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
        String sql = "delete from tb_bookinfo where bookid=? ";
        qr.execute(sql,bookId);
    }

    @Override
    public void changeBook(Book book) throws SQLException {
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
        qr.execute(sql,book.getBookId(),book.getBookTypeld(),book.getBookName(),book.getBookPress(),book.getBookPubDate(),book.getBookSize(),book.getBookVersion(),book.getBookAuthor(),book.getBookTanslor(),book.getBookisbn(),book.getBookPrice(),book.getBookPages(),book.getBookOutline(),book.getBookCatalog(),book.getBookMprice(),book.getBookPic(),book.getBookPicStatus(),book.getBookStoremount(),book.getBookStoretime(),book.getBookPackstyle());

}

    @Override
    public void changeType(int bookId, int typeId) throws SQLException {
        QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
        String sql="update tb_bookinfo set BookTypeId=? where BookId=";
        qr.execute(sql,typeId,bookId);
    }

    @Override
    public void changeStore(int bookId, int bookstore) throws SQLException {
        QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
        String sql="update tb_bookinfo set BookStoremount=? where BookId=";
        qr.execute(sql,bookstore,bookId);
    }
}
