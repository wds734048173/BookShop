package org.lanqiao.service.impl;

import org.lanqiao.dao.IManagerDao;
import org.lanqiao.dao.impl.ManagerDaoImpl;
import org.lanqiao.domain.Manager;
import org.lanqiao.service.IManagerService;

import java.sql.SQLException;
import java.util.List;

public class ManagerServiceImpl implements IManagerService {
    IManagerDao managerDao = new ManagerDaoImpl();
    @Override
    public List<Manager> getManagerLlist() throws SQLException {
        return managerDao.selectAll();
    }

    @Override
    public Manager getManager(String username, String password) {
        return managerDao.getManager(username,password);
    }

    @Override
    public int addManager(Manager manager) {
        return managerDao.addManager(manager);
    }

    @Override
    public int updateManager(Manager manager) {
        return managerDao.updatePwd(manager);
    }
}
