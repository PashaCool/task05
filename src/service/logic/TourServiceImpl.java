package service.logic;

import java.util.List;

import dao.mysql.MySqlTourDao;
import entity.Tour;
import exceptions.DaoException;
import exceptions.ServiceException;
import service.TourService;

public class TourServiceImpl implements TourService{
	
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Tour> readAllTour() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tour> readTourByType(String type) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}


}
