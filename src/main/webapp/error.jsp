<%--
  Created by IntelliJ IDEA.
  User: error
  Date: 2/8/18
  Time: 3:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%@ page isErrorPage="true" %>

<c:forEach   begin = "1" end = "5" var="i">
    Item <c:out value = "${i}"/><p>

    </c:forEach>
        <c:forTokens items = "Zara,nuha,roshy" delims = "," var = "name">
            <c:out value = "${name}"/><p>
        </c:forTokens>
sorry an exception occurred:<br>
The exception is : <%= exception %>

</body>
</html>
