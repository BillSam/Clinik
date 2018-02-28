package pojos.actions;

import pojos.users.Doctor;
import pojos.users.Patient;

/**
 * Created by error on 2/6/18.
 */
public class Examination {

    private String examId;
    private String doctorId;
    private String patientId;
    private String comment;
    private String time;
    private String date;


    public String getExamId() {
        return examId;
    }

    public void setExanId(String examId) {
        this.examId = examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
