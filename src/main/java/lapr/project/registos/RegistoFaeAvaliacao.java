package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Avaliacao;
import lapr.project.model.FAE;
import lapr.project.model.FaeAvaliacao;
import lapr.project.model.Utilizador;

/**
 *
 * @author Ricardo Osorio
 */
public class RegistoFaeAvaliacao {

    private List<FaeAvaliacao> m_listaFaeAvaliacao;

    public RegistoFaeAvaliacao() {
        this.m_listaFaeAvaliacao = new ArrayList<>();
    }

    public FaeAvaliacao getObjFaeDecisaoDoFae(String usernameFae) {
        for (FaeAvaliacao faeDecisao : m_listaFaeAvaliacao) {
            if (faeDecisao.getFaeAssociado().getUsernameFae().equalsIgnoreCase(usernameFae)) {
                return faeDecisao;
            }
        }
        return null;
    }

    public Avaliacao getAvaliacaoDoFae(String usernameFAE) {
        for (FaeAvaliacao faeDecisao : m_listaFaeAvaliacao) {
            if (faeDecisao.getFaeAssociado().getUsernameFae().equalsIgnoreCase(usernameFAE)) {
                return faeDecisao.getAvaliacao();
            }
        }
        return null;
    }

    public void addFaeAvaliacao(FAE fae) {
        this.m_listaFaeAvaliacao.add(new FaeAvaliacao(fae));
    }

    public List<FAE> getListaTodosFAE() {
        ArrayList<FAE> listaTodosFae = new ArrayList<>();
        for (FaeAvaliacao faeDecisao : m_listaFaeAvaliacao) {
            listaTodosFae.add(faeDecisao.getFaeAssociado());
        }
        return listaTodosFae;
    }

    public List<Utilizador> getListaUtilizadoresAssociadoAosFAE() {
        List<Utilizador> listaUtilizadoresAssociadoAosFAE = new ArrayList<>();
        for (FaeAvaliacao faeAvaliacao : this.m_listaFaeAvaliacao) {
            listaUtilizadoresAssociadoAosFAE.add(faeAvaliacao.getFaeAssociado().getUtilizador());
        }
        return listaUtilizadoresAssociadoAosFAE;
    }

}
