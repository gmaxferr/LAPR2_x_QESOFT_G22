package lapr.project.controller;

import lapr.project.estados.Exposicao.EstadoExposicao;
import lapr.project.estados.CandidaturaAExposicao.EstadoCandidaturaAExposicao;
import java.util.ArrayList;
import java.util.List;
import lapr.project.estados.*;
import lapr.project.model.*;
import lapr.project.registos.*;

/**
 * Representação do Controller do caso de uso - atribuir candidaturas
 *
 * @author Ricardo Osório Ana Leite
 */
public class AtribuirCandidaturasController {

    private ArrayList<Exposicao> m_listaExpo;
    private RegistoExposicoes m_re;
    private CandidaturaAExposicao m_cand;
    private Exposicao m_e;
    private CentroExposicoes m_centroExposicoes;
    private RegistoMecanismos m_rm;
    private RegistoCandidaturasAExposicao m_rc;
    private EstadoExposicao m_estadoExposicao;
    private EstadoCandidaturaAExposicao m_estadoCandidatura;
    private final String m_usernameOrganizador;

    public AtribuirCandidaturasController(CentroExposicoes centroExposicoes, String usernameOrganizador) {
        this.m_listaExpo = new ArrayList<>();
        this.m_centroExposicoes = centroExposicoes;
        this.m_usernameOrganizador = usernameOrganizador;
    }

    public void getRegistoExposicoes() {
        this.m_re = m_centroExposicoes.getRegistoExposicoes();
    }

    /**
     * Devolve a lista de Exposições do Organizador
     *
     * @return lista de Exposições o Organizador
     */
    public ArrayList<Exposicao> getListaExposicoesDoOrganizador() {
        m_listaExpo = m_centroExposicoes.getRegistoExposicoes().getlistaExposicoesDoOrganizadorEstadoCriadaOuDemosDefinidasSemFAE(this.m_usernameOrganizador);
        return m_listaExpo;
    }

    /**
     * Método que guarda a exposição escolhida pelo utilizador
     *
     * @param exposicao exposição escolhida
     */
    public void setExposicao(Exposicao exposicao) {
        this.m_e = exposicao;
    }

    public void getRegistoMecanismos() {
        this.m_rm = m_centroExposicoes.getRegistoMecanismos();
    }

    public List<Mecanismo> getListaMecanismos() {
        return this.m_rm.getListaMecanismos();
    }

    public void getRegistoCandidaturas() {
        this.m_rc = this.m_e.getRegistoCandidaturasAExposicao();
    }

    public void getRegistoAtribuicoes() {
        this.m_e.getRegistoAtribuicoes();
    }

    /**
     * Devolve as atribuições geradas.
     *
     * @param mec mecanismo.
     *
     * @return atribuições geradas.
     */
    public List<AtribuicoesCandidatura> atribui(Mecanismo mec) {
        MecanismoSimples mecanismo = (MecanismoSimples) mec;
        return mecanismo.atribui(this.m_e);
    }

    /**
     * Devolve as atribuições geradas.
     *
     * @param mec mecanismo.
     * @param numeroFAEOuExperiencia
     *
     * @return atribuições geradas.
     */
    public List<AtribuicoesCandidatura> atribui(Mecanismo mec, String numeroFAEOuExperiencia) {
        MecanismoIteragivel mecanismo = (MecanismoIteragivel) mec;
        return mecanismo.atribui(this.m_e, numeroFAEOuExperiencia);
    }

    public void registaAtribuicao(List<AtribuicoesCandidatura> listaAtribuicao) {
        this.m_e.getRegistoAtribuicoes().setListaAtribuicao(listaAtribuicao);
    }

    public void setEstadoCandidaturaAtribuida() {
        this.m_estadoExposicao = this.m_e.getEstado();
        m_estadoExposicao.setEstadoCandidaturasAtribuidas();

        this.m_estadoCandidatura = this.m_cand.getEstado();
        m_estadoCandidatura.setEstadoCandidaturaAtribuida();
    }
}
