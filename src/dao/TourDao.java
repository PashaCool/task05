package dao;

import java.util.List;

import dao.GenericDao;
import entity.Tour;
import exceptions.DaoException;

public interface TourDao extends GenericDao<Tour>{
    
    List<Tour> readByType(String type) throws DaoException;

}
