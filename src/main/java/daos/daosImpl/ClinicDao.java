package daos.daosImpl;

import DataMapper.DbUtil;
import pojos.actions.*;
import pojos.users.Patient;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by error on 2/12/18.
 */
public class ClinicDao {


    private DbUtil myDb =null;

    public ClinicDao() {
        myDb = new DbUtil();
    }



    public boolean getPatient(Patient patient){
        boolean status = true;
        ResultSet rs =null;
        String sql;
        sql = "select * from patientsDetails where id='"+patient.getRegId()+"'";
        try {
            if (myDb != null) {
                rs = myDb.read(sql);

                if (rs!= null && rs.next()){
                    status = false;
                }else {
                    status = true;
                }
            }else if (myDb == null){
                status= true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;

    }

    /*public ArrayList<String> getDoctorsActive(){
        ResultSet rs = null;
        ArrayList<Doctor> doctors = new ArrayList<>();
        Doctor doctor = new Doctor();

        String sql = "select * from users where profession='Doctor' and isLoggedIn=true";
        if (myDb != null){

            rs = myDb.read(sql);
            try {
                if (rs!=null) {
                    while (rs.next()) {

                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    return doctors;
    }*/





    public boolean test(LabTesting labTest) {
        boolean status = false;
        int k =0;
        String sql;
        sql = "insert into labTests(testId,testType,pojos.users.Patient,results,time,date) values('"+labTest.getTestId()+"','"+labTest.getTestType()+"','"
                +labTest.getPatientId()+"','"+labTest.getResults()+"','"+labTest.getTime()+"','"+labTest.getDate()+"')";

        k = myDb.write(sql);
        status = testRowsAffected(k);

        return status;


    }
    public ResultSet viewPastTestsRecords(Patient patient){
        ResultSet rs = null;
        String sql;
        sql = "select * from labTests where id='"+patient.getRegId()+"'";

        rs = myDb.read(sql);

        return rs;

    }

    public boolean prescribe(Prescription prescription) {

        boolean status = false;
        int k = 0;
        String sql;
        sql ="insert into prescriptions(prescriptionId,patient,doctor,drug,time,date) values('"+prescription.getPrescriptionId()+"','"+prescription.getPatient()+"','"
                +prescription.getDoctor()+"','"+prescription.getDoctor()+"','"+prescription.getTime()+"','"+prescription.getDate()+"')";
        status = testRowsAffected(myDb.write(sql));
        return status;

    }


    public boolean dispense(Dispense dispense) {
        boolean status = false;
        int k = 0;
        String sql;

        sql ="insert into prescriptions(dispenseId,patient,drugs,time,date) values('"+dispense.getDispenceId()+"','"+dispense.getPatient()+"','"
                +dispense.getDrugs()+"','"+dispense.getTime()+"','"+dispense.getDate()+"')";
        status = testRowsAffected(myDb.write(sql));

        return status;

    }

    public boolean pay(Payment payment) {
        boolean status = false;
        int k =0;
        String sql;
        sql="insert into prescriptions(paymentId,patient,payment,time,date) values('"+payment.getPaymentId()+"','"+payment.getPatient()+"','"
                +payment.getPayment()+"','"+payment.getTime()+"','"+payment.getDate()+"')";

        status = testRowsAffected(myDb.write(sql));
        return status;
    }

    private static boolean testRowsAffected(int k){
        boolean status =false;
        if (k>0){
            status = true;
        }
        return status;
    }



}
