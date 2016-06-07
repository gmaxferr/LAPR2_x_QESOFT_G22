package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.TipoConflito;

/**
 *
 * @author Ana Leite
 */
public class RegistoTipoConflitos {

    private List<TipoConflito> m_listaTipoConflitos;

    public RegistoTipoConflitos() {
        this.m_listaTipoConflitos = new ArrayList<>();
    }

    public List<TipoConflito> getListaTipoConflitos() {
        return this.m_listaTipoConflitos;
    }

    public TipoConflito novoTipoConflito() {
        return new TipoConflito();
    }

    public boolean validaTipoDeConflito(TipoConflito tipoConflito) {
        return !m_listaTipoConflitos.contains(tipoConflito);
    }

    public boolean add(TipoConflito tipoConflito) {
        boolean b = validaTipoDeConflito(tipoConflito);
        if (b) {
            m_listaTipoConflitos.add(tipoConflito);
        }
        return b;
    }
}
