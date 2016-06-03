package classesREMOVIDAS;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import classesREMOVIDAS.Exposicao;
import classesREMOVIDAS.Organizador;
import classesREMOVIDAS.Utilizador;

/**
 * Representação de um registo de organizadores.
 *
 * @author Ana Leite e Ricardo Osório
 */
public class RegistoOrganizadores implements Serializable {

    /**
     * Lista de organizadores.
     */
    private List<Organizador> listaOrganizadores;

    /**
     * Exposicao que tem este registo de organizadores
     */
    private Exposicao exposicao;

    /**
     * Construtor de objetos do tipo RegistoOrganizadores sem parâmetros.
     */
    public RegistoOrganizadores(Exposicao exposicao) {
        this.listaOrganizadores = new ArrayList<>();
        this.exposicao = exposicao;
    }

    /**
     * Devolve a lista de organizadores.
     *
     * @return lista de organizadores.
     */
    public List<Organizador> getListaOrganizadores() {
        return this.listaOrganizadores;
    }

    /**
     * Devolve o tamanho da lista de Organizadores desta exposição. Por outras
     * palavras, este número equivale ao número de Organizadores da exposição
     *
     * @return
     */
    public int getSize() {
        return this.listaOrganizadores.size();
    }

    /**
     * Adiciona o utilizador à lista de organizadores.
     *
     * @param utilizador
     */
    public void addOrganizador(Utilizador utilizador) {
        if (validarUtilizador(utilizador)) {
            this.listaOrganizadores.add(new Organizador(utilizador));
        }
    }

    /**
     * Verifica se o utilizador recebido como parametro já existe como
     * Organizador desta exposição ou se o utilizador não tem o seu registo
     * confirmado
     *
     * @param utilizador utilizador a ser verificado
     * @return true se o utilizador já for organizador. Caso contrário, retorna
     * false.
     */
    private boolean validarUtilizador(Utilizador utilizador) {
        if (utilizador.getConfirmacaoRegisto() == false) {
            return false;
        }
        for (Organizador organizador : listaOrganizadores) {
            if (organizador.getUtilizador().equals(utilizador)) {
                return false;
            }
        }
        return true;
    }

}
