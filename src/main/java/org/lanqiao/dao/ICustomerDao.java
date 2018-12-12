package org.lanqiao.dao;

import org.lanqiao.domain.Condition;
import org.lanqiao.domain.Customer;

import java.util.List;

public interface ICustomerDao {
    //获取客户信息列表
    public List<Customer> getCustomerList(Condition condition);
    //通过客户信息id获取详情
    public Customer getCustomerById(int CustomerById);
    //获取书籍分类列表数量
    public Long getCustomerCount(Condition condition);

    public Customer getCustomer(String customerName,String pwd);
    //增
    public void addCustomer(Customer customer);
    //改
    public void updateCustomer(Customer customer);
}
