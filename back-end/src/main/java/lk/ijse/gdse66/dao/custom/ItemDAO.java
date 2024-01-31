package lk.ijse.gdse66.dao.custom;

import lk.ijse.gdse66.dao.CrudDAO;
import lk.ijse.gdse66.dao.SuperDAO;
import lk.ijse.gdse66.entity.Item;

import java.sql.Connection;
import java.sql.SQLException;

public interface ItemDAO extends CrudDAO<Item> {
    boolean reduceQty(Connection connection, Item item) throws SQLException;
}
