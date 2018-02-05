/*
 * Интерфейс для работы с турами
 */

package dao;

import java.util.List;

import dao.GenericDao;
import entity.Tour;
import exceptions.DaoException;

public interface TourDao extends GenericDao<Tour> {

    // Метод для поиска туров по типу(tour, shopping, sanative)
    List<Tour> readByType(String type) throws DaoException;

}
