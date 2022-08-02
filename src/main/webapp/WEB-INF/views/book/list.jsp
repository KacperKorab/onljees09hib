<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="<c:url value="/book-form/add/"/>">add</a>
<table>
    <tr>
        <th>Id</th>
        <th>title</th>
        <th>publisher</th>
        <th>akcje</th>
    </tr>
<c:forEach items="${books}" var="book">
    <tr>
        <td>${book.id}</td>
        <td>${book.title}</td>
        <td>${book.publisher.name}</td>
        <td>
            <a href="<c:url value="/book-form/confirm/${book.id}"/>">delete</a>
            <a href="<c:url value="/book-form/edit/${book.id}"/>">update</a>
        </td>
    </tr>
</c:forEach>
</table>
</body>
</html>
