package lk.ijse.gdse66.dao.custom;

import lk.ijse.gdse66.dao.CrudDAO;
import lk.ijse.gdse66.entity.Order;

import java.sql.Connection;
import java.sql.SQLException;

public interface OrderDAO extends CrudDAO<Order> {
    String getLastId(Connection connection) throws SQLException;
}
