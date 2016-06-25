package lapr.project.uiModel;

import java.util.List;
import javax.swing.AbstractListModel;
import lapr.project.model.ConflitoDeInteresse;

/**
 * Representação de uma AbstractListModelConflitosDeInteresseCandidaturaAExposicao
 * 
 * @author G29
 */
public class AbstractListModelConflitosDeInteresseCandidaturaAExposicao extends AbstractListModel {

    /**
     * Lista de conflitos de interesse
     */
    private transient List<ConflitoDeInteresse> m_listaConflitos;

    /**
     * Construtor de objetos do tipo AbstractListModelConflitosDeInteresseCandidaturaAExposicao
     * com o parametro lista de conflitos
     * 
     * @param listaConflitos lista de conflitos
     */
    public AbstractListModelConflitosDeInteresseCandidaturaAExposicao(List<ConflitoDeInteresse> listaConflitos) {
        this.m_listaConflitos = listaConflitos;
    }

    /**
     * Devolve o tamanho da lista de conflitos
     * 
     * @return tamanho da lista de conflitos
     */
    @Override
    public int getSize() {
        return m_listaConflitos.size();
    }

    /**
     * Devolve um conflito
     * 
     * @param i posição do conflito
     * @return conflito na posição i da lista
     */
    @Override
    public Object getElementAt(int i) {
        return m_listaConflitos.get(i);
    }

}
