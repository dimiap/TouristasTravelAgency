package org.example.touristastravelagency_v0;

import org.example.touristastravelagency_v0.models.Countries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetCountriesDAO {

    public static List<Countries> getAllCountries() {

        List<Countries> arrayList = new ArrayList<>();
        String query = "SELECT id_country, country FROM Countries";

        try (
                Connection connection = DatabaseManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Countries countries = new Countries();
                countries.setIdCountry(resultSet.getInt("id_country"));
                countries.setCountry(resultSet.getString("country"));
                arrayList.add(countries);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return arrayList;
    }
}
