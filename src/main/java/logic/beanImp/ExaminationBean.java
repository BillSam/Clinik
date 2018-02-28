package logic.beanImp;

import daos.daosImpl.ExaminationDao;
import logic.beanInterface.ExaminationIn;
import pojos.actions.Examination;
import pojos.users.Patient;

/**
 * Created by error on 2/26/18.
 */
public class ExaminationBean implements ExaminationIn {
    private ExaminationDao examinationDao = null;

    public ExaminationBean() {
        examinationDao = new ExaminationDao();
    }

    @Override
    public boolean createExamination(Examination examination) {

        return examinationDao.create(examination);

    }

    @Override
    public Examination readExamination(Patient patient) {

        return examinationDao.read(patient);
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
