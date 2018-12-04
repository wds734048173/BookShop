package org.lanqiao.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.dao.IManagerDao;
import org.lanqiao.domain.Manager;
import org.lanqiao.utils.jdbcUtils;

import java.sql.SQLException;
import java.util.List;

public class IManagerDaoDaoImpl implements IManagerDao {
    private QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());
    @Override
    public List<Manager> selectAll() throws SQLException {
        String sql = "select * from tb_manager";
        return qr.query(sql,new BeanListHandler<>(Manager.class));
    }
}
