package org.lanqiao.service.impl;

import org.lanqiao.dao.IManagerDao;
import org.lanqiao.dao.impl.ManagerDaoImpl;
import org.lanqiao.domain.Condition;
import org.lanqiao.domain.Manager;
import org.lanqiao.service.IManagerService;

import java.sql.SQLException;
import java.util.List;

public class ManagerServiceImpl implements IManagerService {
    IManagerDao iManagerDao = new ManagerDaoImpl();
    @Override
    public List<Manager> getManagerLlist(Condition condition) throws SQLException {
        return iManagerDao.selectAll(condition);
    }

    @Override
    public void deleteManager(int AdminId) {
        iManagerDao.deleteManagerById(AdminId);

    }

    @Override
    public Manager getManager(String username, String password) {
        return iManagerDao.getManager(username,password);
    }

    @Override
    public int addManager(Manager manager) {
        return iManagerDao.addManager(manager);
    }

    @Override
    public int updateManager(Manager manager) {
        return iManagerDao.updatePwd(manager);
    }

    @Override
    public int getManagerCount(Condition condition) {
        return Integer.valueOf(iManagerDao.getManagerCount(condition).toString());
    }
}
