package logic.beanInterface;

import pojos.users.Doctor;
import pojos.users.User;

import javax.ejb.Remote;
import java.util.ArrayList;

/**
 * Created by error on 2/9/18.
 */
@Remote
public interface UserBeanIo {
    boolean registerUser(User user);
    boolean logInUser(User user);
    boolean deleteUser(User User);
    boolean updateUser(User user);
    ArrayList<User> getDoctorsLoggedIn();

}
