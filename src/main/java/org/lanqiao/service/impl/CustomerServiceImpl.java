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
        List<Customer> customerList = customerDao.getCustomerList(condition);
        for (int i = 0; i < customerList.size(); i++) {
            int sexId = Integer.valueOf(customerList.get(i).getCustomerSex());
            if(sexId == 0){
                customerList.get(i).setCustomerSexStr("男");
            }else{
                customerList.get(i).setCustomerSexStr("女");
            }
        }
        return customerList;
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
