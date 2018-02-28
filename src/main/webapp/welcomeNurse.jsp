<%@ page import="java.util.ArrayList" %>
<%@ page import="logic.beanImp.ClinicBeanLogic" %><%--
  Created by IntelliJ IDEA.
  User: error
  Date: 2/12/18
  Time: 7:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>welcome nurse</title>
</head>
<body>
<%
    String Id = (String) session.getAttribute("UserId");
    if (Id != null){

%>
<h3><%= Id +" profile:" %></h3>
<p>Welcome to your profile, you have logged in as a nurse:</p><br><br>
<p>You can get patient vitals:</p> <a href="getPatientVitals.jsp">Patient vitals</a> or <br><br>
<p>You can book a patient to a doctors</p>  <br><a href="bookPatient">BookPatient</a>



<a href="logOut">LogOut</a>
<%

    }else {
        out.print("You need to log in first..");
    }


%>

</body>
</html>
