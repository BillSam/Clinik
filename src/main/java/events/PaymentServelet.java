package events;

import pojos.users.Patient;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by error on 3/7/18.
 */
@WebServlet(urlPatterns = "/payment")
public class PaymentServelet extends HttpServlet {
    @Inject
    Event<PaymentEvent> paymentEventEvent;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PaymentEvent paymentEvent = new PaymentEvent("Credit", 50000);

        System.out.println("Before fire");

        paymentEventEvent.fire(paymentEvent);



    }
}
