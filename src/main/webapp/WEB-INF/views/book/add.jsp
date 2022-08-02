<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<%--@elvariable id="book" type="pl.coderslab.book.Book"--%>
<form:form modelAttribute="book" cssClass="some-class">
    <%@include file="_form.jsp" %>
    <input type="submit"/>
</form:form>

</body>
</html>
