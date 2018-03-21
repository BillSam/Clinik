package logic.beanInterface;

import pojos.actions.Booking;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by error on 2/21/18.
 */
@Remote
public interface BookingInt {
    boolean createBooking(Booking booking);
    Booking getBooking(String id);
    boolean updateBooking(Booking booking);
    boolean deleteBooking(String id);
    List getAllBookings();
}
