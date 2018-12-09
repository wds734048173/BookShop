package org.lanqiao.dao.impl;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.dao.ICartItemDao;
import org.lanqiao.domain.CartItem;
import org.lanqiao.utils.jdbcUtils;

import java.sql.SQLException;
import java.util.List;

public class CartItemDaoImpl implements ICartItemDao {
    @Override
    public List<CartItem> findByCustomerId(int CustomerId) throws SQLException {
         QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
        String sql = "SELECT b.BookId,b.BookName,b.BookMprice,b.BookPrice,b.BookPic,s.ordermount,CustomerId FROM tb_bookinfo b, tb_shopbook s WHERE b.BookId = s.BookId and CustomerId=?";
        List<CartItem> shopList = qr.query(sql,new BeanListHandler<>(CartItem.class),CustomerId);
        return shopList;
    }

    @Override
    public void delByCustomer(int CustomerId,int BookId) throws SQLException {
        String sql = "delete  from tb_shopbook where CustomerId=? and BookId=?";
        QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
        qr.update(sql,CustomerId,BookId);
    }


//    @Override
//    public List<CartItem> finfByBookId(int BookId) throws SQLException {
//
//        String sql = "select BookName from tb_bookinfo where BookId=?";
//        List<CartItem> bookList = qr.query(sql,new BeanListHandler<>(CartItem.class),BookId);
//        return bookList;
//    }

}
