package web;

import logic.beanImp.PatientVitalsBean;
import pojos.actions.PatientVitals;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by error on 2/19/18.
 */
@WebServlet(urlPatterns = "/addVitals")
//create a servlet that receives patient vitals from jsp and call the
//dao methods to save the patient vitals..
public class AddVitals extends HttpServlet {
    @Inject
    private PatientVitalsBean logic;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("getPatientVitals.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PatientVitals vitals = new PatientVitals();

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        //create a session and set the attributes
        HttpSession session = req.getSession();
        String id = (String) session.getAttribute("UserId");

        if (id != null){
            //if the session is not null allow the user to add vitals..
            vitals.setPatientId(req.getParameter("patientId"));
            vitals.setReceptionistId(id);
            vitals.setWeight(Double.valueOf(req.getParameter("patientWeight")));
            vitals.setHeight(Double.valueOf(req.getParameter("patientHeight")));
            vitals.setBloodPressure(Double.valueOf(req.getParameter("patientBp")));


            if (logic.addPatientVitals(vitals)){
                out.print("<h2>Success</h2>");
                req.getRequestDispatcher("getPatientVitals.jsp").include(req,resp);

            }else {
                out.print("Failed to add vitals");
                req.getRequestDispatcher("getPatientVitals.jsp").include(req,resp);
            }






    }
}}
