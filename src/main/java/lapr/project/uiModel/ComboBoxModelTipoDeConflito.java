package lapr.project.uiModel;

import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import lapr.project.model.TipoConflito;

/**
 * Representação de uma ComboBoxModelTipoDeConflito 
 * 
 * @author G29
 */
public class ComboBoxModelTipoDeConflito  extends AbstractListModel implements ComboBoxModel {

    /**
     * Lista de tipos de conflito.
     */
    private transient List<TipoConflito> m_listaTipos;

    /**
     * Objeto (tipo de conflito) selecionado.
     */
    String selection;

    /**
     * Construtor de objetos do tipo ComboBoxModelTipoDeConflito com o
     * parâmetro lista de tipos de conflito.
     *
     * @param listaTipos - lista de Tipos de conflito
     */
    public ComboBoxModelTipoDeConflito(List<TipoConflito> listaTipos) {
        this.selection = null;
        this.m_listaTipos = listaTipos;
    }

    /**
     * Devolve o tamanho da lista de tipos de conflito
     *
     * @return tamanho da lista de tipos de conflito
     */
    @Override
    public int getSize() {
        return this.m_listaTipos.size();
    }

    /**
     * Devolve um tipo de conflito
     *
     * @param index posição do tipo de conflito
     * @return tipo de conflito.
     */
    @Override
    public Object getElementAt(int index) {
        return this.m_listaTipos.get(index);
    }

    /**
     * Define o item selecionado.
     *
     * @param anItem - item selecionado.
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
