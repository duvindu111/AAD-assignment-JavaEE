package lk.ijse.gdse66.dao.custom.impl;

import lk.ijse.gdse66.dao.custom.CustomerDAO;
import lk.ijse.gdse66.entity.Customer;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {

    DataSource connectionPool;

    public CustomerDAOImpl() {
        try {
            InitialContext ic = new InitialContext();
            connectionPool = (DataSource) ic.lookup("java:/comp/env/jdbc/eeAssignment");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int save(Customer entity) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement pstm = connection.prepareStatement("INSERT INTO customer (id,name,address,contact) VALUES (?,?,?,?)");
            pstm.setString(1, entity.getId());
            pstm.setString(2, entity.getName());
            pstm.setString(3, entity.getAddress());
            pstm.setString(4, entity.getContact());
            pstm.executeUpdate();
            return HttpServletResponse.SC_CREATED;
        } catch (SQLIntegrityConstraintViolationException e) {
            return HttpServletResponse.SC_CONFLICT; //duplicate values
        } catch (SQLException e) {
            return HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
        }
    }

    @Override
    public int update(Customer entity) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement pstm = connection.prepareStatement("UPDATE customer SET name = ?, address = ?, contact = ? WHERE id = ?");
            pstm.setString(1, entity.getName());
            pstm.setString(2, entity.getAddress());
            pstm.setString(3, entity.getContact());
            pstm.setString(4, entity.getId());
            pstm.executeUpdate();
            return HttpServletResponse.SC_NO_CONTENT;
        } catch (SQLIntegrityConstraintViolationException e) {
            return HttpServletResponse.SC_CONFLICT; //duplicate values
        } catch (SQLException e) {
            return HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
        }
    }

    @Override
    public ArrayList<Customer> getAll() {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement pstm = connection.prepareStatement("SELECT * FROM customer");
            ResultSet rs = pstm.executeQuery();

            ArrayList<Customer> customerList = new ArrayList<Customer>();
            while(rs.next()){
                Customer customer = new Customer(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                );

                customerList.add(customer);
            }
            return customerList;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public int delete(String id) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement pstm = connection.prepareStatement("DELETE FROM customer WHERE id=?");
            pstm.setString(1, id);
            int count = pstm.executeUpdate();
            System.out.println(count);
            return HttpServletResponse.SC_NO_CONTENT;
        } catch (SQLException e) {
            return HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
        }
    }

    @Override
    public Customer findBy(String id) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement pstm = connection.prepareStatement("SELECT * FROM customer WHERE id=?");
            pstm.setString(1, id);

            ResultSet rs = pstm.executeQuery();

            Customer customer = new Customer();
            if(rs.next()) {
                customer.setId(rs.getString(1));
                customer.setName(rs.getString(2));
                customer.setAddress(rs.getString(3));
                customer.setContact(rs.getString(4));
            }
            return customer;
        } catch (SQLException e) {
            return null;
        }
    }
}
