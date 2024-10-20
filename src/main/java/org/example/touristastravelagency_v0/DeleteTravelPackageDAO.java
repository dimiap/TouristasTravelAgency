package org.example.touristastravelagency_v0;

import org.example.touristastravelagency_v0.models.Bookings;
import org.example.touristastravelagency_v0.models.Destinations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteTravelPackageDAO {
    public static Integer deleteTravelPackage(Integer deletedPackageID){
        Integer rs = null;
        Destinations destinations = new Destinations();
        try{
            Connection connection = DatabaseManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(destinations.DeleteTravelPackages());
            preparedStatement.setInt(1,deletedPackageID);
            rs = preparedStatement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
    public static Integer deleteAllTravelPackage(Integer deletedDestinationID){
        Integer rs = null;
        Destinations destinations = new Destinations();
        try{
            Connection connection = DatabaseManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(destinations.DeleteAllTravelPackages());
            preparedStatement.setInt(1,deletedDestinationID);
            rs = preparedStatement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
    public static Integer deleteDestination(Integer deletedDestinationID){
        Integer rs = null;
        Destinations destinations = new Destinations();
        try{
            Connection connection = DatabaseManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(destinations.DeleteDestination());
            preparedStatement.setInt(1,deletedDestinationID);
            rs = preparedStatement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
}
