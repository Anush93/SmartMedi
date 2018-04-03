/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementsystem.PatientReg;

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
public class patientRegDB {
    String url = "jdbc:mysql://localhost:3306/mydb";
    String username = "root";
    String password = "";
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    void patientRegistr(patientRegistration pr) throws SQLException{
        
            con = (Connection)DriverManager.getConnection(url, username, password); //get the connection
            
            String query = "INSERT INTO preg VALUES(?,?,?,?,?,?) ";
            pst = (PreparedStatement)con.prepareStatement(query);
            
            
            pst.setInt(1, pr.getpRegId()); //add values to the sql query
            pst.setString(2, pr.getDate());//add values to the sql query
            pst.setString(3, pr.getExPhysician());//add values to the sql query
            pst.setInt(4, pr.getComfirmedConsultantId());//add values to the sql query
            pst.setInt(5, pr.getWardNo());//add values to the sql query
            pst.setInt(6, pr.getpId());//add values to the sql query
           
        
            pst.executeUpdate(); // execute the sql query and insert the values to the db table 
            
          
      
        
        
    }
    ArrayList<patientRegistration> getPatientREg(patientRegistration pdt){
        try {
            
       
            ArrayList<patientRegistration> list = new ArrayList<>();
            con = (Connection)DriverManager.getConnection(url, username, password); //get the connection
            
            String query = "SELECT * FROM preg WHERE pId ="+pdt.getSearchPatientId();
           
            pst = (PreparedStatement)con.prepareStatement(query);
             //pst = (PreparedStatement)con.prepareStatement("SELECT * patientinfo WHERE pId=?");
            
            
            
            rs = pst.executeQuery(); // execute the sql query and insert the values to the db table 
            
            while(rs.next()){
                patientRegistration pr = new patientRegistration();
                pr.setpRegId(rs.getInt(1));
                pr.setDate(rs.getString(2));
                pr.setExPhysician(rs.getString(3));
                pr.setComfirmedConsultantId(rs.getInt(4));
                pr.setWardNo(rs.getInt(5));
                pr.setpId(rs.getInt(6));
               
                list.add(pr);
                
            }
            
            return list;
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Please check your PId and try");
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
    public boolean updatePatientReg(patientRegistration pr){
      try {
            
       
            
            con = (Connection)DriverManager.getConnection(url, username, password); //get the connection
            
            //String query = 
            
            pst = (PreparedStatement)con.prepareStatement("UPDATE preg SET Date=?,exPhysicianName=?,confirmConsultantEId=?,wardNo=?,pId=? WHERE regNo=?");
            pst.setString(1, pr.getDate());
            pst.setString(2,pr.getExPhysician() );
            pst.setInt(3, pr.getComfirmedConsultantId());
            pst.setInt(4, pr.getWardNo());
            pst.setInt(5, pr.getpId());
            pst.setInt(6, pr.getUpdateRegID());
            
            
            
            
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
    public boolean deletePatientReg(patientRegistration pr){
      try {
            
       
            
            con = (Connection)DriverManager.getConnection(url, username, password); //get the connection
            
            String query = "DELETE FROM preg WHERE regNo="+pr.getUpdateRegID();
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
    int getPatientMaxRegId(){
        try {
            
       
            ArrayList<patientRegistration> list = new ArrayList<>();
            con = (Connection)DriverManager.getConnection(url, username, password); //get the connection
            
            String regNo = "SELECT MAX(regNo) AS RId FROM preg";
            pst = (PreparedStatement)con.prepareStatement(regNo);
            
            
            
            rs = pst.executeQuery(); // execute the sql query and insert the values to the db table
            int a = 0;
             while(rs.next()){
            
             a = rs.getInt(1);
                
                
             }
             return a;
            
           
            
        } catch (Exception e) {
            
         return 0;   
            
            
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
