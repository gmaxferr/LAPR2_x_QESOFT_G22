package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.estados.EstadoExposicao;
import lapr.project.estados.EstadoCandidaturaAExposicao;
import lapr.project.model.*;
import lapr.project.registos.*;

/**
 * Representação do Controller do caso de uso - atribuir candidaturas
 *
 * @author Ricardo Osório Ana Leite
 */
public class AtribuirCandidaturasController {

    private ArrayList<Exposicao> listaExpo;
    private List<CandidaturaAExposicao> listaCand;
    private ArrayList<FAE> listaFAE;
    private RegistoExposicoes re;
    /*as variaveis seguintes são de instância para evitar problemas 
    caso fossem de classe quando duas pessoas ou mais executam este UC ao 
    mesmo tempo. Os dados guardados do primeiro utilizador seriam 
    sobrepostos pelos do segundo*/
    private CandidaturaAExposicao cand;
    private Decisao d;
    private Exposicao e;

    private CentroExposicoes centroExposicoes;
    private RegistoMecanismos rm;
    private RegistoCandidaturasAExposicao rc;
    private EstadoExposicao estadoExposicao;
    private EstadoCandidaturaAExposicao estadoCandidatura;
    private final String usernameOrganizador;

    public AtribuirCandidaturasController(CentroExposicoes centroExposicoes, String usernameOrganizador) {
        this.listaExpo = new ArrayList<>();
        this.listaCand = new ArrayList<>();
        this.listaFAE = new ArrayList<>();
        this.centroExposicoes = centroExposicoes;
        this.usernameOrganizador = usernameOrganizador;
    }

    /**
     * Devolve a lista de Exposições do Organizador
     *
     * @return lista de Exposições o Organizador
     */
    public ArrayList<Exposicao> getListaExposicoesDoOrganizador() {
        listaExpo = centroExposicoes.getRegistoExposicoes().getListaExposicoesDoOrganizador(this.usernameOrganizador);
        return listaExpo;
    }

    /**
     * Método que guarda a exposição escolhida pelo utilizador
     *
     * @param exposicao exposição escolhida
     */
    public void setExposicao(Exposicao exposicao) {
        this.e = exposicao;
    }

    /**
     * Devolve a lista de Candidaturas
     *
     * @return lista de candidaturas
     */
    public List<CandidaturaAExposicao> getListaCandidatuas() {
        listaCand = this.e.getRegistoCandidaturas().getListaCandidaturasAExposicao();
        return listaCand;
    }

    /**
     * Devolve a lista de FAE
     *
     * @return lista de FAE
     */
    public List<FAE> getListaFAE() {
        return this.e.getRegistoFAE().getListaFAE();
    }

    /**
     * Valida a decisão. Consiste na validação local
     *
     * @param c candidatura escolhida pelo utilizador
     */
    public void validarDecisao(CandidaturaAExposicao c) {
        e.validarDecisao(c);
    }

    public void getRegistoExposicoes() {
        this.re = centroExposicoes.getRegistoExposicoes();
    }

    public void getRegistoMecanismos() {
        this.rm = centroExposicoes.getRegistoMecanismos();
    }

    public List<Mecanismo> getListaMecanismos() {
        return this.rm.getListaMecanismos();
    }

    public void getRegistoCandidaturas() {
        this.rc = this.e.getRegistoCandidaturas();
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
    public List<Atribuicao> atribui(Mecanismo mec) {
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
    public List<Atribuicao> atribui(Mecanismo mec, String numeroFAEOuExperiencia) {
        MecanismoIteragivel mecanismo = (MecanismoIteragivel) mec;
        return mecanismo.atribui(this.e, numeroFAEOuExperiencia);
    }

    public void registaAtribuicao(List<Atribuicao> listaAtribuicao) {
        this.e.getRegistoAtribuicoes().setListaAtribuicao(listaAtribuicao);
    }

    public void setEstadoCandidaturaAtribuida() {
        this.estadoExposicao = this.e.getEstado();
        estadoExposicao.setEstadoCandidaturasAtribuidas();

        this.estadoCandidatura = this.cand.getEstado();
        estadoCandidatura.setEstadoCandidaturaAtribuida();
    }

}
