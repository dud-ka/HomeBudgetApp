<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,700,700i" rel="stylesheet">
    <link href="https://unpkg.com/lemoncss/dist/lemon.min.css" rel="stylesheet">
    <style>
        button>a,
        button>a:link,
        button>a:visited {
            color: #ffffff;
        }
        header {
            margin-top: 5vh;
            margin-bottom: 5vh;
        }
        .small {
            width: 30vw;
        }

    </style>

</head>
<body>
<header>
    <c:if test="${loggedUser != null}">

        <header>
            <div class="row">
                <div class="column"><center>Zalogowany użytkownik: ${loggedUser.username} </center></div>
            </div>
            <div class="row">
                <div class="column">
                    <center><button><a href="/logout"> WYLOGUJ </a></button></center>
                </div>
                <div class="column">
                    <center><button><a href="/main"> Powrót do podsumowania </a></button></center>
                </div>
            </div>
        </header>

        <div class="container small">
            <form:form modelAttribute="newBill" method="post">
                <form:input path="date" type = "date" autocomplete="true"/><br>
                <form:input path="total" placeholder = "suma"/><form:errors path="total"/><br>
                <form:input path="description" placeholder = "opis"/><form:errors path="description"/><br>
                <form:button>ZAPISZ</form:button>
            </form:form>
        </div>
    </c:if>
</header>
</body>
</html>
