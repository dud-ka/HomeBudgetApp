<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<div>

    <form:form modelAttribute="registerForm" method="post">
        <div>
            <form:label path = "email" for = "email"> Email: </form:label>
            <form:input path = "email" name = "email" /><form:errors path = "email"/>
        </div>
        <div>
            <form:label path = "username" for = "username"> Nazwa użytkownika </form:label>
            <form:input path = "username" name = "username" /><form:errors path = "username"/>
        </div>
        <div>
            <form:label path = "password" for = "password"> Hasło: </form:label>
            <form:password path = "password" name = "password"/><form:errors path = "password"/>
        </div>
        <div>
            <form:label path = "confirmPassword" for = "confirmPassword"> Powtórz hasło: </form:label>
            <form:password path = "confirmPassword" name = "confirmPassword"/><form:errors path = "confirmPassword"/>
        </div>
        <form:button> WYŚLIJ </form:button>
    </form:form>
    <div><a href="<c:url value="/login"/>">Chcę się zalogować.</a></div>

</div>
</body>
</html>
