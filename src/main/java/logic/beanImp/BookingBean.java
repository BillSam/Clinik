package logic.beanImp;
import daos.daosInterface.Crud;
import daos.qualifiers.Clinic;
import logic.beanInterface.BookingInt;
import pojos.actions.Booking;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 * Created by error on 2/21/18.
 */
@RequestScoped
public class BookingBean implements BookingInt {
    @Inject
    @Clinic(value= Clinic.clinicChoice.BookingDao)
    Crud bookingDao;

    @Override
    public boolean createBooking(Booking booking) {

        return bookingDao.create(booking);

    }

    @Override
    public boolean getBooking(Booking booking) {
        return false;
    }

    @Override
    public boolean updateBooking(Booking booking) {
        return false;
    }

    @Override
    public boolean deleteBooking(Booking booking) {
        return false;
    }
}
