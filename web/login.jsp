<%--
  Created by IntelliJ IDEA.
  User: Igor
  Date: 16/05/2019
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="css/styleForm.css">
</head>
<body>
<div class="registrationForm">
    <h2>Log in</h2>
    <form action="login" method="post">
        <input id="login" name="login" placeholder="Login" required>
        <input id="password" name="password" placeholder="Password" required>
        <input id="buttonId" type="submit" value="Sign in">
    </form>
</div>
</body>
</html>
