package lapr.project.ui.model;

import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import lapr.project.model.CandidaturaAExposicao;

/**
 *
 * @author guilherme
 */
public class ComboBoxModelCandidaturaAExposicao extends AbstractListModel implements ComboBoxModel {

    /**
     * Lista de Candidaturas.
     */
    private transient List<CandidaturaAExposicao> m_listaCands;

    /**
     * Objeto (Candidaturas) selecionado.
     */
    Object selection;

    /**
     * Construtor de objetos do tipo ComboBoxModelCandidaturaAExposicao com o
     * parâmetro lista de candidaturas.
     *
     * @param listaCands - lista de Candidaturas
     */
    public ComboBoxModelCandidaturaAExposicao(List<CandidaturaAExposicao> listaCands) {
        this.selection = null;
        this.m_listaCands = listaCands;
    }

    /**
     * Devolve o tamanho da lista das candidaturas
     *
     * @return tamanho da lista das candidaturas.
     */
    public int getSize() {
        return this.m_listaCands.size();
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
