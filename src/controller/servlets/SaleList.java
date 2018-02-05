/*
 * Отправляет на страницу с отображением записей из таблицы sales
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

import entity.Sale;
import exceptions.ServiceException;
import service.FactoryException;
import service.SaleService;
import service.ServiceFactory;
import service.logic.MainServiceFactoryImpl;

@WebServlet("/SaleList")
public class SaleList extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Sale> sales = new ArrayList<Sale>();
        try {
            ServiceFactory fact = new MainServiceFactoryImpl();
            SaleService service = fact.getSaleService();
            sales = service.readAllSale();
        } catch (FactoryException | ServiceException e) {
            throw new ServletException(e);
        }
        request.setAttribute("sales", sales);
        RequestDispatcher disp = getServletContext().getRequestDispatcher("/WEB-INF/jsp/sale.jsp");
        disp.forward(request, response);
    }
}
