package lapr.project.ui.model;

import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import lapr.project.model.Exposicao;

/**
 * Representação de uma ComboBoxModel de exposições.
 *
 * @author G29
 */
public class ComboBoxModelExposicoes extends AbstractListModel implements ComboBoxModel {

    /**
     * Lista de Exposições.
     */
    private transient List<Exposicao> m_listaExposicoes;

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
        this.m_listaExposicoes = listaExposicoes;
    }

    /**
     * Devolve o tamanho da lista das exposições.
     *
     * @return tamanho da lista das exposições.
     */
    @Override
    public int getSize() {
        return this.m_listaExposicoes.size();
    }

    /**
     * Devolve o titulo da exposição.
     *
     * @param index posição da exposição.
     *
     * @return exposição.
     */
    @Override
    public Object getElementAt(int index) {
        return this.m_listaExposicoes.get(index).getTitulo();
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
