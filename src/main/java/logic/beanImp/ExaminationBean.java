package logic.beanImp;

import daos.daosImpl.ExaminationDao;
import daos.daosInterface.Crud;
import daos.qualifiers.Clinic;
import logic.beanInterface.ExaminationIn;
import pojos.actions.Examination;
import pojos.users.Patient;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created by error on 2/26/18.
 */
@Stateless
public class ExaminationBean implements ExaminationIn {
    @Inject
    @Clinic(value = Clinic.clinicChoice.ExaminationDao)
    Crud examinationDao;

    @Override
    public boolean createExamination(Examination examination) {

        return examinationDao.create(examination);

    }

    @Override
    public Examination readExamination(Patient patient) {

        return (Examination) examinationDao.read(patient);
    }

    @Override
    public boolean updateExamination(Examination examination) {
        return examinationDao.update(examination);
    }

    @Override
    public boolean deleteExamination(Examination examination) {
        return examinationDao.delete(examination);
    }
}
