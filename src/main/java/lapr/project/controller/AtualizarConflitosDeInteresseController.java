package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.ConflitoDeInteresse;
import lapr.project.model.Exposicao;
import lapr.project.model.FAE;
import lapr.project.model.TipoConflito;
import lapr.project.registos.RegistoCandidaturasAExposicao;
import lapr.project.registos.RegistoConflitos;
import lapr.project.registos.RegistoExposicoes;
import lapr.project.registos.RegistoFAE;

/**
 *
 * @author Guilherme
 */
public class AtualizarConflitosDeInteresseController {

    private RegistoConflitos rc;
    private RegistoCandidaturasAExposicao rcand;
    private RegistoFAE rf;
    private RegistoExposicoes re;
    private String usernameFae;
    private CentroExposicoes ce;
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
    public AtualizarConflitosDeInteresseController(String usernameFae, CentroExposicoes ce) {
        this.ce = ce;
        this.usernameFae = usernameFae;

        re = ce.getRegistoExposicoes();
    }

    /**
     *
     * @return lista de exposições válidas do centro de exposições
     */
    public List<Exposicao> getListaExposicoes() {
        return re.getListaExposicoesValidas();
    }

    /**
     * @return lista de conflitos da exposição pretendida
     */
    public List<ConflitoDeInteresse> getConflitos() {
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
     * @return
     */
    public List<Exposicao> getFaeExpos() {
        List<Exposicao> expos = re.getListaExposicoesValidas();
        List<Exposicao> exposFAE = new ArrayList<>();
        for (Exposicao ex : expos) {
            if (ex.getRegistoFAE().isFAE(usernameFae)) {
                exposFAE.add(ex);
            }
        }
        return exposFAE;
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
    }

    /**
     * Valida um FAE através de um username (se existe ou não)
     *
     * @param username - username do FAE
     * @return
     */
    public boolean validaFAE(String username) {
        return rf.isFAE(username);
    }

    /**
     * Regista um conflito no registo de conflitos da exposição com o FAE e
     * candidatura selecionados pelo utilizador
     */
    public void registaConflito() {
        rc.criarConflito(fae, cand);
    }

    /**
     *
     * @return Lista de candidaturas da Exposição selecionada
     */
    public List<CandidaturaAExposicao> getListaCandidaturas() {
        return rcand.getListaCandidaturasAExposicao();
    }

    /**
     * Valida a informação de candidatura
     *
     * @return true se for válida; false caso contrário
     */
    public boolean validaConflito() {
        return rc.valida(fae, cand);
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
     * altera o FAE guardado no Controller
     *
     * @param fae - FAE
     */
    public void setFae(FAE fae) {
        this.fae = fae;
    }
    
    /**
     * 
     * @return lista de FAE da exposição selecionada
     */
    public List<FAE> getListaFae(){
        return rf.getListaFAE();
    }
}
