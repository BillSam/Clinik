package daos.daosImpl;

import DataMapper.DbUtil;
import daos.daosInterface.Crud;
import pojos.actions.Examination;
import pojos.actions.LabTesting;
import pojos.users.Patient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by error on 2/21/18.
 */
public class LabTestingDao implements Crud {
    private DbUtil myDb = null;

    public LabTestingDao() {
        myDb =  new DbUtil();
    }

    @Override
    public boolean create(Object o) {
        LabTesting labTesting = (LabTesting) o;

        String sql = "insert into labTests(id,patientId,LabTechId,testType,results) values(Null,'"+labTesting.getPatientId()+"','"+labTesting.getLabTechnicianId()+"','"+labTesting.getTestType()+"','"+labTesting.getResults()+"')";

        int rows = myDb.write(sql);

        return rows > 0;

    }

    @Override
    public LabTesting read(Object o) {
        Patient patient = (Patient) o;
        LabTesting labTests = new LabTesting();

        String sql ="select * from labTests where patientId='"+patient.getRegId()+"'";

        if (myDb != null){
            ResultSet rs = myDb.read(sql);

            try {
                while (rs != null && rs.next()){
                    labTests.setTestType(rs.getString("testType"));
                    labTests.setResults(rs.getString("results"));
                    labTests.setPatientId(rs.getString("patientId"));


                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }

        return labTests;
    }

    @Override
    public boolean update(Object o) {
        return false;
    }

    @Override
    public boolean delete(Object o) {
        Patient patient = (Patient) o;
        int k = 0;
        String sql= "delete from labTests where patientId='"+patient.getRegId()+"'";
        if (myDb != null)
            k = myDb.write(sql);

        return k>0;
    }

    @Override
    public ArrayList<Object> getAll() {
        return null;
    }


}
