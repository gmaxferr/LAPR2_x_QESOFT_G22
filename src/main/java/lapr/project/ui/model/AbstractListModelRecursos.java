package lapr.project.ui.model;

import java.util.List;
import javax.swing.AbstractListModel;
import lapr.project.model.Recurso;

/**
 *
 * @author G29
 */
public class AbstractListModelRecursos extends AbstractListModel {

    private transient List<Recurso> m_listaRecursos;

    public AbstractListModelRecursos(List<Recurso> listaRecursos) {
        this.m_listaRecursos = listaRecursos;
    }

    /**
     *
     * @return tamanho da lista de recursos (numero de recursos existentes)
     */
    @Override
    public int getSize() {
        return m_listaRecursos.size();
    }

    /**
     * 
     * @param i
     * @return recurso na posição i, da lista de recursos
     */
    @Override
    public Object getElementAt(int i) {
        return m_listaRecursos.get(i).getNomeRecurso();
    }

}
