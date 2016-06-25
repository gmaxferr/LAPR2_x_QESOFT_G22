package lapr.project.uiModel;

import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import lapr.project.model.*;

/**
 * Representação de uma ComBoBoxModelAtribuicoesDemonstracaoMostraCandidatura
 * 
 * @author G29
 */
public class ComBoBoxModelAtribuicoesDemonstracaoMostraCandidatura extends AbstractListModel implements ComboBoxModel {

    /**
     * Lista de atribuições
     */
    private transient List<AtribuicaoCandidaturaDemonstracao> m_listaAtribuicoes;

    /**
     * Objeto selecionado
     */
    private String selection;

    /**
     * Construtor de objetos do tipo ComboBoxModelAtribuicoesMostraCandidatura
     * com o parâmetro lista de atribuições.
     *
     * @param listaAtribuicoes lista de atribuições.
     */
    public ComBoBoxModelAtribuicoesDemonstracaoMostraCandidatura(List<AtribuicaoCandidaturaDemonstracao> listaAtribuicoes) {
        this.selection = null;
        this.m_listaAtribuicoes = listaAtribuicoes;
    }

    /**
     * Devolve o tamanho da lista de atribuições
     *
     * @return tamanho da lista de atribuições
     */
    @Override
    public int getSize() {
        if (this.m_listaAtribuicoes != null) {
            return this.m_listaAtribuicoes.size();
        }return 0;
    }

    /**
     * Devolve uma String com os dados de uma candidatura.
     *
     * @param index posição da atribuição.
     * @return String com os dados de uma candidatura.
     */
    @Override
    public Object getElementAt(int index) {
        CandidaturaADemonstracao candidaturaDemonstracao = this.m_listaAtribuicoes.get(index).getCandidaturaAssociada();
        String candidatura = candidaturaDemonstracao.getDadosCandidatura();
        return candidatura;
    }

    /**
     * Define o item selecionado
     *
     * @param anItem item selecionado
     */
    @Override
    public void setSelectedItem(Object anItem) {
        selection = (String) anItem;
    }

    /**
     * Devolve o item selecionado
     *
     * @return item selecionado
     */
    @Override
    public Object getSelectedItem() {
        return selection;
    }
}
