package logic.beanInterface;

import pojos.actions.Examination;
import pojos.users.Patient;

import javax.ejb.Remote;

/**
 * Created by error on 2/26/18.
 */
@Remote
public interface ExaminationIn {

    boolean createExamination(Examination examination);
    Examination readExamination(Patient patient);
    boolean updateExamination(Examination examination);
    boolean deleteExamination(Examination examination);
}

