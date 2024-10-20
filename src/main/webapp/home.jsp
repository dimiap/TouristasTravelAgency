<%@ page import="java.util.List" %>
<%@ page import="org.example.touristastravelagency_v0.models.Countries" %>
<%@ page import="org.example.touristastravelagency_v0.models.Destinations" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <title>Touristas Travel Agency</title>
    <style>
        .search-form {
            background: #f8f9fa;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            margin-bottom: 50px;
        }
        .search-form input, .search-form select {
            margin-bottom: 15px;
        }
        .search-form .btn-primary {
            background-color: #31a9f0;
            border-color: #31a9f0;
        }
        .advanced {
            text-decoration: none;
            font-size: 15px;
            font-weight: 500;
            color: #31a9f0 !important;
        }
        .collapse.in {
            display: block;
        }
        body {
            margin: 0;
            padding: 0;
        }
        a {
            text-decoration: none;
            color: black;
        }
        a:hover {
            color: #595959;
        }
        header {
            padding: 0 25px 0 25px;
            box-shadow: #00000040 0 0 20px 0;
            position: sticky;
            top: 0;
            background: white;
        }
        .home-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .header-logo img {
            width: 70px;
        }
        .headerlink1, .headerlink2, .headerlink3, .headerlink4 {
            margin-right: 18px;
            font-size: 20px;
        }
        .headerlink1:hover, .headerlink2:hover, .headerlink3:hover, .headerlink4:hover {
            color: #2a6fb5;
        }
        .header-login {
            font-size: 20px;
            border-radius: 100px;
            color: white;
            background: #31a9f0;
            padding: 8px 17px;
        }
        .header-signup {
            font-size: 20px;
            border-radius: 100px;
            color: white;
            background: #04AA6D;
            padding: 8px 17px;
        }
        .home-sct1-wrapper {
            background-image: url("https://www.westjet.com/content/dam/westjet/images/airports/interiors/210712-family-at-airport-1152x250.jpg");
            background-size: cover;
        }
        .home-sct1 {
            max-width: 1600px;
            margin: auto;
            padding: 100px 100px 120px;
            background: #0000006e;
            color: white;
        }
        .home-sct1 h2 {
            font-weight: normal;
            color: #dadada;
        }
        .home-services {
            display: flex;
            justify-content: space-evenly;
            font-size: 20.5px;
            background: #cceeff;
            margin-bottom: -150px;
            margin-top: 90px;
            border-radius: 100px;
            text-align: center;
        }
        .servicelink1 {
            padding: 30px 0;
        }
        .home-sct2-wrapper {
            padding: 70px 100px 250px;
        }
        footer {
            background: black;
        }
        .home-footer {
            max-width: 1600px;
            margin: auto;
            color: white;
            padding: 50px 100px;
        }
        .footerlink1, .footerlink2, .footerlink3, .footerlink4 {
            margin-right: 18px;
            font-size: 20px;
            color: #e4e4e4;
        }
        .footerlink1:hover, .footerlink2:hover, .footerlink3:hover, .footerlink4:hover {
            color: white;
        }
    </style>
</head>
<body>
<header class="bg-light">
    <div class="home-header">
        <div class="header-logo">
            <a class="navbar-brand" href="PopularDestinationsServlet">
                <img src="Touristas.png" width="60" height="60">
            </a>
        </div>
        <div class="nav-links">
            <a class="headerlink4" href="contact.jsp">About us</a>
        </div>
        <% if(session.getAttribute("username") == null){ %>
        <a class="dashboard" href="login.jsp"><div class="header-login"> Sign In </div></a>
        <a class="dashboard" href="SignUpServlet"><div class="header-signup"> Sign Up </div></a>
        <%} else if (session.getAttribute("admin_role") == "false"){%>
        <div>
            <a class="dashboard" href="UpdateUserServlet"><div class="header-login"> Profile </div></a>
        </div>
        <%} else {%>
        <div>
            <a class="dashboard" href="adminDashboard.jsp"><div class="header-login"> Profile </div></a>
        </div>
        <%}%>
    </div>
</header>
<div class="home-sct1-wrapper">
    <div class="home-sct1">
        <div style="text-align: center">
            <h1> Touristas Travel Agency </h1>
            <h2> Travel like a </h2>
            <i> <h2 style="color: #66ccff"> Touristas </h2> </i>
        </div>
        <div class="home-services">
            <a class="servicelink1" href="ShowAllServlet"> All Packages </a>
        </div>
    </div>
</div>

<div class="container-fluid destination py-5">
    <div class="container py-5">
        <div class="search-form">
            <form action="AdvancedSearchServlet" method="get">
                <div class="row">
                    <div class="col-md-3">
                        <label for="id_country" class="form-label">Country</label>
                        <select class="form-select" id="id_country" name="id_country" required>
                            <option value="">Choose Country</option>
                            <%
                                List<Countries> countries = (List<Countries>) request.getAttribute("countriesList");
                                if (countries != null) {
                                    for (Countries country : countries) {
                            %>
                            <option value="<%= country.getIdCountry() %>"><%= country.getCountry() %></option>
                            <%
                                    }
                                }
                            %>
                        </select>
                    </div>
                    <div class="col-md-2">
                        <label for="price" class="form-label">Max Price</label>
                        <input type="number" class="form-control" id="price" name="price" placeholder="Max Price">
                    </div>
                    <div class="col-md-3">
                        <label for="startDate" class="form-label">Start Date</label>
                        <input type="date" class="form-control" id="startDate" name="startDate">
                    </div>
                    <div class="col-md-1 align-self-end">
                        <button type="submit" class="btn btn-primary">Search</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="mx-auto text-center mb-5" style="max-width: 900px;">
            <h5 class="section-title px-3">Destinations</h5>
            <h1 class="mb-0">Popular Destinations</h1>
        </div>
        <div class="tab-class text-center">
            <div class="tab-content">
                <div id="tab-1" class="tab-pane fade show p-0 active">
                    <div class="row g-4">
                        <%
                            List<Destinations> destinationsList = (List<Destinations>) request.getAttribute("popularDestinations");
                            if (destinationsList != null) {
                                for (Destinations destinations: destinationsList) {
                        %>
                        <div class="col-md-4">
                            <div class="card">
                                <img src="<%= destinations.getImage() %>" class="card-img-top" alt="<%= destinations.getD_name() %>">
                                <form id="destInfoForm<%= destinations.getDestinationID() %>" action="ShowDestInfoServlet" method="get">
                                    <input type="hidden" name="freq" value="<%= destinations.getFreq() %>"/>
                                    <input type="hidden" name="destinationID" value="<%= destinations.getDestinationID() %>"/>
                                </form>
                                <a href="javascript:void(0);" class="country-link" onclick="submitForm('destInfoForm<%= destinations.getDestinationID() %>');">
                                    <%= destinations.getD_name() %>
                                </a>

                            </div>
                        </div>
                        <% } %>
                        <% } %>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>

<footer>
    <div class="home-footer">
        <div class="footer-sct1">
            <div class="footer-sct1-clm1">
                <div class="footer-logo">
                </div>
                <p></p>
            </div>
            <div class="footer-sct1-clm2">
                <a class="footerlink2" href="contact.jsp">Contact Us</a>
            </div>
        </div>
        <div class="footer-sct2">
            <p class="copyright-notice">
                Copyright © 2024 Touristas Travel Agency | All Rights Reserved.
            </p>
        </div>
    </div>
    <script type="text/javascript">
        function submitForm(formId) {
            document.getElementById(formId).submit();
        }
    </script>
</footer>
</body>
</html>