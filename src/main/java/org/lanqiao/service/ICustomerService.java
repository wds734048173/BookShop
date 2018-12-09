package org.lanqiao.service;

import javafx.print.Collation;
import org.lanqiao.domain.Condition;
import org.lanqiao.domain.Customer;

import java.util.List;

public interface ICustomerService {
    public List<Customer> getCustomerList(Condition condition);

    public int getCustomerCount(Condition condition);

    public Customer getCustomerById(int condition);

    public Customer getCustomer(String customer,String pwd);
    //增
    public void addCustomer(Customer customer);
    //改
    public void updateCustomer(Customer customer);
}
