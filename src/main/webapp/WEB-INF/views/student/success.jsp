<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 02.08.2022
  Time: 09:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Student data</h3>
<p>imię: ${student.firstName}</p>
<p>nazwisko: ${student.lastName}</p>
<p>gender: ${student.gender}</p>
<p>country: ${student.country}</p>
<p>notes: ${student.notes}</p>
<p>mailingList: ${student.mailingList}</p>
<p>programmingSkills:
    <ul>
<c:forEach items="${student.programmingSkills}" var="ps">
    <li>${ps}</li>
</c:forEach>
</ul>

</p>
<p>hobbies:
<ul>
    <c:forEach items="${student.hobbies}" var="ps">
        <li>${ps}</li>
    </c:forEach>
</ul>
</p>
</body>
</html>
