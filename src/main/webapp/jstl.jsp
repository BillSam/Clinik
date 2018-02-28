<%--
  Created by IntelliJ IDEA.
  User: error
  Date: 2/13/18
  Time: 8:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>jstl</title>
</head>
<body>
<c:out value="${'Welcome to javaTpoint'}"/>
<c:set var="Income" scope="session" value="${4000*4}"/>
<c:out value="${Income}"/>

</body>
</html>
