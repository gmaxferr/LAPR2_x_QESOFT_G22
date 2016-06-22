package lapr.project.controller;

import java.util.List;
import lapr.project.model.CandidaturaADemonstracao;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.ConflitoDeInteresseDemonstracao;
import lapr.project.model.Exposicao;
import lapr.project.model.FAE;
import lapr.project.model.TipoConflito;
import lapr.project.model.TipoConflitoDemonstracao;
import lapr.project.registos.RegistoAtribuicoesDemonstracao;
import lapr.project.registos.RegistoCandidaturasADemonstracoes;
import lapr.project.registos.RegistoConflitosDemonstracao;
import lapr.project.registos.RegistoDemonstracoes;
import lapr.project.registos.RegistoExposicoes;
import lapr.project.registos.RegistoFAE;
import lapr.project.registos.RegistoTiposConflitoDemonstracao;

/**
 *
 * @author guima
 */
public class AtualizarConflitoDeInteresseCandidaturaADemonstracaoController {

    private RegistoConflitosDemonstracao m_rc;
    private RegistoCandidaturasADemonstracoes m_rcand;
    private RegistoFAE m_rf;
    private RegistoDemonstracoes m_rd;
    private RegistoAtribuicoesDemonstracao m_rad;
    private RegistoTiposConflitoDemonstracao m_rtc;
    private RegistoExposicoes m_re;

    private CentroExposicoes m_ce;
    private String username;
    private Exposicao e;
    private FAE faeDaCand;
    private CandidaturaADemonstracao cand;
    private TipoConflitoDemonstracao tipo;
    

    /**
     * Construtor do Controller (UC14)
     *
     * @param username - username do FAE que iniciou o caso de uso
     * @param ce - Centro de Exposições
     */
    public AtualizarConflitoDeInteresseCandidaturaADemonstracaoController(String username, CentroExposicoes ce) {
        this.m_ce = ce;
        this.username = username;
    }

    /**
     * @return lista de conflitos da exposição pretendida
     */
    public List<ConflitoDeInteresseDemonstracao> getListaConflitos() {
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
     * Regista um conflito no registo de conflitos da exposição com o FAE e
     * candidatura selecionados pelo utilizador
     */
    public void registaConflito() {
        m_rc.criarConflito(faeDaCand, cand, tipo);
    }

    /**
     *
     * @return Lista de candidaturas da Exposição selecionada
     */
    public List<CandidaturaADemonstracao> getListaCandidaturas() {
        m_rad = e.getRegistoAtribuicoesDemonstracao();
    }

    /**
     * Valida a informação de candidatura
     *
     * @return true se for válida; false caso contrário
     */
    public boolean validaConflito() {
        return m_rc.valida(faeDaCand, cand, tipo);
    }

    /**
     * Altera a candidatura guardada no Controller
     *
     * @param cand - Nova Candidatura
     */
    public void setCandidatura(CandidaturaAExposicao cand) {
        this.cand = cand;
    }

    /**
     *
     * @return lista de FAE da exposição selecionada
     */
    public List<FAE> getListaFae() {
        return m_rf.getListaFAE();
    }

    /**
     * Armazena o tipo de conflito selecionado na interface
     *
     * @param tc - tipo de conflito selecionado
     */
    public void setTipoConflito(TipoConflito tc) {
        this.tipo = tc;
    }

    /**
     * Método criado apenas para inicializar o registo de tipos de conflito.
     */
    public void pullRegistoDeTiposDeConflito() {
        this.m_rtc = m_ce.getRegistoTiposConflitos();
    }

    /**
     * @return lista de tipos de conflito do centro de exposições
     */
    public List<TipoConflito> getListaDeTiposConflito() {
        return m_rtc.getListaTipoConflitos();
    }
}
