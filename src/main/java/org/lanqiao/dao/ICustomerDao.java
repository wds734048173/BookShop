package org.lanqiao.dao;

import org.lanqiao.domain.Customer;

import java.util.List;

public interface ICustomerDao {
    //查
    public List<Customer> getCustomerList();
    public Customer getCustomer(String customerName,String pwd);
    //增
    public void addCustomer(Customer customer);
    //改
    public void updateCustomer(Customer customer);

}
