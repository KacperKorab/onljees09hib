<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Update book</h3>
<%--@elvariable id="book" type="pl.coderslab.book.Book"--%>
<form:form modelAttribute="book" cssClass="some-class" action="/book-form/update">
    <%@include file="_form.jsp" %>
    <input type="submit"/>
</form:form>

</body>
</html>
