package org.lanqiao.dao;

import org.lanqiao.domain.Condition;
import org.lanqiao.domain.Order;
import org.lanqiao.domain.OrderItem;

import java.util.List;

public interface IOrderDao {
    public List<Order> getOrderList(Condition condition);
    public  Long getOrderCount(Condition condition);
    public void updateOrderState(int orderId,int state);
    public Order getOrderById(int orderId);
    public List<OrderItem> getOrderItemList(int orderId);
    public List<Order> getOrderByCusId(int CustomerId);
}
