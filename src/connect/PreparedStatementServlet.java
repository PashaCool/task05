package connect;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Servlet")
public class PreparedStatementServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		performTask(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		performTask(req, resp);
	}

	protected void performTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn = null;
			try {
				cn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/tourfirm1?autoReconnect=true&useSSL=false", "root", "12345");
				PreparedStatement ps = null;
				String sql = "insert into `clients` (`id`, `name`, `surname`, `phone`) VALUES(?,?,?,?)";
				// компиляция (подготовка) запроса
				ps = cn.prepareStatement(sql);
				Rec.insert(ps, 10, "Sam", "Name", 2);
				Rec.insert(ps, 13, "John", "Black", 3);
				Rec.insert(ps, 14, "Mike", "Call", 4);
				out.println("COMPLETE");
			} finally {
				if (cn != null)
					cn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.close();
	}
}

class Rec {
	static void insert(PreparedStatement ps, int id, String name, String surname, int salary) throws SQLException {
		// установка входных параметров
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, surname);
		ps.setInt(4, salary);
		// выполнение подготовленного запроса
		ps.executeUpdate();
	}
}