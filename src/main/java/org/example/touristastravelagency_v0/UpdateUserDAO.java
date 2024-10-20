package org.example.touristastravelagency_v0;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.touristastravelagency_v0.models.Destinations;
import org.example.touristastravelagency_v0.models.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UpdateUserDAO {
    public static Integer UpdateUserDAO(HttpServletRequest request) {
        Users user = new Users();
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String password = request.getParameter("pass");
        String u_name = request.getParameter("u_name");
        int idCountry = Integer.parseInt(request.getParameter("id_country"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        Boolean admin_role = false;
        Integer resultSet;
        try {
            Connection connection = DatabaseManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(user.UpdateUser());
            statement.setString(1, password);
            statement.setString(2, u_name);
            statement.setInt(3, idCountry);
            statement.setString(4, phone);
            statement.setString(5, email);
            statement.setBoolean(6, admin_role);
            statement.setString(7, username);
            resultSet = statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }
    public static List<Users> ShowUserInfo (HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        List<Users> usersList = new ArrayList<>();
        PreparedStatement ps = null;
        try {
            Connection conn = DatabaseManager.getConnection();
            Users user = new Users();
            ps = conn.prepareStatement(user.ShowUser());
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Users users = new Users();
                users.setPass(rs.getString("pass"));
                users.setU_name(rs.getString("u_name"));
                users.setId_country(rs.getInt("id_country"));
                users.setPhone(rs.getInt("phone"));
                users.setEmail(rs.getString("email"));
                users.setAdmin_role(rs.getBoolean("admin_role"));
                usersList.add(users);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usersList;
    }
}
