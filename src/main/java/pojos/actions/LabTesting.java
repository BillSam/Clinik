package pojos.actions;

import pojos.users.LabTechnician;
import pojos.users.Patient;

/**
 * Created by error on 2/6/18.
 */
public class LabTesting {
    private String testId;
    private String testType;
    private String patientId;
    private String labTechnicianId;
    private String results;
    private String time;
    private String date;

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getLabTechnicianId() {
        return labTechnicianId;
    }

    public void setLabTechnicianId(String labTechnicianId) {
        this.labTechnicianId = labTechnicianId;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
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
