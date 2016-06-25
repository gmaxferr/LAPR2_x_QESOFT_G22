package lapr.project.uiModel;

import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import lapr.project.model.TipoConflitoDemonstracao;

/**
 * Representação de uma ComboBoxModelTipoDeConflitoDemonstracao
 *
 * @author G29
 */
public class ComboBoxModelTipoDeConflitoDemonstracao  extends AbstractListModel implements ComboBoxModel {

    /**
     * Lista de tipos de conflito.
     */
    private transient List<TipoConflitoDemonstracao> m_listaTipos;

    /**
     * Objeto (tipo de conflito) selecionado.
     */
    TipoConflitoDemonstracao selection;

    /**
     * Construtor de objetos do tipo ComboBoxModelTipoDeConflito com o
     * parâmetro lista de tipos de conflito.
     *
     * @param listaTipos - lista de Tipos de conflito
     */
    public ComboBoxModelTipoDeConflitoDemonstracao(List<TipoConflitoDemonstracao> listaTipos) {
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
        selection = (TipoConflitoDemonstracao) anItem;
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
