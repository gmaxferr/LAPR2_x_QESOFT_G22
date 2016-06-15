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
public class ModelComboBoxDias extends AbstractListModel implements ComboBoxModel {

    int[] dias_28 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28};
    int[] dias_29 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29};
    int[] dias_30 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
    int[] dias_31 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};

    private Object selectedItem;
    private int opcao;

    public ModelComboBoxDias(int opcao) {
        this.opcao = opcao;
    }

    @Override
    public int getSize() {
        switch (this.opcao) {
            case 28:
                return dias_28.length;
            case 29:
                return dias_29.length;
            case 30:
                return dias_30.length;
            case 31:
                return dias_31.length;
            default:
                return 31;
        }
    }

    @Override
    public Object getElementAt(int index) {
        switch (this.opcao) {
            case 28:
                return dias_28[index];
            case 29:
                return dias_29[index];
            case 30:
                return dias_30[index];
            case 31:
                return dias_31[index];
            default:
                return null;
        }
    }

    @Override
    public void setSelectedItem(Object anItem) {
        switch (this.opcao) {
            case 28:
                selectedItem = (Integer) anItem;
            case 29:
                selectedItem = (Integer) anItem;
            case 30:
                selectedItem = (Integer) anItem;
            case 31:
                selectedItem = (Integer) anItem;
            default:

        }
    }

    @Override
    public Object getSelectedItem() {
        switch (this.opcao) {
            case 28:
                return selectedItem;
            case 29:
                return selectedItem;
            case 30:
                return selectedItem;
            case 31:
                return selectedItem;
            default:
                return null;
        }
    }
}
