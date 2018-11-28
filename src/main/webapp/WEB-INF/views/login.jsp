<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div>

    <form:form modelAttribute="loginForm" method="post">
        <div>
            <form:label path = "email" for = "email"> Email: </form:label>
            <form:input path = "email" name = "email" /><form:errors path = "email"/>
        </div>
        <div>
            <form:label path = "password" for = "password"> Hasło: </form:label>
            <form:input path = "password" name = "password"/><form:errors path = "password"/>
        </div>
        <form:button> WYŚLIJ </form:button>
    </form:form>
    <div><a href="/register">Nie mam jeszcze konta.</a></div>

</div>
</body>
</html>
