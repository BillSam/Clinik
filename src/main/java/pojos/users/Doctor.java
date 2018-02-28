package pojos.users;

/**
 * Created by error on 2/6/18.
 */
public class Doctor extends User {

    private String docId;
    private boolean isBooked;

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }



    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    @Override
    public String toString() {
        return this.docId;
    }
}
