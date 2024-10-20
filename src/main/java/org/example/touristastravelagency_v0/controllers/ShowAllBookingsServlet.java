package org.example.touristastravelagency_v0.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.touristastravelagency_v0.models.Bookings;
import org.example.touristastravelagency_v0.showAllBookingsDAO;

import java.io.IOException;
import java.util.List;

@WebServlet("/ShowAllBookingsServlet")
public class ShowAllBookingsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Bookings> bookings = showAllBookingsDAO.getAllBookings();
        request.setAttribute("bookingsList", bookings);
        request.getRequestDispatcher("bookingsAdmin.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
