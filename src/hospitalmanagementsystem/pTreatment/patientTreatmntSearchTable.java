/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementsystem.pTreatment;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Anush
 */
public class patientTreatmntSearchTable extends AbstractTableModel{
     private static final String[] COLUMN_NAMES ={"TreatmentID","Date","ExDoctorId","Status"};
     private static ArrayList<patientTreatment> list;

    patientTreatmntSearchTable(ArrayList<patientTreatment> ptTList){
        list = ptTList;

    
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
    public String getColumnName(int columnIndex){
        return COLUMN_NAMES[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getTreatmentID();
            case 1:
                return list.get(rowIndex).getDate();
            case 2:
                return list.get(rowIndex).getExDoctorID();
            case 3:
                return list.get(rowIndex).getStatus();
            
             
            default:
                return "Error";
            
            
        }
        
        }
    
    
}
