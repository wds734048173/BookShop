package org.lanqiao.dao;

import org.lanqiao.domain.Condition;
import org.lanqiao.domain.Manager;

import java.sql.SQLException;
import java.util.List;

public interface IManagerDao {
 public List<Manager> selectAll(Condition condition) throws SQLException;
 //删除管理员信息
 public void deleteManagerById(int AdminId);
 public Manager getManager(String username,String password);
 //用户注册，需判断是否注册成功
 public int addManager(Manager manager);
 //修改密码
 public int updatePwd(Manager manager);
 //获取管理员列表数量
 public Long getManagerCount(Condition condition);
}
