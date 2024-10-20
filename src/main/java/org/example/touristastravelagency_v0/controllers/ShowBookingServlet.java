package org.example.touristastravelagency_v0.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.touristastravelagency_v0.ShowBookingsDAO;
import org.example.touristastravelagency_v0.models.Bookings;

import java.io.IOException;
import java.util.List;

@WebServlet("/ShowBookingServlet")
public class ShowBookingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (username == null) {
            response.sendRedirect("login.jsp");
        } else {
            List<Bookings> bookings = ShowBookingsDAO.getBookingsByUsername(username);
            request.setAttribute("bookingsList", bookings);
            request.getRequestDispatcher("booking.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
