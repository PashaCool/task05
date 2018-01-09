package service;

import java.util.List;

import entity.Sale;
import exceptions.ServiceException;

public interface SaleService {
    
    void save(Sale Sale) throws ServiceException;

    void delete(Long id) throws ServiceException;

    List<Sale> readAllSale() throws ServiceException;

}
