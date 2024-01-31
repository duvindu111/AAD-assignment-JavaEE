package lk.ijse.gdse66.bo.custom;

import lk.ijse.gdse66.bo.SuperBO;
import lk.ijse.gdse66.dto.OrderDTO;

import java.sql.Connection;
import java.sql.SQLException;

public interface OrderDetailsBO extends SuperBO {

    OrderDTO getOrderDetailsById(Connection connection, String id) throws SQLException;
}
