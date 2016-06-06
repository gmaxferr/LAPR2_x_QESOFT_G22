package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.FAE;
import lapr.project.model.Utilizador;

/**
 *
 * @author Ricardo Osório Ana Leite
 */
public class RegistoFAE {

    private List<FAE> listaFAE;

    public RegistoFAE() {
        this.listaFAE = new ArrayList<>();
    }

    public void adicionaFAE(Utilizador u) {
        FAE fae = new FAE(u);
        addFAE(fae);
    }

    private void addFAE(FAE fae) {
        this.listaFAE.add(fae);
    }

    public void confirmaAddFAE(boolean b) {
        if (b == true) {
            //adiciona o fae à lista definitivamente
        } else {
            //reverte a operação de adicionar o fae feita até aqui
        }
    }

    public List<FAE> getListaFAE() {
        return this.listaFAE;
    }

    public boolean isFAE(String usernameFAE) {
        for (FAE fae : listaFAE) {
            if (fae.getUtilizador().getM_StrUsername().equalsIgnoreCase(usernameFAE)) {
                return true;
            }
        }
        return false;
    }
}
