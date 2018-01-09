package service;

import java.util.List;

import entity.Client;
import exceptions.ServiceException;

public interface ClientService {

    void save(Client client) throws ServiceException;

    void delete(Long id) throws ServiceException;

    List<Client> readAllClient() throws ServiceException;

    List<Client> readClientByName(String name, String surname) throws ServiceException;

    boolean UniqueClient(String phone) throws ServiceException;
}
