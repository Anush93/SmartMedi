/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementsystem.pTreatment;

/**
 *
 * @author Anush
 */
public class patientTreatment {
    private int treatmentID;
    private String date;
    private int exDoctorID;
    private String status;
    private int regNo;
    private int searchingID;

    /**
     * @return the treatmentID
     */
    public int getTreatmentID() {
        return treatmentID;
    }

    /**
     * @param treatmentID the treatmentID to set
     */
    public void setTreatmentID(int treatmentID) {
        this.treatmentID = treatmentID;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the exDoctorID
     */
    public int getExDoctorID() {
        return exDoctorID;
    }

    /**
     * @param exDoctorID the exDoctorID to set
     */
    public void setExDoctorID(int exDoctorID) {
        this.exDoctorID = exDoctorID;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the regNo
     */
    public int getRegNo() {
        return regNo;
    }

    /**
     * @param regNo the regNo to set
     */
    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    /**
     * @return the searchingID
     */
    public int getSearchingID() {
        return searchingID;
    }

    /**
     * @param searchingID the searchingID to set
     */
    public void setSearchingID(int searchingID) {
        this.searchingID = searchingID;
    }
    
}
