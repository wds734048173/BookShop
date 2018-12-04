package org.lanqiao.service.impl;

import org.lanqiao.dao.IManagerDao;
import org.lanqiao.dao.impl.IManagerDaoDaoImpl;
import org.lanqiao.domain.Manager;
import org.lanqiao.service.IManagerService;

import java.sql.SQLException;
import java.util.List;

public class ManagerServiceImpl implements IManagerService {
    @Override
    public List<Manager> getManagerLlist() throws SQLException {
        IManagerDao iManagerDao = new IManagerDaoDaoImpl();
        return iManagerDao.selectAll();
    }
}
