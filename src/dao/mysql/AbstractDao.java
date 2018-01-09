package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dao.GenericDao;
import entity.Entity;
import exceptions.DaoException;

public abstract class AbstractDao<T extends Entity> implements GenericDao<T> {

    protected Connection connection;
    private Logger logger = Logger.getLogger(AbstractDao.class);

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Long create(T obj) throws DaoException {
        String sql = getInsertQuery();
        ResultSet result = null;
        try (PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);) {
            setEntity(statement, obj);
            statement.executeUpdate();
            result = statement.getGeneratedKeys();
            if (result.next()) {
                return result.getLong(1);
            } else {
                logger.error("There is no autoincremented index after trying to add record into table `client`");
                throw new DaoException("There is no autoincremented index");
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                result.close();
            } catch (NullPointerException | SQLException e) {
            }
        }
    }

    public T read(long key) throws DaoException {
        String sql = getSelectQuery();
        ResultSet resultSet = null;
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setLong(1, key);
            resultSet = statement.executeQuery();
            T trip = null;
            while (resultSet.next()) {
                trip = parseResultSet(resultSet);
            }
            return trip;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                resultSet.close();
            } catch (NullPointerException | SQLException e) {
            }
        }
    }

    @Override
    public void delete(long key) throws DaoException {
        String sql = getDeleteQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setLong(1, key);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public List<T> readAll() throws DaoException {
        String sql = getSelectAllQuery();
        ResultSet resultSet = null;
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            resultSet = statement.executeQuery();
            List<T> passengeers = new ArrayList<>();
            T client = null;
            while (resultSet.next()) {
                client = parseResultSet(resultSet);
                passengeers.add(client);
            }
            return passengeers;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                resultSet.close();
            } catch (SQLException | NullPointerException e) {
            }
        }
    }

    abstract public String getSelectAllQuery();

    abstract public String getSelectQuery();

    abstract protected T parseResultSet(ResultSet resultSet) throws DaoException;

    abstract public String getDeleteQuery();

    abstract public String getInsertQuery();

    abstract protected void setEntity(PreparedStatement statement, T object) throws DaoException;

    abstract public void update(T obj, long key) throws DaoException;
}
