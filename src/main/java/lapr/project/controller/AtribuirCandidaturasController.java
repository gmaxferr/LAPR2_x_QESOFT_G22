package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.estados.EstadoCandidatura;
import lapr.project.estados.EstadoExposicao;
import lapr.project.model.Atribuicao;
import lapr.project.model.Candidatura;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.model.FAE;
import lapr.project.model.Mecanismo;
import lapr.project.registos.RegistoCandidaturas;
import lapr.project.registos.RegistoExposicoes;
import lapr.project.registos.RegistoMecanismos;

/**
 * Representação do Controller do caso de uso - atribuir candidaturas
 *
 * @author Ricardo Osório Ana Leite
 */
public class AtribuirCandidaturasController {

    private ArrayList<Exposicao> listaExpo;
    private ArrayList<Candidatura> listaCand;
    private ArrayList<FAE> listaFAE;
    private RegistoExposicoes re;
    /*as variaveis seguintes são de instância para evitar problemas 
    caso fossem de classe quando duas pessoas ou mais executam este UC ao 
    mesmo tempo. Os dados guardados do primeiro utilizador seriam 
    sobrepostos pelos do segundo*/
    private Candidatura cand;
    private Decisao d;
    private Exposicao e;

    private CentroExposicoes centroExposicoes;
    private RegistoMecanismos rm;
    private RegistoCandidaturas rc;
    private EstadoExposicao estadoExposicao;
    private EstadoCandidatura estadoCandidatura;

    public AtribuirCandidaturasController(CentroExposicoes centroExposicoes) {
        this.listaExpo = new ArrayList<>();
        this.listaCand = new ArrayList<>();
        this.listaFAE = new ArrayList<>();
        this.cand = new Candidatura();
        this.centroExposicoes = centroExposicoes;
    }

    /**
     * Devolve a lista de Exposições do Organizador
     *
     * @return lista de Exposições o Organizador
     */
    public ArrayList<Exposicao> getlistaExposicoesDoOrganizador() {
        listaExpo = centroExposicoes.getRegistoExposicoes().getlistaExposicoesDoOrganizador();
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
    public ArrayList<Candidatura> getListaCandidatuas() {
        listaCand = this.e.getListaCandidaturas();
        return listaCand;
    }

    /**
     * Devolve a lista de FAE
     *
     * @return lista de FAE
     */
    public ArrayList<FAE> getListaFAE() {
        return this.e.getListaFAE();
    }

    /**
     * Chama o método criarDecisão para a exposição correta
     *
     * @param fae fae escolhido pelo utilizador
     * @param c candidatura escolhida pelo utilizador
     */
    public void criarDecisao(FAE fae, Candidatura c) {
        d = c.criarDecisao(fae);
    }

    /**
     * Valida a decisão. Consiste na validação local
     *
     * @param c candidatura escolhida pelo utilizador
     */
    public void validarDecisao(Candidatura c) {
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

    public List<Atribuicao> atribui(Mecanismo mec) {
        return mec.atribui();
    }

    public void registaAtribuicao(List<Atribuicao> listaAtribuicao) {
        this.e.getRegistoAtribuicoes().setListaAtribuicao(listaAtribuicao);
    }

    public void setEstadoCandidaturaAtribuida() {
        this.estadoExposicao = this.e.getEstadoExposicao();
        estadoExposicao.setEstadoCandidaturasAtribuidas();

        this.estadoCandidatura = this.cand.getEstadoCandidatura();
        estadoCandidatura.setEstadoCandidaturaAtribuida();
    }

}
