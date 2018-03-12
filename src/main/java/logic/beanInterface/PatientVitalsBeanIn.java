package logic.beanInterface;

import pojos.actions.PatientVitals;
import pojos.users.Patient;

import javax.ejb.Remote;

/**
 * Created by error on 2/21/18.
 */
@Remote
public interface PatientVitalsBeanIn {

    boolean addPatientVitals(PatientVitals vitals);
    PatientVitals getPatientVitals(Patient patient);
    boolean updatePatientVitals(PatientVitals vitals);
    boolean deletePatientVitals(Patient patient);
}
