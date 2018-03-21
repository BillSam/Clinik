package logic.beanImp;
import daos.daosInterface.Crud;
import daos.qualifiers.Clinic;
import logic.beanInterface.BookingInt;
import pojos.actions.Booking;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import java.util.List;

import static daos.qualifiers.Clinic.clinicChoice.BookingDao;

/**
 * Created by error on 2/21/18.
 */
@Stateless
public class BookingBean implements BookingInt {
    @Inject
    @Clinic(value = BookingDao)
    private Crud bookingDao;

    @Override
    public boolean createBooking(Booking booking) {

        return bookingDao.create(booking);

    }

    @Override
    public Booking getBooking(String id) {
        return null;
    }

    @Override
    public boolean updateBooking(Booking booking) {
        return false;
    }

    @Override
    public boolean deleteBooking(Booking booking) {
        return false;
    }

    @Override
    public List getAllBookings() {
        return null;
    }
}
