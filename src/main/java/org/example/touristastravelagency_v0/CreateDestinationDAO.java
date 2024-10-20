package org.example.touristastravelagency_v0;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import org.example.touristastravelagency_v0.models.Destinations;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CreateDestinationDAO {
    public static Integer CreateDestinationDAO(String d_name,String d_description, Integer id_country, String attractions, String imageName, Integer freq) {
        Destinations destinations = new Destinations();
        int destinationId = 0;
        try {
            Connection connection = DatabaseManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(destinations.CreateDestination(),PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, d_name);
            statement.setString(2, d_description);
            statement.setInt(3, id_country);
            statement.setString(4, attractions);
            statement.setString(5, imageName);
            statement.setInt(6, freq);
            statement.executeUpdate();
            var rs = statement.getGeneratedKeys();
            if (rs.next()) {
                destinationId = (rs.getInt(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return destinationId;
    }
    public static int[] CreateTravelPackagesDAO(HttpServletRequest request,Integer destinationId) {
        Destinations destinations = new Destinations();
        String[] prices = request.getParameterValues("price");
        String[] durations = request.getParameterValues("duration");
        String[] startDates = request.getParameterValues("startDate");
        String[] endDates = request.getParameterValues("endDate");
        List<Destinations> travelPackagesList = new ArrayList<>();
        for (int i = 0; i < prices.length; i++) {
            Destinations travelPackage = new Destinations();
            travelPackage.setDestinationID(destinationId);
            travelPackage.setPrice(Float.parseFloat(prices[i]));
            travelPackage.setDuration(Integer.parseInt(durations[i]));
            travelPackage.setStartDate(Date.valueOf(startDates[i]));
            travelPackage.setEndDate(Date.valueOf(endDates[i]));
            travelPackagesList.add(travelPackage);
        }
        int[] result;
        try {
            Connection connection = DatabaseManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(destinations.CreateTravelPackages());
            for (Destinations travelPackage : travelPackagesList) {
                statement.setInt(1, travelPackage.getDestinationID());
                statement.setFloat(2, travelPackage.getPrice());
                statement.setInt(3, travelPackage.getDuration());
                statement.setDate(4, travelPackage.getStartDate());
                statement.setDate(5, travelPackage.getEndDate());
                statement.addBatch();
            }
            result = statement.executeBatch();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
