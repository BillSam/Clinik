package logic.beanImp;

import daos.daosImpl.PatientDao;
import logic.beanInterface.PatientBeanIn;
import pojos.users.Patient;

import javax.enterprise.context.RequestScoped;
import java.util.ArrayList;

/**
 * Created by error on 2/21/18.
 */
@RequestScoped
public class PatientBean implements PatientBeanIn{
    private PatientDao patientDao = null;

    public PatientBean() {
         patientDao = new PatientDao();
    }

    public boolean registerPatient(Patient patient){
        boolean status = false;
        if (!verifyPatient(patient))
            status = patientDao.create(patient);

        return status;
    }
    public boolean verifyPatient(Patient patient){
        Patient patient1 = new Patient();

       patient1 =  patientDao.read(patient);

       if (patient1.getRegId().equals(patient.getRegId()))
           return true;
       return false;
    }

    @Override
    public Patient getPatientDetails(Patient patient) {
        Patient patient1 = new Patient();
        patient1 = patientDao.read(patient);

        return patient1;
    }

    @Override
    public boolean updatePatient(Patient patient) {
        return patientDao.update(patient);
    }

    @Override
    public boolean deletePatient(Patient patient) {
        return  patientDao.delete(patient);
    }

    @Override
    public ArrayList<Patient> getpatients() {
        return null;
    }


}
