/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementsystem.pTreatment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Anush
 */
public class DBTreatment {
    String url = "jdbc:mysql://localhost:3306/mydb";
    String username = "root";
    String password = "";
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    void pTreatment(patientTreatment pt) throws SQLException{
        
            con = (Connection)DriverManager.getConnection(url, username, password); //get the connection
            
            String query = "INSERT INTO ptreatment VALUES(?,?,?,?,?) ";
            pst = (PreparedStatement)con.prepareStatement(query);
            
            
            pst.setInt(1, pt.getTreatmentID()); //add values to the sql query
            pst.setString(2, pt.getDate());//add values to the sql query
            pst.setInt(3, pt.getExDoctorID());//add values to the sql query
            pst.setString(4, pt.getStatus());//add values to the sql query
            pst.setInt(5, pt.getRegNo());//add values to the sql query
           
           
            pst.executeUpdate(); // execute the sql query and insert the values to the db table 
            
          
      
        
        
    }
    
    ArrayList<patientTreatment> getPatientREg(patientTreatment ptt){
        try {
            
       
            ArrayList<patientTreatment> list = new ArrayList<>();
            con = (Connection)DriverManager.getConnection(url, username, password); //get the connection
            
            String query = "SELECT * FROM ptreatment WHERE regNo ="+ptt.getSearchingID();
            
            pst = (PreparedStatement)con.prepareStatement(query);
             //pst = (PreparedStatement)con.prepareStatement("SELECT * patientinfo WHERE pId=?");
            
            
            
            rs = pst.executeQuery(); // execute the sql query and insert the values to the db table 
            
            while(rs.next()){
                patientTreatment pt = new patientTreatment();
                pt.setTreatmentID(rs.getInt(1));
                pt.setDate(rs.getString(2));
                pt.setExDoctorID(rs.getInt(3));
                pt.setStatus(rs.getString(4));
                pt.setRegNo(rs.getInt(5));
               
               
                list.add(pt);
                
            }
            
            return list;
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Please check your RegNo and try");
            return null;
            
            
        }finally{
            try {
                if (pst != null){
                    con.close();
                }
                if (con != null){
                    con.close();
                }
                
            } catch (Exception e) {
            }
        }
        
        
    }
    
    public boolean updatePatientTreatment(patientTreatment pt){
      try {
            
       
            
            con = (Connection)DriverManager.getConnection(url, username, password); //get the connection
            
            //String query = 
            
            pst = (PreparedStatement)con.prepareStatement("UPDATE ptreatment SET date=?,examineDoctorId=?,status=?,regNo=? WHERE treatmentId=?");
            pst.setString(1, pt.getDate());
            pst.setInt(2,pt.getExDoctorID() );
            pst.setString(3, pt.getStatus());
            pst.setInt(4, pt.getRegNo());
            pst.setInt(5, pt.getTreatmentID());
           
            
            pst.executeUpdate(); // execute the sql query and insert the values to the db table 
            return true; 
            
        } catch (Exception e) {
        
            System.out.print(e);
            return false;
            
            
        }finally{
            try {
                if (pst != null){
                    con.close();
                }
                if (con != null){
                    con.close();
                }
                
            } catch (Exception e) {
            }
        } 
   }
     public boolean deletePatientTreatment(patientTreatment pt){
      try {
            
       
            
            con = (Connection)DriverManager.getConnection(url, username, password); //get the connection
            
            String query = "DELETE FROM ptreatment WHERE treatmentId="+pt.getTreatmentID();
            pst = (PreparedStatement)con.prepareStatement(query);
            
            
            
            pst.executeUpdate(); // execute the sql query and insert the values to the db table 
            return true; 
            
        } catch (Exception e) {
            System.out.print(e);
            return false;
            
            
        }finally{
            try {
                if (pst != null){
                    con.close();
                }
                if (con != null){
                    con.close();
                }
                
            } catch (Exception e) {
            }
        } 
    }
    
}
