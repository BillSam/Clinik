package logic.beanInterface;

import pojos.actions.PatientVitals;
import pojos.users.Patient;

/**
 * Created by error on 2/21/18.
 */
public interface PatientVitalsBeanIn {

    boolean addPatientVitals(PatientVitals vitals);
    PatientVitals getPatientVitals(Patient patient);
    boolean updatePatientVitals(PatientVitals vitals);
    boolean deletePatientVitals(Patient patient);
}
