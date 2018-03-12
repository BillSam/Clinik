package web;

import logic.beanImp.PatientVitalsBean;
import pojos.actions.PatientVitals;
import pojos.users.Patient;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by error on 2/25/18.
 */
@WebServlet(urlPatterns = "/viewVitals")
public class ViewVitals extends HttpServlet {
    @EJB
    private PatientVitalsBean logic;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("viewVitals.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("patientId") != null){

            PatientVitals vitals = new PatientVitals();
            Patient patient = new Patient();
            patient.setRegId(req.getParameter("patientId"));

            //vitals = logic.getPatientVitals(patient);
            if (vitals.getPatientId() != null){

                req.setAttribute("vitals",vitals);
                System.out.println(vitals.getHeight());
                req.getRequestDispatcher("viewVitals.jsp").forward(req,resp);

            }



        }


    }
}
