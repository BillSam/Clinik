package web;

import logic.beanImp.PatientBean;
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
 * Created by error on 2/18/18.
 */
@WebServlet(urlPatterns = "/regPatient")

//create a servlet that receive patient details and call the patientBean
public class RegPatient extends HttpServlet {
    //inject the patientBean object
    @EJB
    private PatientBean logic;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("regP.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Patient patient = new Patient();
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        if (req.getParameter("patientId") != null) {
            //get the passed patient parameters from the jsp file and
            //set them to a new patient object
            patient.setRegId(req.getParameter("patientId"));
            patient.setName(req.getParameter("patientName"));
            patient.setAge(Integer.parseInt(req.getParameter("patientAge")));
            patient.setAddress(req.getParameter("patientAddress"));
            patient.setGender(req.getParameter("patientGender"));

            //register the new patient
            if (logic.registerPatient(patient)){
                out.print("Successfully added patient");
                req.getRequestDispatcher("regP.jsp").include(req,resp);

            }else {
                out.print("Failed to register patient");
                req.getRequestDispatcher("regP.jsp").include(req,resp);
            }

        }


    }
}
