/*
 * Сервлет отправляет на jsp страницу для отображения записей из таблицы clients
 */

package controller.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Client;
import exceptions.ServiceException;
import service.ClientService;
import service.FactoryException;
import service.ServiceFactory;
import service.logic.MainServiceFactoryImpl;

@WebServlet("/ClientList")
public class ClientList extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RequestDispatcher disp;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Client> clients = new ArrayList<Client>();
        try {
            ServiceFactory fact = new MainServiceFactoryImpl();
            ClientService service = fact.getClientService();
            clients = service.readAllClient();
        } catch (FactoryException | ServiceException e) {
            throw new ServletException(e);
        }
        request.setAttribute("clients", clients);
        RequestDispatcher disp = getServletContext().getRequestDispatcher("/WEB-INF/jsp/client/list.jsp");
        disp.forward(request, response);
    }
}
