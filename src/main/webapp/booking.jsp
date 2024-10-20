<%@ page import="org.example.touristastravelagency_v0.models.Bookings" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.touristastravelagency_v0.models.Bookings" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bookings</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: "Roboto", sans-serif;
        }
        .container {
            margin-top: 50px;
        }
        .table thead th {
            background-color: #66ccff;
            color: #fff;
        }
    </style>
</head>
<body>
<div class="container">
    <h1 class="my-4 text-center">My Bookings</h1>
    <%
        List<Bookings> bookings = (List<Bookings>) request.getAttribute("bookingsList");
        if (bookings != null && !bookings.isEmpty()) {
    %>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Destination</th>
            <th>Country</th>
            <th>Price</th>
            <th>Duration</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Booking Date</th>
            <th>Booking Status</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (Bookings booking : bookings) {
        %>
        <tr>
            <td><%= booking.getDestinationName() %></td>
            <td><%= booking.getCountry() %></td>
            <td><%= booking.getPrice() %></td>
            <td><%= booking.getDuration() %> μέρες </td>
            <td><%= booking.getStartDate() %></td>
            <td><%= booking.getEndDate() %></td>
            <td><%= booking.getBookingDate() %></td>
            <td><%= booking.getBookingStatus() %></td>
            <td>
                <% Integer bookingId= booking.getBookingID();%>
                <form action="DeleteBookingServlet" method="post" onsubmit="return confirm('Are you sure?');">
                    <input type="hidden" name="bookingId" value="<%= bookingId %>"/>
                    <button type="submit" class="btn btn-danger">Cancel</button>
                </form>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <%
    } else {
    %>
    <div class="alert alert-info" role="alert">
        No bookings.
    </div>
    <%
        }
    %>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
