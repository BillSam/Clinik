package web;

import logic.beanInterface.UserBeanIo;
import pojos.users.User;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Created by error on 2/17/18.
 */
//make the servlet accessible
@WebServlet(urlPatterns = "/RegUser")
//a servlet that register a new user
public class RegUser extends HttpServlet {
    //inject the required bean logic
    @Inject
    private UserBeanIo logic;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("registerUser.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User();
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();



        if (req.getParameter("userAge") != null){
            //get the passed parameters and set them to a new user object
            user.setUserId(req.getParameter("userId"));
            user.setFname(req.getParameter("userFname"));
            user.setLname(req.getParameter("userLname"));
            user.setPassword(req.getParameter("userpass"));
            user.setAge(Integer.parseInt(req.getParameter("userAge")));
            user.setProfession(req.getParameter("userProf"));
            user.setLoggedIn(false);

            //register the user
            //if registration is successful redirect the user to login page if
            //not display the registration page again
            if (logic.registerUser(user)){

                out.print("<h3 color=\"blue\">Registration Success</h3>");
                req.getRequestDispatcher("logUser.jsp").include(req,resp);


            }else {
                out.print("<h3 color=\"red\">Registration failed</h3>");
                req.getRequestDispatcher("registerUser.jsp").include(req,resp);
            }


        }else {
            out.print("You need to enter details");
        }


    }
}
