/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public class ModelComboBoxt30Dias extends AbstractListModel implements ComboBoxModel{

    int[] dias = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};

    
    private Object selectedItem;
    
    @Override
    public int getSize() {
        return dias.length;
    }

    @Override
    public Object getElementAt(int index) {
        return dias[index];
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (Integer) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
}
