package org.example.touristastravelagency_v0;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.touristastravelagency_v0.models.Bookings;
import org.example.touristastravelagency_v0.models.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChangeBookingStatusDAO {
    public static Integer ChangeBookingStatusDAO(HttpServletRequest request) {
        Bookings bookings = new Bookings();
        int bookingID = Integer.parseInt(request.getParameter("bookingId"));
        String status = request.getParameter("bookingStatus");
        Integer resultSet;
        try {
            Connection connection = DatabaseManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(bookings.ChangeStatusBooking());
            statement.setString(1, status);
            statement.setInt(2, bookingID);
            resultSet = statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }
}

