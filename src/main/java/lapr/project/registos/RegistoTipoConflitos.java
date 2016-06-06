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

    public List<TipoConflito> getListaTipoConflitos() {
        return this.listaTipoConflitos;
    }

    public TipoConflito novoTipoConflito() {
        return new TipoConflito();
    }

    public boolean validaTipoDeConflito(TipoConflito tipoConflito) {
        return !listaTipoConflitos.contains(tipoConflito);
    }

    public boolean add(TipoConflito tipoConflito) {
        boolean b = validaTipoDeConflito(tipoConflito);
        if (b) {
            listaTipoConflitos.add(tipoConflito);
        }
        return b;
    }
}
