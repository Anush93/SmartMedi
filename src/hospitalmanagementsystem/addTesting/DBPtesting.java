/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementsystem.addTesting;

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
public class DBPtesting {
    String url = "jdbc:mysql://localhost:3306/mydb";
    String username = "root";
    String password = "";
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    void patientTest(patientTesting pt) throws SQLException{
        
            con = (Connection)DriverManager.getConnection(url, username, password); //get the connection
            
            String query = "INSERT INTO ptesting VALUES(?,?,?,?,?) ";
            pst = (PreparedStatement)con.prepareStatement(query);
            
            
            pst.setInt(1, pt.getTestID()); //add values to the sql query
            pst.setString(2, pt.getDate());//add values to the sql query
            pst.setString(3, pt.getType());//add values to the sql query
            pst.setString(4, pt.getDescription());//add values to the sql query
            pst.setInt(5, pt.getRegNo());//add values to the sql query
          
           
        
            pst.executeUpdate(); // execute the sql query and insert the values to the db table 
            
          
      
        
        
    }
    
    
    ArrayList<patientTesting> getPatientTest(patientTesting pt){
        try {
            
       
            ArrayList<patientTesting> list = new ArrayList<>();
            con = (Connection)DriverManager.getConnection(url, username, password); //get the connection
            
            String query = "SELECT * FROM ptesting WHERE regNo ="+pt.getSearchPRegNO();
            
            pst = (PreparedStatement)con.prepareStatement(query);
             //pst = (PreparedStatement)con.prepareStatement("SELECT * patientinfo WHERE pId=?");
            
            
            
            rs = pst.executeQuery(); // execute the sql query and insert the values to the db table 
            
            while(rs.next()){
                patientTesting ptT = new patientTesting();
                ptT.setTestID(rs.getInt(1));
                ptT.setDate(rs.getString(2));
                ptT.setType(rs.getString(3));
                ptT.setDescription(rs.getString(4));
                ptT.setRegNo(rs.getInt(5));
               
                list.add(ptT);
                
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
    
    public boolean updatePatientReg(patientTesting pt){
      try {
            
       
            
            con = (Connection)DriverManager.getConnection(url, username, password); //get the connection
            
            //String query = 
            
            pst = (PreparedStatement)con.prepareStatement("UPDATE ptesting SET date=?,type=?,description=?,regNo=? WHERE testId=?");
            pst.setString(1,pt.getDate());
            pst.setString(2,pt.getType() );
            pst.setString(3, pt.getDescription());
            pst.setInt(4, pt.getRegNo());
            pst.setInt(5, pt.getTestID());
           
            
            
            
            
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
    
    public boolean deletePTesting(patientTesting pt){
      try {
            
       
            
            con = (Connection)DriverManager.getConnection(url, username, password); //get the connection
            
            String query = "DELETE FROM ptesting WHERE testId="+pt.getTestID();
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
