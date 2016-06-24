package lapr.project.controller;

import java.util.List;
import lapr.project.model.*;
import lapr.project.registos.*;

/**
 * Representação do controller do UC Atualizar Conflito De Interesse Candidatura 
 * A Demonstracao
 * 
 * @author G29
 */
public class AtualizarConflitoDeInteresseCandidaturaADemonstracaoController {

    /**
     * Registo conflitos da demonstração
     */
    private RegistoConflitosDemonstracao m_rc;
    
    /**
     * Registo das Candidaturas a demonstração
     */
    private RegistoCandidaturasADemonstracao m_rcand;
    
    /**
     * Registo de FAE's
     */
    private RegistoFAE m_rf;
    
    /**
     * Registo de demonstrações
     */
    private RegistoDemonstracoes m_rd;
    
    /**
     * Registo de atribuições candidatura a demonstração
     */
    private RegistoAtribuicoesCandidaturasDemonstracao m_rad;
    
    /**
     * Regsito tipos de conflito a de mosntração
     */
    private RegistoTiposConflitoDemonstracao m_rtc;
    
    /**
     * Registo de exposições
     */
    private RegistoExposicoes m_re;

    /**
     * Centro de exposições
     */
    private CentroExposicoes m_ce;
    
    /**
     * USername do fae
     */
    private String username;
    
    /**
     * Exposição selecionada
     */
    private Exposicao e;
    
    /**
     * Demonstração selecionada
     */
    private Demonstracao d;
    
    /**
     * FAE
     */
    private FAE fae;
    
    /**
     * Candidatura a demonstração
     */
    private CandidaturaADemonstracao cand;
    
    /**
     * tipo de conflito a demonstração
     */
    private TipoConflitoDemonstracao tipo;
    

    /**
     * Construtor de objetos do tipo AtualizarConflitoDeInteresseCandidaturaADemonstracaoController
     * com os paramentros username e centro de exposições
     *
     * @param username - username do FAE que iniciou o caso de uso
     * @param ce - Centro de Exposições
     */
    public AtualizarConflitoDeInteresseCandidaturaADemonstracaoController(String username, CentroExposicoes ce) {
        this.m_ce = ce;
        this.username = username;
    }

    /**
     * Devolve a lista de conflitos da exposição pretendida
     * 
     * @return lista de conflitos da exposição pretendida
     */
    public List<ConflitoDeInteresseDemonstracao> getListaConflitos() {
        m_rc = d.getRegistoConflitosDemonstracao();
        return m_rc.getListaConflitos();
    }

    /**
     * Remove conflito da lista de conflitos da exposição
     *
     * @param c - Conflito a remover
     */
    public void removeConflito(ConflitoDeInteresseDemonstracao c) {
        m_rc.remove(c);
    }

    /**
     * Cria uma lista com as exposições de um FAE
     *
     * @return lista de exposições de um FAE
     */
    public List<Exposicao> getFaeExpos() {
        m_re = m_ce.getRegistoExposicoes();
        return m_re.getFaeDasDemosExpos(username);
    }

    /**
     * Guarda a exposição pretendida no Controller
     *
     * @param e - Exposição
     */
    public void selectExpo(Exposicao e) {
        this.e = e;
        m_rd = e.getRegistoDemonstracoes();
    }
   
    /**
     * Guarda a demonstração pretendida no Controller
     *
     * @param d - demonstração
     */
    public void selectDemo(Demonstracao d) {
        this.d = d;
        m_rf = d.getRegistoFAE();
    }

    /**
     * Regista um conflito no registo de conflitos da exposição com o FAE e
     * candidatura selecionados pelo utilizador
     */
    public void registaConflito() {
        m_rc.criarConflito(fae, cand, tipo);
    }

    /**
     * Devolve a lista de candidaturas da exposição selecionada
     * 
     * @return lista de candidaturas da exposição selecionada
     */
    public List<CandidaturaADemonstracao> getListaCandidaturas() {
        m_rad = e.getRegistoAtribuicoesDemonstracao();
        return m_rad.getListaCandidaturasDoFAE(username);
    }

    /**
     * Valida a informação de candidatura
     *
     * @return true se for válida; false caso contrário
     */
    public boolean validaConflito() {
        return m_rc.valida(fae, cand, tipo);
    }

    /**
     * Altera a candidatura guardada no Controller
     *
     * @param cand - Nova Candidatura
     */
    public void setCandidatura(CandidaturaADemonstracao cand) {
        this.cand = cand;
    }

    /**
      Lista de FAE's da demonstração selecionada
      * 
     * @return lista de FAE da demonstracao selecionada
     */
    public List<FAE> getListaFae() {
        return m_rf.getListaFAE();
    }

    /**
     * Armazena o tipo de conflito selecionado na interface
     *
     * @param tcd - tipo de conflito selecionado
     */
    public void setTipoConflito(TipoConflitoDemonstracao tcd) {
        this.tipo = tcd;
    }

    /**
     * Guarda o registo de tipos de conflitos da demonstração
     */
    public void pullRegistoDeTiposDeConflito() {
        this.m_rtc = m_ce.getRegistoTiposConflitosDemonstracao();
    }

    /**
     * Devolve a lista de tipos de conflito de demonstrações do centro de exposições
     * 
     * @return lista de tipos de conflito de demonstrações do centro de exposições
     */
    public List<TipoConflitoDemonstracao> getListaDeTiposConflito() {
        return m_rtc.getListaTipoConflitos();
    }

    /**
     * Devolve a lista de demonstrações
     * 
     * @return lista de demonstrações
     */
    public List<Demonstracao> getListaDemonstracoes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
