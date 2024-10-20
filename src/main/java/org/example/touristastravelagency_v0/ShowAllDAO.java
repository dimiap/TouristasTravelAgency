package org.example.touristastravelagency_v0;

import org.example.touristastravelagency_v0.models.Destinations;

import java.sql.*;

public class ShowAllDAO {
    public ResultSet ShowAllDestinations() throws SQLException {
        DatabaseManager dm = new DatabaseManager();
        Destinations dest = new Destinations();
        Connection con = dm.getConnection();
        PreparedStatement ps = con.prepareStatement(dest.allDestinations());
        return ps.executeQuery();
    }
}
