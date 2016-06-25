package lapr.project.uiModel;

import java.util.List;
import javax.swing.AbstractListModel;
import lapr.project.model.Demonstracao;

/**
 * Representação de uma AbstractListModelDemonstracoes
 * 
 * @author G29
 */
public class AbstractListModelDemonstracoes extends AbstractListModel {

    /**
     * Lista de demonstrações
     */
    private transient List<Demonstracao> m_listaDemonstracoes;

    /**
     * Construtor de objetos do tipo AbstractListModelDemonstracoes com o 
     * parametro lista de demonstrações
     * 
     * @param listaDemonstracoes lista de demonstrações
     */
    public AbstractListModelDemonstracoes(List<Demonstracao> listaDemonstracoes) {
        this.m_listaDemonstracoes = listaDemonstracoes;
    }

    /**
     * Devolve o tamanho da lista de demonstrações
     * 
     * @return  tamanho da lista de demonstrações
     */
    @Override
    public int getSize() {
        return m_listaDemonstracoes.size();
    }

    /**
     * Devolve uma demonstração
     * 
     * @param i posição da demonstração
     * @return demonstração na posição i da lista
     */
    @Override
    public Object getElementAt(int i) {
        return m_listaDemonstracoes.get(i);
    }

}