package org.lanqiao.service.impl;

import org.lanqiao.dao.ICustomerDao;
import org.lanqiao.dao.impl.CustomerDaoImpl;
import org.lanqiao.domain.Customer;
import org.lanqiao.service.ICustomerService;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService {
    ICustomerDao customerDao = new CustomerDaoImpl();

    @Override
    public List<Customer> getCustomerList() {
        return customerDao.getCustomerList();
    }

    @Override
    public Customer getCustomer(String customer,String pwd) {
        return customerDao.getCustomer(customer,pwd);
    }

    @Override
    public Customer getCustomerById(int CustomerId) {
        return customerDao.getCustomerById(CustomerId);
    }

    @Override
    public void addCustomer(Customer customer) {
        customerDao.addCustomer(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerDao.updateCustomer(customer);
    }
}
