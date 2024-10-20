package org.example.touristastravelagency_v0.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.touristastravelagency_v0.DatabaseManager;
import org.example.touristastravelagency_v0.ShowAllDAO;
import java.sql.ResultSet;
import org.example.touristastravelagency_v0.models.Destinations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet(name = "ShowAllServlet", value = "/ShowAllServlet")
public class  ShowAllServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ShowAllDAO showAllDAO;

    public void init() {
        showAllDAO = new ShowAllDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        try{
            ResultSet rs = showAllDAO.ShowAllDestinations();
            List<Map<String, String>> alldestinations = new ArrayList<>();
            while (rs.next()) {
                Map<String, String> destination = new HashMap<>();
                destination.put("D_id", String.valueOf(rs.getInt("D_id")));
                destination.put("DestinationName", rs.getString("DestinationName"));
                destination.put("Image", rs.getString("Image"));
                destination.put("CountryName", rs.getString("CountryName"));
                destination.put("freq", rs.getString("freq"));
                alldestinations.add(destination);
            }
            request.setAttribute("alldestinations", alldestinations);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/showAll.jsp");
            dispatcher.forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
