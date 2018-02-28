package logic.beanImp;


import daos.daosImpl.UserDao;
import logic.beanInterface.UserBeanIo;
import pojos.users.Doctor;
import pojos.users.User;

import javax.enterprise.context.RequestScoped;
import java.util.ArrayList;


/**
 * Created by error on 2/9/18.
 */
@RequestScoped
public class UserBeanLogic implements UserBeanIo {
    UserDao userDao = null;

    public UserBeanLogic() {
        userDao = new UserDao();
    }

    public boolean registerUser(User user) {

        if (verifyRegisterUser(user)){
            return userDao.create(user);
        }
        return false;
    }

    public boolean verifyRegisterUser(User user) {

        User u = userDao.read(user);
        if (u.getUserId() != null) {
            if (u.getUserId().equals(user.getUserId()))
                return false;
            return true;

        }
        return true;
    }


    public boolean logInUser(User user) {
        boolean status = false;

        status = userDao.logInUser(user);

        return status;
    }

    public String getLoggedInUserProffesion(User user){
        String profession = null;
        User u = userDao.read(user);
        if (u.getProfession() != null){

            profession =u.getProfession();
        }
        return profession;

    }

    public ArrayList<User> getDoctorsLoggedIn(){

        return userDao.getDoctors();
    }

    public boolean updateLogOut(User user){

        return userDao.updateLogOutStatus(user);
    }

    public boolean updateUser(User user) {

        //return userDao.delete(User user);
    return false;
    }

    public boolean deleteUser(User User) {
        return false;
    }

}
