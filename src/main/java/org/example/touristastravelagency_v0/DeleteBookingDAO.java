package org.example.touristastravelagency_v0;

import org.example.touristastravelagency_v0.models.Bookings;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteBookingDAO {
    public static Integer deleteBooking(Integer deletedBookingID,String username){
        Integer rs = null;
        Bookings booking = new Bookings();
        try{
            Connection connection = DatabaseManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(booking.CancelBooking());
            preparedStatement.setInt(1,deletedBookingID);
            preparedStatement.setString(2,username);
            rs = preparedStatement.executeUpdate();
    } catch(SQLException e){
            e.printStackTrace();
    }
        return rs;
    }
}
