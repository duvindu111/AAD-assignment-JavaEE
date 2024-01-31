package lk.ijse.gdse66.dao.custom;

import lk.ijse.gdse66.dao.CrudDAO;

import java.sql.Connection;
import java.sql.SQLException;

public interface OrderDAO extends CrudDAO {
    String getLastId(Connection connection) throws SQLException;
}
