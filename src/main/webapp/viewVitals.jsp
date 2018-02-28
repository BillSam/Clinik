<%@ page import="pojos.actions.PatientVitals" %><%--
  Created by IntelliJ IDEA.
  User: error
  Date: 2/25/18
  Time: 2:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vitals</title>
</head>
<body>
<form action="viewVitals" method="post">
    PatientId:
    <input type="text" name="patientId"><br>
    <button type="submit">submit</button>
</form>
<%!
    PatientVitals vitals = new PatientVitals();

%>

<%
    if (request.getAttribute("vitals") != null){

        vitals = (PatientVitals) request.getAttribute("vitals");
        %>
    PatientId:<%=vitals.getPatientId()%><br>
    PatientWeight:<%=vitals.getWeight()%><br>
    PatientHeight:<%=vitals.getHeight()%><br>
    PatientBloodPr:<%=vitals.getBloodPressure()%><br>
        <%

    }


%>


</body>
</html>
