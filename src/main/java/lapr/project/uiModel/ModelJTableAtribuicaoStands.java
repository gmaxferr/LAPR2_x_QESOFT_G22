/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.uiModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import lapr.project.model.AtribuicaoStand;

/**
 *
 * @author Ricardo Catalao
 */
public class ModelJTableAtribuicaoStands extends AbstractTableModel {

    private List<AtribuicaoStand> listAtr;

    public ModelJTableAtribuicaoStands(List<AtribuicaoStand> initialList) {
        listAtr = initialList;
    }

    @Override
    public int getRowCount() {
        return listAtr.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        AtribuicaoStand atr = listAtr.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return atr.getCand();
            case 1:
                return atr.getStand();
            default:
                return null;
        }
    }

}
