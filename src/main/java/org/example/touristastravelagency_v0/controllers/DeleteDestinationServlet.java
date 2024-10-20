package org.example.touristastravelagency_v0.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.touristastravelagency_v0.DeleteTravelPackageDAO;

import java.io.IOException;

@WebServlet(name = "DeleteDestinationServlet", value = "/DeleteDestinationServlet")
public class DeleteDestinationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer destinationID = Integer.valueOf(request.getParameter("destinationID"));
        int cntDeletedTP = DeleteTravelPackageDAO.deleteAllTravelPackage(destinationID);
        if (cntDeletedTP > 0) {
            int cntDeletedDes = DeleteTravelPackageDAO.deleteDestination(destinationID);
            if (cntDeletedDes > 0) {
                response.sendRedirect("/adminDashboard.jsp");
            }else{
                response.sendRedirect(request.getContextPath() + "/error.jsp");
            }
        }
    }
}
