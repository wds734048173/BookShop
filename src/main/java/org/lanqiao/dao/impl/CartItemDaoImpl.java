package org.lanqiao.dao.impl;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
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

    @Override
    public void addToCarList(int CustomerId, int BookId,int num) {
        String sql="insert into tb_shopbook values(?,?,?)";
        QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
        try {
            qr.execute(sql,CustomerId,BookId,num);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delBookShop(int CustomerId) {
        String sql = "delete  from tb_shopbook where CustomerId=?";
        QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
        try {
            qr.update(sql,CustomerId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public CartItem getCarList(int CustomerId, int BookId) {
        String sql = "select *  from tb_shopbook where CustomerId=? and BookId=?";
        QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
        CartItem cartItem = null;
        try {
            cartItem = qr.query(sql,new BeanHandler<>(CartItem.class),CustomerId,BookId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartItem;
    }

    @Override
    public void updateCarList(int CustomerId, int BookId, int num) {
        String sql = "update tb_shopbook set ordermount = ? where CustomerId=? and BookId=?";
        QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
        try {
            qr.update(sql,num,CustomerId,BookId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
