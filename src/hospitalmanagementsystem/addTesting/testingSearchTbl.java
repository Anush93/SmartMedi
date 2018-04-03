/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementsystem.addTesting;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Anush
 */
public class testingSearchTbl extends AbstractTableModel{
    
    private static final String[] COLUMN_NAMES ={"TestID","Date","Type","Description"};
     private static ArrayList<patientTesting> list;

    testingSearchTbl(ArrayList<patientTesting> ptTList){
        list = ptTList;
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
                return list.get(rowIndex).getTestID();
            case 1:
                return list.get(rowIndex).getDate();
            case 2:
                return list.get(rowIndex).getType();
            case 3:
                return list.get(rowIndex).getDescription();
           
            default:
                return "Error";
            
            
        }
     }
    
}
