/*
 * При нажатии на кнопки Login или Reistration отправляет на разные страницы. При вводе данных 
 * в поля для логина и пароля получает их. В дальнейшем мог бы сравнивать с логоином и паролем 
 * из базы данных и проводить авторизицию при совпадении, использовать redirect для возвращения
 * на начальную страницу или обратно при не совпадении.ф
 */

package controller.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Test01")
public class Test01 extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private RequestDispatcher disp;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        if (request.getParameter("enter") != null) {
            String log = request.getParameter("login");
            String password = request.getParameter("password");
            request.setAttribute("login", log);
            request.setAttribute("password", password);
            disp = getServletContext().getRequestDispatcher("/WEB-INF/jsp/enter.jsp");
            disp.forward(request, response);
        } else if (request.getParameter("register") != null) {
            disp = getServletContext().getRequestDispatcher("/WEB-INF/jsp/registration.jsp");
            disp.forward(request, response);
        }
    }
}
