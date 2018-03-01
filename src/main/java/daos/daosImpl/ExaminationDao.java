package daos.daosImpl;

import DataMapper.DbUtil;
import daos.daosInterface.Crud;
import daos.qualifiers.Clinic;
import pojos.actions.Examination;
import pojos.users.Patient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static daos.qualifiers.Clinic.clinicChoice.ExaminationDao;

/**
 * Created by error on 2/21/18.
 */
@Clinic(ExaminationDao)
public class ExaminationDao implements Crud {
    private DbUtil myDb =null;

    public ExaminationDao() {
        myDb = new DbUtil();
    }
    @Override
    public boolean create(Object o) {
        Examination examination = (Examination) o;
        boolean status = false;
        int k =0;
        String sql;
        sql = "insert into Examinations(examinationId,doctorId,patientId,comment) values(Null,'"+examination.getDoctorId()+"','"
                +examination.getPatientId()+"','"+examination.getComment()+"')";
        k = myDb.write(sql);
        status = testRowsAffected(k);

        return status;
    }

    @Override
    public Examination read(Object o) {

        Patient patient = (Patient) o;
        Examination examination = new Examination();
        ResultSet rs;
        String sql = "select * from Examinations where patientId='"+patient.getRegId()+"'";
        rs = myDb.read(sql);
        try {
            while (myDb != null && rs != null && rs.next()) {

                examination.setPatientId(rs.getString("patientId"));
                examination.setComment(rs.getString("comment"));
                examination.setDoctorId(rs.getString("doctorId"));
                examination.setDate(rs.getString("date"));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return examination;
    }

    @Override
    public boolean update(Object o) {
        return false;
    }

    @Override
    public boolean delete(Object o) {
        Patient patient = (Patient) o;
        String sql = "delete from Examinations where patientId='"+patient.getRegId()+"'";

        int rows = myDb.write(sql);
        boolean status =  testRowsAffected(rows);

        return status;
    }

    @Override
    public ArrayList<Object> getAll() {
        Examination examination = new Examination();
        ArrayList<Object> examinations = new ArrayList<Object>();

        String sql = "select * from Examinations";
        ResultSet rs = myDb.read(sql);

        try {
            while (rs != null && rs.next()){
                examination.setExamId(rs.getString("id"));
                examination.setDoctorId(rs.getString("doctorId"));
                examination.setPatientId(rs.getString("patientId"));
                examination.setComment(rs.getString("comment"));
                examination.setDate(rs.getString("date"));

                examinations.add(examination);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return examinations;
    }

    private static boolean testRowsAffected(int k){
        boolean status =false;
        if (k>0){
            status = true;
        }
        return status;
    }
}
