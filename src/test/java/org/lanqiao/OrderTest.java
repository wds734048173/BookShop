package org.lanqiao;

import org.junit.Test;
import org.lanqiao.dao.IOrderDao;
import org.lanqiao.dao.impl.OrderDaoImpl;
import org.lanqiao.domain.Order;

import java.util.List;


public class OrderTest {
    @Test
    public void getOrderListTest(){
        IOrderDao orderDao = new OrderDaoImpl();
        List<Order> orderList = orderDao.getOrderList();
        for (int i = 0; i < orderList.size(); i++) {
            System.out.println(orderList.get(i).toString());
        }
    }
}
