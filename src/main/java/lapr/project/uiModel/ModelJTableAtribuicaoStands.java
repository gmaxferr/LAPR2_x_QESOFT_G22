package lapr.project.uiModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import lapr.project.model.AtribuicaoStand;

/**
 * representação de um ModelJTableAtribuicaoStands
 * 
 * @author G29
 */
public class ModelJTableAtribuicaoStands extends AbstractTableModel {

    /**
     * Lista de atribuições
     */
    private List<AtribuicaoStand> listAtr;

    /**
     * Construtor de objetos do tipo ModelJTableAtribuicaoStands com o paramentro
     * initiaList (lista de atribuições)
     * 
     * @param initialList lista de atribuições
     */
    public ModelJTableAtribuicaoStands(List<AtribuicaoStand> initialList) {
        listAtr = initialList;
    }

    /**
     * Devolce o tamanho da lista de atribuições
     * 
     * @return tamanho da lista de atribuições
     */
    @Override
    public int getRowCount() {
        return listAtr.size();
    }

    /**
     * Devolve o numero de colunas
     * 
     * @return numero de colunas
     */
    @Override
    public int getColumnCount() {
        return 2;
    }

    /**
     * Devolve algo dependendo do numero da coluna
     * 
     * @param rowIndex numero da linha
     * @param columnIndex numero da coluna
     * @return algo dependendo do numero da coluna (retorna a candidatura ou
     * o stand)
     */
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
