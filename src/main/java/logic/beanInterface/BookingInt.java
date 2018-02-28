package logic.beanInterface;

import pojos.actions.Booking;

/**
 * Created by error on 2/21/18.
 */
public interface BookingInt {
    boolean createBooking(Booking booking);
    boolean getBooking(Booking booking);
    boolean updateBooking(Booking booking);
    boolean deleteBooking(Booking booking);
}
