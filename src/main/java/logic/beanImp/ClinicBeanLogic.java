package logic.beanImp;

import daos.daosImpl.ClinicDao;
import logic.beanInterface.ClinicBeanInterface;
import pojos.actions.*;

import javax.enterprise.context.RequestScoped;

/**
 * Created by error on 2/6/18.
 */
@RequestScoped
public class  ClinicBeanLogic implements ClinicBeanInterface {
    private ClinicDao clinicDao = null;

    public ClinicBeanLogic() {
        clinicDao = new ClinicDao();
    }


    /*@Override
    public ArrayList<String> getAvailableDoctors() {

        return clinicDao.getDoctorsActive();
    }*/

    public boolean book(Booking booking) {
        return false;
    }

    public boolean examine(Examination examination) {
        return false;
    }

    public boolean test(LabTesting labTest) {
        return false;
    }

    public boolean prescribe(Prescription prescription) {
        return false;
    }

    public boolean dispense(Dispense dispense) {
        return false;
    }

    public boolean pay(Payment payment) {
        return false;
    }
}
