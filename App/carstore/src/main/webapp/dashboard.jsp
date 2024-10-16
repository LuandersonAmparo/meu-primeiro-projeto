<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta charset="UTF-8">
    <title>dashboard</title>
</head>
<body>
<div>
    <h1>Cars</h1>
    <table>
        <tr>
            <th>NAME</th>
            <th>color</th>
        </tr>
        <c:forEach var="car" items="${cars}">
            <tr>
                <td>${car.name}</td>
                <td>${car.color}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>