package lk.ijse.gdse66.bo.custom.impl;

import lk.ijse.gdse66.bo.custom.CustomerBO;
import lk.ijse.gdse66.dao.DAOFactory;
import lk.ijse.gdse66.dao.custom.CustomerDAO;
import lk.ijse.gdse66.dto.CustomerDTO;
import lk.ijse.gdse66.entity.Customer;

import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {

    CustomerDAO customerDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER_DAO);

    @Override
    public int saveCustomer(CustomerDTO dto) {
        return customerDAO.save(new Customer(dto.getId(), dto.getName(), dto.getAddress(), dto.getContact()));
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() {
        ArrayList<Customer> customersList = customerDAO.getAll();

        ArrayList<CustomerDTO> customerDTOList = new ArrayList<CustomerDTO>();

        for(Customer customer : customersList){
            CustomerDTO dto = new CustomerDTO(
                    customer.getId(),
                    customer.getName(),
                    customer.getAddress(),
                    customer.getContact()
            );

            customerDTOList.add(dto);
        }
        return customerDTOList;
    }

    @Override
    public int updateCustomer(CustomerDTO dto) {
        return customerDAO.update(new Customer(dto.getId(), dto.getName(), dto.getAddress(), dto.getContact()));
    }

    @Override
    public int removeCustomer(String id) {
        return customerDAO.delete(id);
    }

    @Override
    public CustomerDTO getCustomerById(String id) {
        Customer customer = customerDAO.findBy(id);

        return new CustomerDTO(
                customer.getId(),
                customer.getName(),
                customer.getAddress(),
                customer.getContact()
        );
    }
}
