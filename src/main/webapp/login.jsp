<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="style.css">
    <title>Log In User</title>
</head>
<body>
<body>
<div class="login-page">
    <div class="form">
        <div class="login">
            <div class="login-header">
                <h3>Sign In</h3>
                <p> Enter your log in credentials.</p>
            </div>
        </div>
        <form action = "LoginServlet" method = "post" class="login-form">
            <input type="text" name="username" placeholder="Username" />
            <input type="password" name= "pass" placeholder="Password"/>
            <button type="submit"> Sign In </a> </button>
        </form>
    </div>
</div>
</body>
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
    .login-page {
        width: 360px;
        padding: 8% 0 0;
        margin: auto;
    }
    .login-page .form .login{
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
    .form input {
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
