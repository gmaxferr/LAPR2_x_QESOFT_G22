package lapr.project.uiModel;

import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 * Representação de uma ComboBoxModelStandart
 * 
 * @author G29
 */
public class ComboBoxModelStandart<T> extends AbstractListModel implements ComboBoxModel {

    /**
     * Lista de stands
     */
    private transient List<T> list;

    /**
     * Item seleciondao
     */
    private T selectedItem;
    
    /**
     * Construtor de objetos do tipo ComboBoxModelStandart com o parametro 
     * initialList
     * 
     * @param initialList lista de stands
     */
    public ComboBoxModelStandart(List<T> initialList){
        this.list = initialList;
    }

    /**
     * Devolve o tamanho da lista
     * 
     * @return tamanho da lista
     */
    @Override
    public int getSize() {
        return list.size();
    }

    /**
     * Devolve um stand
     * 
     * @param index posição do stand
     * @return stand
     */
    @Override
    public Object getElementAt(int index) {
        return list.get(index);
    }

    /**
     * Define o item selecionado
     * 
     * @param anItem item selecionado
     */
    @Override
    public void setSelectedItem(Object anItem) {
        this.selectedItem = (T)anItem;
    }

    /**
     * Devolve o item selecionado
     * 
     * @return item selecionado
     */
    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

}
