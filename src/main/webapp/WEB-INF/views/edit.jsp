<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,700,700i" rel="stylesheet">
    <link href="https://unpkg.com/lemoncss/dist/lemon.min.css" rel="stylesheet">
    <style>
        button>a,
        button>a:link,
        button>a:visited
     {
            color: #ffffff;
        }
        header {
            margin-top: 5vh;
            margin-bottom: 5vh;
        }
        .small {
            width: 40vw;
        }

    </style>
</head>
<body>
<header>
    <div class="row container small">
        <div class="column">
            <center>Zalogowany użytkownik: ${loggedUser.username} </center>
        </div>
        <div class="column">
            <center><button><a href="/logout"> WYLOGUJ </a></button></center>
        </div>
    </div>
    <div class="row container small">
        <div class="column">
            <center><button><a href="/main"> Powrót do podsumowania </a></button></center>
            <center><button><a href="/add"> Dodaj paragon </a></button></center>
        </div>
    </div>
</header>


<div class="container small">
    <div>
        <p id = "total"><strong>Kwota paragonu: ${editBill.total} zł</strong></p>
        <p><strong>Edytujesz paragon nr:  ${editBill.id}</strong></p>
    </div>
    <table>
        <thead>
        <tr>
            <th>Kwota</th>
            <th>Kategoria</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${editBill.detailsDTOS}" var="bill">
            <form:form modelAttribute="billDetails" action="" method="post" id="${bill.id}">
                <tr>
                    <td>
                        <input type="hidden" name="id" value="${bill.id}" form="${bill.id}"/>
                        <input type="text" name="amount" value="${bill.amount}" form="${bill.id}"/>

                    </td>
                    <td>
                        <select data-value="${bill.category}" name="category" class="categories" form="${bill.id}">
                            <c:forEach items="${categories}" var="cat">
                                <option>${cat}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td><input type="submit" value="save"/></td>
                </tr>
            </form:form>


        </c:forEach>


        <form:form modelAttribute="billDetails" action="" method="post" id="new">
            <tr>
                <td>
                    <input type="text" name="amount" form="new"/>

                </td>
                <td>
                    <select name="category" class="categories" form="new">
                        <c:forEach items="${categories}" var="cat">
                            <option>${cat}</option>
                        </c:forEach>
                    </select>
                </td>
                <td><input type="submit" value="save"/></td>
            </tr>
        </form:form>



        </tbody>
        <script>
            document.addEventListener("DOMContentLoaded", function () {
                document.querySelectorAll("select.categories").forEach(e => e.value = e.dataset.value)
            })
        </script>
    </table>
</div>

</body>
</html>
