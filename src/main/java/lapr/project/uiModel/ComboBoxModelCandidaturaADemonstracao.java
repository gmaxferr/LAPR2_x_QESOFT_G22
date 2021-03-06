package lapr.project.uiModel;

import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import lapr.project.model.CandidaturaADemonstracao;

/**
 * Representação de uma ComboBoxModelCandidaturaADemonstracao
 *
 * @author G29
 */
public class ComboBoxModelCandidaturaADemonstracao extends AbstractListModel implements ComboBoxModel {

    /**
     * Lista de Candidaturas.
     */
    private transient List<CandidaturaADemonstracao> m_listaCands;

    /**
     * Candidatura selecionada.
     */
    private transient Object selection;

    /**
     * Construtor de objetos do tipo ComboBoxModelCandidaturaADemonstracao com o
     * parâmetro lista de candidaturas.
     *
     * @param listaCands - lista de Candidaturas
     */
    public ComboBoxModelCandidaturaADemonstracao(List<CandidaturaADemonstracao> listaCands) {
        this.selection = null;
        this.m_listaCands = listaCands;
    }

    /**
     * Devolve o tamanho da lista das candidaturas
     *
     * @return tamanho da lista das candidaturas.
     */
    @Override
    public int getSize() {
        if (this.m_listaCands != null) {
            return this.m_listaCands.size();
        }
        return 0;
    }

    /**
     * Devolve um candidatura
     *
     * @param index posição da candidatura
     * @return candidatura.
     */
    @Override
    public Object getElementAt(int index) {
        return this.m_listaCands.get(index);
    }

    /**
     * Define o item selecionado.
     *
     * @param anItem - item selecionado.
     */
    @Override
    public void setSelectedItem(Object anItem) {
        selection = anItem;
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
