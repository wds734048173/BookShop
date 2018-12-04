package org.lanqiao.dao;

import org.lanqiao.domain.Manager;

import java.sql.SQLException;
import java.util.List;

public interface IManagerDao {
 public List<Manager> selectAll() throws SQLException;
}
