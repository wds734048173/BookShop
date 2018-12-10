package org.lanqiao.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.lanqiao.dao.ICustomerDao;
import org.lanqiao.domain.Condition;
import org.lanqiao.domain.Customer;
import org.lanqiao.utils.jdbcUtils;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerDaoImpl implements ICustomerDao {
    private QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
    @Override
    public List<Customer> getCustomerList(Condition condition) {
        List<Customer> customerList = null;
        StringBuffer sql = new StringBuffer("SELECT * from tb_customerinfo where 1 = 1 ");
        List<Object> search = new ArrayList<>();
        if(condition != null){
            if(condition.getName() != null && !"".equals(condition.getName())){
                sql.append(" and CustomerName like ? ");
                search.add("%" + condition.getName() + "%");
            }
            sql.append(" limit ?,?");
            search.add(condition.getCurrentPage());
            search.add(condition.getPageSize());
        }
        try {
            customerList = qr.query(sql.toString(),new BeanListHandler<>(Customer.class),search.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public Customer getCustomerById(int CustomerId) {
        Customer customer = null;
        String sql = "SELECT * from tb_customerinfo where CustomerId = ?";
        try {
            customer = qr.query(sql,new BeanHandler<>(Customer.class),CustomerId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public Long getCustomerCount(Condition condition) {
        StringBuffer sql = new StringBuffer("SELECT count(1) from tb_customerinfo where 1 = 1 ");
        List<Object> search = new ArrayList<>();
        if(condition.getName() != null && !"".equals(condition.getName())){
            sql.append(" and CustomerName like ? ");
            search.add("%" + condition.getName() + "%");
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
    public Customer getCustomer(String customerName,String pwd) {
        String sql="select * from tb_customerinfo where CustomerName=? and CustomerPwd=?";
        Customer customer=null;
        try {
            customer = qr.query(sql,new BeanHandler<>(Customer.class),customerName,pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public void addCustomer(Customer customer) {
        String sql="insert into tb_customerinfo (CustomerName,CustomerPwd,Customertruename,CustomerSex,CustomerTel,CustomerEmail,CustomerAddr,CTime,RTime,CustomerLogTime,CustomerLastLogT) values(?,?,?,?,?,?,?,?,?,?,?)";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            qr.execute(sql,customer.getCustomerName(),customer.getCustomerPwd(),customer.getCustomertruename(),customer.getCustomerSex(),customer.getCustomerTel(),customer.getCustomerEmail(),customer.getCustomerAddr(),format.format(new Date()),format.format(new Date()),1,format.format(new Date()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        String sql = "update tb_customerinfo set CustomerTel=?,CustomerEmail=?,CustomerAddr=? where CustomerId=?";
        try {
            qr.execute(sql,customer.getCustomerTel(),customer.getCustomerEmail(),customer.getCustomerAddr(),customer.getCustomerId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



