package lapr.project.registos;

import java.util.List;
import lapr.project.model.*;

/**
 *
 * @author osori
 */
public class RegistoConflitos {

    List<ConflitoDeInteresse> listaConflitos;

    public void criarConflito(FAE fae, CandidaturaAExposicao cand) {
        if (valida(fae, cand) == true) {
            this.listaConflitos.add(new ConflitoDeInteresse(fae, cand));
        }
    }

    private boolean valida(FAE fae, CandidaturaAExposicao cand) {
        //valida se pode criar este conflito (se já existe, etc)
        return true;
    }

}
