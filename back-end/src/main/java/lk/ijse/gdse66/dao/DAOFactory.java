package lk.ijse.gdse66.dao;

import lk.ijse.gdse66.dao.custom.impl.CustomerDAOImpl;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory(){

    }

    public static DAOFactory getDAOFactory(){
        return (daoFactory==null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes{
        CUSTOMER_DAO
    }

    public <T extends SuperDAO> T getDAO(DAOTypes type){
        switch (type){
            case CUSTOMER_DAO:
                return (T) new CustomerDAOImpl();
            default:
                return null;
        }
    }
}
