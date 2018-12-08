package org.lanqiao.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.dao.ICommentDao;
import org.lanqiao.dao.ICustomerDao;
import org.lanqiao.domain.Customer;
import org.lanqiao.utils.jdbcUtils;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        String sql = "update tb_customerinfo set CustomerName=?,CustomerPwd=?,Customertruename=?,CustomerSex=?,CustomerTel=?,CustomerEmail=?,CustomerAddr=? where CustomerId=?";
        try {
            qr.execute(sql,customer.getCustomerName(),customer.getCustomerPwd(),customer.getCustomertruename(),customer.getCustomerSex(),customer.getCustomerTel(),customer.getCustomerEmail(),customer.getCustomerAddr(),customer.getCustomerId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
