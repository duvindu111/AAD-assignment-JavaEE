package lk.ijse.gdse66.bo.custom.impl;

import lk.ijse.gdse66.bo.custom.OrderBO;
import lk.ijse.gdse66.dao.DAOFactory;
import lk.ijse.gdse66.dao.custom.OrderDAO;

import java.sql.Connection;
import java.sql.SQLException;

public class OrderBOImpl implements OrderBO {

    OrderDAO orderDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ORDER_DAO);

    @Override
    public String getLastId(Connection connection) throws SQLException {
        return orderDAO.getLastId(connection);
    }
}
