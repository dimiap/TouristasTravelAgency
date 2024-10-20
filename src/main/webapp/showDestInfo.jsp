<%@ page import="java.sql.ResultSet" %>
<%@ page import="org.example.touristastravelagency_v0.models.Destinations" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Details</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #66ccff;
            background-image: linear-gradient(45deg, #66ccff, #99ddff);
            font-family: "Roboto", sans-serif;
            -webkit-font-smoothing: antialiased;
            -moz-osx-font-smoothing: grayscale;
        }
        .container {
            margin-top: 50px;
            max-width: 800px;
            background: #fff;
            padding: 30px;
            box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
            border-radius: 10px;
        }
        .destination-box {
            text-align: center;
        }
        .destination-box img {
            width: 100%;
            height: auto;
            border-radius: 10px;
        }
        .destination-details {
            margin-top: 20px;
        }
        .package {
            border: 1px solid #dee2e6;
            padding: 15px;
            margin-bottom: 20px;
            border-radius: 10px;
            background-color: #f8f9fa;
        }
        .package h4 {
            margin-bottom: 15px;
        }
    </style>
</head>
<body>
<%
    List<Destinations> destinations = (List<Destinations>) request.getAttribute("destinationsList");
    Destinations destination = destinations.getFirst();
%>
<div class="container">
    <h1 class="my-4 text-center">Destination</h1>
    <div class="destination-box">
        <img src="<%= destination.getImage() %>" alt="<%= destination.getD_name() %>" class="img-fluid"/>
        <div class="destination-details mt-4">
            <h2><%= destination.getD_name() %></h2>
            <p><%= destination.getD_description() %></p>
            <p>Country: <%= destination.getCountryName() %></p>
            <input type="hidden" name="packageId" value="<%= destination.getId_country() %>" />
            <h4>Attractions</h4>
            <ul>
                <%
                    String attractions = destination.getAttractions();
                    if (attractions != null) {
                        String[] attractionsList = attractions.split(",");
                        for (String attraction : attractionsList) {
                %>
                <li><%= attraction.trim() %></li>
                <%
                        }
                    }
                %>
            </ul>
            <input type="hidden" id="Freq" name="Freq" value="<%= request.getAttribute("freq") %>">
            <h4 class="mt-4">Packages</h4>
            <%
                List<Destinations> destinationsList = (List<Destinations>) request.getAttribute("destinationsList");
                if (destinationsList != null) {
                    for (Destinations dest : destinationsList) {
            %>
            <div class="package">
                <h4>Package <%= dest.getPackageID() %></h4>
                <p>Price: <%= dest.getPrice() %></p>
                <p>Duration: <%= dest.getDuration() %> days</p>
                <p>Start Date: <%= dest.getStartDate() %></p>
                <p>End Date: <%= dest.getEndDate() %></p>
                <% if(session.getAttribute("admin_role") == "false" || session.getAttribute("admin_role") == null) { %>
                <form action="BookingServlet" method="post">
                    <input type="hidden" name="packageId" value="<%= dest.getPackageID() %>" />
                    <button type="submit" class="btn btn-primary">Book</button>
                </form>
                <% } %>
            </div>
            <%
                    }
                }
            %>
            <% if(session.getAttribute("admin_role") == "true") { %>
            <div>
                <form action="EditDestinationServlet" method="get">
                    <input type="hidden" name="destinationID" value="<%= destination.getDestinationID() %>" />
                    <button type="submit" class="btn btn-primary">Edit</button>
                </form>
                <form action="DeleteDestinationServlet" method="post">
                    <input type="hidden" name="destinationID" value="<%= destination.getDestinationID() %>" />
                    <button type="submit" class="btn btn-danger">Delete</button>
                </form>
            </div>
            <% } %>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
