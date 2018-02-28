<%--
  Created by IntelliJ IDEA.
  User: error
  Date: 2/11/18
  Time: 12:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User registration</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/custom.css">
    <script src="js/bootstrap.min.js"></script>
    <script src="js/good.js"></script>
</head>
<body>
<div class="container">
    <div class="card card-container">
        <form class="form-signin" method="post" action="RegUser">
            User Id
            <input type="text" class="form-control" id="inputEmail" name="userId" value="" placeholder="User Id" /><br>
            User Firstname:
            <input type="text" class="form-control"  name="userFname" value="" placeholder="User first name" /><br>
            User lastname:
            <input type="text" class="form-control"  name="userLname" value="" placeholder="User last name" /><br>
            user Password:
            <input type="password" class="form-control" id="inputPassword" name="userpass" value="" placeholder="password" /><br>
            User Age:
            <input type="text" class="form-control"  name="userAge" value="" placeholder="User Age" /><br>
            User Profession:
            <select class="form-control" name="userProf">
                <option>Receptionist</option>
                <option>Doctor</option>
                <option>LabTechnician</option>
                <option>Pharmacist</option>
                <option>Nurse</option>
            </select>

            <br>

            <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">register</button>
            </form>
    </div>
</div>



</body>
</html>
