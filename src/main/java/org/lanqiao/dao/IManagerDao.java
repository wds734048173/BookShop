package org.lanqiao.dao;

import org.lanqiao.domain.Manager;

import java.sql.SQLException;
import java.util.List;

public interface IManagerDao {
 public List<Manager> selectAll() throws SQLException;
 public Manager getManager(String username,String password);
 //用户注册，需判断是否注册成功
 public int addManager(Manager manager);
}
