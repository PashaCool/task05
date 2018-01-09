package connect;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.mysql.MySqlClientDao;
import dao.pool.ConnectionPool;
import entity.Client;
import exceptions.PersistentException;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		 
        PrintWriter pw = response.getWriter();
        pw.println("<B>Список пассажиров</B>");
        pw.println("<table border=1>");
        try {
        	List<Client> list = Arrays.asList(new Client("Chester", "Chitos", "8(029)501-53-15"), 
            		new Client("Kirill", "Mithel", "8(029)454-64-21"));
        	
        	List<Client> lst = new ArrayList<>();
        	ConnectionPool m = ConnectionPool.getInstance();
    		try {
    			pw.println("перед инит");
    			m.init();
    			pw.println("после инит");
    			Connection z = m.getConnection();
    			MySqlClientDao dao = new MySqlClientDao();
    			dao.setConnection(z);
    			lst = dao.readAll();
    		} catch (Exception e) {
    			e.printStackTrace();
    			pw.println("generate exception");
    		}
     	    	
        	pw.println("<tr>");
            pw.println("<td>Имя</td>");
            pw.println("<td>Фамилия</td>");
            pw.println("<td>Телефон</td>");
            pw.println("<td>Скидка</td>");
            pw.println("</tr>");
            for (Client gr : lst) {
                pw.println("<tr>");
                pw.println("<td>" + gr.getName() + "</td>");
                pw.println("<td>" + gr.getSurname() + "</td>");
                pw.println("<td>" + gr.getPhone() + "</td>");
                pw.println("<td>" + gr.getSale() + "</td>");
                pw.println("</tr>");
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
        pw.println("</table>");
	}
}
