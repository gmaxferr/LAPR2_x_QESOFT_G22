package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import lapr.project.estados.EstadoExposicao;
import lapr.project.model.*;

/**
 *
 * @author Ricardo Osório Ana Leite
 */
public class RegistoExposicoes {

    /**
     * Lista de exposições existentes
     */
    private final ArrayList<Exposicao> m_listaExposicoes;

    public RegistoExposicoes() {
        m_listaExposicoes = new ArrayList<>();

    }

    /**
     * Método que devolve lista das Exposições
     *
     * @return lista das Exposições
     */
    public List<Exposicao> getListaExposicoes() {
        return m_listaExposicoes;
    }

    /**
     * Devolve uma nova exposição criada
     *
     * @return nova exposição
     */
    public Exposicao novaExposicao() {
        return new Exposicao();
    }

    /**
     * Valida a exposição e no caso positivo adiciona à lista de exposições
     *
     * @param e exposição recebida
     * @return boolean que representa o sucesso da operação
     */
    public boolean registaExposicao(Exposicao e) {
        if (validaExposicao(e)) {
            addExposicao(e);
            return true;
        } else {
            return false;
        }

    }

    /**
     * Método que adiciona uma exposição
     *
     * @param e exposição para adicionar
     */
    private void addExposicao(Exposicao e) {
        m_listaExposicoes.add(e);
    }

    /**
     * Método para validar exposição
     *
     * @param e exposição pretendida
     * @return boolean que representa o sucesso da operação
     */
    public boolean validaExposicao(Exposicao e) {
        return e.valida();
    }

    /**
     * Deolve uma lista com todas as exposições associadas a um centro de
     * exposições
     *
     * @return lista com todas as exposições associadas a um centro de
     * exposições
     */
    public ArrayList<Exposicao> getListaExposicoesValidas() {
        ArrayList<Exposicao> lista = new ArrayList<>();
        for (Exposicao exposicao : this.m_listaExposicoes) {
            if (exposicao.dadosMinimosObrigatorios() == true) {
                lista.add(exposicao);
            }
        }
        return lista;
    }

    public ArrayList<Exposicao> getListaExposicoesEstadoCandidaturasAbertas() {
        ArrayList<Exposicao> lista = new ArrayList<>();
        for (Exposicao exposicao : this.m_listaExposicoes) {
            if (exposicao.getEstado().isEstadoCandidaturasAbertas()) {
                lista.add(exposicao);
            }
        }
        return lista;
    }

    /**
     * Método que devolve a lista de exposições do organizador autenticado no
     * sistema
     *
     * @param usernameOrganizador
     * @return lista de exposições do organizador
     */
    public ArrayList<Exposicao> getlistaExposicoesDoOrganizadorEstadoCriadaOuDemosDefinidasSemFAE(String usernameOrganizador) {
        ArrayList<Exposicao> listaExposicoesDoOrganizador = new ArrayList<>();

        //encontra as exposições do organizador autenticado no sistema.
        for (Exposicao exposicao : m_listaExposicoes) {
            for (Organizador organizador : exposicao.getListaOrganizadores()) {
                if (organizador.getUsernameOrganizador().equalsIgnoreCase(usernameOrganizador) && exposicao.getEstado().isEstadoCriada() || exposicao.getEstado().isEstadoDemosDefinidasSemFAE()) {
                    listaExposicoesDoOrganizador.add(exposicao);
                }
            }
        }

        return listaExposicoesDoOrganizador;

    }

    /**
     * Método que remove exposições repetidas de um ArrayList
     *
     * @param array ArrayList desejado
     */
    public void removerExposiçõesRepetidas(ArrayList array) {
        //remove as exposições repetidas dentro do arrayList
    }

    /**
     * Cria uma lista com as exposições em que existem candidaturas aceites de
     * um representante
     *
     * @param username - username do representante
     * @return lista com as exposições em que existem candidaturas aceites de um
     * representante
     */
    public List<Exposicao> getListaExposicoesComCanditaturasAceitesRepresentante(String username) {
        List<Exposicao> listaExpoRep = new ArrayList();
        for (Exposicao e : m_listaExposicoes) {
            RegistoCandidaturasAExposicao rc = e.getRegistoCandidaturasAExposicao();
            for (CandidaturaAExposicao c : rc.getListaCandidaturas()) {
                if (c.getUsernameExpositor().equals(username)) {
                    if (c.getEstado().isEstadoCandidaturaAceite()) {
                        listaExpoRep.add(e);
                        break;
                    }
                }
            }
        }
        return listaExpoRep;
    }

    /**
     * Cria uma lista com as exposições em que existem candidaturas de um
     * representante
     *
     * @param username - username do representante
     * @return - lista com as exposições em que existem candidaturas do
     * representante
     */
    public List<Exposicao> getExposicoesDoRepresentante(String username) {
        List<Exposicao> listaExpoRep = new ArrayList();
        for (Exposicao e : m_listaExposicoes) {
            RegistoCandidaturasAExposicao rc = e.getRegistoCandidaturasAExposicao();
            for (CandidaturaAExposicao c : rc.getListaCandidaturas()) {
                if (c.getUsernameExpositor().equals(username)) {
                    listaExpoRep.add(e);
                    break;

                }
            }
        }
        return listaExpoRep;
    }

    public ArrayList<Exposicao> getListaExposicoesEstadoCandidaturasAvaliadas() {
        ArrayList<Exposicao> listaExposicoesEstadoCandidaturasAvaliadas = new ArrayList<>();
        for (Exposicao exposicao : this.m_listaExposicoes) {
            if (exposicao.getEstado().isEstadoCandidaturasAvaliadas()) {
                listaExposicoesEstadoCandidaturasAvaliadas.add(exposicao);
            }
        }
        return listaExposicoesEstadoCandidaturasAvaliadas;
    }

    public List<Exposicao> getlistaExposicoesEstadoCandidaturasAbertas() {
        ArrayList<Exposicao> listaExposicoesEstadoCandidaturasAbertas = new ArrayList<>();
        for (Exposicao exposicao : m_listaExposicoes) {
            if (exposicao.getEstado().isEstadoCandidaturasAbertas()) {
                listaExposicoesEstadoCandidaturasAbertas.add(exposicao);
            }
        }
        return listaExposicoesEstadoCandidaturasAbertas;
    }

    public ArrayList<Exposicao> getListaExposicoesEstadoCandidaturasAtribuidasDoFAE(String usernameFAE) {
        ArrayList<Exposicao> listaExposicoesEstadoCandidaturaAtribuidasDoFAE = new ArrayList<>();
        for (Exposicao exposicao : this.m_listaExposicoes) {
            if (exposicao.getEstado().isEstadoCandidaturasAtribuidas() && exposicao.getRegistoFAE().isFAE(usernameFAE)) {
                listaExposicoesEstadoCandidaturaAtribuidasDoFAE.add(exposicao);
            }
        }
        return listaExposicoesEstadoCandidaturaAtribuidasDoFAE;
    }

    /**
     * Devolve exposições do organizador em que existem demonstrações pendentes
     *
     * @param usernameOrganizador - username do organizador logado
     * @return exposições do organizador em que existem demonstrações pendentes
     */
    public List<Exposicao> getlistaExposicoesDoOrganizadorComDemos(String usernameOrganizador) {
        ArrayList<Exposicao> listaExposicoesDoOrganizador = new ArrayList<>();

        //encontra as exposições do organizador autenticado no sistema.
        for (Exposicao exposicao : m_listaExposicoes) {
            if (exposicao.getRegistoDemonstracoes().getDemonstracoesPendentes().size() > 0) {
                for (Organizador organizador : exposicao.getListaOrganizadores()) {
                    if (organizador.getUsernameOrganizador().equalsIgnoreCase(usernameOrganizador)) {
                        listaExposicoesDoOrganizador.add(exposicao);
                        break;
                    }
                }
            }
        }
        return listaExposicoesDoOrganizador;
    }

    public List<Exposicao> getFaeExpos(String usernameFae) {
        List<Exposicao> exposFAE = new ArrayList<>();
        for (Exposicao ex : this.m_listaExposicoes) {
            if (ex.getRegistoFAE().isFAE(usernameFae)) {
                exposFAE.add(ex);
            }
        }
        return exposFAE;
    }

    /**
     * @return Retorna uma lista com todas as exposições em estado de
     * candidaturas decididas
     */
    public List<Exposicao> getListaExposicoesEstadoCandidaturasDecididas() {
        List<Exposicao> listExpo = new ArrayList<>();
        List<Exposicao> listaExpo = getListaExposicoes();
        for (Exposicao e : m_listaExposicoes){
            EstadoExposicao state = e.getEstado();
            if(state.isEstadoCandidaturasDecididas()){
                listExpo.add(e);
            }
        }
        return listExpo;
    }
}
