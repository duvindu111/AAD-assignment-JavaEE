package lk.ijse.gdse66.bo.custom;

import lk.ijse.gdse66.bo.SuperBO;
import lk.ijse.gdse66.dto.OrderDTO;

import java.sql.Connection;
import java.sql.SQLException;

public interface OrderBO extends SuperBO {
    String getLastId(Connection connection) throws SQLException;

    boolean placeOrder(Connection connection, OrderDTO orderDTO) throws SQLException;

    OrderDTO getOrderById(Connection connection, String id) throws SQLException;
}
