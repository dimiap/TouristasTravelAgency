package org.example.touristastravelagency_v0;

import jakarta.servlet.http.HttpServletRequest;
import org.example.touristastravelagency_v0.models.Destinations;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EditDestinationDAO {
    public static Integer EditDestinationDAO(Integer destinationId,String d_name,String d_description, Integer id_country, String attractions, String imageName) {
        Destinations destinations = new Destinations();
        try {
            Connection connection = DatabaseManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(destinations.EditDestination());
            statement.setString(1, d_name);
            statement.setString(2, d_description);
            statement.setInt(3, id_country);
            statement.setString(4, attractions);
            statement.setString(5, imageName);
            statement.setInt(6, destinationId);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return destinationId;
    }
    public static void EditTravelPackagesDAO(List<Destinations> travelPackages) {
        Destinations destinations = new Destinations();
        try {
            Connection connection = DatabaseManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(destinations.EditTravelPackages());
            for (Destinations travelPackage : travelPackages) {
                statement.setFloat(1, travelPackage.getPrice());
                statement.setInt(2, travelPackage.getDuration());
                statement.setDate(3, travelPackage.getStartDate());
                statement.setDate(4, travelPackage.getEndDate());
                statement.setInt(5, travelPackage.getPackageID());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void AddTravelPackagesDAO(List<Destinations> travelPackages,Integer destinationID) {
        Destinations destinations = new Destinations();
        try {
            Connection connection = DatabaseManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(destinations.AddTravelPackage());
            for (Destinations travelPackage : travelPackages) {
                statement.setInt(1, destinationID);
                statement.setFloat(2, travelPackage.getPrice());
                statement.setInt(3, travelPackage.getDuration());
                statement.setDate(4, travelPackage.getStartDate());
                statement.setDate(5, travelPackage.getEndDate());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
