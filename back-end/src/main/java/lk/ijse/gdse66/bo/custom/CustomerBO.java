package lk.ijse.gdse66.bo.custom;

import lk.ijse.gdse66.bo.SuperBO;
import lk.ijse.gdse66.dto.CustomerDTO;
import lk.ijse.gdse66.entity.Customer;

import java.util.ArrayList;

public interface CustomerBO extends SuperBO {

    int saveCustomer(CustomerDTO customerDTO);

    ArrayList<CustomerDTO> getAllCustomers();

    int updateCustomer(CustomerDTO customerDTO);

    int removeCustomer(String id);

    CustomerDTO getCustomerById(String id);
}
