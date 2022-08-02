<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="student" cssClass="some-class">
    <form:input path="firstName"/> <br/>
    <form:input path="lastName"/> <br/>
    <form:radiobutton path="gender" value="f"/><br/>
    <form:radiobutton path="gender" value="m"/><br/>
    <form:select path="country"><br/>
        <form:options items="${countries}" />
    </form:select>
    <form:textarea path="notes"/><br/>
    <form:checkbox path="mailingList"/><br/>
    <form:select path="programmingSkills" multiple="true"><br/>
        <form:options items="${programmingSkills}" />
    </form:select> <br/>
    <form:checkboxes path="hobbies" items="${hobbies}"/> <br/>
    <input type="submit"/>
</form:form>


</body>
</html>
