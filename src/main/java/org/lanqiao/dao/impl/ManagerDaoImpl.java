package org.lanqiao.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.dao.IManagerDao;
import org.lanqiao.domain.Manager;
import org.lanqiao.utils.jdbcUtils;

import java.sql.SQLException;
import java.util.List;

public class ManagerDaoImpl implements IManagerDao {
    private QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
    @Override
    public List<Manager> selectAll() throws SQLException {
        String sql = "select * from tb_manager";
        return qr.query(sql,new BeanListHandler<>(Manager.class));
    }

    @Override
    public Manager getManager(String username, String password) {
        String sql = "select * from tb_manager where AdminName = ? and AdminPwd = ?";
        Manager manager = null;
        try {
            manager = qr.query(sql,new BeanHandler<>(Manager.class),username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return manager;
    }

    @Override
    public int addManager(Manager manager) {
        String sql = "INSERT INTO tb_manager (AdminName,AdminPwd,AdminFlag,Ctime,Rtime) VALUES (?,?,0,now(),now())";
        int result = -1;
        try {
            result = qr.execute(sql,manager.getAdminName(),manager.getAdminPwd());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
