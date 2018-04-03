/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementsystem.pPayment;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Anush
 */
public class pPaymentSearchTbl extends AbstractTableModel{
    
     private static final String[] COLUMN_NAMES ={"regNo","paymentID","wardCharges","med&treatment","Testing"};
     private static ArrayList<patientPayments> list;

     pPaymentSearchTbl(ArrayList<patientPayments> PPList){
        list = PPList;
     }
     
     @Override
      public String getColumnName(int columnIndex){
        return COLUMN_NAMES[columnIndex];
    }

    @Override
    public int getRowCount() {
        return list.size();
        }

    @Override
    public int getColumnCount() {
         return COLUMN_NAMES.length;
        }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getpRegNo();
            case 1:
                return list.get(rowIndex).getpPaymentId();
            case 2:
                return list.get(rowIndex).getWardCharges();
            case 3:
                return list.get(rowIndex).getTreatMedcine();
            case 4:
                return list.get(rowIndex).getTesting();
            
            default:
                return "Error";
            
      }
    }    
    
}
    
