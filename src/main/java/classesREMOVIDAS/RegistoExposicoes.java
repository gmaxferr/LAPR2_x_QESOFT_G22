package classesREMOVIDAS;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import classesREMOVIDAS.Candidatura;
import classesREMOVIDAS.Exposicao;
import classesREMOVIDAS.FAE;
import classesREMOVIDAS.Organizador;

/**
 * Representação de um registo de exposições.
 *
 * @author Ricardo Osório e Ana Leite
 */
public class RegistoExposicoes implements Serializable {

    /**
     * Lista de exposições.
     */
    private List<Exposicao> listaExpos;

    /**
     * Contrutor de objetos do tipo RegistoExposicoes sem parâmetros.
     */
    public RegistoExposicoes() {
        this.listaExpos = new ArrayList<>();
    }

    /**
     * Devolve a lista de exposições.
     *
     * @return lista de exposições.
     */
    public List<Exposicao> getListaExposicoes() {
        return this.listaExpos;
    }

    /**
     * Devolve a lista de exposições em que um dado fae.
     *
     * @param usernameFAE username do fae.
     * @return lista de exposições em que um dado fae.
     */
    public List<Exposicao> getListaExposicoesDoFAE(String usernameFAE) {
        List<Exposicao> lista = new ArrayList<>();
        for (Exposicao e : this.listaExpos) {
            List<FAE> listaFAE = e.getRegistoFAE().getListaFAE(); //chamar pelo Registo ou ao objecto mesmo?
            if (verificarSeTemOFAE(listaFAE, usernameFAE) && verificarRepetido(lista, e) == false) {
                lista.add(e);
            }
        }
        return lista;
    }

    /**
     * Verifica se o username pertence à lista de fae.
     *
     * @param lista lista de fae.
     * @param usernameFAE username do fae.
     * @return true se encontrar o fae na lista de fae. Caso contrário retorna
     * false.
     */
    private boolean verificarSeTemOFAE(List<FAE> lista, String usernameFAE) {
        for (FAE fae : lista) {
            if (fae.getUsername().equalsIgnoreCase(usernameFAE)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Devolve a lista de exposições de um organizador.
     *
     * @param usernameOrganizador username do organizador.
     *
     * @return lista de exposições de um organizador.
     */
    public List<Exposicao> getListaExposicoesDoOrganizador(String usernameOrganizador) {
        List<Exposicao> lista = new ArrayList<>();
        for (Exposicao e : this.listaExpos) {
            List<Organizador> listaOrganizadores = e.getRegistoOrganizadores().getListaOrganizadores(); //chamar pelo Registo ou ao objecto mesmo?
            if (verificarSeTemOOrganizador(listaOrganizadores, usernameOrganizador) && verificarRepetido(lista, e) == false) {
                lista.add(e);
            }
        }
        return lista;
    }

    /**
     * Adiciona uma exposição.
     *
     * @param exposicao exposição a ser adicionada.
     */
    public void addExposicao(Exposicao exposicao) {
        if (validarExposicao(exposicao)) {
            this.listaExpos.add(exposicao);
        }
    }

    /**
     * Valida a exposição nova a ser adicionada. A validação consiste em
     * verificar se existe alguma exposição igual ou se a exposição não tem o
     * número mínimo de Organizadores (2)
     *
     * @param exposicao exposição a validar
     * @return true se a exposição for considerada como válida, caso contrário
     * false
     */
    private boolean validarExposicao(Exposicao exposicao) {
        for (Exposicao expo : this.listaExpos) {
            if (expo.equals(exposicao) || exposicao.getNumeroOrganizadores() < 2) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verifica se o username pertence à lista de organizadores.
     *
     * @param lista lista de organizadores.
     * @param username username do organizador
     *
     * @return true se encontrar o organizador na lista de organizadores. Caso
     * contrário retorna false.
     */
    private boolean verificarSeTemOOrganizador(List<Organizador> lista, String usernameOrganizador) {
        for (Organizador o : lista) {
            if (o.getUsername().equalsIgnoreCase(usernameOrganizador)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica se existem exposições repetidas.
     *
     * @param lista lista de exposições.
     * @param exposicao exposição.
     *
     * @return true se encontrar a exposição na lista de exposições. Caso
     * contrário retorna false.
     */
    private boolean verificarRepetido(List<Exposicao> lista, Exposicao exposicao) {
        for (Exposicao e : lista) {
            if (e.equals(exposicao)) {
                return true;
            }
        }
        return false;
    }

    public List<Exposicao> getListaExposicoesComCanditaturasAceitesRepresentante(String username) {
        List<Exposicao> listaExpoRep = new ArrayList();
        for (Exposicao e : listaExpos) {
            RegistoCandidaturas rc = e.getRegistoCandidaturas();
            for (Candidatura c : rc.getListaCandidaturas()) {
                if (c.getM_UsernameExpositor().equals(username)) {
                    if (c.getEstado().isEstadoCandidaturaAceite()) {
                        listaExpoRep.add(e);
                        break;
                    }
                }
            }
        }
        return listaExpoRep;
    }

    public List<Exposicao> getExposicoesDoRepresentante(String username) {
        List<Exposicao> listaExpoRep = new ArrayList();
        for (Exposicao e : listaExpos) {
            RegistoCandidaturas rc = e.getRegistoCandidaturas();
            for (Candidatura c : rc.getListaCandidaturas()) {
                if (c.getM_UsernameExpositor().equals(username)) {
                    listaExpoRep.add(e);
                    break;

                }
            }
        }
        
    }
}
