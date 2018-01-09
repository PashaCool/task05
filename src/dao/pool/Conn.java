package dao.pool;

import java.sql.Connection;
import java.util.List;

import dao.mysql.MySqlClientDao;
import entity.Client;
import exceptions.DaoException;
import exceptions.PersistentException;

public class Conn {

	public static void main(String[] args) throws DaoException {
		
		ConnectionPool m = ConnectionPool.getInstance();
		try {
			m.init();
			Connection z = m.getConnection();
			MySqlClientDao dao = new MySqlClientDao();
			dao.setConnection(z);
			System.out.print("Connect to DB");
			List<Client> list = dao.readAll();
			for (Client cl : list) {
				System.out.println(cl);
			}
			//System.out.print("Connect to DB");
		} catch (PersistentException e) {
			System.out.print("Problem");
			e.printStackTrace();
		}
	}
}
