package lapr.project.uiModel;

import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import lapr.project.model.Demonstracao;

/**
 * Representação de uma ComboBoxModel de demonstrações.
 *
 * @author Ricardo Osório e Ana Leite
 */
public class ComboBoxModelDemonstracoes extends AbstractListModel implements ComboBoxModel {

    /**
     * Lista de demonstrações.
     */
    private transient List<Demonstracao> m_listaDemonstracoes;

    /**
     * Objeto selecionado.
     */
    String selection;

    /**
     * Construtor de objetcos do tipo ComboBoxModelDemonstrações com o parâmetro
     * lista de demonstrações.
     *
     * @param listaDemonstracoes lista de demonstrações.
     */
    public ComboBoxModelDemonstracoes(List<Demonstracao> listaDemonstracoes) {
        this.selection = null;
        this.m_listaDemonstracoes = listaDemonstracoes;
    }

    /**
     * Devolve o tamanho da lista de demonstrações.
     *
     * @return tamanho da lista de demonstrações.
     */
    @Override
    public int getSize() {
        if (this.m_listaDemonstracoes != null) {
            return this.m_listaDemonstracoes.size();
        }
        return 0;
    }

    /**
     * Devolve uma demonstração.
     *
     * @param index posição da demonstração.
     * @return demonstração.
     */
    @Override
    public Object getElementAt(int index) {
        return this.m_listaDemonstracoes.get(index).getCodigoIdentificacao();
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
