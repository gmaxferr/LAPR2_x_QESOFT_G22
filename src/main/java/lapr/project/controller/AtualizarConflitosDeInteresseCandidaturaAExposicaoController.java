package lapr.project.controller;

import java.util.List;
import lapr.project.model.*;
import lapr.project.registos.*;

/**
 * Representação do controller do UC Atualizar Conflitos De Interesse Candidatura 
 * A Exposicao
 * 
 * @author G29
 */
public class AtualizarConflitosDeInteresseCandidaturaAExposicaoController {

    /**
     * Registo de conflitos
     */
    private RegistoConflitos rc;
    
    /**
     * Registo de candidaturas a exposição
     */
    private RegistoCandidaturasAExposicao rcand;
    
    /**
     * Registo de FAE
     */
    private RegistoFAE rf;
    
    /**
     * Registo de tipos de conflito
     */
    private RegistoTipoConflitos rtc;
    
    /**
     * Registo de exposições
     */
    private RegistoExposicoes re;

    /**
     * Centro de exposições
     */
    private CentroExposicoes ce;
    
    /**
     * Username do fae
     */
    private String usernameFae;
    
    /**
     * Exposição selecionada
     */
    private Exposicao e;
    
    /**
     * FAE
     */
    private FAE fae;
    
    /**
     * Candidatura a exposição
     */
    private CandidaturaAExposicao cand;
    
    /**
     * Tipo de conflito
     */
    private TipoConflito tipo;

    /**
     * Construtor de objetos do tipo AtualizarConflitosDeInteresseCandidaturaAExposicaoController 
     * com os parametros username do fae e centro de exposições
     *
     * @param usernameFae - username do FAE que iniciou o caso de uso
     * @param ce - Centro de Exposições
     */
    public AtualizarConflitosDeInteresseCandidaturaAExposicaoController(String usernameFae, CentroExposicoes ce) {
        this.ce = ce;
        this.usernameFae = usernameFae;
    }

    /**
     * Devolve a lista de conflitos da exposição pretendida
     * 
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
    public List<Exposicao> getExposFae() {
        re = ce.getRegistoExposicoes();
        return re.getExposEstadoConflitosDetetadosFae(usernameFae);
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
     * Devolve a lista de candidaturas da Exposição selecionada
     * 
     * @return lista de candidaturas da Exposição selecionada
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
     * Devolve a lista de FAE da exposição selecionada
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
     * Inicializar o registo de tipos de conflito.
     */
    public void pullRegistoDeTiposDeConflito() {
        this.rtc = ce.getRegistoTiposConflitos();
    }

    /**
     * Devolve a lista de tipos de conflito do centro de exposições
     * 
     * @return lista de tipos de conflito do centro de exposições
     */
    public List<TipoConflito> getListaDeTiposConflito() {
        return rtc.getListaTipoConflitos();
    }
}
