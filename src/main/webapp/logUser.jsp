<%--
  Created by IntelliJ IDEA.
  User: error
  Date: 2/11/18
  Time: 2:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LogIn</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/custom.css">
    <script src="js/bootstrap.min.js"></script>
    <script src="js/good.js"></script>
</head>
<body>
<div class="container">
    <div class="card card-container">
        <form class="form-signin" method="post" action="logUser">
            User Id:
            <input type="text" class="form-control" id="inputEmail" name="userId" value="" placeholder="User Id" />
            <br>

            Password:
            <input type="password" class="form-control" id="inputPassword" name="userPass" placeholder="password" value="" required/>
            <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">login</button>

        </form>

    </div>

</div>

</body>
</html>
