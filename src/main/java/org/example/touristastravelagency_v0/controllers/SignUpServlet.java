package org.example.touristastravelagency_v0.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.touristastravelagency_v0.GetCountriesDAO;
import org.example.touristastravelagency_v0.SignUpDAO;
import org.example.touristastravelagency_v0.models.Countries;
import org.example.touristastravelagency_v0.models.Users;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static java.lang.System.out;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Users user = new Users();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch country list
        List<Countries> entryList = GetCountriesDAO.getAllCountries();
        request.setAttribute("countriesList", entryList);
        request.getRequestDispatcher("signUp.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int i = 0;
        try{
            i = SignUpDAO.SignUpDAO(request);
        }catch(Exception e){
            response.sendRedirect("error.jsp");
            throw new RuntimeException(e);
        }
        if(i>0){
            response.sendRedirect("/PopularDestinationsServlet");
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.setAttribute("username", user.username);
                session.setAttribute("admin_role", user.admin_role);
            }
        }
    }
}
