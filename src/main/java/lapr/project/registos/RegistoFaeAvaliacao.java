package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Avaliacao;
import lapr.project.model.FAE;
import lapr.project.model.FaeAvaliacao;

/**
 *
 * @author Ricardo Osorio
 */
public class RegistoFaeAvaliacao {

    private List<FaeAvaliacao> listaFaeDecisao;

    public RegistoFaeAvaliacao() {
        this.listaFaeDecisao = new ArrayList<>();
    }

    public FaeAvaliacao getObjFaeDecisaoDoFae(String usernameFae) {
        for (FaeAvaliacao faeDecisao : listaFaeDecisao) {
            if (faeDecisao.getFaeAssociado().getUsernameFae().equalsIgnoreCase(usernameFae)) {
                return faeDecisao;
            }
        }
        return null;
    }

    public Avaliacao getAvaliacaoDoFae(String usernameFAE) {
        for (FaeAvaliacao faeDecisao : listaFaeDecisao) {
            if (faeDecisao.getFaeAssociado().getUsernameFae().equalsIgnoreCase(usernameFAE)) {
                return faeDecisao.getAvaliacao();
            }
        }
        return null;
    }

    public void addFaeAvaliacao(FAE fae) {
        this.listaFaeDecisao.add(new FaeAvaliacao(fae));
    }

    public List<FAE> getListaTodosFAE() {
        ArrayList<FAE> listaTodosFae = new ArrayList<>();
        for (FaeAvaliacao faeDecisao : listaFaeDecisao) {
            listaTodosFae.add(faeDecisao.getFaeAssociado());
        }
        return listaTodosFae;
    }

}
