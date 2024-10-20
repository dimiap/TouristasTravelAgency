package org.example.touristastravelagency_v0.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.touristastravelagency_v0.AdvancedSearchDAO;
import org.example.touristastravelagency_v0.GetCountriesDAO;
import org.example.touristastravelagency_v0.SignUpDAO;
import org.example.touristastravelagency_v0.models.Countries;
import org.example.touristastravelagency_v0.models.Destinations;
import org.example.touristastravelagency_v0.models.Users;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/AdvancedSearchServlet")
public class AdvancedSearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Users user = new Users();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch country list
        String countryId = request.getParameter("id_country");
        float maxPrice = Float.parseFloat(request.getParameter("price"));
        String startDate = request.getParameter("startDate");
        List<Map<String, String>> searchResults = AdvancedSearchDAO.AdvancedSearchDAO(countryId, maxPrice,startDate);
        request.setAttribute("searchResults", searchResults);
        RequestDispatcher dispatcher = request.getRequestDispatcher("search_results.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
