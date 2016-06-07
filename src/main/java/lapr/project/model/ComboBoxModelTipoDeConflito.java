package lapr.project.model;

import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author guilherme
 */
public class ComboBoxModelTipoDeConflito  extends AbstractListModel implements ComboBoxModel {

    /**
     * Lista de tipos de conflito.
     */
    private List<TipoConflito> listaTipos;

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
        this.listaTipos = listaTipos;
    }

    /**
     * Devolve o tamanho da lista de tipos de conflito
     *
     * @return tamanho da lista de tipos de conflito
     */
    @Override
    public int getSize() {
        return this.listaTipos.size();
    }

    /**
     * Devolve um tipo de conflito
     *
     * @param index posição do tipo de conflito
     * @return tipo de conflito.
     */
    @Override
    public Object getElementAt(int index) {
        return this.listaTipos.get(index);
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
