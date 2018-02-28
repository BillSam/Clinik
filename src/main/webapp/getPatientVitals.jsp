<%--
  Created by IntelliJ IDEA.
  User: error
  Date: 2/12/18
  Time: 7:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>vitals</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/custom.css">
    <script src="js/bootstrap.min.js"></script>
    <script src="js/good.js"></script>
</head>
<body>

<div class="container">
    <div class="card card-container">
        <form class="form-signin" method="post" action="addVitals">
            PatientId:
            <input type="text" class="form-control" id="inputEmail" name="patientId" value="" placeholder="patientId" /><br>
            PatientWeight:
            <input type="text" class="form-control"  name="patientWeight" value="" placeholder="Weight" /><br>
            PatientHeight:
            <input type="text" class="form-control"  name="patientHeight" value="" placeholder="Height" /><br>
            patient BloodPressure
            <input type="text" class="form-control"  name="patientBp" value="" placeholder="bloodPressure" /><br>


            <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">submit</button>




</body>
</html>
