<%--
  Created by IntelliJ IDEA.
  User: Igor
  Date: 15/05/2019
  Time: 00:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Servlet</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="registrationForm">
        <h2>Registration</h2>
        <form action="registration" method="post">
            <input id="name" name="name" placeholder="Name" required>
            <input id="lastName" name="lastName" placeholder="Last name" required>
            <input id="email" name="email" placeholder="Email" required>
            <input id="password" name="password" placeholder="Password" required>
            <input id="buttonId" type="submit" value="Sign up">
        </form>
    </div>

    <%--<script src="script.js"></script>--%>

</body>
</html>
