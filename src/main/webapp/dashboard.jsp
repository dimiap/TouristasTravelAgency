<%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="java.util.*" %>
<%@ page import="org.example.touristastravelagency_v0.models.Users" %>
<%@ page import="org.example.touristastravelagency_v0.models.Countries" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Dashboard</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #66ccff;
            background-image: linear-gradient(45deg, #66ccff, #99ddff);
            font-family: "Roboto", sans-serif;
            -webkit-font-smoothing: antialiased;
            -moz-osx-font-smoothing: grayscale;
        }
        .dashboard-page {
            width: 360px;
            padding: 8% 0 0;
            margin: auto;
        }
        .form {
            position: relative;
            z-index: 1;
            background: #FFFFFF;
            max-width: 360px;
            margin: 0 auto 100px;
            padding: 45px;
            text-align: center;
            box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
        }
        .form input, .form select {
            font-family: "Roboto", sans-serif;
            outline: 0;
            background: #f2f2f2;
            width: 100%;
            border: 0;
            margin: 0 0 15px;
            padding: 15px;
            box-sizing: border-box;
            font-size: 14px;
        }
        .form button {
            font-family: "Roboto", sans-serif;
            text-transform: uppercase;
            outline: 0;
            background-color: #66ccff;
            background-image: linear-gradient(45deg, #66ccff, #99ddff);
            width: 100%;
            border: 0;
            padding: 15px;
            color: #FFFFFF;
            font-size: 14px;
            -webkit-transition: all 0.3 ease;
            transition: all 0.3 ease;
            cursor: pointer;
        }
        .form button:hover {
            background-color: #0056b3;
        }
        .form .message {
            margin: 15px 0 0;
            color: #b3b3b3;
            font-size: 12px;
        }
        .form .message a {
            color: #4CAF50;
            text-decoration: none;
        }
    </style>
</head>
<body>
<%
    String username = (String) session.getAttribute("username");
    List<Users> usersList = (List<Users>) request.getAttribute("usersList");
    Users users = usersList.get(0);
%>
<div class="dashboard-page">
    <div class="form">
        <div class="signup">
            <div class="signup-header">
                <h3> Profile of user <%= username%></h3>
                <p>You can change your data: </p>
            </div>
        </div>
        <form action="UpdateUserServlet" method="post">
            <p>Password</p>
            <input type="password" name="pass" placeholder="Password" value="<%= users.getPass() %>" required />
            <p>Name</p>
            <input type="text" name="u_name" placeholder="Name" value="<%= users.getU_name() %>" required />
            <p>Country</p>
            <select name="id_country" required class="select-field">
                <%
                    List<Countries> countries = (List<Countries>) request.getAttribute("countriesList");
                    int userCountryId = users.getId_country();
                    if (countries != null) {
                        for (Countries country : countries) {
                            boolean isSelected = (country.getIdCountry() == userCountryId);
                %>
                <option value="<%= country.getIdCountry() %>" <%= isSelected ? "selected" : "" %>><%= country.getCountry() %></option>
                <%
                        }
                    }
                %>
            </select>
            <p>Phone Number</p>
            <input type="text" name="phone" placeholder="Phone" value="<%= users.getPhone() %>" required />
            <p>Email</p>
            <input type="email" name="email" placeholder="Email" value="<%= users.getEmail() %>" required />
            <button type="submit">Change</button>
        </form>
        <div class="message">
            <a href="ShowBookingServlet">My bookings</a>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
