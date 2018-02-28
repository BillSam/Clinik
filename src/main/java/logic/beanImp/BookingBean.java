package logic.beanImp;

import daos.daosImpl.BookingDao;
import logic.beanInterface.BookingInt;
import pojos.actions.Booking;

import javax.enterprise.context.RequestScoped;

/**
 * Created by error on 2/21/18.
 */
@RequestScoped
public class BookingBean implements BookingInt {

    private BookingDao bookingDao = null;

    public BookingBean() {
        bookingDao = new BookingDao();
    }

    @Override
    public boolean createBooking(Booking booking) {

       // return bookingDao.createBooking(booking);

        return true;
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
