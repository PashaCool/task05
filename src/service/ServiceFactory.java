package service;

import java.sql.Connection;

import dao.ClientDao;
import dao.TourDao;
import dao.mysql.MySqlSaleDao;

public interface ServiceFactory extends AutoCloseable {
    ClientService getClientService() throws FactoryException;

    TourService getTourService() throws FactoryException;

    ClientDao getClientDao() throws FactoryException;

    TourDao getTourDao() throws FactoryException;

    SaleService getSaleService() throws FactoryException;

    MySqlSaleDao getSaleDao() throws FactoryException;

    Connection getConnection() throws FactoryException;
}
