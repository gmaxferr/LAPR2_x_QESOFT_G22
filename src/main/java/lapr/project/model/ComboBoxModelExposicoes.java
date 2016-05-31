package lapr.project.model;

import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 * Representação de uma ComboBoxModel de exposições.
 * 
 * @author Ana Leite e Ricardo Osório
 */
public class ComboBoxModelExposicoes extends AbstractListModel implements ComboBoxModel {

    /**
     * Lista de Exposições.
     */
    private List<Exposicao> listaExposicoes;

    /**
     * Objeto selecionado.
     */
    String selection;

    /**
     * Construtor de objetos do tipo ComboBoxModelExposições com o parâmetro
     * lista de exposições.
     * 
     * @param listaExposicoes lista de exposições.
     */
    public ComboBoxModelExposicoes(List<Exposicao> listaExposicoes) {
        this.selection = null;
        this.listaExposicoes = listaExposicoes;
    }

    /**
     * Devolve o tamanho da lista das exposições.
     * 
     * @return tamanho da lista das exposições.
     */
    @Override
    public int getSize() {
        return this.listaExposicoes.size();
    }

    /**
     * Devolve uma exposição.
     * 
     * @param index posição da exposição.
     * @return exposição.
     */
    @Override
    public Object getElementAt(int index) {
        return this.listaExposicoes.get(index).getTitulo();
    }

    /**
     * Define o item selecionado.
     * 
     * @param anItem item selcionado.
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
