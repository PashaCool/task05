/*
 * При нажатии на кнопку create tour отправляет данные из формы для заполнения. Не удалость изъять данные
 * из списка и из чек-боксов.
 */

package controller.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreateTour")
public class CreateTour extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RequestDispatcher disp;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("createTour") != null) {
            disp = getServletContext().getRequestDispatcher("/WEB-INF/jsp//tour/TourCreate.jsp");
            disp.forward(request, response);
        }
    }
}
