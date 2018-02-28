package daos.daosImpl;

import DataMapper.DbUtil;
import daos.daosInterface.Crud;
import pojos.actions.Booking;
import pojos.actions.Examination;
import pojos.users.Patient;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by error on 2/21/18.
 */
public class BookingDao implements Crud{

    private DbUtil myDb =null;

    public BookingDao() {
        myDb = new DbUtil();
    }


    @Override
    public boolean create(Object o) {
        Booking booking = (Booking) o;
        int k=0;
        String sql="insert into bookings(id,patientid,doctorid,room) values(Null,'"+booking.getPatientId()+"','"+booking.getDoctorId()+"',"+booking.getRoom()+")";
        if (myDb != null)
            k = myDb.write(sql);

        return k >0;
    }

    @Override
    public Object read(Object o) {
        Patient patient = (Patient) o;
        Booking booking = (Booking) o;
        String sql = "select * from bookings where patientid='"+patient.getRegId()+"'";
        if (myDb != null) {
            ResultSet rs = myDb.read(sql);
            try {
                while (rs != null && rs.next()){

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return booking;
    }

    @Override
    public boolean update(Object o) {
        return false;
    }

    @Override
    public boolean delete(Object o) {
        return false;
    }

    @Override
    public ArrayList<Object> getAll() {
        return null;
    }
}
