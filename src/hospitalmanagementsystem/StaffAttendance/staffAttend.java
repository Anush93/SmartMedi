/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementsystem.StaffAttendance;

/**
 *
 * @author Anush
 */
public class staffAttend {
    private int attendID;
    private int eID;
    private String Date;
    private String intime;
    private String OutTime;
    private int SearchEID;
    private int updateAttendanceId;

    /**
     * @return the eID
     */
    public int geteID() {
        return eID;
    }

    /**
     * @param eID the eID to set
     */
    public void seteID(int eID) {
        this.eID = eID;
    }

    /**
     * @return the Date
     */
    public String getDate() {
        return Date;
    }

    /**
     * @param Date the Date to set
     */
    public void setDate(String Date) {
        this.Date = Date;
    }

    /**
     * @return the intime
     */
    public String getIntime() {
        return intime;
    }

    /**
     * @param intime the intime to set
     */
    public void setIntime(String intime) {
        this.intime = intime;
    }

    /**
     * @return the OutTime
     */
    public String getOutTime() {
        return OutTime;
    }

    /**
     * @param OutTime the OutTime to set
     */
    public void setOutTime(String OutTime) {
        this.OutTime = OutTime;
    }

    /**
     * @return the attendID
     */
    public int getAttendID() {
        return attendID;
    }

    /**
     * @param attendID the attendID to set
     */
    public void setAttendID(int attendID) {
        this.attendID = attendID;
    }

    /**
     * @return the SearchEID
     */
    public int getSearchEID() {
        return SearchEID;
    }

    /**
     * @param SearchEID the SearchEID to set
     */
    public void setSearchEID(int SearchEID) {
        this.SearchEID = SearchEID;
    }

    /**
     * @return the updateAttendanceId
     */
    public int getUpdateAttendanceId() {
        return updateAttendanceId;
    }

    /**
     * @param updateAttendanceId the updateAttendanceId to set
     */
    public void setUpdateAttendanceId(int updateAttendanceId) {
        this.updateAttendanceId = updateAttendanceId;
    }
    
}
