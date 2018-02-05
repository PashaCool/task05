package dao;

import java.util.List;

import dao.GenericDao;
import entity.Client;
import exceptions.DaoException;

public interface ClientDao extends GenericDao<Client> {

    List<Client> readByName(String name, String surname) throws DaoException;

    /*
     * Решил проверять уникальность по номеру телефона, т.к. это единственный
     * идентификатор личности, который не должен повторяться
     */
    boolean chechUnique(String phone) throws DaoException;
}
