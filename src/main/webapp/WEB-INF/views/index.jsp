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
        body {
            width: 1200px;
            margin: 0 auto;
            background-color: wheat;
        }
        table {
            max-width: 500px;
            margin: 0 auto;
        }
    </style>
</head>
<body>

<c:if test="${loggedUser != null}">
    <header>
        <span>Zalogowany użytkownik: ${loggedUser.username} </span> <button><a href="/logout"> WYLOGUJ </a></button>
    </header>
    <table>
        <thead>
        <th>Data</th>
        <th>Opis</th>
        <th>Kwota</th>
        <th>Kategoria</th>
        </thead>
        <tbody>
        <c:forEach items="${userBills}" var="bill">
        <tr>
            <td>${bill.date}</td>
            <td>${bill.description}</td>
            <td>${bill.amount}</td>
            <td>${bill.category}</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>


</body>
</html>
