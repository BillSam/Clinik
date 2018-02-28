<%--
  Created by IntelliJ IDEA.
  User: error
  Date: 2/22/18
  Time: 8:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Doctor Profile</title>
</head>
<body>
<%
    String Id = (String) session.getAttribute("UserId");
    if (Id != null){

%>
<h3><%= Id +" profile:" %></h3>
<p>Welcome to your profile, you have logged in as a Doctor:</p><br><br>
<p>You can view patient vitals:</p> <a href="viewVitals.jsp">Patient vitals</a> or <br><br>
<p>You can view patient past Examination records:</p>
<p>You can save patient examination details:</p><a href="saveExamination">save Examinations</a>


<a href="logOut">LogOut</a>
<%

    }else {
        out.print("You need to log in first..");
    }


%>

</body>
</html>
