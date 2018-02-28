package logic.beanImp;

import daos.daosImpl.VitalsDao;
import logic.beanInterface.PatientVitalsBeanIn;
import pojos.actions.PatientVitals;
import pojos.users.Patient;

import javax.enterprise.context.RequestScoped;

/**
 * Created by error on 2/21/18.
 */
@RequestScoped
public class PatientVitalsBean implements PatientVitalsBeanIn{
    private VitalsDao patientVitalsDao = null;

    public PatientVitalsBean() {
        patientVitalsDao = new VitalsDao();
    }

    @Override
    public boolean addPatientVitals(PatientVitals vitals) {

        return patientVitalsDao.create(vitals);
    }



    @Override
    public boolean updatePatientVitals(PatientVitals vitals) {
        return false;
    }

    @Override
    public PatientVitals getPatientVitals(Patient patient) {

        return patientVitalsDao.read(patient);
    }

    @Override
    public boolean deletePatientVitals(Patient patient) {
        return patientVitalsDao.delete(patient);
    }
}
