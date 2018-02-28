<%@ page import="pojos.actions.PatientVitals" %>
<%@ page import="logic.beanImp.NurseBean" %><%--
  Created by IntelliJ IDEA.
  User: error
  Date: 2/12/18
  Time: 8:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>vitals</title>
</head>
<body>
<%!
    PatientVitals vitals = new PatientVitals();
    NurseBean bean = new NurseBean();

%>
<%
    String id = (String) session.getAttribute("UserId");
    if (id != null){

        vitals.setPatientId(request.getParameter("patientId"));
        vitals.setReceptionistId(id);
        vitals.setWeight(Double.valueOf(request.getParameter("patientWeight")));
        vitals.setHeight(Double.valueOf(request.getParameter("patientHeight")));
        vitals.setBloodPressure(Double.valueOf(request.getParameter("patientBp")));


        if (bean.addVitals(vitals)){
            out.print("Success");



        }else {
            out.print("Failed to add vitals");
        }












    }



%>

</body>
</html>
