package dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.TourDao;
import entity.Tour;
import exceptions.DaoException;

public class MySqlTourDao extends AbstractDao<Tour> implements TourDao {

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM `tours_list` where `id` = ?";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM `tours_list` WHERE `id` = ?";
    }

    @Override
    public String getInsertQuery() {
        return "insert into `tours_list` (`city`, `type`, `days`, `price`, `eat`, `hotel`, `visa`, `transport`) values (?,?,?,?,?,?,?,?);";
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM `tours_list`";
    }

    @Override
    public List<Tour> readByType(String type) throws DaoException {
        String sql = "SELECT * FROM `tours_list` where `type` = ?";
        ResultSet resultSet = null;
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, type);
            resultSet = statement.executeQuery();
            List<Tour> trips = new ArrayList<>();
            Tour tour = null;
            while (resultSet.next()) {
                tour = parseResultSet(resultSet);
                trips.add(tour);
            }
            return trips;
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
    protected void setEntity(PreparedStatement statement, Tour obj) throws DaoException {
        try {
            statement.setString(1, obj.getCity());
            statement.setString(2, obj.getType());
            statement.setInt(3, obj.getDays());
            statement.setDouble(4, obj.getPrice());
            statement.setBoolean(5, obj.isEat());
            statement.setBoolean(6, obj.isHotel());
            statement.setBoolean(7, obj.isVisa());
            statement.setString(8, obj.getTransBus());
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    protected Tour parseResultSet(ResultSet resultSet) throws DaoException {
        Tour trip = new Tour();
        try {
            trip.setId(resultSet.getLong("id"));
            trip.setCity(resultSet.getString("city"));
            trip.setType(resultSet.getString("type"));
            trip.setDays(resultSet.getInt("days"));
            trip.setPrice(resultSet.getDouble("price"));
            trip.setEat(resultSet.getBoolean("eat"));
            trip.setHotel(resultSet.getBoolean("hotel"));
            trip.setVisa(resultSet.getBoolean("visa"));
            trip.setTransBus(resultSet.getString("transport"));
            return trip;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void update(Tour obj, long key) throws DaoException {
        String sql = "update `tours_list` set `city` = ?, `type` = ?, `days` = ?, `price` = ?, `eat` = ?, `hotel` = ?, `visa` = ?, `transport` = ? where `id` = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            setEntity(statement, obj);
            statement.setLong(9, key);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
