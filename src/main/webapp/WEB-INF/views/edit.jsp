<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<header>
    <span>Zalogowany użytkownik: ${loggedUser.username} </span> <button><a href="/logout"> WYLOGUJ </a></button>
    <button><a href="/main"> Powrót do strony głównej </a></button>
</header>

${editBill.total}
<%--${editBill.billDetails}--%>


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

</body>
</html>
