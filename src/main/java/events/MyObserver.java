package events;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;

/**
 * Created by error on 3/7/18.
 */
@RequestScoped
public class MyObserver {


    public void doPayment(@Observes PaymentEvent paymentEvent){

        System.out.println("Observed  a fired object from : " + paymentEvent.getPaymentType());



    }

}
