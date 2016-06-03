package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.TipoConflito;

/**
 *
 * @author Ana Leite
 */
public class RegistoTipoConflitos {

    private List<TipoConflito> listaTipoConflitos;

    public RegistoTipoConflitos() {
        this.listaTipoConflitos = new ArrayList<>();
    }

    public boolean validaTipoDeConflito(TipoConflito tipoConflito) {
        return true;
    }

    public TipoConflito criarTipoConflito() {
        TipoConflito tipoConflito = new TipoConflito();
        return tipoConflito;
    }

    public List<TipoConflito> getListaTipoConflitos() {
        return this.listaTipoConflitos;
    }
}
