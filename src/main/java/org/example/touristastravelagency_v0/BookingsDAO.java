package org.example.touristastravelagency_v0;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.touristastravelagency_v0.models.Bookings;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.Calendar;

public class BookingsDAO extends HttpServlet {
    public static Integer BookingsDAO(String username,HttpServletRequest request) {
        Bookings bookings = new Bookings();
        Integer PackageID = Integer.valueOf(request.getParameter("packageId"));
        Date BookingDate = new Date(Calendar.getInstance().getTimeInMillis());
        String BookingStatus = "pending";
        Integer i = null;
        try {
            Connection connection = DatabaseManager.getConnection();
            PreparedStatement st = connection.prepareStatement(bookings.CreateBooking());
            st.setString(1, username);
            st.setInt(2, PackageID);
            st.setDate(3, BookingDate);
            st.setString(4, BookingStatus);
            i = st.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
}
