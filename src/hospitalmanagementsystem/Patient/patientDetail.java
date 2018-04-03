/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementsystem.Patient;

/**
 *
 * @author Anush
 */
public class patientDetail {
    private int pId;
    private String name;
    private String gender;
    private String birthday;
    private int phone;
    private String address;
    private String bloodGroup;
    private String NIC;
    
    private String searchNIC;
    private int updatePID;

    /**
     * @return the pId
     */
    public int getpId() {
        return pId;
    }

    /**
     * @param pId the pId to set
     */
    public void setpId(int pId) {
        this.pId = pId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the phone
     */
    public int getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(int phone) {
        this.phone = phone;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the bloodGroup
     */
    public String getBloodGroup() {
        return bloodGroup;
    }

    /**
     * @param bloodGroup the bloodGroup to set
     */
    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    /**
     * @return the NIC
     */
    public String getNIC() {
        return NIC;
    }

    /**
     * @param NIC the NIC to set
     */
    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    /**
     * @return the searchPID
     */
    

    /**
     * @return the searchNIC
     */
    public String getSearchNIC() {
        return searchNIC;
    }

    /**
     * @param searchNIC the searchNIC to set
     */
    public void setSearchNIC(String searchNIC) {
        this.searchNIC = searchNIC;
    }

    /**
     * @return the updatePID
     */
    public int getUpdatePID() {
        return updatePID;
    }

    /**
     * @param updatePID the updatePID to set
     */
    public void setUpdatePID(int updatePID) {
        this.updatePID = updatePID;
    }
    
}
