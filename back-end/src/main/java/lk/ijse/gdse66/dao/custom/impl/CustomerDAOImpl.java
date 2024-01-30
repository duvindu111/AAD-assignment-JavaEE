package lk.ijse.gdse66.dao.custom.impl;

import lk.ijse.gdse66.dao.custom.CustomerDAO;
import lk.ijse.gdse66.entity.Customer;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
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
    public boolean update(Customer entity) {
        return false;
    }

    @Override
    public ArrayList<Customer> getAll() {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Customer findBy(String id) {
        return null;
    }
}
