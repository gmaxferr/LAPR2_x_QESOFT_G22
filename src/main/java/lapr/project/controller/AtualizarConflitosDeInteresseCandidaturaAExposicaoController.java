package lapr.project.controller;

import java.util.List;
import lapr.project.model.*;
import lapr.project.registos.*;

/**
 *
 * @author G29
 */
public class AtualizarConflitosDeInteresseCandidaturaAExposicaoController {

    private RegistoConflitos rc;
    private RegistoCandidaturasAExposicao rcand;
    private RegistoFAE rf;
    private RegistoTipoConflitos rtc;
    private RegistoExposicoes re;

    private CentroExposicoes ce;
    private String usernameFae;
    private Exposicao e;
    private FAE fae;
    private CandidaturaAExposicao cand;
    private TipoConflito tipo;

    /**
     * Construtor do Controller (UC14)
     *
     * @param usernameFae - username do FAE que iniciou o caso de uso
     * @param ce - Centro de Exposições
     */
    public AtualizarConflitosDeInteresseCandidaturaAExposicaoController(String usernameFae, CentroExposicoes ce) {
        this.ce = ce;
        this.usernameFae = usernameFae;
    }

    /**
     * @return lista de conflitos da exposição pretendida
     */
    public List<ConflitoDeInteresse> getListaConflitos() {
        return rc.getListaConflitos();
    }

    /**
     * Remove conflito da lista de conflitos da exposição
     *
     * @param c - Conflito a remover
     */
    public void removeConflito(ConflitoDeInteresse c) {
        rc.remove(c);
    }

    /**
     * Cria uma lista com as exposições de um FAE
     *
     * @return lista de exposições de um FAE
     */
    public List<Exposicao> getFaeExpos() {
        re = ce.getRegistoExposicoes();
        return re.getFaeExpos(usernameFae);
    }

    /**
     * Guarda a exposição pretendida no Controller
     *
     * @param e - Exposição
     */
    public void selectExpo(Exposicao e) {
        this.e = e;
        rc = e.getRegistoConflitos();
        rcand = e.getRegistoCandidaturasAExposicao();
        rf = e.getRegistoFAE();
        fae = rf.getFAE(usernameFae);
    }

    /**
     * Regista um conflito no registo de conflitos da exposição com o FAE e
     * candidatura selecionados pelo utilizador
     */
    public void registaConflito() {
        rc.criarConflito(fae, cand, tipo);
    }

    /**
     *
     * @return Lista de candidaturas da Exposição selecionada
     */
    public List<CandidaturaAExposicao> getListaCandidaturas() {
        return rcand.getListaCandidaturas();
    }

    /**
     * Valida a informação de candidatura
     *
     * @return true se for válida; false caso contrário
     */
    public boolean validaConflito() {
        return rc.valida(fae, cand, tipo);
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
        return rf.getListaFAE();
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
        this.rtc = ce.getRegistoTiposConflitos();
    }

    /**
     * @return lista de tipos de conflito do centro de exposições
     */
    public List<TipoConflito> getListaDeTiposConflito() {
        return rtc.getListaTipoConflitos();
    }
}
