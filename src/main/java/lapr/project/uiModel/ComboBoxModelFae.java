package lapr.project.uiModel;

import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import lapr.project.model.FAE;

/**
 * Represnetação de uma ComboBoxModelFae
 * 
 * @author G29
 */
public class ComboBoxModelFae extends AbstractListModel implements ComboBoxModel {

    /**
     * Lista de FAEs.
     */
    private transient List<FAE> m_listaFae;

    /**
     * Objeto (FAE) selecionado.
     */
    String selection;

    /**
     * Construtor de objetos do tipo ComboBoxModelFae com o parâmetro lista de
     * FAEs.
     *
     * @param listaFae - lista de FAEs.
     */
    public ComboBoxModelFae(List<FAE> listaFae) {
        this.selection = null;
        this.m_listaFae = listaFae;
    }

    /**
     * Devolve o tamanho da lista dos FAE
     *
     * @return tamanho da lista dos FAE.
     */
    public int getSize() {
        return this.m_listaFae.size();
    }

    /**
     * Devolve um FAE
     *
     * @param index posição do FAE.
     * @return FAE.
     */
    @Override
    public Object getElementAt(int index) {
        return this.m_listaFae.get(index);
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
