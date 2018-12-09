package org.lanqiao.service;

import org.lanqiao.domain.Customer;

import java.util.List;

public interface ICustomerService {
    //查
    public List<Customer> getCustomerList();
    public Customer getCustomer(String customer,String pwd);
    public Customer getCustomerById(int CustomerId);
    //增
    public void addCustomer(Customer customer);
    //改
    public void updateCustomer(Customer customer);
}
