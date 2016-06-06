package lapr.project.registos;

import java.util.List;
import lapr.project.model.*;

/**
 *
 * @author osori
 */
public class RegistoConflitos {

    List<ConflitoDeInteresse> listaConflitos;

    /**
     * Cria um conflito entre o FAE e a Candidatura passados como argumentos e
     * regista esse conflito.
     *
     * @param fae FAE que conflite com uma Candidatura
     * @param cand Candidatura com que o FAE conflite
     */
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
