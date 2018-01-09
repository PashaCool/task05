package service;

import java.util.List;

import entity.Tour;
import exceptions.ServiceException;

public interface TourService {

    void save(Tour Tour) throws ServiceException;

    void delete(Long id) throws ServiceException;

    List<Tour> readAllTour() throws ServiceException;

    List<Tour> readTourByType(String type) throws ServiceException;

}
