package org.example.touristastravelagency_v0.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.touristastravelagency_v0.ShowDestInfoDAO;
import org.example.touristastravelagency_v0.models.Destinations;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ShowDestInfoServlet", value = "/ShowDestInfoServlet")
public class ShowDestInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("destinationID");
        if (id == null || id.isEmpty()) {
            response.sendRedirect("error.jsp");
            return;
        }
        try {
            int updatefreq = ShowDestInfoDAO.UpdateFreq(id);
            List<Destinations> destinationsList = ShowDestInfoDAO.ShowDestInfoDAO(id);
            request.setAttribute("destinationsList", destinationsList);
            request.setAttribute("freq", updatefreq);
            request.getRequestDispatcher("showDestInfo.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
