package org.example.touristastravelagency_v0;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.touristastravelagency_v0.models.Bookings;
import org.example.touristastravelagency_v0.models.Destinations;

import javax.print.attribute.standard.Destination;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PopularDestinationsDAO {
    public static List<Destinations> getPopularDestinations(HttpServletRequest request) {
        List<Destinations> destinationsList = new ArrayList<>();
        Destinations destinations = new Destinations();
        try{
            Connection connection = DatabaseManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(destinations.popularDestinations());
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Destinations dest = new Destinations();
                dest.setDestinationID(resultSet.getInt("id"));
                dest.setD_name(resultSet.getString("DestinationName"));
                dest.setImage(resultSet.getString("image"));
                dest.setFreq(resultSet.getInt("freq"));
                destinationsList.add(dest);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return destinationsList;
    }
}