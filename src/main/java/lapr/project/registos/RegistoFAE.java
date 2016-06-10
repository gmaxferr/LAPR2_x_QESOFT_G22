package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.*;

/**
 *
 * @author Ricardo Osório Ana Leite
 */
public class RegistoFAE {

    private List<FAE> m_listaFAE;
    private List<FAE> m_listaFAETemp;
    private RegistoOrganizadores m_rOrganizadoresDestaExposicao;

    public RegistoFAE() {
        this.m_listaFAE = new ArrayList<>();
        this.m_listaFAETemp = new ArrayList<>();
    }

    public List<FAE> getListaFAE() {
        return this.m_listaFAE;
    }

    public boolean adicionaFAE(Utilizador u) {
        if (validaUtilizador(u)) {
            this.m_listaFAETemp.add(new FAE(u));
            return true;
        }
        return false;
    }

    private boolean validaUtilizador(Utilizador u) {
        for (FAE fae : m_listaFAETemp) {
            if (fae.getUsernameFae().equalsIgnoreCase(u.getUsername())) {
                return false;
            }
        }
        for (Organizador organizador : this.m_rOrganizadoresDestaExposicao.getListaOrganizadores()) {
            if (organizador.getUsernameOrganizador().equalsIgnoreCase(u.getUsername())) {
                return false;
            }
        }
        return true;
    }

    public void confirmaAddFAE() {
        this.m_listaFAE.clear();
        this.m_listaFAE.addAll(this.m_listaFAETemp);
    }

    /**
     * Verifica se já existe um FAE com um determinado username
     *
     * @param usernameFAE - username do FAE a procurar
     * @return true se encontrar, false caso contrário
     */
    public boolean isFAE(String usernameFAE) {
        for (FAE fae : m_listaFAE) {
            if (fae.getUtilizador().getUsername().equalsIgnoreCase(usernameFAE)) {
                return true;
            }
        }
        return false;
    }

    public void setRegistoOrganizadoresParaValidacoes(RegistoOrganizadores ro) {
        this.m_rOrganizadoresDestaExposicao = ro;
    }

    /**
     * Retorn ao FAE que tem determinado username
     *
     * @param usernameFAE - usernmae do FAE
     * @return FAE com o username enviado como parametro. null caso não exista
     */
    public FAE getFAE(String usernameFAE) {
        for (FAE f : m_listaFAE) {
            if (f.getUsernameFae().equals(usernameFAE)) {
                return f;
            }
        }
        return null;
    }

    public List<Utilizador> getListaUtilizadoresCorrespondentesAosFae() {
        List<Utilizador> listaUtilizadores = new ArrayList<>();
        for (FAE fae : m_listaFAE) {
            listaUtilizadores.add(fae.getUtilizador());
        }
        return listaUtilizadores;
    }
}
