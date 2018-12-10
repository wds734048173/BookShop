package org.lanqiao.service;

import org.lanqiao.domain.Condition;
import org.lanqiao.domain.Order;

import java.util.List;

public interface IOrderService {
    public List<Order> getOrderList(Condition condition);
    public int getOrderCount(Condition condition);
}
