package org.example.touristastravelagency_v0.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.touristastravelagency_v0.DeleteBookingDAO;

import java.io.IOException;

@WebServlet(name = "DeleteBookingServlet", value = "/DeleteBookingServlet")
public class DeleteBookingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer bookingId = Integer.valueOf(request.getParameter("bookingId"));
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        int cntDeleted = DeleteBookingDAO.deleteBooking(bookingId,username);
        if(cntDeleted > 0){
            response.sendRedirect("/PopularDestinationsServlet");
        }else{
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}
