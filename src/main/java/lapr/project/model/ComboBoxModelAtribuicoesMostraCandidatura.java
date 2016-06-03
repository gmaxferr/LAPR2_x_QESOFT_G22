package lapr.project.model;

import classesREMOVIDAS.Candidatura;
import classesREMOVIDAS.Atribuicao;
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
    private List<Atribuicao> listaAtribuicoes;

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
    public ComboBoxModelAtribuicoesMostraCandidatura(List<Atribuicao> listaAtribuicoes) {
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
        Candidatura candidatura = this.listaAtribuicoes.get(index).getCand();
        String candidaturaExpositor = candidatura.getNomeEmpresa() + "; " + candidatura.getUsernameExpositor();
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
