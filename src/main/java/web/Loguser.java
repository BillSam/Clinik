package web;

import logic.beanImp.UserBeanLogic;
import pojos.users.User;

import javax.ejb.EJB;
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
 * Created by error on 2/17/18.
 */
//give the servlet url name
@WebServlet(urlPatterns = "logUser")
//Loguser servlet to log in users and redirect them to their specific welcome pages:
public class Loguser extends HttpServlet {
    //inject the managed userBean logic
    @EJB
    private UserBeanLogic logic;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("logUser.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User();

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        if (req.getParameter("userPass") != null){

            //get the passed parameters from the logUser.jsp
            //set the parameters to a new user object
            user.setUserId(req.getParameter("userId"));
            user.setPassword(req.getParameter("userPass"));


            //logIn the user with the parameters passed
            if (logic.logInUser(user)){
                //if log in is successful get the user profession
                String profession = logic.getLoggedInUserProffesion(user);

                HttpSession session = req.getSession();
                session.setAttribute("UserId",user.getUserId());
                session.setMaxInactiveInterval(1*60);
                //redirect the user to welcome page based on the profession
                if (profession.equals("Receptionist")){

                    resp.sendRedirect("welcomeReceptionist.jsp");

                }else if (profession.equals("Nurse")){
//                   HttpSession session = req.getSession();
//                    session.setAttribute("UserId",user.getUserId());
//                    session.setMaxInactiveInterval(1*60);
                    resp.sendRedirect("welcomeNurse.jsp");

                }else if (profession.equals("Doctor")){
//                    HttpSession session = req.getSession();
//                    session.setAttribute("UserId",user.getUserId());
//                    session.setMaxInactiveInterval(1*60);
                    resp.sendRedirect("welcomeDoctor.jsp");

                }







            }else{

                out.print("Password or username wrong..");
                req.getRequestDispatcher("logUser.jsp").include(req,resp);
            }
    }
    }
}
