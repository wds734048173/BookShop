package org.lanqiao.dao;

import org.lanqiao.domain.CartItem;

import java.sql.SQLException;
import java.util.List;

public interface ICartItemDao {
    //通过用户查询购物车条目
    public List<CartItem> findByCustomerId(int CustomerId) throws SQLException;
    //删除商品
    public void delByCustomer(int CustomerId,int BookId) throws SQLException;
    //添加到购物车
    public void addToCarList(int CustomerId,int BookId,int num);
    //删除用户的购物车
    public void delBookShop(int CustomerId);
    //通过客户id和商品id查询购物车信息
    public CartItem getCarList(int CustomerId, int BookId);
    //修改购物车数量
    public void updateCarList(int CustomerId, int BookId, int num);
}
