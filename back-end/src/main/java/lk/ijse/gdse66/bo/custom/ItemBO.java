package lk.ijse.gdse66.bo.custom;

import lk.ijse.gdse66.bo.SuperBO;
import lk.ijse.gdse66.dto.CustomerDTO;
import lk.ijse.gdse66.dto.ItemDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO extends SuperBO {
    boolean saveCustomer(Connection connection, ItemDTO itemDTO) throws SQLException;

    boolean updateItem(Connection connection, ItemDTO itemDTO) throws SQLException;

    ArrayList<ItemDTO> getAllItems(Connection connection) throws SQLException;

    ItemDTO getItemByCode(Connection connection, String id) throws SQLException;

    boolean removeItem(Connection connection, String id) throws SQLException;
}
