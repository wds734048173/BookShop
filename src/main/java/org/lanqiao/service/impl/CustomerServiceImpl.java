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
}
