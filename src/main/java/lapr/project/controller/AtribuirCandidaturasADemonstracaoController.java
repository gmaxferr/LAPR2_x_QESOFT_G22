package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.estados.CandidaturaADemonstracao.EstadoCandidaturaADemonstracao;
import lapr.project.estados.Demonstracao.EstadoDemonstracao;
import lapr.project.model.*;
import lapr.project.registos.*;

/**
 * Representação do Controller do caso de uso - atribuir candidaturas a demonstração
 * 
 * @author Ana Leite
 */
public class AtribuirCandidaturasADemonstracaoController {

    /**
     * Centro de Exposições
     */
    private CentroExposicoes m_centroExposicoes;
    
    /**
     * Registo de Demonstrações
     */
    private RegistoDemonstracoes m_rd;
    
    /**
     * Registo de Mecanismos
     */
    private RegistoMecanismos m_rm;
    
    /**
     * Registo Candidaturas a Demonstrações
     */
    private RegistoCandidaturaADemonstracoes m_rc;
    
    /**
     * Registo de atribuições
     */
    private RegistoAtribuicoes m_ra;
    
    /**
     * Lista de demonstrações
     */
    private List<Demonstracao> m_listaDemos;
    
    /**
     * Exposição
     */
    private Exposicao m_exposicao;
    
    /**
     * Demonstração escolhida
     */
    private Demonstracao m_demonstracao;
    
    /**
     * Estado Demonstração
     */
    private EstadoDemonstracao m_estadoDemonstracao;
    
    /**
     * Estado candidatura a demonstração
     */
    private EstadoCandidaturaADemonstracao m_estadoCandidatura;
    
    /**
     * Candidatura a demonstração
     */
    private CandidaturaADemonstracao m_cand;
    
    /**
     * Constrói uma instância de AtribuirCandidaturasADemonstracaoController 
     * recebendo como parâmetro o centro de exposições
     * 
     * @param centroExposicoes centro de exposições
     */
    public AtribuirCandidaturasADemonstracaoController(CentroExposicoes centroExposicoes){
        this.m_centroExposicoes = centroExposicoes;
        this.m_listaDemos = new ArrayList<>();
    }
    
    /**
     * Guarda o registo de demonstrações
     */
    public void getRegistoDemonstracoes(){
        this.m_rd = m_exposicao.getRegistoDemonstracoes();
    }
    
    /**
     * Devolve a lista de demonstrações de um organizador
     * 
     * @param usernameOrganizador username do organizador
     * @return lista de demonstrações de um organizador
     */
    public List<Demonstracao> getListaDemonstracoesDoOrganizador(String usernameOrganizador){
        return this.m_listaDemos=  m_rd.getListaDemonstracoesDoOrganizador(usernameOrganizador);
    }
    
    /**
     * Modifica a demonstração
     * 
     * @param demonstracao nova demonstração
     */
    public void setDemonstracao(Demonstracao demonstracao){
        this.m_demonstracao = demonstracao;
    }
    
    /**
     * Guarda o registo de mecanismos
     */
    public void getRegistoMecanismos() {
        this.m_rm = m_centroExposicoes.getRegistoMecanismos();
    }

    /**
     * Devolve a lista de mecanismos
     * 
     * @return lista de mecanismos
     */
    public List<Mecanismo> getListaMecanismos() {
        return this.m_rm.getListaMecanismos();
    }

    /**
     * Guarda o registo de candidaturas
     */
    public void getRegistoCandidaturas() {
        this.m_rc = this.m_demonstracao.getRegistoCandidaturasADemonstracao();
    }

    /**
     * Guarda o registo de atribuicoes
     */
    public void getRegistoAtribuicoes() {
        this.m_ra = m_exposicao.getRegistoAtribuicoes();
    }
    
    /**
     * Devolve as atribuições geradas.
     *
     * @param mec mecanismo.
     *
     * @return atribuições geradas.
     */
    public List<AtribuicaoCandidatura> atribui(Mecanismo mec) {
        MecanismoSimples mecanismo = (MecanismoSimples) mec;
        return mecanismo.atribui(this.m_demonstracao);
    }
    
    /**
     * Devolve as atribuições geradas.
     *
     * @param mec mecanismo.
     * @param numeroFAEOuExperiencia
     *
     * @return atribuições geradas.
     */
    public List<AtribuicaoCandidatura> atribui(Mecanismo mec, String numeroFAEOuExperiencia) {
        MecanismoIteragivel mecanismo = (MecanismoIteragivel) mec;
        return mecanismo.atribui(this.m_demonstracao, numeroFAEOuExperiencia);
    }
    
    /**
     * Regista a atribuição gerada
     * 
     * @param listaAtribuicao lista de atribuicoes
     */
    public void registaAtribuicao(List<AtribuicaoCandidatura> listaAtribuicao) {
        this.m_ra.setListaAtribuicao(listaAtribuicao);
    }
    
    /**
     * 
     */
    public void setEstadoCandidaturaAtribuida(){
        this.m_estadoDemonstracao = this.m_demonstracao.getEstadoDemo();
        m_estadoDemonstracao.setEstadoDemonstracaoCandidaturasAtribuidas();
        
        this.m_estadoCandidatura = this.m_cand.getEstado();
        m_estadoCandidatura.setEstadoCandidaturaAtribuida();
    }
}
