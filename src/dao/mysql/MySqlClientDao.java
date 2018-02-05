/*
 * Dao для работы с таблицей clients
 */

package dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ClientDao;
import entity.Client;
import exceptions.DaoException;

public class MySqlClientDao extends AbstractDao<Client> implements ClientDao {

    @Override
    public String getSelectQuery() {
        return "SELECT `id`, `surname`, `name`, `phone`, `size`, `trips` FROM `clients`, `sales` where id_sale = sales_id_sale AND `id` = ?";
    }

    public String getSelectName() {
        return "SELECT `id`, `surname`, `name`, `phone`, `size`, `trips` FROM `clients`, `sales` where id_sale = sales_id_sale AND `surname` = ? AND `name` = ?";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM `clients` WHERE `id` = ?";
    }

    @Override
    public String getInsertQuery() {
        return "insert into `clients` (`name`, `surname`, `phone`) values (?,?,?);";
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT `id`, `surname`, `name`, `phone`, `size`, `trips` FROM `clients`, `sales` where id_sale = sales_id_sale ORDER BY `surname`, `name`, `id`";
    }

    @Override
    protected void setEntity(PreparedStatement statement, Client client) throws DaoException {
        try {
            statement.setString(1, client.getName());
            statement.setString(2, client.getSurname());
            statement.setString(3, client.getPhone());
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    protected Client parseResultSet(ResultSet resultSet) throws DaoException {
        Client client = new Client();
        try {
            client.setId(resultSet.getLong("id"));
            client.setName(resultSet.getString("name"));
            client.setSurname(resultSet.getString("surname"));
            client.setPhone(resultSet.getString("phone"));
            client.setSale(resultSet.getInt("size"));
            client.setTrips(resultSet.getInt("trips"));
            return client;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void update(Client client, long key) throws DaoException {
        String sql = "UPDATE `clients` SET `name` = ?, `surname` = ?, `phone` = ? WHERE `id` = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            setEntity(statement, client);
            statement.setLong(4, key);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Client> readByName(String name, String surname) throws DaoException {
        String sql = "SELECT `id`, `surname`, `name`, `phone`, `size`, `trips` FROM `clients`, `sales` where id_sale = sales_id_sale AND `surname` = ? AND `name` = ?";
        ResultSet resultSet = null;
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, surname);
            statement.setString(2, name);
            resultSet = statement.executeQuery();
            List<Client> persons = new ArrayList<>();
            Client client = null;
            while (resultSet.next()) {
                client = parseResultSet(resultSet);
                persons.add(client);
            }
            return persons;
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
    public boolean chechUnique(String phone) throws DaoException {
        String sql = "SELECT `id` FROM `clients` WHERE `phone` = ?";
        ResultSet resultSet = null;
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, phone);
            resultSet = statement.executeQuery();
            return !resultSet.next();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                resultSet.close();
            } catch (Exception e) {
            }
        }
    }
}
