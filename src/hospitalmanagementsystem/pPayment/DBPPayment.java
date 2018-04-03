/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementsystem.pPayment;

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
public class DBPPayment {
    String url = "jdbc:mysql://localhost:3306/mydb";
    String username = "root";
    String password = "";
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    void patientPay(patientPayments pp) throws SQLException{
        
            con = (Connection)DriverManager.getConnection(url, username, password); //get the connection
            
            String query = "INSERT INTO ppayment VALUES(?,?,?,?,?) ";
            pst = (PreparedStatement)con.prepareStatement(query);
            
            
            pst.setInt(1, pp.getpPaymentId()); //add values to the sql query
            pst.setInt(2, pp.getWardCharges());//add values to the sql query
            pst.setInt(3, pp.getTreatMedcine());//add values to the sql query
            pst.setInt(4, pp.getTesting());//add values to the sql query
            pst.setInt(5, pp.getpRegNo());//add values to the sql query
          
           
        
            pst.executeUpdate(); // execute the sql query and insert the values to the db table 
            
          
      
        
        
    }
    
    ArrayList<patientPayments> getPPayments(patientPayments pp){
        try {
            
       
            ArrayList<patientPayments> list = new ArrayList<>();
            con = (Connection)DriverManager.getConnection(url, username, password); //get the connection
            
            String query = "SELECT * FROM ppayment WHERE pReg_regNo ="+pp.getSearchRegNo();
            
            pst = (PreparedStatement)con.prepareStatement(query);
             //pst = (PreparedStatement)con.prepareStatement("SELECT * patientinfo WHERE pId=?");
            
            
            
            rs = pst.executeQuery(); // execute the sql query and insert the values to the db table 
            
            while(rs.next()){
                patientPayments PP = new patientPayments();
                PP.setpPaymentId(rs.getInt(1));
                PP.setWardCharges(rs.getInt(2));
                PP.setTreatMedcine(rs.getInt(3));
                PP.setTesting(rs.getInt(4));
                PP.setpRegNo(rs.getInt(5));
                
               
                list.add(PP);
                
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
    
     public boolean updatePPayments(patientPayments pp){
      try {
            
       
            
            con = (Connection)DriverManager.getConnection(url, username, password); //get the connection
            
            //String query = 
            
            pst = (PreparedStatement)con.prepareStatement("UPDATE ppayment SET wardCharge=?,treatmentMedicine=?,testing=?,pReg_regNo=? WHERE pPaymentId=?");
            pst.setInt(1, pp.getWardCharges());
            pst.setInt(2, pp.getTreatMedcine());
            pst.setInt(3, pp.getTesting());
            pst.setInt(4, pp.getpRegNo());
            pst.setInt(5, pp.getUpdatePaymentId());
            
            
            
            
            
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
      public boolean deletePatientPayment(patientPayments pp){
      try {
            
       
            
            con = (Connection)DriverManager.getConnection(url, username, password); //get the connection
            
            String query = "DELETE FROM ppayment WHERE pPaymentId="+pp.getUpdatePaymentId();
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
