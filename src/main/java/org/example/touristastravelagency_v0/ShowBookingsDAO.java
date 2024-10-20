package org.example.touristastravelagency_v0;

import org.example.touristastravelagency_v0.models.Bookings;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ShowBookingsDAO {
    public static List<Bookings> getBookingsByUsername(String username) {
        Bookings bookings = new Bookings();
        List<Bookings> bookingsList = new ArrayList<>();
        try{
            Connection connection = DatabaseManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(bookings.ShowBooking());
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Bookings booking = new Bookings();
                booking.setDestinationName(resultSet.getString("DestinationName"));
                booking.setCountry(resultSet.getString("Country"));
                booking.setPrice(resultSet.getFloat("Price"));
                booking.setDuration(resultSet.getInt("Duration"));
                booking.setStartDate(resultSet.getDate("StartDate"));
                booking.setEndDate(resultSet.getDate("EndDate"));
                booking.setBookingID(resultSet.getInt("BookingId"));
                booking.setBookingDate(resultSet.getDate("BookingDate"));
                booking.setBookingStatus(resultSet.getString("BookingStatus"));
                bookingsList.add(booking);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return bookingsList;
    }
}
