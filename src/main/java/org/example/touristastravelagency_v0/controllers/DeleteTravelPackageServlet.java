package org.example.touristastravelagency_v0.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.touristastravelagency_v0.DeleteTravelPackageDAO;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteTravelPackageServlet", value = "/DeleteTravelPackageServlet")
public class DeleteTravelPackageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        try {
            Integer packageId = Integer.valueOf(request.getParameter("packageID"));
            int cntDeletedTP = DeleteTravelPackageDAO.deleteTravelPackage(packageId);

            if (cntDeletedTP > 0) {
                out.print("{\"success\": true}");
            } else {
                out.print("{\"success\": false, \"message\": \"No package found to delete.\"}");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.print("{\"success\": false, \"message\": \"An error occurred: " + e.getMessage() + "\"}");
        } finally {
            out.flush();
        }
    }
}
