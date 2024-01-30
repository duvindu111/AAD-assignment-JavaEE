package lk.ijse.gdse66.bo.custom;

import lk.ijse.gdse66.bo.SuperBO;
import lk.ijse.gdse66.dto.CustomerDTO;

public interface CustomerBO extends SuperBO {

    int saveCustomer(CustomerDTO customerDTO);
}
