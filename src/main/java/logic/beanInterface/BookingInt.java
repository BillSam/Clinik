package logic.beanInterface;

import pojos.actions.Booking;

import javax.ejb.Remote;

/**
 * Created by error on 2/21/18.
 */
@Remote
public interface BookingInt {
    boolean createBooking(Booking booking);
    boolean getBooking(Booking booking);
    boolean updateBooking(Booking booking);
    boolean deleteBooking(Booking booking);
}
