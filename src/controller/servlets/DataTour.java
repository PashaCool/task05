/*
 * Сервлет получает данные из формы заполнения. Отправляет на страницу
 * с отображением полученных данных из формы. Не удалось получить данные из списков и чек-боксов.
 */

package controller.servlets;

import java.io.IOException;

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

@WebServlet("/DataTour")
public class DataTour extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RequestDispatcher disp;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("create") != null) {
            String city = request.getParameter("city");
            String type = request.getParameter("type");
            String pr = request.getParameter("price");
            double price = Double.parseDouble(pr);
            String d = request.getParameter("days");
            int days = Integer.parseInt(d);
            String transport = request.getParameter("transport");
            request.setAttribute("city", city);
            request.setAttribute("type", type);
            request.setAttribute("price", price);
            request.setAttribute("days", days);
            disp = getServletContext().getRequestDispatcher("/WEB-INF/jsp/tour/dataTour.jsp");
            disp.forward(request, response);
        }
    }
}
