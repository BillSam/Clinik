package pojos.actions;

import pojos.users.Patient;
import pojos.users.Pharmacist;

/**
 * Created by error on 2/6/18.
 */
public class Dispense {

    private String dispenceId;
    private Patient patient;
    private Pharmacist pharmacist;
    private String drugs;
    private String time;
    private String date;

    public String getDispenceId() {
        return dispenceId;
    }

    public void setDispenceId(String dispenceId) {
        this.dispenceId = dispenceId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Pharmacist getPharmacist() {
        return pharmacist;
    }

    public void setPharmacist(Pharmacist pharmacist) {
        this.pharmacist = pharmacist;
    }

    public String getDrugs() {
        return drugs;
    }

    public void setDrugs(String drugs) {
        this.drugs = drugs;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
