/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementsystem.StaffInfo;

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
public class DBStaff {
    String url = "jdbc:mysql://localhost:3306/mydb";
    String username = "root";
    String password = "";
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    void staffInfo(staffInformation si) throws SQLException{
        
            con = (Connection)DriverManager.getConnection(url, username, password); //get the connection
            
            String query = "INSERT INTO staffinformation VALUES(?,?,?,?,?,?,?,?) ";
            pst = (PreparedStatement)con.prepareStatement(query);
            
            
            pst.setInt(1, si.getEmployeeID()); //add values to the sql query
            pst.setString(2, si.getName());//add values to the sql query
            pst.setString(3, si.getOccupation());//add values to the sql query
            pst.setString(4, si.getConsultant());//add values to the sql query
            pst.setString(5, si.getBirthday());//add values to the sql query
            pst.setString(6, si.getGender());//add values to the sql query
            pst.setInt(7, si.getTeleNo());//add values to the sql query
            pst.setString(8, si.getAddress());//add values to the sql query
           
            pst.executeUpdate(); // execute the sql query and insert the values to the db table 
            
          
      
        
        
    }
    
    ArrayList<staffInformation> getStaffInfo(staffInformation si){
        try {
            
       
            ArrayList<staffInformation> list = new ArrayList<>();
            con = (Connection)DriverManager.getConnection(url, username, password); //get the connection
            
            String query = "SELECT * FROM staffinformation WHERE employeeId ="+si.getSearchEmployeeId();
            
            pst = (PreparedStatement)con.prepareStatement(query);
             //pst = (PreparedStatement)con.prepareStatement("SELECT * patientinfo WHERE pId=?");
            
            
            
            rs = pst.executeQuery(); // execute the sql query and insert the values to the db table 
           
            while(rs.next()){
                staffInformation SI = new staffInformation();
                SI.setEmployeeID(rs.getInt(1));
                SI.setName(rs.getString(2));
                SI.setOccupation(rs.getString(3));
                SI.setConsultant(rs.getString(4));
                SI.setBirthday(rs.getString(5));
                SI.setGender(rs.getString(6));
                SI.setTeleNo(rs.getInt(7));
                 SI.setAddress(rs.getString(8));
               
                list.add(SI);
                
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
    
    public boolean updatestaffInfo(staffInformation si){
      try {
            
       
            
            con = (Connection)DriverManager.getConnection(url, username, password); //get the connection
            
            //String query = 
            
            pst = (PreparedStatement)con.prepareStatement("UPDATE staffinformation SET name=?,occupation=?,isConsultant=?,birthday=?,gender=?,teleNo=?,address=? WHERE employeeId=?");
            pst.setString(1, si.getName());
            pst.setString(2,si.getOccupation() );
            pst.setString(3, si.getConsultant());
            pst.setString(4, si.getBirthday());
            pst.setString(5, si.getGender());
            pst.setInt(6, si.getTeleNo());
            pst.setString(7, si.getAddress());
            pst.setInt(8, si.getUpdateEmployeeId());
            
            
            
            
            pst.executeUpdate(); // execute the sql query and insert the values to the db table 
            return true; 
            
        } catch (Exception e) {
        
            
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
    
    public boolean deleteStaffInfo(staffInformation si){
      try {
            
       
            
            con = (Connection)DriverManager.getConnection(url, username, password); //get the connection
            
            String query = "DELETE FROM staffinformation WHERE employeeId="+si.getUpdateEmployeeId();
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
