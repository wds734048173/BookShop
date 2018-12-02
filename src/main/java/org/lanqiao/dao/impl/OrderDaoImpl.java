package org.lanqiao.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.dao.IOrderDao;
import org.lanqiao.domain.Order;
import org.lanqiao.utils.jdbcUtils;


import java.sql.SQLException;
import java.util.List;

public class OrderDaoImpl implements IOrderDao {

    private QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
    public List<Order> getOrderList() {
        String sql = "select * from tb_order";
        List<Order> orderList = null;
        try {
            orderList = qr.query(sql, new BeanListHandler<Order>(Order.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }
}
