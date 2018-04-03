/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementsystem.Patient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Anush
 */
public class dbPatient {
    String url = "jdbc:mysql://localhost:3306/mydb";
    String username = "root";
    String password = "";
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    boolean patientInformation(patientDetail pd){
        try {
            con = (Connection)DriverManager.getConnection(url, username, password); //get the connection
            
            String query = "INSERT INTO patientinfo VALUES(?,?,?,?,?,?,?,?) ";
            pst = (PreparedStatement)con.prepareStatement(query);
            
            
            pst.setInt(1, pd.getpId()); //add values to the sql query
            pst.setString(2, pd.getName());//add values to the sql query
            pst.setString(3, pd.getGender());//add values to the sql query
            pst.setString(4,pd.getBirthday());//add values to the sql query
            pst.setInt(5, pd.getPhone());//add values to the sql query
            pst.setString(6, pd.getAddress());//add values to the sql query
            pst.setString(7, pd.getBloodGroup());//add values to the sql query
            pst.setString(8, pd.getNIC());//add values to the sql query
        
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
    ArrayList<patientDetail> getPatient(patientDetail pdt){
        try {
            
       
            ArrayList<patientDetail> list = new ArrayList<>();
            con = (Connection)DriverManager.getConnection(url, username, password); //get the connection
            
            String query = "SELECT * FROM patientinfo WHERE pId ="+pdt.getSearchNIC();
            pst = (PreparedStatement)con.prepareStatement(query);
            
            
            
            rs = pst.executeQuery(); // execute the sql query and insert the values to the db table 
            while(rs.next()){
                patientDetail pd = new patientDetail();
                pd.setpId(rs.getInt(1));
                pd.setName(rs.getString(2));
                pd.setGender(rs.getString(3));
                pd.setBirthday(rs.getString(4));
                pd.setPhone(rs.getInt(5));
                pd.setAddress(rs.getString(6));
                pd.setBloodGroup(rs.getString(7));
                pd.setNIC(rs.getString(8));
                list.add(pd);
                
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
   public boolean updatePatient(patientDetail pd){
      try {
            
       
            
            con = (Connection)DriverManager.getConnection(url, username, password); //get the connection
          
            //String query = 
            
            pst = (PreparedStatement)con.prepareStatement("UPDATE patientinfo SET name=?,gender=?,birthday=?,phone=?,address=?,bloodGroup=?,NIC=? WHERE pId=?");
            pst.setString(1, pd.getName());
            pst.setString(2,pd.getGender() );
            pst.setString(3, pd.getBirthday());
            pst.setInt(4, pd.getPhone());
            pst.setString(5, pd.getAddress());
            pst.setString(6, pd.getBloodGroup());
            pst.setString(7, pd.getNIC());
            pst.setInt(8, pd.getUpdatePID());
            
            
            
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
   public boolean deletePatient(patientDetail pd){
      try {
            
       
            
            con = (Connection)DriverManager.getConnection(url, username, password); //get the connection
           
            String query = "DELETE FROM patientinfo WHERE pId="+pd.getUpdatePID();
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
       
   int getPatientMaxId(){
        try {
            
       
            ArrayList<patientDetail> list = new ArrayList<>();
            con = (Connection)DriverManager.getConnection(url, username, password); //get the connection
           
            String PId = "SELECT MAX(pId) AS Id FROM patientinfo";
            pst = (PreparedStatement)con.prepareStatement(PId);
            
            
            
            rs = pst.executeQuery(); // execute the sql query and get the values from the db table
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


