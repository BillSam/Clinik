package web;

import logic.beanImp.UserBeanLogic;
import logic.beanInterface.UserBeanIo;
import pojos.users.User;

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
 * Created by error on 2/22/18.
 */
@WebServlet(urlPatterns = "/logOut")
public class LogOut extends HttpServlet {
    @Inject
    private UserBeanLogic logic;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        User user = new User();

        HttpSession session = req.getSession();
        String id = (String) session.getAttribute("UserId");
        user.setUserId(id);
        if (id != null){
            session.invalidate();
            if (logic.updateLogOut(user)){
                resp.sendRedirect("index.jsp");
            }


        }else {
            out.print("You are not logged in to log out");

        }
    }
}
