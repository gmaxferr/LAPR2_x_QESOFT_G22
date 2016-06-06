package lapr.project.model;

import java.util.List;
import javax.swing.*;

/**
 * Representação de uma ComboBoxModel de atribuições.
 *
 * @author Ricardo Osório e Ana Leite
 */
public class ComboBoxModelAtribuicoesMostraCandidatura extends AbstractListModel implements ComboBoxModel {

    /**
     * Lista de Atribuições.
     */
    private List<AtribuicoesCandidatura> listaAtribuicoes;

    /**
     * Objeto selecionado.
     */
    String selection;

    /**
     * Construtor de objetos do tipo ComboBoxModelAtribuicoesMostraCandidatura
     * com o parâmetro lista de atribuições.
     *
     * @param listaAtribuicoes lista de atribuições.
     */
    public ComboBoxModelAtribuicoesMostraCandidatura(List<AtribuicoesCandidatura> listaAtribuicoes) {
        this.selection = null;
        this.listaAtribuicoes = listaAtribuicoes;
    }

    /**
     * Devolve o tamanho da lista de atribuições.
     *
     * @return tamanho da lista de atribuições.
     */
    @Override
    public int getSize() {
        return this.listaAtribuicoes.size();
    }

    /**
     * Devolve uma String com dados de uma candidatura.
     *
     * @param index posição da atribuição.
     * @return String com dados de uma candidatura.
     */
    @Override
    public Object getElementAt(int index) {
        CandidaturaAExposicao candidatura = this.listaAtribuicoes.get(index).getCandidaturaAssociada();
        String candidaturaExpositor = candidatura.getM_StrNomeEmpresa() + "; " + candidatura.getM_StrUsernameExpositor();
        return candidaturaExpositor;
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
     * Devolve o item selecionado
     *
     * @return item selecionado
     */
    @Override
    public Object getSelectedItem() {
        return selection;
    }
}
