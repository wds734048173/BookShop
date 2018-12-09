package org.lanqiao.service.impl;
import org.lanqiao.dao.ICustomerDao;
import org.lanqiao.dao.impl.CustomerDaoImpl;
import org.lanqiao.domain.Condition;
import org.lanqiao.domain.Customer;
import org.lanqiao.service.ICustomerService;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService {
    ICustomerDao customerDao = new CustomerDaoImpl();


    @Override
    public List<Customer> getCustomerList(Condition condition) {
        return customerDao.getCustomerList(condition);
    }

    @Override
    public int getCustomerCount(Condition condition) {
        return Integer.valueOf(customerDao.getCustomerCount(condition).toString());
    }

    @Override
    public Customer getCustomerById(int condition) {
        return customerDao.getCustomerById(condition);
    }


    @Override
    public void addCustomer(Customer customer) {
        customerDao.addCustomer(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerDao.updateCustomer(customer);
    }

    @Override
    public Customer getCustomer(String customer,String pwd) {
        return customerDao.getCustomer(customer,pwd);
    }
}
