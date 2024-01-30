package lk.ijse.gdse66.bo.custom.impl;

import lk.ijse.gdse66.bo.custom.CustomerBO;
import lk.ijse.gdse66.dao.DAOFactory;
import lk.ijse.gdse66.dao.custom.CustomerDAO;
import lk.ijse.gdse66.dto.CustomerDTO;
import lk.ijse.gdse66.entity.Customer;

public class CustomerBOImpl implements CustomerBO {

    CustomerDAO customerDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER_DAO);

    @Override
    public int saveCustomer(CustomerDTO dto) {
        return customerDAO.save(new Customer(dto.getId(), dto.getName(), dto.getAddress(), dto.getContact()));
    }
}
