package logic.beanInterface;

import pojos.actions.*;

/**
 * Created by error on 2/6/18.
 */
public interface ClinicBeanInterface {

    //ArrayList<String> getAvailableDoctors();

    //boolean registerPatient(Patient patient);
    //boolean registerUser(User user);
    boolean book(Booking booking);
    boolean examine(Examination examination);
    boolean test(LabTesting labTest);
    boolean prescribe(Prescription prescription);
    boolean dispense(Dispense dispense);
    boolean pay(Payment payment);



}
