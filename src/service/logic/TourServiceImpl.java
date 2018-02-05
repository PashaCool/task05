package service.logic;

import java.util.List;

import dao.mysql.MySqlTourDao;
import entity.Tour;
import entity.tour.LastMinuteOffer;
import entity.tour.Order;
import exceptions.DaoException;
import exceptions.ServiceException;
import service.TourService;

public class TourServiceImpl implements TourService {

    private MySqlTourDao dao;

    public MySqlTourDao getDao() {
        return this.dao;
    }

    public void setTourDao(MySqlTourDao dao) {
        this.dao = dao;
    }

    @Override
    public void save(Tour tour) throws ServiceException {
        try {
            dao.create(tour);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(Long id) throws ServiceException {
        try {
            dao.delete(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Tour> readAllTour() throws ServiceException {
        try {
            return dao.readAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Tour> readTourByType(String type) throws ServiceException {
        try {
            return dao.readByType(type);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    // Сделать тур горящим используя шаблон Decorator
    public void doFlamingOffer(long key) throws ServiceException {
        try {
            Tour tour = dao.read(key);
            if (!(tour.isSale())) {
                Order order = new LastMinuteOffer(tour);
                tour.setPrice(order.getPrice());
                tour.setOffer(order.getOffer());
                tour.setSale(true);
                dao.update(tour, key);
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    // Вернуть тур к первоначальной стоимости, выведя из состояния горящего
    public void outFlamingOffer(long key) throws ServiceException {
        try {
            Tour tour = dao.read(key);
            if (tour.isSale()) {
                double price = tour.getPrice() / ((100 - tour.getOffer()) / 100);
                tour.setPrice(price);
                tour.setSale(false);
                tour.setOffer(0);
                dao.update(tour, key);
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
