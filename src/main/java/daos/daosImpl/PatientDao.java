package daos.daosImpl;

import DataMapper.DbUtil;
import daos.daosInterface.Crud;
import daos.qualifiers.Clinic;
import pojos.users.Patient;

import javax.enterprise.context.RequestScoped;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static daos.qualifiers.Clinic.clinicChoice.PatientDao;

/**
 * Created by error on 2/21/18.
 */
@RequestScoped
@Clinic(PatientDao)
public class PatientDao implements Crud {
    private DbUtil myDb =null;

    public PatientDao() {
        myDb = new DbUtil();
    }

    public boolean create(Object o) {
        Patient patient = (Patient) o;
        int k=0;
        String sql ="insert into patientsDetails(id,name,age,gender,address) values('"+patient.getRegId()+"','"+patient.getName()+"',"
                +patient.getAge()+",'"+patient.getGender()+"','"+patient.getAddress()+"')";
        if (myDb != null){
            k = myDb.write(sql);
        }
        return k>0;
    }

    public Patient read(Object o){
        Patient patient = (Patient) o;
        Patient patient1 = new Patient();
        ResultSet rs;
        String sql = "select * from patientsDetails where id='"+patient.getRegId()+"'";

        if (myDb != null){
            rs = myDb.read(sql);

            try {
                while (rs != null && rs.next()){
                    patient1.setRegId(rs.getString("id"));
                    patient1.setAddress(rs.getString("address"));
                    patient1.setAge(rs.getInt("age"));
                    patient1.setName(rs.getString("name"));
                    patient1.setGender(rs.getString("gender"));



                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    return patient1;
    }

    @Override
    public boolean update(Object o) {
        return false;
    }

    @Override
    public boolean delete(Object o) {
        Patient patient = (Patient) o;
        int k =0;
        String sql = "delete from patientDetails where id='"+patient.getRegId()+"'";
        if (myDb != null){

            k = myDb.write(sql);
        }

        return k>0;

    }

    @Override
    public ArrayList<Object> getAll() {
        return null;
    }
}
