package lk.ijse.gdse66.bo.custom;

import lk.ijse.gdse66.bo.SuperBO;

import java.sql.Connection;
import java.sql.SQLException;

public interface OrderBO extends SuperBO {
    String getLastId(Connection connection) throws SQLException;
}
