package daos.daosImpl;

import DataMapper.DbUtil;
import daos.daosInterface.Crud;
import pojos.actions.Examination;
import pojos.actions.PatientVitals;
import pojos.users.Patient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by error on 2/27/18.
 */
public class VitalsDao implements Crud {
    private DbUtil myDb=null;

    public VitalsDao() {
         myDb = new DbUtil();
    }

    @Override
    public boolean create(Object o) {
        PatientVitals patientVitals = (PatientVitals) o;
        int k =0;
        String sql;
        sql ="insert into patientVitals(vitalsId,patientId,nurseId,weight,height,bp) values(NULL,'"+patientVitals.getPatientId()+"','"+patientVitals.getReceptionistId()
                +"','"+patientVitals.getWeight()+"','"+patientVitals.getHeight()+"','"+patientVitals.getBloodPressure()+"')";
        if (myDb != null)
            k = myDb.write(sql);

        return k > 0;
    }

    @Override
    public PatientVitals read(Object o) {
        PatientVitals patientVitals = new PatientVitals();
        Patient patient = (Patient) o;

        String sql = "select * from patientVitals where patientId='"+patient.getRegId()+"'";

        ResultSet rs = myDb.read(sql);

        try {
            while (rs != null && rs.next()){
                patientVitals.setPatientId(rs.getString("patientId"));
                patientVitals.setBloodPressure(rs.getDouble("bp"));
                patientVitals.setHeight(rs.getDouble("height"));
                patientVitals.setWeight(rs.getDouble("weight"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return patientVitals;
    }

    @Override
    public boolean update(Object o) {
        return false;
    }

    @Override
    public boolean delete(Object o) {
        Patient patient = (Patient) o;
        int k =0;
        String sql = "delete from patientVitals where patientId='"+patient.getRegId()+"'";
        if (myDb != null)
            k = myDb.write(sql);

        return k>0;

    }

    @Override
    public ArrayList<Object> getAll() {
        return null;
    }
}
