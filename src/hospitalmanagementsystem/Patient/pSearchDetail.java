/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementsystem.Patient;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Anush
 */
public class pSearchDetail extends AbstractTableModel{
     private static final String[] COLUMN_NAMES ={"pID","Name","Gender","Birthday","Phone","Address","BloodGroup","NIC"};
     private static ArrayList<patientDetail> list;

    pSearchDetail(ArrayList<patientDetail> ptList){
        list = ptList;
    }
     
     
      
    
    @Override
    public int getRowCount() {
        return list.size();
        
    }
    public String getColumnName(int columnIndex){
        return COLUMN_NAMES[columnIndex];
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getpId();
            case 1:
                return list.get(rowIndex).getName();
            case 2:
                return list.get(rowIndex).getGender();
            case 3:
                return list.get(rowIndex).getBirthday();
            case 4:
                return list.get(rowIndex).getPhone();
            case 5:
                return list.get(rowIndex).getAddress();
            case 6:
                return list.get(rowIndex).getBloodGroup();
            case 7:
                return list.get(rowIndex).getNIC(); 
            default:
                return "Error";
            
            
        }
        
    }
    
}
