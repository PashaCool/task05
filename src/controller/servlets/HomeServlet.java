/*
 * Стартовый сервлет. Welcome-file не сделал. 
 * Welcome-jsp я так понял был бы страницей со статическим наполнением, а я решил сразу отображать данные
 * из таблицы tours_list, поэтому запускал этот сервлет первым, чтобы попасть на стартовую страницу 
 * с динамическими данными.
 * С сервлетами ранее знаком не был, поэтому в этом пакете они все выполнены по принципу "работает - и хорошо",
 * чтобы была хоть какая-то функциональность.
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

import entity.Tour;
import exceptions.ServiceException;
import service.FactoryException;
import service.ServiceFactory;
import service.TourService;
import service.logic.MainServiceFactoryImpl;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Tour> tours = new ArrayList<Tour>();
        try {
            ServiceFactory fact = new MainServiceFactoryImpl();
            TourService service = fact.getTourService();
            tours = service.readAllTour();
        } catch (FactoryException | ServiceException e) {
            throw new ServletException(e);
        }
        request.setAttribute("t", tours);
        RequestDispatcher disp = getServletContext().getRequestDispatcher("/home.jsp");
        disp.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
