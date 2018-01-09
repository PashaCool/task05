package service;

import com.mysql.jdbc.Connection;

import dao.ClientDao;
import dao.TourDao;
import dao.mysql.MySqlSaleDao;

public interface ServiceFactory extends AutoCloseable {
    ClientService getUserService() throws FactoryException;
    TourService getAccountService() throws FactoryException;

    ClientDao getUserDao() throws FactoryException;
    TourDao getAccountDao() throws FactoryException;
    MySqlSaleDao getTransferDao() throws FactoryException;

    Connection getConnection() throws FactoryException;
}
