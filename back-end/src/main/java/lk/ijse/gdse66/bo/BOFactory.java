package lk.ijse.gdse66.bo;

import lk.ijse.gdse66.bo.custom.impl.CustomerBOImpl;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory(){

    }

    public static BOFactory getBOFactory(){
        return (boFactory==null) ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes{
        CUSTOMER_BO
    }

    public <T extends SuperBO> T getBO(BOTypes type){
        switch (type){
            case CUSTOMER_BO:
                return (T) new CustomerBOImpl();
            default:
                return null;
        }
    }
}
