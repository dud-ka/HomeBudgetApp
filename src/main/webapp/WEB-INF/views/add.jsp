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
        button>a:visited,
        a:active, a:focus, a:hover, a:link:active, a:link:focus, a:link:hover, a:visited:active, a:visited:focus, a:visited:hover{
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
            <div class="row container small">
                <div class="column">
                    <center>Zalogowany użytkownik: ${loggedUser.username} </center>
                </div>
                <div class="column">
                    <center><button><a href="/logout"> WYLOGUJ </a></button></center>
                </div>
            </div>
            <div class="row">
                <div class="column">
                    <center><button><a href="/main"> Powrót do podsumowania </a></button></center>
                </div>
            </div>
        </header>

        <div class="container small">
            <form:form modelAttribute="newBill" method="post">
                <form:errors path="date"/>
                <form:input path="date" type = "date" id = "dateNow"/><br>
                <form:errors path="total"/>
                <form:input path="total" placeholder = "suma"/><br>
                <form:errors path="description"/>
                <form:input path="description" placeholder = "opis"/><br>
                <form:button>ZAPISZ</form:button>
            </form:form>
        </div>
    </c:if>
    <script>
        document.addEventListener("DOMContentLoaded", function () {
            document.getElementById('dateNow').valueAsDate = new Date();
        })
    </script>
</header>
</body>
</html>
