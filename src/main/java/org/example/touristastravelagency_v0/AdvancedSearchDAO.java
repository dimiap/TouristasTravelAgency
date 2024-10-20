package org.example.touristastravelagency_v0;

import org.example.touristastravelagency_v0.models.Destinations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdvancedSearchDAO {
    public static List<Map<String, String>> AdvancedSearchDAO (String countryId, float price,String startDate) {
        List<Map<String, String>> results = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            Connection connection = DatabaseManager.getConnection();
            Destinations dest = new Destinations();
            PreparedStatement st = connection.prepareStatement(dest.AdvancedSearch());
            st.setString(1, countryId);
            st.setFloat(2, price);
            st.setString(3, startDate);
            rs = st.executeQuery();

            while (rs.next()) {
                Map<String, String> d = new HashMap<>();
                d.put("D_id", String.valueOf(rs.getInt(1)));
                d.put("DestinationName", rs.getString(2));
                d.put("Image", rs.getString(3));
                d.put("CountryName", rs.getString(4));
                d.put("freq", rs.getString(5));
                results.add(d);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return results;
    }
}
