package org.example.touristastravelagency_v0;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.touristastravelagency_v0.models.Countries;
import org.example.touristastravelagency_v0.models.Destinations;
import org.example.touristastravelagency_v0.models.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShowDestInfoDAO {
    public static List<Destinations> ShowDestInfoDAO(String  id) throws SQLException {
        PreparedStatement ps;
        List<Destinations> destinationsList = new ArrayList<>();

        try {
            Connection conn = DatabaseManager.getConnection();
            Destinations dest = new Destinations();
            ps = conn.prepareStatement(dest.showDestInfo());
            ps.setInt(1, Integer.parseInt(id));
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Destinations destinations = new Destinations();
                destinations.setDestinationID(rs.getInt("id"));
                destinations.setD_name(rs.getString("DestinationName"));
                destinations.setD_description(rs.getString("TripDescription"));
                destinations.setAttractions(rs.getString("Attractions"));
                destinations.setImage(rs.getString("Image"));
                destinations.setFreq(rs.getInt("Freq"));
                destinations.setPackageID(rs.getInt("PackageID"));
                destinations.setPrice(rs.getFloat("TripPrice"));
                destinations.setDuration(rs.getInt("TripDuration"));
                destinations.setStartDate(rs.getDate("TripStart"));
                destinations.setEndDate(rs.getDate("TripEnd"));
                destinations.setId_country(rs.getInt("CountryID"));
                destinations.setCountryName(rs.getString("Country"));
                destinationsList.add(destinations);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return destinationsList;
    }
    public static Integer UpdateFreq(String id) throws SQLException {
        Destinations destinations = new Destinations();
        PreparedStatement statement;
        try {
            Connection connection = DatabaseManager.getConnection();
            statement = connection.prepareStatement(destinations.updateFreq());
            statement.setInt(1, Integer.parseInt(id));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return statement.executeUpdate();
    }
}
