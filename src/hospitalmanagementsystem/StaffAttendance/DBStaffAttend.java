/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementsystem.StaffAttendance;

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
public class DBStaffAttend {
     String url = "jdbc:mysql://localhost:3306/mydb";
    String username = "root";
    String password = "";
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    void staffAtt(staffAttend sa) throws SQLException{
        
            con = (Connection)DriverManager.getConnection(url, username, password); //get the connection
            
            String query = "INSERT INTO sattendance VALUES(?,?,?,?,?) ";
            pst = (PreparedStatement)con.prepareStatement(query);
            
            
            pst.setInt(1, sa.getAttendID()); //add values to the sql query
            pst.setInt(2, sa.geteID());//add values to the sql query
            pst.setString(3, sa.getDate());//add values to the sql query
            pst.setString(4, sa.getIntime());//add values to the sql query
            pst.setString(5, sa.getOutTime());//add values to the sql query
          
           
        
            pst.executeUpdate(); // execute the sql query and insert the values to the db table 
            
          
      
        
        
    }
    
    ArrayList<staffAttend> getStaffAttend(staffAttend sa){
        try {
            
       
            ArrayList<staffAttend> list = new ArrayList<>();
            con = (Connection)DriverManager.getConnection(url, username, password); //get the connection
            
            String query = "SELECT * FROM sattendance WHERE employeeId ="+sa.getSearchEID();
            
            pst = (PreparedStatement)con.prepareStatement(query);
             //pst = (PreparedStatement)con.prepareStatement("SELECT * patientinfo WHERE pId=?");
            
            
            
            rs = pst.executeQuery(); // execute the sql query and insert the values to the db table 
            
            while(rs.next()){
                staffAttend SA = new staffAttend();
                SA.setAttendID(rs.getInt(1));
                SA.seteID(rs.getInt(2));
                SA.setDate(rs.getString(3));
                SA.setIntime(rs.getString(4));
                SA.setOutTime(rs.getString(5));
                
               
                list.add(SA);
                
            }
            
            return list;
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Please check your EmployeeId and try");
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
    
     public boolean updatestaffAttend(staffAttend sa){
      try {
            
       
            
            con = (Connection)DriverManager.getConnection(url, username, password); //get the connection
            
            //String query = 
            
            pst = (PreparedStatement)con.prepareStatement("UPDATE sattendance SET employeeId=?,date=?,inTime=?,outTime=? WHERE attendanceId=?");
            pst.setInt(1, sa.geteID());
            pst.setString(2,sa.getDate());
            pst.setString(3, sa.getIntime());
            pst.setString(4, sa.getOutTime());
            pst.setInt(5, sa.getUpdateAttendanceId());
           
            
            
            
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
     
      public boolean deleteStaffAttendance(staffAttend sa){
      try {
            
       
            
            con = (Connection)DriverManager.getConnection(url, username, password); //get the connection
            
            String query = "DELETE FROM sattendance WHERE attendanceId="+sa.getUpdateAttendanceId();
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
