package org.example.touristastravelagency_v0;

import com.mysql.cj.conf.ConnectionUrlParser;
import org.example.touristastravelagency_v0.models.Countries;
import org.example.touristastravelagency_v0.models.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LoginDAO {
    public static ConnectionUrlParser.Pair<Boolean,Boolean> LoginDAO (String username, String password){
        Users user = new Users();
        Boolean result = false;
        Boolean userRole =user.admin_role;
        try {
                Connection connection = DatabaseManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(user.LoginUser());
                statement.setString(1,username);
                statement.setString(2,password);
                ResultSet resultSet = statement.executeQuery();
                if(resultSet.next()){
                    userRole = resultSet.getBoolean("admin_role");
                    result = true;
                }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new ConnectionUrlParser.Pair<>(result, userRole);
    }
}
