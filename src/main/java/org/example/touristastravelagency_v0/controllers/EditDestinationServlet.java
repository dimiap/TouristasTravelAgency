package org.example.touristastravelagency_v0.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.example.touristastravelagency_v0.*;
import org.example.touristastravelagency_v0.models.Countries;
import org.example.touristastravelagency_v0.models.Destinations;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@WebServlet(name = "EditDestinationServlet", value = "/EditDestinationServlet")
@MultipartConfig
public class EditDestinationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("destinationID");
        if (id == null || id.isEmpty()) {
            response.sendRedirect("error.jsp");
        } else {
            try {
                List<Destinations> destinationsList = ShowDestInfoDAO.ShowDestInfoDAO(id);
                request.setAttribute("destinationsList", destinationsList);
                List<Countries> entryList = GetCountriesDAO.getAllCountries();
                request.setAttribute("countriesList", entryList);
                request.getRequestDispatcher("editDestination.jsp").forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new ServletException(e);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer destinationID = Integer.valueOf(request.getParameter("destinationID"));
        String d_name = request.getParameter("d_name");
        String d_description = request.getParameter("d_description");
        int id_country = Integer.parseInt(request.getParameter("id_country"));
        String attractions = request.getParameter("attractions");
        String imageName = request.getParameter("imageName");
        Part imagePart = request.getPart("image");
        if (imagePart != null && imagePart.getSize() > 0) {
            imageName = imagePart.getSubmittedFileName();
            String uploadPath = getServletContext().getRealPath("");
            imagePart.write(uploadPath + "/" + imageName);
        }
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            if (paramName.startsWith("deletePackage_")) {
                String packageIDStr = paramName.substring("deletePackage_".length());
                try {
                    Integer packageID = Integer.valueOf(packageIDStr);
                    String deleteFlag = request.getParameter(paramName);
                    if ("true".equals(deleteFlag)) {
                        DeleteTravelPackageDAO.deleteTravelPackage(packageID);
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }
            EditDestinationDAO.EditDestinationDAO(destinationID, d_name, d_description, id_country, attractions, imageName);
            List<Destinations> updatedPackages = new ArrayList<>();
            List<Destinations> newPackages = new ArrayList<>();
            parameterNames = request.getParameterNames();
            while (parameterNames.hasMoreElements()) {
                String paramName = parameterNames.nextElement();
                if (paramName.startsWith("price_") && !paramName.equals("price_new")) {
                    String packageIDStr = paramName.substring("price_".length());
                    Integer packageID = Integer.valueOf(packageIDStr);
                    float price = Float.parseFloat(request.getParameter("price_" + packageIDStr));
                    int duration = Integer.parseInt(request.getParameter("duration_" + packageIDStr));
                    Date startDate = Date.valueOf(request.getParameter("startDate_" + packageIDStr));
                    Date endDate = Date.valueOf(request.getParameter("endDate_" + packageIDStr));
                    Destinations travelPackage = new Destinations();
                    travelPackage.setPackageID(packageID);
                    travelPackage.setPrice(price);
                    travelPackage.setDuration(duration);
                    travelPackage.setStartDate(startDate);
                    travelPackage.setEndDate(endDate);
                    updatedPackages.add(travelPackage);
                } else if (paramName.equals("price_new")) {
                    float price = Float.parseFloat(request.getParameter("price_new"));
                    int duration = Integer.parseInt(request.getParameter("duration_new"));
                    Date startDate = Date.valueOf(request.getParameter("startDate_new"));
                    Date endDate = Date.valueOf(request.getParameter("endDate_new"));
                    Destinations travelPackage = new Destinations();
                    travelPackage.setPrice(price);
                    travelPackage.setDuration(duration);
                    travelPackage.setStartDate(startDate);
                    travelPackage.setEndDate(endDate);
                    newPackages.add(travelPackage);
            }
        }
            EditDestinationDAO.EditTravelPackagesDAO(updatedPackages);
            EditDestinationDAO.AddTravelPackagesDAO(newPackages,destinationID);
            response.sendRedirect("/adminDashboard.jsp");
    }
}

