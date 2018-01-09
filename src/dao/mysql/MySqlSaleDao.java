package dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Sale;
import exceptions.DaoException;

public class MySqlSaleDao extends AbstractDao<Sale>{
    
    @Override
    public String getSelectQuery() {
        return "SELECT * FROM `sales` where `id_sale` = ?";
    }
    
    @Override
    public String getDeleteQuery() {
        return "DELETE FROM `sales` WHERE `id_sale` = ?";
    }
    
    @Override
    public String getInsertQuery() {
        return "insert into `sales` (`title`, `size`) values (?,?);";
    }
    
    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM `sales` ORDER BY `size` DESC";
    }
    
    @Override
    protected void setEntity(PreparedStatement statement, Sale sale) throws DaoException {
        try {
            statement.setString(1, sale.getName());
            statement.setByte(2, sale.getSize());
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
    
    @Override
    protected Sale parseResultSet(ResultSet resultSet) throws DaoException {
        Sale sale = new Sale();
        try {
            sale.setId(resultSet.getLong("id_sale"));
            sale.setName(resultSet.getString("title"));
            sale.setSize(resultSet.getByte("size"));
            return sale;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void update(Sale sale, long key) throws DaoException {
        String sql = "update `sales` set `title` = ?, `size` = ? where `id_sale` = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            setEntity(statement, sale);
            statement.setLong(3, key);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
