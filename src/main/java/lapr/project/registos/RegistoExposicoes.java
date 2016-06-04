package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import lapr.project.estados.Estado;
import lapr.project.estados.EstadoExposicaoCandidaturasAbertas;
import lapr.project.estados.EstadoExposicaoCandidaturasFechadas;
import lapr.project.model.Agendavel;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.Exposicao;
import lapr.project.model.Organizador;

/**
 *
 * @author Ricardo Osório Ana Leite
 */
public class RegistoExposicoes implements Agendavel {

    /**
     * Lista de exposições existentes
     */
    private ArrayList<Exposicao> m_listaExposicoes;

    public RegistoExposicoes() {
        m_listaExposicoes = new ArrayList<Exposicao>();

    }

    /**
     * Método que devolve lista das Exposições
     *
     * @return lista das Exposições
     */
    public List<Exposicao> getExposicao() {
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
    public ArrayList<Exposicao> getListaExposicoesDoOrganizador(String usernameOrganizador) {
        ArrayList<Exposicao> listaExposicoesDoOrganizador = new ArrayList<>();

        //encontra as exposições do organizador autenticado no sistema.
        for (Exposicao exposicao : m_listaExposicoes) {
            for (Organizador organizador : exposicao.getListaOrganizadores()) {
                if (organizador.getUsernameOrganizador().equalsIgnoreCase(usernameOrganizador)) {
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

    @Override
    public void Agendavel(Estado estado, String dataAbertura) {
        /*
            Converte a string para Date
            Cria o timer
            Associa o timer ao Estado
         */
    }

    public void setEstadoCandidaturasAbertas(Exposicao exposicao) {
        Estado estado = new EstadoExposicaoCandidaturasAbertas(exposicao);
        String dataAbertura = exposicao.getM_strDataInicio();
        Agendavel(estado, dataAbertura);
    }

    public void setEstadoCandidaturasFechadas(Exposicao exposicao) {
        Estado estado = new EstadoExposicaoCandidaturasFechadas(exposicao);
        String dataFecho = exposicao.getM_strDataFim();
        Agendavel(estado, dataFecho);
    }

    public void setEstadoExposicaoConflitosDetetados(Exposicao exposicao) {
        Estado estado = new EstadoExposicaoCandidaturasFechadas(exposicao);
        String dataLimite = exposicao.getM_strDataFim();
        Agendavel(estado, dataLimite);
    }

    public List<Exposicao> getListaExposicoesComCanditaturasAceitesRepresentante(String username) {
        List<Exposicao> listaExpoRep = new ArrayList();
        for (Exposicao e : m_listaExposicoes) {
            RegistoCandidaturas rc = e.getRegistoCandidaturas();
            for (CandidaturaAExposicao c : rc.getListaCandidaturas()) {
                if (c.getM_StrUsernameExpositor().equals(username)) {
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
            RegistoCandidaturas rc = e.getRegistoCandidaturas();
            for (CandidaturaAExposicao c : rc.getListaCandidaturas()) {
                if (c.getM_StrUsernameExpositor().equals(username)) {
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
            if(exposicao.getEstado().isEstadoCandidaturasAtribuidas() && exposicao.getRegistoFAE().isFAE(usernameFAE)){
                listaExposicoesEstadoCandidaturaAtribuidasDoFAE.add(exposicao);
            }
        }
        return listaExposicoesEstadoCandidaturaAtribuidasDoFAE;
    }

}
