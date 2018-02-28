<%@ page import="java.util.ArrayList" %>
<%@ page import="pojos.users.Doctor" %>
<%@ page import="pojos.users.User" %><%--
  Created by IntelliJ IDEA.
  User: error
  Date: 2/21/18
  Time: 8:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Booking</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/custom.css">
    <script src="js/bootstrap.min.js"></script>
    <script src="js/good.js"></script>
</head>
<body>
<div class="container">
    <div class="card card-container">
<form class="form-signin" method="post" action="bookPatient">
    Patient Id:
    <input type="text" name="patientId" class="form-control" id="inputEmail"  placeholder="Patient Id" required><br>
    <%
        ArrayList<User> doctors = (ArrayList<User>) request.getAttribute("doctors");


        %>
    Doctor:
    <select class="form-control" name="doctor">
        <%
        for (User d:doctors) {
            %>
        <option name="doctor"><%=d.getUserId() %></option>
            <%
        }

        %>
    </select><br>
    <%

    %>
    Room:
    <input type="text" name="room"  class="form-control" placeholder="Room" required><br>
    <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Book</button>

</form>
</body>
</html>
