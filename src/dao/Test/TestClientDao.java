package dao.Test;

import dao.mysql.MySqlClientDao;
import entity.Client;
import exceptions.DaoException;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestClientDao {

    private Client mike = new Client("Rob", "Fox", "8(029)345-56-77");

    @Test
    public void createTest(MySqlClientDao clientDao) throws DaoException {
        Long id = clientDao.create(mike);
        Assert.assertNotNull(id);
    }

    @Test
    public void readTest(MySqlClientDao clientDao) throws DaoException {
        Client jim = clientDao.read(5);
        Assert.assertNotNull(jim);
        Assert.assertNotNull(jim.getId());
    }

    @Test
    public void testDelete(MySqlClientDao clientDao) throws DaoException {
        Long id = clientDao.create(mike);
        Assert.assertNotNull(id);

        List<Client> list = clientDao.readAll();
        Assert.assertNotNull(list);

        long oldSize = list.size();
        Assert.assertTrue(oldSize > 0);

        clientDao.delete(id);

        list = clientDao.readAll();
        Assert.assertNotNull(list);

        long newSize = list.size();
        Assert.assertEquals(1, oldSize - newSize);
    }

    @Test
    public void testReadAll(MySqlClientDao clientDao) throws DaoException {
        List<Client> clients = clientDao.readAll();
        Assert.assertNotNull(clients);
        Assert.assertTrue(clients.size() > 0);
    }
}
