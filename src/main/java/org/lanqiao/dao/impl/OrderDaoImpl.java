package org.lanqiao.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.lanqiao.dao.IOrderDao;
import org.lanqiao.domain.CartItem;
import org.lanqiao.domain.Condition;
import org.lanqiao.domain.Order;
import org.lanqiao.domain.OrderItem;
import org.lanqiao.utils.jdbcUtils;


import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDaoImpl implements IOrderDao {

    private QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
    public List<Order> getOrderList(Condition condition) {
        List<Order> orderList = null;
        StringBuffer sql = new StringBuffer("SELECT * from tb_order where 1 = 1 ");
        List<Object> search = new ArrayList<>();
        if(condition != null){
            if(condition.getName() != null && !"".equals(condition.getName())){
                sql.append(" and no like ? ");
                search.add("%" + condition.getName() + "%");
            }
            if(condition.getState() != null && !"".equals(condition.getState())){
                sql.append(" and state = ? ");
                search.add(condition.getState());
            }
            sql.append(" limit ?,?");
            search.add(condition.getCurrentPage());
            search.add(condition.getPageSize());
        }
        try {
            orderList = qr.query(sql.toString(),new BeanListHandler<>(Order.class),search.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    @Override
    public Long getOrderCount(Condition condition) {
        StringBuffer sql = new StringBuffer("SELECT count(1) from tb_order where 1 = 1 ");
        List<Object> search = new ArrayList<>();
        if(condition.getName() != null && !"".equals(condition.getName())){
            sql.append(" and no like ? ");
            search.add("%" + condition.getName() + "%");
        }
        if(condition.getState() != null && !"".equals(condition.getState())){
            sql.append(" and state = ? ");
            search.add(condition.getState());
        }
        Long count = 0L;
        try {
            count = qr.query(sql.toString(),new ScalarHandler<>(1),search.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public void updateOrderState(int orderId, int state) {
        String sql = "UPDATE tb_order SET rtime = now(),state = ? WHERE id = ?";
        try {
            qr.execute(sql,state,orderId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Order getOrderById(int orderId) {
        String sql = "SELECT * FROM tb_order WHERE id = ?";
        Order order = null;
        try {
            order = qr.query(sql,new BeanHandler<>(Order.class),orderId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public List<OrderItem> getOrderItemList(int orderId) {
        String sql = "SELECT * FROM tb_orderitem WHERE oId = ?";
        List<OrderItem> orderItemList = null;
        try {
            orderItemList = qr.query(sql,new BeanListHandler<>(OrderItem.class),orderId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderItemList;
    }

    @Override
    public List<Order> getOrderByCusId(int CustomerId) {
        String sql = "select * from tb_order where customerId=?";
        List<Order> orderList = null;
        try {
            orderList= qr.query(sql,new BeanListHandler<>(Order.class),CustomerId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    @Override
    public void createOrder(Order order,List<CartItem> cartItemList) {
        Connection conn = null;
        try {
            conn = jdbcUtils.getConnection();
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql1 = "insert into tb_order(no,price,money,state,name,phone,address,ctime,rtime,freight,customerId) values(?,?,?,?,?,?,?,?,?,?,?)";
        String sql2 = "select max(id) from tb_order";
        String sql3 = "insert into tb_orderitem (oId,bookId,mprice,price,num,bookName,bookPic) values (?,?,?,?,?,?,?)";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            qr.execute(sql1,order.getNo(),order.getPrice(),order.getMoney(),order.getState(),order.getName(),order.getPhone(),order.getAddress(),format.format(new Date()),format.format(new Date()),order.getFreight(),order.getCustomerId());
            int oId = qr.query(sql2,new ScalarHandler<>(1));
            for (int i = 0; i < cartItemList.size(); i++) {
                qr.execute(sql3,oId,cartItemList.get(i).getBookId(),cartItemList.get(i).getBookMprice(),cartItemList.get(i).getBookPrice(),cartItemList.get(i).getOrdermount(),cartItemList.get(i).getBookName(),cartItemList.get(i).getBookPic());
            }
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
