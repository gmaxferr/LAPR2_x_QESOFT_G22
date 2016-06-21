package lapr.project.ui.model;

import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import lapr.project.model.CandidaturaAExposicao;

/**
 *
 * @author G29
 */
public class ComboBoxModelCandidaturasMostraExpositores extends AbstractListModel implements ComboBoxModel {

    /**
     * Lista de candidaturas.
     */
    private transient List<CandidaturaAExposicao> m_listaCandidaturas;

    /**
     * Objeto selecionado.
     */
    String selection;

    /**
     * Construtor de objetos do tipo ComboBoxModelCandidaturasMostraExpositores
     * com o parâmetro lista de candidaturas.
     *
     * @param listaCandidaturas lista de candidaturas.
     */
    public ComboBoxModelCandidaturasMostraExpositores(List<CandidaturaAExposicao> listaCandidaturas) {
        this.selection = null;
        this.m_listaCandidaturas = listaCandidaturas;
    }

    /**
     * Devolve o tamanho da lista das candidaturas.
     *
     * @return tamanho da lista das candidaturas.
     */
    @Override
    public int getSize() {
        return this.m_listaCandidaturas.size();
    }

    /**
     * Devolve o username do expositor.
     *
     * @param index posição da candidatura na lista de candidaturas.
     *
     * @return username do expositor.
     */
    @Override
    public Object getElementAt(int index) {
        return this.m_listaCandidaturas.get(index).getUsernameExpositor();
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
