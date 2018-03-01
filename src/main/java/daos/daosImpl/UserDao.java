package daos.daosImpl;

import DataMapper.DbUtil;
import daos.daosInterface.Crud;
import daos.qualifiers.Clinic;
import pojos.users.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static daos.qualifiers.Clinic.clinicChoice.UserDao;

/**
 * Created by error on 2/11/18.
 */
@Clinic(UserDao)
public class UserDao implements Crud{
    private DbUtil myDb = null;

    public UserDao() {
        myDb = new DbUtil();
    }

    public boolean create(Object o){
        boolean status = false;
        User user = (User) o;
        int k = 0;
        String sql = null;
        sql ="insert into users(userId,fname,lname,password,age,profession,isLoggedIn) values('"+user.getUserId()+"','"+user.getFname()+"','"+user.getLname()+"','"+user.getPassword()+"','"+user.getAge()+"','"+user.getProfession()+"',"+user.isLoggedIn()+")";
        if (myDb != null){
            k = myDb.write(sql);
        }
        status = testRowsAffected(k);

    return status;
    }

    public User read(Object o){
        User u = new User();
        User user = (User) o;
        String sql = null;
        sql = "select * from users where userId = '"+user.getUserId()+"'";
        if (myDb != null) {

            ResultSet resultSet = myDb.read(sql);

            try {
                if (resultSet != null) {
                    while (resultSet.next()) {

                        u.setUserId(resultSet.getString("userId"));
                        u.setFname(resultSet.getString("fname"));
                        u.setLname(resultSet.getString("lname"));
                        u.setPassword(resultSet.getString("password"));
                        u.setProfession(resultSet.getString("profession"));
                        u.setAge(resultSet.getInt("age"));
                        u.setLoggedIn(resultSet.getBoolean("isLoggedIn"));


                        return u;


                    }
                }else {
                    return u;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return u;


    }

    @Override
    public boolean update(Object o) {
        return false;
    }

    @Override
    public boolean delete(Object o) {
        User user = (User) o;
        boolean status = false;
        String sql = "delete from users where userId='"+user.getUserId()+"'";
        if (myDb != null){

            status = testRowsAffected(myDb.write(sql));

        }
        return status;
    }

    @Override
    public ArrayList<Object> getAll() {
        return null;
    }

    public boolean updateLogInUserStatus(User user){
        boolean status = false;
        int k =0;
        String sql;

        sql = "update users set isLoggedIn=true where userId='"+user.getUserId()+"'";

        if (myDb != null){
            k = myDb.write(sql);

            status = testRowsAffected(k);

        }

    return status;

    }

    public boolean updateLogOutStatus(User user){
        boolean status = false;
        int k = 0;
        String sql = "update users set isLoggedIn=false where userId='"+user.getUserId()+"'";
        if (myDb != null){
            k = myDb.write(sql);

            status = testRowsAffected(k);
        }
        return status;


    }

    public boolean logInUser(User user){
        User u = read(user);


        if (u.getUserId() != null && u.getPassword() !=null ){
            if (u.getUserId().equals(user.getUserId())){

                if (u.getPassword().equals(user.getPassword())){

                    if (updateLogInUserStatus(user)) {
                        return true;
                    }
                }
            }
        }
        return false;

    }

    public ArrayList<User> getDoctors() {
        ArrayList<User> doctors = new ArrayList<User>();
        User doctor = new User();
        ResultSet rs = null;
        String sql = "select * from users where profession='Doctor' and isLoggedIn=true";
        if (myDb != null){

            rs = myDb.read(sql);
            try {
                while (rs.next()){
                    doctor.setUserId(rs.getString("userId"));
                    doctor.setFname(rs.getString("fname"));
                    doctor.setLname(rs.getString("lname"));

                    doctors.add(doctor);

                }


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return doctors;
    }


    private static boolean testRowsAffected(int k){
        boolean status =false;
        if (k>0){
            status = true;
        }
        return status;
    }

}
