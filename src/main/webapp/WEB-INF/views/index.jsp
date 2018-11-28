<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Budget App</title>
    <style>
        header {
            height: 50px;
            font-size: 20px;
            width: 1200px;
            margin: 0 auto;
            background-color: beige;
        }
    </style>
</head>
<body>


<c:if test="${loggedUser != null}">
    <header>
        <span>Zalogowany użytkownik: ${loggedUser.username} </span> <button><a href="/logout"> WYLOGUJ </a></button>
    </header>




</c:if>


</body>
</html>
