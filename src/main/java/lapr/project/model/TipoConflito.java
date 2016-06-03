package lapr.project.model;

import lapr.project.registos.RegistoMecanismosDetecaoConflitos;

/**
 *
 * @author Ana Leite
 */
public class TipoConflito {

    private TipoConflito tipoConflito;
    private RegistoMecanismosDetecaoConflitos rmdc;

    public TipoConflito() {
        this.rmdc = new RegistoMecanismosDetecaoConflitos();
    }

    public void setTipoConflito(TipoConflito tipoConflito) {
        this.tipoConflito = tipoConflito;
    }

    public RegistoMecanismosDetecaoConflitos getRegistoMecanismosDetecaoConflitos() {
        return this.rmdc;
    }
}
