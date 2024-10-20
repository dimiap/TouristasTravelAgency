package org.example.touristastravelagency_v0.controllers;

import com.mysql.cj.conf.ConnectionUrlParser;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.touristastravelagency_v0.GetCountriesDAO;
import org.example.touristastravelagency_v0.LoginDAO;
import org.example.touristastravelagency_v0.models.Countries;
import org.example.touristastravelagency_v0.models.Users;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Users user = new Users ();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        user.username = request.getParameter("username");
        user.pass = request.getParameter("pass");
        ConnectionUrlParser.Pair<Boolean,Boolean> temp = LoginDAO.LoginDAO(user.username,user.pass);
        Boolean result = temp.left;
        Boolean admin_role = temp.right;

        if(result) {
            doGet(null, null);
            response.sendRedirect("/PopularDestinationsServlet");
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.setAttribute("username", user.username);
                String role = String.valueOf(admin_role);
                session.setAttribute("admin_role", role);
            }
        } else {
            response.sendRedirect("error.jsp");
            return;
        }
        out.close();
    }
}

