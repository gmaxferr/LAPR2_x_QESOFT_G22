package classesModelERegistoDeESOFT;

import java.util.List;

/**
 *
 * @author osori
 */
class RegistoConflitos {

    List<ConflitoDeInteresse> listaConflitos;

    public void criarConflito(FAE fae, Candidatura cand) {
        if (valida(fae, cand) == true) {
            this.listaConflitos.add(new ConflitoDeInteresse(fae, cand));
        }
    }

    private boolean valida(FAE fae, Candidatura cand) {
        //valida se pode criar este conflito (se já existe, etc)
        return true;
    }

}
