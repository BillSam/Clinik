package logic.beanImp;

import daos.daosImpl.VitalsDao;
import daos.daosInterface.Crud;
import daos.qualifiers.Clinic;
import logic.beanInterface.PatientVitalsBeanIn;
import pojos.actions.PatientVitals;
import pojos.users.Patient;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 * Created by error on 2/21/18.
 */
@Stateless
public class PatientVitalsBean implements PatientVitalsBeanIn{
    @Inject
    @Clinic(value = Clinic.clinicChoice.PatientVitals)
    Crud patientVitalsDao;

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

        return (PatientVitals) patientVitalsDao.read(patient);
    }

    @Override
    public boolean deletePatientVitals(Patient patient) {
        return patientVitalsDao.delete(patient);
    }
}
