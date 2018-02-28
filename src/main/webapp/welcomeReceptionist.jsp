<%--
  Created by IntelliJ IDEA.
  User: error
  Date: 2/11/18
  Time: 7:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    String Id = (String) session.getAttribute("UserId");
    if (Id != null){

        %>
<h3><%= Id +" profile"%>></h3>
<p>Welcome to your profile, you have logged in as a receptionist:</p><br><br>
<p>You can only:</p> <a href="regP.jsp">RegisterPatient</a> or <br><br>


<a href="logOut">LogOut</a>
<%

    }else {
        out.print("You need to log in first..");
    }


%>
</body>
</html>
