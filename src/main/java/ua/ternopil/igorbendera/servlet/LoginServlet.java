package ua.ternopil.igorbendera.servlet;

import ua.ternopil.igorbendera.dao.impl.UserDaoImpl;
import ua.ternopil.igorbendera.domain.User;
import ua.ternopil.igorbendera.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        User user = new User(login, password);
        boolean isUser = false;

        try {
            isUser = new UserDaoImpl().isUserExist(user);
        } catch(SQLException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        if(isUser) {
            request.setAttribute("userEmail", login);
            request.getRequestDispatcher("cabinet.jsp").forward(request,response);
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
//        UserService userService = UserService.getUserService();
//        User user = userService.getParticularUser(login);

//        if(user != null && user.getPassword().equals(password)) {
//            request.setAttribute("userEmail", login);
//            request.getRequestDispatcher("cabinet.jsp").forward(request,response);
//        } else {
//            request.getRequestDispatcher("login.jsp").forward(request,response);
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
