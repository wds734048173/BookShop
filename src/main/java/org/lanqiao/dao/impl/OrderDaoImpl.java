package org.lanqiao.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.lanqiao.dao.IOrderDao;
import org.lanqiao.domain.BookType;
import org.lanqiao.domain.Condition;
import org.lanqiao.domain.Order;
import org.lanqiao.utils.jdbcUtils;


import java.sql.SQLException;
import java.util.ArrayList;
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
}
