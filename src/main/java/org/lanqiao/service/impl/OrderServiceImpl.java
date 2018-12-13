package org.lanqiao.service.impl;


import org.lanqiao.dao.IOrderDao;
import org.lanqiao.dao.impl.OrderDaoImpl;
import org.lanqiao.domain.CartItem;
import org.lanqiao.domain.Condition;
import org.lanqiao.domain.Order;
import org.lanqiao.domain.OrderItem;
import org.lanqiao.service.IOrderService;
import org.lanqiao.utils.DataMap;

import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements IOrderService {
    IOrderDao orderDao = new OrderDaoImpl();
    @Override
    public List<Order> getOrderList(Condition condition) {
        List<Order> orderList = orderDao.getOrderList(condition);
        Map<Integer,String> stateMap = DataMap.getOrderStateIdName();
        Map<Integer,String> customerMap = DataMap.getCustomerIdNameMap();
        for (int i = 0; i < orderList.size(); i++) {
            //对订单状态进行转换
            int state = orderList.get(i).getState();
            if(stateMap.containsKey(state)){
                orderList.get(i).setStateStr(stateMap.get(state));
            }
            //对订单的客户进行转换
            int customerId = orderList.get(i).getCustomerId();
            if(customerMap.containsKey(customerId)){
                orderList.get(i).setCustomerName(customerMap.get(customerId));
            }
        }
        return orderList;
    }

    @Override
    public int getOrderCount(Condition condition) {
        return Integer.valueOf(orderDao.getOrderCount(condition).toString());
    }

    @Override
    public void updateOrderState(int orderId, int state) {
        orderDao.updateOrderState(orderId,state);
    }

    @Override
    public Order getOrderById(int orderId) {
        Order order = orderDao.getOrderById(orderId);
        Map<Integer,String> stateMap = DataMap.getOrderStateIdName();
        Map<Integer,String> customerMap = DataMap.getCustomerIdNameMap();
        //对订单状态进行转换
        if(stateMap.containsKey(order.getState())){
            order.setStateStr(stateMap.get(order.getState()));
        }
        //对订单的客户进行转换
        if(customerMap.containsKey(order.getCustomerId())){
            order.setCustomerName(customerMap.get(order.getCustomerId()));
        }
        return order;
    }

    @Override
    public List<OrderItem> getOrderItemList(int orderId) {
        return orderDao.getOrderItemList(orderId);
    }

    @Override
    public List<Order> getOrderByCusId(int CustomerId) {
        return orderDao.getOrderByCusId(CustomerId);
    }

    @Override
    public void createOrder(Order order,List<CartItem> cartItemList) {
        orderDao.createOrder(order,cartItemList);
    }
}
