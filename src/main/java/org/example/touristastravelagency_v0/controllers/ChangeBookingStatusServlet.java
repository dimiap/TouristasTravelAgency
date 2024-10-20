package org.example.touristastravelagency_v0.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.touristastravelagency_v0.ChangeBookingStatusDAO;
import org.example.touristastravelagency_v0.GetCountriesDAO;
import org.example.touristastravelagency_v0.UpdateUserDAO;
import org.example.touristastravelagency_v0.models.Countries;
import org.example.touristastravelagency_v0.models.Users;

import java.io.IOException;
import java.util.List;

@WebServlet("/ChangeBookingStatusServlet")
public class ChangeBookingStatusServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Users user = new Users();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int i = 0;
        try{
            i = ChangeBookingStatusDAO.ChangeBookingStatusDAO(request);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        if(i>0){
            response.sendRedirect("ShowAllBookingsServlet");
        }
    }
}
