package service.logic;

import java.util.List;

import dao.mysql.MySqlSaleDao;
import entity.Sale;
import exceptions.DaoException;
import exceptions.ServiceException;
import service.SaleService;

public class SaleServiceImpl implements SaleService {

    private MySqlSaleDao dao;

    public MySqlSaleDao getDao() {
        return this.dao;
    }

    public void setSaleDao(MySqlSaleDao dao) {
        this.dao = dao;
    }

    @Override
    public void save(Sale Sale) throws ServiceException {
    }

    @Override
    public void delete(Long id) throws ServiceException {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Sale> readAllSale() throws ServiceException {
        try {
            return dao.readAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
