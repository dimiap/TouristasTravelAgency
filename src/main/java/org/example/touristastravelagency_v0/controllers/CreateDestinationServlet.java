package org.example.touristastravelagency_v0.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.example.touristastravelagency_v0.CreateDestinationDAO;
import org.example.touristastravelagency_v0.GetCountriesDAO;
import org.example.touristastravelagency_v0.models.Countries;
import org.example.touristastravelagency_v0.models.Destinations;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CreateDestinationServlet", value = "/CreateDestinationServlet")
@MultipartConfig
public class  CreateDestinationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch country list
        List<Countries> countriesList = GetCountriesDAO.getAllCountries();
        request.setAttribute("countriesList", countriesList);
        request.getRequestDispatcher("createDestination.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String d_name = request.getParameter("d_name");
        String d_description = request.getParameter("d_description");
        int id_country = Integer.parseInt(request.getParameter("id_country"));
        String attractions = request.getParameter("attractions");
        Part imagePart = request.getPart("image");
        String imageName = imagePart.getSubmittedFileName();
        int freq = 0;
        if (imagePart != null && imagePart.getSize() > 0) {
            String uploadPath = getServletContext().getRealPath("");
            imagePart.write(uploadPath + "/" + imageName);
        }
        int destinationID =  CreateDestinationDAO.CreateDestinationDAO(d_name,d_description,id_country,attractions,imageName,freq);
        int [] i =CreateDestinationDAO.CreateTravelPackagesDAO(request,destinationID);
        if(!(i.length == 0)){
            response.sendRedirect("adminDashboard.jsp");
        } else{
            response.sendRedirect("error.jsp");
        }
    }
}
