package lapr.project.model;

import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 * Representação de uma ComboBoxModel de mecanismos.
 * 
 * @author Ricardo Osório e Ana Leite
 */
public class ComboBoxModelMecanismos extends AbstractListModel implements ComboBoxModel {

    /**
     * Lista de Mecanismos.
     */
    private List<Mecanismo> listaMecanismos;

    /**
     * Objeto selecionado.
     */
    String selection;

    /**
     * Construtor de objetos do tipo ComboBoxModelMecanismos com o parâmetro
     * lista de mecanismos.
     * 
     * @param listaMecanismos lista de mecanismos.
     */
    public ComboBoxModelMecanismos(List<Mecanismo> listaMecanismos) {
        this.selection = null;
        this.listaMecanismos = listaMecanismos;
    }

    /**
     * Devolve o tamanho da lista de mecanismos.
     * 
     * @return tamanho da lista de mecanismos.
     */
    @Override
    public int getSize() {
        return this.listaMecanismos.size();
    }

    /**
     * Devolve um mecanismo.
     * 
     * @param index posição do mecanismo.
     * @return mecanoismo.
     */
    @Override
    public Object getElementAt(int index) {
        return this.listaMecanismos.get(index).getNome();
    }

    /**
     * Define o item selecionado.
     * 
     * @param anItem item selecionado.
     */
    @Override
    public void setSelectedItem(Object anItem) {
        selection = (String) anItem;
    }

    /**
     * Devolve o item selecionado.
     * 
     * @return item selecionado.
     */
    @Override
    public Object getSelectedItem() {
        return selection;
    }

}
