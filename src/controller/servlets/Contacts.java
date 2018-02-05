/*
 * Сервлет отправляет на страницу с контактами при нажатии на кнопку Contacts
 */

package controller.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Contacts")
public class Contacts extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RequestDispatcher disp;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        if (request.getParameter("contacts") != null) {
            disp = getServletContext().getRequestDispatcher("/WEB-INF/jsp/contacts.html");
            disp.forward(request, response);
        }
    }
}
