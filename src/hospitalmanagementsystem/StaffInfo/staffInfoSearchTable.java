/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementsystem.StaffInfo;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Anush
 */
public class staffInfoSearchTable extends AbstractTableModel {
    
     private static final String[] COLUMN_NAMES ={"EmployeeID","Name","Occupation","Is Consultant","Birthday","Gender","TeleNo","Address"};
     private static ArrayList<staffInformation> list;

     staffInfoSearchTable(ArrayList<staffInformation> SIList){
        list = SIList;
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
                return list.get(rowIndex).getEmployeeID();
            case 1:
                return list.get(rowIndex).getName();
            case 2:
                return list.get(rowIndex).getOccupation();
            case 3:
                return list.get(rowIndex).getConsultant();
            case 4:
                return list.get(rowIndex).getBirthday();
            case 5:
                return list.get(rowIndex).getGender();
            case 6:
                return list.get(rowIndex).getTeleNo();
            case 7:
                return list.get(rowIndex).getAddress();
             
            default:
                return "Error";
            
            
        }
        }
    
}
