package org.example.touristastravelagency_v0.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.touristastravelagency_v0.GetCountriesDAO;
import org.example.touristastravelagency_v0.SignUpDAO;
import org.example.touristastravelagency_v0.UpdateUserDAO;
import org.example.touristastravelagency_v0.models.Countries;
import org.example.touristastravelagency_v0.models.Users;

import java.io.IOException;
import java.util.List;

@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Users user = new Users();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch country list
        List<Countries> countriesList = GetCountriesDAO.getAllCountries();
        List<Users> usersList = UpdateUserDAO.ShowUserInfo(request);
        request.setAttribute("countriesList", countriesList);
        request.setAttribute("usersList", usersList);
        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int i = 0;
        try{
            i = UpdateUserDAO.UpdateUserDAO(request);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        if(i>0){
            response.sendRedirect("UpdateUserServlet");
        }
    }
}
