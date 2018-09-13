<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Siłownia Arkadia</title>
</head>
<body>

<form:form action="processForm" modelAttribute="client">

    Twoje imię: <form:input path="firstName"/>
    <br><br>

    Wzrost w metrach <form:input path="height"/>
    <br><br>

    Waga w kilogramach: <form:input path="weight"/>
    <br><br>

    <input type="submit" value="Submit">

</form:form>
</body>
</html>
