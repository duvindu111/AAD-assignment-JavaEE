package lk.ijse.gdse66.dao.custom.impl;

import lk.ijse.gdse66.dao.custom.OrderDAO;
import lk.ijse.gdse66.dao.util.CrudUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public boolean save(Connection connection, Object entity) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Connection connection, Object entity) throws SQLException {
        return false;
    }

    @Override
    public ArrayList getAll(Connection connection) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(Connection connection, String id) throws SQLException {
        return false;
    }

    @Override
    public Object findBy(Connection connection, String id) throws SQLException {
        return null;
    }

    @Override
    public String getLastId(Connection connection) throws SQLException {
        String sql = "SELECT order_id FROM orders ORDER BY order_id DESC LIMIT 1";
        ResultSet rs = CrudUtil.execute(connection, sql);

        String lastId = "no_ids";
        if (rs.next()) {
            lastId = rs.getString(1);
        }
        return lastId;
    }
}
