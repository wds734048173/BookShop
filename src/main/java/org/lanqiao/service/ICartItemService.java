package org.lanqiao.service;

import org.lanqiao.domain.CartItem;

import java.sql.SQLException;
import java.util.List;

public interface ICartItemService {
    public List<CartItem> findAll();
    public void addCartItem(int BookId);
    public void removeCartItem(int CustomerId,int BookId);
    //添加到购物车
    public void addToCarList(int CustomerId,int BookId,int num);
    public List<CartItem> findByCustomerId(int CustomerId) throws SQLException;
}
