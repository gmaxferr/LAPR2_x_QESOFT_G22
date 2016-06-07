package lapr.project.controller;

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
    private CandidaturaAExposicao cand;
    private Exposicao e;
    private CentroExposicoes centroExposicoes;
    private RegistoMecanismos rm;
    private RegistoCandidaturasAExposicao rc;
    private EstadoExposicao estadoExposicao;
    private EstadoCandidaturaAExposicao estadoCandidatura;
    private final String usernameOrganizador;

    public AtribuirCandidaturasController(CentroExposicoes centroExposicoes, String usernameOrganizador) {
        this.m_listaExpo = new ArrayList<>();
        this.centroExposicoes = centroExposicoes;
        this.usernameOrganizador = usernameOrganizador;
    }

    public void getRegistoExposicoes() {
        this.m_re = centroExposicoes.getRegistoExposicoes();
    }

    /**
     * Devolve a lista de Exposições do Organizador
     *
     * @return lista de Exposições o Organizador
     */
    public ArrayList<Exposicao> getListaExposicoesDoOrganizador() {
        m_listaExpo = centroExposicoes.getRegistoExposicoes().getlistaExposicoesDoOrganizadorEstadoCriadaOuDemosDefinidasSemFAE(this.usernameOrganizador);
        return m_listaExpo;
    }

    /**
     * Método que guarda a exposição escolhida pelo utilizador
     *
     * @param exposicao exposição escolhida
     */
    public void setExposicao(Exposicao exposicao) {
        this.e = exposicao;
    }

    public void getRegistoMecanismos() {
        this.rm = centroExposicoes.getRegistoMecanismos();
    }

    public List<Mecanismo> getListaMecanismos() {
        return this.rm.getListaMecanismos();
    }

    public void getRegistoCandidaturas() {
        this.rc = this.e.getRegistoCandidaturasAExposicao();
    }

    public void getRegistoAtribuicoes() {
        this.e.getRegistoAtribuicoes();
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
        return mecanismo.atribui(this.e);
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
        return mecanismo.atribui(this.e, numeroFAEOuExperiencia);
    }

    public void registaAtribuicao(List<AtribuicoesCandidatura> listaAtribuicao) {
        this.e.getRegistoAtribuicoes().setListaAtribuicao(listaAtribuicao);
    }

    public void setEstadoCandidaturaAtribuida() {
        this.estadoExposicao = this.e.getEstado();
        estadoExposicao.setEstadoCandidaturasAtribuidas();

        this.estadoCandidatura = this.cand.getEstado();
        estadoCandidatura.setEstadoCandidaturaAtribuida();
    }
}
