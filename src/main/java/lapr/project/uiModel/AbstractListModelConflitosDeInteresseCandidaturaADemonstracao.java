package lapr.project.uiModel;

import java.util.List;
import javax.swing.AbstractListModel;
import lapr.project.model.ConflitoDeInteresseDemonstracao;

/**
 * Representação de uma AbstractListModelConflitosDeInteresseCandidaturaADemonstracao
 * 
 * @author G29
 */
public class AbstractListModelConflitosDeInteresseCandidaturaADemonstracao extends AbstractListModel {

    /**
     * Lista de conflitos de interesse a demonstração
     */
    private transient List<ConflitoDeInteresseDemonstracao> listaConflitos;

    /**
     * Construtor de objetos do tipo AbstractListModelConflitosDeInteresseCandidaturaADemonstracao
     * com o parametros lista de conflitos
     * 
     * @param listaConflitos lista de conflitos
     */
    public AbstractListModelConflitosDeInteresseCandidaturaADemonstracao(List<ConflitoDeInteresseDemonstracao> listaConflitos) {
        this.listaConflitos = listaConflitos;
    }

    /**
     * Devolve o tamanho da lista de conflitos
     * 
     * @return tamanho da lista de conflitos
     */
    @Override
    public int getSize() {
        return listaConflitos.size();
    }

    /**
     * Devolve um conflito
     * 
     * @param i posição do conflito
     * @return conflito na posição i da lista
     */
    @Override
    public String getElementAt(int i) {
        return listaConflitos.get(i).getCandidatura().getDadosCandidatura();
    }
}
