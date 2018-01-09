package dao;

import java.util.List;

import exceptions.DaoException;

public interface GenericDao<T> {
    
    Long create(T obj) throws DaoException;
    
    T read(long key) throws DaoException;
    
    void update(T obj, long key) throws DaoException;
    
    void delete(long key) throws DaoException;
    
    List<T> readAll() throws DaoException;

}
