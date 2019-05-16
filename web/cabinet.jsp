<%--
  Created by IntelliJ IDEA.
  User: Igor
  Date: 15/05/2019
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cabinet</title>
</head>
<body>
    <h1>Welcome to the cabinet ${userEmail}</h1>

    <a href="index.jsp">Exit</a>

    <style>
        a {
            position: absolute;
            right: 5%;
            top: 5%;
            font-size: 24px;
            font-family: sans-serif;
            padding: 5px 10px;
            border-radius: 5px;

            text-decoration: none;
            color: white;
            background: linear-gradient(#b03b44, #d76870);
        }

        a:hover {
            color: #454545;
        }
    </style>
</body>
</html>
