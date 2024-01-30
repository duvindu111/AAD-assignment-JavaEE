package lk.ijse.gdse66.dao;

import java.util.ArrayList;

public interface CrudDAO<T> extends SuperDAO {

    public int save(T entity);

    public boolean update(T entity);

    public ArrayList<T> getAll();

    public boolean delete(String id);

    public T findBy(String id);
}
