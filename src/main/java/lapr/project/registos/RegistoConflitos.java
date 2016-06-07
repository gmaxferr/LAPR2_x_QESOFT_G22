package lapr.project.registos;

import java.util.List;
import lapr.project.model.*;

/**
 *
 * @author osori
 */
public class RegistoConflitos {

    private List<ConflitoDeInteresse> listaConflitos;

    /**
     * Cria um conflito entre o FAE e a Candidatura passados como argumentos e
     * regista esse conflito.
     *
     * @param fae FAE que conflite com uma Candidatura
     * @param cand Candidatura com que o FAE conflite
     */
    public void criarConflito(FAE fae, CandidaturaAExposicao cand) {
        if (valida(fae, cand) == true) {
            this.getListaConflitos().add(new ConflitoDeInteresse(fae, cand));
        }
    }

    /**
     * Verifica se um conflito é válido, verificando se este já existe ou não.
     *
     * @param fae - FAE em conflito
     * @param cand - Candidatura em conflito
     * @return true se for válido; false caso contrário.
     */
    public boolean valida(FAE fae, CandidaturaAExposicao cand) {
        boolean valido = true;
        for (ConflitoDeInteresse c : listaConflitos) {
            if (c.getFae().equals(fae) && c.getCandidatura().equals(cand)) {
                valido = false;
            }
        }
        return valido;
    }

    /**
     * @return a lista de conflitos
     */
    public List<ConflitoDeInteresse> getListaConflitos() {
        return listaConflitos;
    }

    /**
     * Remove um conflito da lista dos mesmos
     *
     * @param c - Conflito a remover
     */
    public void remove(ConflitoDeInteresse c) {
        listaConflitos.remove(c);
    }

    /**
     * Remove um conflito da lista dos mesmos
     *
     * @param c - Conflito a remover
     */
    public void adiciona(ConflitoDeInteresse c) {
        listaConflitos.add(c);
    }
}
