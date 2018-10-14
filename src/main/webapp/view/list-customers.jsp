<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Lista klientów</title>

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

    <div id="wrapper">
        <div id="header">
            <h2>CRM - Dane klientów</h2>
        </div>
    </div>

    <div id="container">
        <div id="content">

            <input type="button" value="Dodaj klienta"
                onclick="window.location.href='showFormForAdd'; return false;"
                class="add-button">

            <table>
                <tr>
                    <th>Numer</th>
                    <th>Imię</th>
                    <th>Nazwisko</th>
                    <th>E-mail </th>
                    <th>Wzrost</th>
                    <th>Waga</th>
                    <th>BMI</th>
                    <th>Akcja</th>
                </tr>

                <c:forEach var="tempCustomer" items="${clients}">

                    <c:url var="updateLink" value="/customer/showFormForUpdate">
                            <c:param name="customerId" value="${tempCustomer.id}"/>
                    </c:url>

                    <tr>
                        <td>${tempCustomer.id}</td>
                        <td>${tempCustomer.firstName}</td>
                        <td>${tempCustomer.lastName}</td>
                        <td>${tempCustomer.email}</td>
                        <td>${tempCustomer.height}</td>
                        <td>${tempCustomer.weight}</td>
                        <td>${tempCustomer.bmi}</td>

                        <td>
                            <a href="${updateLink}">Zaktualizuj</a>
                        </td>
                    </tr>

                </c:forEach>
            </table>
        </div>
    </div>

</body>
</html>
