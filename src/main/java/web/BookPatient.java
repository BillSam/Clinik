package web;

import logic.beanImp.BookingBean;
import logic.beanImp.UserBeanLogic;
import pojos.actions.Booking;
import pojos.users.User;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by error on 2/21/18.
 */
@WebServlet(urlPatterns = "/bookPatient")
public class BookPatient extends HttpServlet {

    @Inject
    private UserBeanLogic logic;
    @EJB
    private BookingBean book;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //create an arrayList to store the doctors available for booking
        //set the arrayList created as attribute to the request object
        //then forward the req to a jsp to display the available doctors
        ArrayList<User> doctors = logic.getDoctorsLoggedIn();

        req.setAttribute("doctors",doctors);

        req.getRequestDispatcher("bookPatient.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        Booking booking = new Booking();


        if (req.getParameter("patientId") != null){
            //get the booking parameters passed

            booking.setPatientId(req.getParameter("patientId"));
            booking.setRoom(req.getParameter("room"));
            System.out.println(req.getParameter("doctor"));
            booking.setDoctorId(req.getParameter("doctor"));




        //persist the booking record in the db by calling the bookingDao methods
        if (book.createBooking(booking)){
            req.getRequestDispatcher("welcomeNurse.jsp").forward(req,resp);

        }else {
            out.print("Failed");
        }





        }


    }
}
