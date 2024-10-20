<%@ page import="org.example.touristastravelagency_v0.models.Countries" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="style.css">
    <title>Sign Up</title>
</head>
<body>
<div class="signup-page">
    <div class="form">
        <div class="signup">
            <div class="signup-header">
                <h3>Sign Up</h3>
                <p>Enter your credentials to sign up.</p>
            </div>
        </div>
        <form action="SignUpServlet" method="post" class="signup-form">
            <input type="text" name="username" placeholder="Username" required />
            <input type="password" name="pass" placeholder="Password" required />
            <input type="text" name="u_name" placeholder="Name" required />
            <select name="id_country" required class="select-field">
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
            <input type="text" name="phone" placeholder="Phone Number" required />
            <input type="email" name="email" placeholder="Email" required />
            <button type="submit">Sign Up</button>
        </form>
    </div>
</div>
</body>
<style>
    header .header{
        background-color: #fff;
        height: 45px;
    }
    header a img{
        width: 134px;
        margin-top: 4px;
    }
    .signup-page {
        width: 360px;
        padding: 8% 0 0;
        margin: auto;
    }
    .signup-page .form .signup{
        margin-top: -31px;
        margin-bottom: 26px;
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
        background-image: linear-gradient(45deg,#66ccff,#99ddff);
        width: 100%;
        border: 0;
        padding: 15px;
        color: #FFFFFF;
        font-size: 14px;
        -webkit-transition: all 0.3 ease;
        transition: all 0.3 ease;
        cursor: pointer;
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

    .container {
        position: relative;
        z-index: 1;
        max-width: 300px;
        margin: 0 auto;
    }

    body {
        background-color: #66ccff;
        background-image: linear-gradient(45deg,#66ccff,#99ddff);
        font-family: "Roboto", sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
    }
</style>
</html>
