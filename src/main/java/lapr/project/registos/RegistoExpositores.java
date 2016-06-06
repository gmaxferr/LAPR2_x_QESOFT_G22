package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Expositor;
import lapr.project.model.Utilizador;

/**
 *
 * @author Ricardo Osorio
 */
public class RegistoExpositores {

    private List<Expositor> listaExpositores;

    public RegistoExpositores() {
        this.listaExpositores = new ArrayList<>();
    }

    public boolean addExpositor(Utilizador utilizador) {
        if (validaExpositor(utilizador)) {
            this.listaExpositores.add(new Expositor(utilizador));
            return true;
        }
        return false;
    }

    private boolean validaExpositor(Utilizador utilizador) {
        for (Expositor expositor : listaExpositores) {
            if (expositor.getM_strUsername().equalsIgnoreCase(utilizador.getM_StrUsername())) {
                return false;
            }
        }
        return true;
    }

    public List<Expositor> getListaExpositores() {
        return this.listaExpositores;
    }
}
