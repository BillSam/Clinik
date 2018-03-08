package events;

/**
 * Created by error on 3/7/18.
 */
public class PaymentEvent {

    private String paymentType;
    public double value;

    public PaymentEvent(String paymentType, double value) {
        this.setPaymentType(paymentType);
        this.setValue(value);

    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

}
