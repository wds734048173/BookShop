package org.lanqiao.service.impl;

import org.lanqiao.dao.ICartItemDao;
import org.lanqiao.dao.impl.CartItemDaoImpl;
import org.lanqiao.domain.CartItem;
import org.lanqiao.service.ICartItemService;

import java.sql.SQLException;
import java.util.List;

public class CartItemServiceImpl implements ICartItemService {
    private ICartItemDao dao;
    public CartItemServiceImpl(){
            dao = new CartItemDaoImpl();
    }

    @Override
    public List<CartItem> findAll() {
        return null;
    }

    @Override
    public void addCartItem(int BookId) {
        String sql ="";
    }

    //移除购物车中的某项商品
    @Override
    public void removeCartItem(int CustomerId,int BookId) {
        try {
            dao.delByCustomer(CustomerId,BookId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addToCarList(int CustomerId, int BookId, int num) {
        /*
        * 通过用户id和书籍id查看是否添加过购物车
        * 1、如果没有数据，证明是新数据，直接新增
        * 2、如果有数据，就说明购物车有该商品，修改数量即可
        * */
        CartItem cartItem = dao.getCarList(CustomerId,BookId);
        if(cartItem == null){
            dao.addToCarList(CustomerId,BookId,num);
        }else{
            int oldNum = cartItem.getOrdermount();
            dao.updateCarList(CustomerId,BookId,num+oldNum);
        }

    }

    //通过用户名查找购物车
    @Override
    public List<CartItem> findByCustomerId(int CustomerId) throws SQLException {
        ICartItemDao iCartItem = new CartItemDaoImpl();
        List<CartItem> cartItemList=iCartItem.findByCustomerId(CustomerId);
        return cartItemList;
    }

    @Override
    public void delBookShop(int CustomerId) {
        dao.delBookShop(CustomerId);
    }

}
