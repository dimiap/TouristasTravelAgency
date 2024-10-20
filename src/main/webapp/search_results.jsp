<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.touristastravelagency_v0.models.Destinations" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All destinations</title>
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
            max-width: 1000px;
            background: #fff;
            padding: 30px;
            box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
            border-radius: 10px;
        }
        .destinations-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
        }
        .destination-box {
            background: #fff;
            border: 1px solid #ddd;
            border-radius: 10px;
            margin: 15px;
            padding: 15px;
            max-width: 300px;
            text-align: center;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .destination-box img {
            max-width: 100%;
            border-radius: 10px;
        }
        .destination-box a {
            display: block;
            font-size: 18px;
            color: #007bff;
            text-decoration: none;
            margin-top: 10px;
        }
        .destination-box a:hover {
            text-decoration: underline;
        }
        .destination-box div {
            font-size: 16px;
            color: #333;
            margin-top: 5px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1 class="text-center">All destinations</h1>
    <div class="destinations-container">
        <%
            List<Map<String, String>> destinations = (List<Map<String, String>>) request.getAttribute("searchResults");
            if (destinations != null) {
                for (Map<String, String> destination : destinations) {
                    destination.get(0);
                    String destinationID = destination.get("D_id");
                    String destinationName = destination.get("DestinationName");
                    String image = destination.get("Image");
                    String countryName = destination.get("CountryName");
                    Integer freq = Integer.valueOf(destination.get("freq"));
        %>
        <div class="destination-box">
            <img src="<%= image %>" alt="<%= destinationName %>"/>
            <form id="destInfoForm<%= destinationID %>" action="ShowDestInfoServlet" method="get">
                <input type="hidden" name="freq" value="<%= freq %>"/>
                <input type="hidden" name="destinationID" value="<%= destinationID %>"/>
            </form>
            <a href="javascript:void(0);" class="country-link" onclick="submitForm('destInfoForm<%= destinationID %>');">
                <%= destinationName %>
            </a>
            <div>Χώρα: <%= countryName %></div>
        </div>
        <%
            }
        } else {
        %>
        <div class="text-center">
            <p>No destinations found</p>
        </div>
        <%
            }
        %>
    </div>
</div>
<script type="text/javascript">
    function submitForm(formId) {
        document.getElementById(formId).submit();
    }
</script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
