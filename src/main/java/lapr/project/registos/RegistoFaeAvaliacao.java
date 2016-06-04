package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Avaliacao;
import lapr.project.model.FaeDecisao;

/**
 *
 * @author Ricardo Osorio
 */
public class RegistoFaeAvaliacao {

    private List<FaeDecisao> listaFaeDecisao;

    public RegistoFaeAvaliacao() {
        this.listaFaeDecisao = new ArrayList<>();
    }

    public FaeDecisao getObjFaeDecisaoDoFae(String usernameFae) {
        for (FaeDecisao faeDecisao : listaFaeDecisao) {
            if (faeDecisao.getFaeAssociado().getUsernameFae().equalsIgnoreCase(usernameFae)) {
                return faeDecisao;
            }
        }
        return null;
    }

    public Avaliacao getAvaliacaoDoFae(String usernameFAE) {
        for (FaeDecisao faeDecisao : listaFaeDecisao) {
            if (faeDecisao.getFaeAssociado().getUsernameFae().equalsIgnoreCase(usernameFAE)) {
                return faeDecisao.getAvaliacao();
            }
        }
        return null;
    }

}
