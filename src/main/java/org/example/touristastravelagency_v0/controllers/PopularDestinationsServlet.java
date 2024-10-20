package org.example.touristastravelagency_v0.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.touristastravelagency_v0.GetCountriesDAO;
import org.example.touristastravelagency_v0.PopularDestinationsDAO;
import org.example.touristastravelagency_v0.models.Countries;
import org.example.touristastravelagency_v0.models.Destinations;

import javax.print.attribute.standard.Destination;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "PopularDestinationsServlet", value = "/PopularDestinationsServlet")
public class PopularDestinationsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Destinations> popularDestinations = PopularDestinationsDAO.getPopularDestinations(request);
        List<Countries> countriesList = GetCountriesDAO.getAllCountries();
        request.setAttribute("countriesList", countriesList);
        request.setAttribute("popularDestinations", popularDestinations);
        RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
        rd.forward(request, response);
    }
}
