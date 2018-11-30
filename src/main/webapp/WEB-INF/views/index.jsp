<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Budget App</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,700,700i" rel="stylesheet">
    <link href="https://unpkg.com/lemoncss/dist/lemon.min.css" rel="stylesheet">
    <style>
       button>a,
       button>a:link,
       button>a:visited,
       a:active, a:focus, a:hover, a:link:active, a:link:focus, a:link:hover, a:visited:active, a:visited:focus, a:visited:hover{
            color: #ffffff;
        }
        header {
            margin-top: 5vh;
            margin-bottom: 5vh;
        }

    </style>
</head>
<body>

<c:if test="${loggedUser != null}">
    <header>
        <div class="row">
            <div class="column"><center>Zalogowany użytkownik: ${loggedUser.username} </center></div>
        </div>
        <div class="row">

            <div class="column">
                <center><button><a href="/logout"> WYLOGUJ </a></button></center>
            </div>

        </div>
    </header>

    <div>
        <center><button><a href="/add">Dodaj paragon</a></button></center>
    </div>

    <table class="container small">
        <thead>
        <th>Nr paragonu</th>
        <th>Data</th>
        <th>Opis</th>
        <th>Kwota</th>
        <th>Kategoria</th>
        <th></th>
        </thead>
        <tbody>
        <c:forEach items="${userBills}" var="bill">
            <tr>
                <td>${bill.id}</td>
                <td>${bill.date}</td>
                <td>${bill.description}</td>
                <td>${bill.amount}</td>
                <td>${bill.category}</td>
                <td><a href="/edit/${bill.id}">Edytuj</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>


</body>
</html>
