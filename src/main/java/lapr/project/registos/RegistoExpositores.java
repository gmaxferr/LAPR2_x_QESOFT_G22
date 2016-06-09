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

    private List<Expositor> m_listaExpositores;

    public RegistoExpositores() {
        this.m_listaExpositores = new ArrayList<>();
    }

    public boolean addExpositor(Utilizador utilizador) {
        if (validaExpositor(utilizador)) {
            this.m_listaExpositores.add(new Expositor(utilizador));
            return true;
        }
        return false;
    }

    private boolean validaExpositor(Utilizador utilizador) {
        for (Expositor expositor : m_listaExpositores) {
            if (expositor.getM_strEmail().equalsIgnoreCase(utilizador.getEmail())) {
                return false;
            }
        }
        return true;
    }

    public List<Expositor> getListaExpositores() {
        return this.m_listaExpositores;
    }
}
