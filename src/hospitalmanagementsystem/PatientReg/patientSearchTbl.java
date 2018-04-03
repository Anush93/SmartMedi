/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementsystem.PatientReg;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Anush
 */
public class patientSearchTbl extends AbstractTableModel {
     private static final String[] COLUMN_NAMES ={"PatientRegID","Date","ExPhysicianName","ComfirmedConsultantName","wardNo","patientId"};
     private static ArrayList<patientRegistration> list;

    patientSearchTbl(ArrayList<patientRegistration> ptrList){
        list = ptrList;
    }
     
     
      
    
    @Override
    public int getRowCount() {
        return list.size();
        
    }
     @Override
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
                return list.get(rowIndex).getpRegId();
            case 1:
                return list.get(rowIndex).getDate();
            case 2:
                return list.get(rowIndex).getExPhysician();
            case 3:
                return list.get(rowIndex).getComfirmedConsultantId();
            case 4:
                return list.get(rowIndex).getWardNo();
            case 5:
                return list.get(rowIndex).getpId();
             
            default:
                return "Error";
            
            
        }
        
    }
    
    
}
