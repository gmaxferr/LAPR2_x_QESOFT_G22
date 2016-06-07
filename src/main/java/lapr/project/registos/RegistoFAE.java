package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.*;

/**
 *
 * @author Ricardo Osório Ana Leite
 */
public class RegistoFAE {

    private List<FAE> listaFAE;
    private ArrayList<FAE> listaFAETemp;
    private RegistoOrganizadores rOrganizadoresDestaExposicao;

    public RegistoFAE() {
        this.listaFAE = new ArrayList<>();
        this.listaFAETemp = new ArrayList<>();
    }

    public List<FAE> getListaFAE() {
        return this.listaFAE;
    }

    public boolean adicionaFAE(Utilizador u) {
        if (validaUtilizador(u)) {
            this.listaFAETemp.add(new FAE(u));
            return true;
        }
        return false;
    }

    private boolean validaUtilizador(Utilizador u) {
        for (FAE fae : listaFAETemp) {
            if (fae.getUsernameFae().equalsIgnoreCase(u.getStrUsername())) {
                return false;
            }
        }
        for (Organizador organizador : this.rOrganizadoresDestaExposicao.getListaOrganizadores()) {
            if (organizador.getUsernameOrganizador().equalsIgnoreCase(u.getStrUsername())) {
                return false;
            }
        }
        return true;
    }

    public void confirmaAddFAE() {
        this.listaFAE = new ArrayList(this.listaFAETemp);
    }

    /**
     * Verifica se já existe um FAE com um determinado username
     * @param usernameFAE - username do FAE a procurar
     * @return true se encontrar, false caso contrário
     */
    public boolean isFAE(String usernameFAE) {
        for (FAE fae : listaFAE) {
            if (fae.getUtilizador().getStrUsername().equalsIgnoreCase(usernameFAE)) {
                return true;
            }
        }
        return false;
    }
    
    public void setRegistoOrganizadoresParaValidacoes(RegistoOrganizadores ro) {
        this.rOrganizadoresDestaExposicao = ro;
    }

    /**
     * Retorn ao FAE que tem determinado username
     * @param usernameFAE - usernmae do FAE
     * @return FAE com o username enviado como parametro. null caso não exista 
     */
    public FAE getFAE(String usernameFAE) {
        for(FAE f: listaFAE){
            if(f.getUsernameFae().equals(usernameFAE)){
                return f;
            }
        }
        return null;
    }
}
