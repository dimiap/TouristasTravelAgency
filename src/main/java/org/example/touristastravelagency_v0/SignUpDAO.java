package org.example.touristastravelagency_v0;

import jakarta.servlet.http.HttpServletRequest;
import org.example.touristastravelagency_v0.models.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignUpDAO {
    public static Integer SignUpDAO(HttpServletRequest request) {
        Users user = new Users();
        String username = request.getParameter("username");
        String password = request.getParameter("pass");
        String uName = request.getParameter("u_name");
        int idCountry = Integer.parseInt(request.getParameter("id_country"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        Boolean admin_role = false;
        Integer resultSet;
        try {
            Connection connection = DatabaseManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(user.SignUpUser());
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, uName);
            statement.setInt(4, idCountry);
            statement.setString(5, phone);
            statement.setString(6, email);
            statement.setBoolean(7, admin_role);
            resultSet = statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }
}
