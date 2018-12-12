package org.lanqiao.service;

import org.lanqiao.domain.Condition;
import org.lanqiao.domain.Manager;

import java.sql.SQLException;
import java.util.List;

public interface IManagerService {
    public List<Manager> getManagerLlist(Condition condition) throws SQLException;
    public void deleteManager(int AdminId);
    public int getManagerCount(Condition condition);
    //通过用户名密码获取用户详细信息
    public Manager getManager(String username,String password);
    //注册
    public int addManager(Manager manager);
    //修改密码
    public int updateManager(Manager manager);
}
