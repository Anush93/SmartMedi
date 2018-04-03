/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementsystem.StaffAttendance;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Anush
 */
public class staffAttendanceSearchTbl extends AbstractTableModel{
    
     private static final String[] COLUMN_NAMES ={"AttendanceId","Date","Intime","Outtime"};
     private static ArrayList<staffAttend> list;

     staffAttendanceSearchTbl(ArrayList<staffAttend> SAList){
        list = SAList;
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
                return list.get(rowIndex).getAttendID();
            case 1:
                return list.get(rowIndex).getDate();
            case 2:
                return list.get(rowIndex).getIntime();
            case 3:
                return list.get(rowIndex).getOutTime();
            
            default:
                return "Error";
            
            
        }
        }
    
}
