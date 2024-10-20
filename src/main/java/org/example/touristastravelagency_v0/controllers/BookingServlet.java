package org.example.touristastravelagency_v0.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.touristastravelagency_v0.BookingsDAO;
import org.example.touristastravelagency_v0.GetCountriesDAO;
import org.example.touristastravelagency_v0.SignUpDAO;
import org.example.touristastravelagency_v0.models.Bookings;
import org.example.touristastravelagency_v0.models.Countries;
import org.example.touristastravelagency_v0.models.Users;

import java.io.IOException;
import java.util.List;


@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Bookings bookings = new Bookings();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (username != null) {
            BookingsDAO.BookingsDAO(username, request);
            response.sendRedirect("ShowBookingServlet");
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
