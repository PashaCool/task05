package service.logic;

import java.sql.Connection;
import java.sql.SQLException;

import dao.mysql.MySqlClientDao;
import dao.mysql.MySqlSaleDao;
import dao.mysql.MySqlTourDao;
import dao.pool.ConnectionPool;
import service.ClientService;
import service.FactoryException;
import service.SaleService;
import service.ServiceFactory;
import service.TourService;

public class MainServiceFactoryImpl implements ServiceFactory {

    private Connection connection;

    @Override
    public ClientService getClientService() throws FactoryException {
        ClientServiceImpl clientService = new ClientServiceImpl();
        clientService.setClientDao(getClientDao());
        return clientService;
    }

    @Override
    public TourService getTourService() throws FactoryException {
        TourServiceImpl tourServ = new TourServiceImpl();
        tourServ.setTourDao(getTourDao());
        return tourServ;
    }

    public SaleService getSaleService() throws FactoryException {
        SaleServiceImpl tourServ = new SaleServiceImpl();
        tourServ.setSaleDao(getSaleDao());
        return tourServ;
    }

    @Override
    public MySqlClientDao getClientDao() throws FactoryException {
        MySqlClientDao dao = new MySqlClientDao();
        dao.setConnection(getConnection());
        return dao;
    }

    @Override
    public MySqlTourDao getTourDao() throws FactoryException {
        MySqlTourDao dao = new MySqlTourDao();
        dao.setConnection(getConnection());
        return dao;
    }

    @Override
    public MySqlSaleDao getSaleDao() throws FactoryException {
        MySqlSaleDao dao = new MySqlSaleDao();
        dao.setConnection(getConnection());
        return dao;
    }

    @Override
    public Connection getConnection() throws FactoryException {
        ConnectionPool m = ConnectionPool.getInstance();
        try {
            m.init();
            connection = m.getConnection();
            return connection;
        } catch (Exception e) {
            throw new FactoryException(e);
        }
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
        }
    }
}
