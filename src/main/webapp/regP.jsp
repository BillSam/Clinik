<%--
  Created by IntelliJ IDEA.
  User: error
  Date: 2/9/18
  Time: 8:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>registration</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/custom.css">
    <script src="js/bootstrap.min.js"></script>
    <script src="js/good.js"></script>
</head>
<body>
<%
    String Id = (String) session.getAttribute("UserId");
    if (Id != null){
        %>
<div class="container">
    <div class="card card-container">
        <form class="form-signin" method="post" action="regPatient">
            Registration Id
            <input type="text" class="form-control" id="inputEmail" name="patientId" value="" placeholder="Id" /><br>
            patient name:
            <input type="text" class="form-control"  name="patientName" value="" placeholder="name" /><br>
            patient Age:
            <input type="text" class="form-control"  name="patientAge" value="" placeholder="Age" /><br>
            Patient Address:
            <input type="text" class="form-control"  name="patientAddress" value="" placeholder="address" /><br>
            Patient Gender:
            <select class="form-control" name="patientGender">
                <option>male</option>
                <option>female</option>
            </select>

            <br>

            <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">register</button>
        </form>
    </div>
</div>


    <%
    }else {
        out.print("Log in as receptionist to register user");
    }


%>
</body>
</html>
