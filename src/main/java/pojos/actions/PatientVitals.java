package pojos.actions;

import pojos.users.Patient;
import pojos.users.Receptionist;

import javax.enterprise.context.RequestScoped;

/**
 * Created by error on 2/7/18.
 */

public class PatientVitals {

    private int vitalsId;
    private String patientId;
    private String receptionistId;
    private double weight;
    private double height;
    private double bloodPressure;
    private String date;



    public int getVitalsId() {
        return vitalsId;
    }

    public void setVitalsId(int vitalsId) {
        this.vitalsId = vitalsId;
    }


    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getReceptionistId() {
        return receptionistId;
    }

    public void setReceptionistId(String receptionistId) {
        this.receptionistId = receptionistId;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(double bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
