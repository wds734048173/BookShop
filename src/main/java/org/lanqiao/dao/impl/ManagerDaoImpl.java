package org.lanqiao.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.lanqiao.dao.IManagerDao;
import org.lanqiao.domain.Condition;
import org.lanqiao.domain.Manager;
import org.lanqiao.utils.jdbcUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerDaoImpl implements IManagerDao {
    private QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
    @Override
    public List<Manager> selectAll(Condition condition) throws SQLException {
        StringBuffer sql = new StringBuffer("select * from tb_manager  where 1 = 1 ");
        List<Object> search = new ArrayList<>();
        if(condition.getName() != null && !"".equals(condition.getName())){
            sql.append(" and AdminName like ? ");
            search.add("%" + condition.getName() + "%");
        }
        sql.append(" limit ?,?");
        search.add(condition.getCurrentPage());
        search.add(condition.getPageSize());
        List<Manager> managerList = new ArrayList<>();
        try {
            managerList = qr.query(sql.toString(),new BeanListHandler<>(Manager.class),search.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return managerList;
    }

    @Override
    public void deleteManagerById(int AdminId) {
        String sql = "DELETE FROM tb_manager WHERE AdminId = ?";
        try {
            qr.execute(sql,AdminId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    @Override
    public int updatePwd(Manager manager) {
        String sql = "UPDATE tb_manager SET AdminPwd = ? WHERE AdminName = ?";
        int result = -1;
        try {
            result = qr.execute(sql,manager.getAdminPwd(),manager.getAdminName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Long getManagerCount(Condition condition) {
        StringBuffer sql = new StringBuffer("SELECT count(1) from tb_manager where 1 = 1 ");
        List<Object> search = new ArrayList<>();
        if(condition.getName() != null && !"".equals(condition.getName())){
            sql.append(" and AdminName like ? ");
            search.add("%" + condition.getName() + "%");
        }
        Long count = 0L;
        try {
            count = qr.query(sql.toString(),new ScalarHandler<>(1),search.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
