package org.lanqiao.dao;

import org.lanqiao.domain.Order;

import java.util.List;

public interface IOrderDao {
    public List<Order> getOrderList();
}
