package org.lanqiao.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.dao.ICommentDao;
import org.lanqiao.dao.ICustomerDao;
import org.lanqiao.domain.Customer;
import org.lanqiao.utils.jdbcUtils;

import java.sql.SQLException;
import java.util.List;

public class CustomerDaoImpl implements ICustomerDao {
    private QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
    @Override
    public List<Customer> getCustomerList() {
        String sql = "select * from tb_customerinfo";
        List<Customer> customerList = null;
        try {
            customerList = qr.query(sql, new BeanListHandler<Customer>(Customer.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }
}
