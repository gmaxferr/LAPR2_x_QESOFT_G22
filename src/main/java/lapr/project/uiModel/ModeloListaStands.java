package lapr.project.uiModel;

import java.util.List;
import javax.swing.AbstractListModel;
import lapr.project.model.Stand;

/**
 * Representação de um ModeloListaStands
 * 
 * @author G29
 */
public class ModeloListaStands extends AbstractListModel {

    /**
     * Lista de stands
     */
    private transient List<Stand> listaStands;

    /**
     * Construtor de objetos do tipo ModeloListaStands com o parametro 
     * lista de stand
     * 
     * @param listaStands lista de stands
     */
    public ModeloListaStands(List<Stand> listaStands) {
        this.listaStands = listaStands;
    }

    /**
     * Devolve o tamanho da lista de stands
     * 
     * @return tamanho da lista de stands
     */
    @Override
    public int getSize() {
        return this.listaStands.size();
    }

    /**
     * Devolve um stand
     * 
     * @param index posição do stand
     * @return stand na posição index da lista
     */
    @Override
    public Object getElementAt(int index) {
        return this.listaStands.get(index).getID();
    }

}
