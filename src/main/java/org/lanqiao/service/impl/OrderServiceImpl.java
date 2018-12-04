package org.lanqiao.service.impl;

import org.lanqiao.dao.IOrderDao;
import org.lanqiao.dao.impl.OrderDaoImpl;
import org.lanqiao.domain.Order;
import org.lanqiao.service.IOrderService;

import java.util.List;

public class OrderServiceImpl implements IOrderService {
    IOrderDao orderDao = new OrderDaoImpl();
    @Override
    public List<Order> getOrderList() {
        return orderDao.getOrderList();
    }
}
