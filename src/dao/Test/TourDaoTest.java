package dao.Test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import dao.mysql.MySqlTourDao;
import entity.Tour;
import exceptions.DaoException;

public class TourDaoTest {

    private Tour drz = new Tour("Drezden", "shopping", 3, 140.35, false, false, true, "bus");

    @Test
    public void createTest(MySqlTourDao tourDao) throws DaoException {
        Long id = tourDao.create(drz);
        Assert.assertNotNull(id);
    }

    @Test
    public void readTest(MySqlTourDao tourDao) throws DaoException {
        Tour city = tourDao.read(7);
        Assert.assertNotNull(city);
        Assert.assertNotNull(city.getId());
    }

    @Test
    public void testDelete(MySqlTourDao tourDao) throws DaoException {
        Long id = tourDao.create(drz);
        Assert.assertNotNull(id);

        List<Tour> list =tourDao.readAll();
        Assert.assertNotNull(list);

        long oldSize = list.size();
        Assert.assertTrue(oldSize > 0);

        tourDao.delete(id);

        list = tourDao.readAll();
        Assert.assertNotNull(list);

        long newSize = list.size();
        Assert.assertEquals(1, oldSize - newSize);
    }

    @Test
    public void testReadAll(MySqlTourDao tourDao) throws DaoException {
        List<Tour> tours = tourDao.readAll();
        Assert.assertNotNull(tours);
        Assert.assertTrue(tours.size() > 0);
    }
}
