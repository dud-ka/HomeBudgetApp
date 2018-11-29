<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        header {
            height: 50px;
            font-size: 20px;
            width: 1200px;
            margin: 0 auto;
            background-color: beige;
        }
        body {
            width: 1200px;
            margin: 0 auto;
            background-color: wheat;
        }
        table {
            max-width: 500px;
            margin: 0 auto;
        }
        th, td{
            border: 1px solid black;
        }
    </style>
</head>
<body>
<header>
    <c:if test="${loggedUser != null}">
        <span>Zalogowany użytkownik: ${loggedUser.username} </span>
        <button><a href="/main"> Powrót do podsumowania </a></button>
        <button><a href="/logout"> WYLOGUJ </a></button></span>

        <form:form modelAttribute="newBill" method="post">
            <form:input path="date" type = "date" autocomplete="true"/><br>
            <form:input path="total" placeholder = "suma"/><form:errors path="total"/><br>
            <form:input path="description" placeholder = "opis"/><form:errors path="description"/><br>
            <form:button>ZAPISZ</form:button>
        </form:form>
    </c:if>
</header>
</body>
</html>
