package org.lanqiao.service;

import org.lanqiao.domain.Manager;

import java.sql.SQLException;
import java.util.List;

public interface IManagerService {
    public List<Manager> getManagerLlist() throws SQLException;
}
