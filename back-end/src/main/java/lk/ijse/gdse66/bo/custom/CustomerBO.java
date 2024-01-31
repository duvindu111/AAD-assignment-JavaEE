package lk.ijse.gdse66.bo.custom;

import lk.ijse.gdse66.bo.SuperBO;
import lk.ijse.gdse66.dto.CustomerDTO;
import lk.ijse.gdse66.entity.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO {

    boolean saveCustomer(Connection connection, CustomerDTO customerDTO) throws SQLException;

    ArrayList<CustomerDTO> getAllCustomers(Connection connection) throws SQLException;

    boolean updateCustomer(Connection connection, CustomerDTO customerDTO) throws SQLException;

    boolean removeCustomer(Connection connection, String id) throws SQLException;

    CustomerDTO getCustomerById(Connection connection, String id) throws SQLException;
}
