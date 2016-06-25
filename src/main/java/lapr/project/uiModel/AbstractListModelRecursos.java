package lapr.project.uiModel;

import java.util.List;
import javax.swing.AbstractListModel;
import lapr.project.model.Recurso;

/**
 * Representação de uma AbstractListModelRecursos
 * 
 * @author G29
 */
public class AbstractListModelRecursos extends AbstractListModel {

    /**
     * Lista de recursos
     */
    private transient List<Recurso> m_listaRecursos;

    /**
     * Construtor de parametros do tipo AbstractListModelRecursos com o parametro
     * lista de recursos
     * 
     * @param listaRecursos lista de recursos
     */
    public AbstractListModelRecursos(List<Recurso> listaRecursos) {
        this.m_listaRecursos = listaRecursos;
    }

    /**
     * Devolve o tamanho da lista de recursos (numero de recursos existentes)
     * 
     * @return tamanho da lista de recursos (numero de recursos existentes)
     */
    @Override
    public int getSize() {
        return m_listaRecursos.size();
    }

    /**
     * Devolve o recurso na posição i, da lista de recursos
     * 
     * @param i posição do recurso
     * @return recurso na posição i, da lista de recursos
     */
    @Override
    public Object getElementAt(int i) {
        return m_listaRecursos.get(i).getNomeRecurso();
    }

}
