package logic.beanInterface;

import pojos.users.Patient;

import java.util.ArrayList;

/**
 * Created by error on 2/21/18.
 */
public interface PatientBeanIn {

    boolean registerPatient(Patient patient);
    boolean verifyPatient(Patient patient);
    Patient getPatientDetails(Patient patient);
    boolean updatePatient(Patient patient);
    boolean deletePatient(Patient patient);
    ArrayList<Patient> getpatients();

}
