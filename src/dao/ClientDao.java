package dao;

import java.util.List;

import dao.GenericDao;
import entity.Client;
import exceptions.DaoException;

public interface ClientDao extends GenericDao<Client> {

    List<Client> readByName(String name, String surname) throws DaoException;
    
    boolean chechUnique(String login) throws DaoException;
}
