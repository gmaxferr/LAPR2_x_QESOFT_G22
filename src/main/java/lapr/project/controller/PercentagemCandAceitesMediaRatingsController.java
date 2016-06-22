package lapr.project.controller;

import java.util.List;
import lapr.project.model.*;
import lapr.project.registos.*;

/**
 * Controller usado pelo UC-24 Calcular percentagem de candidaturas do expositor
 * aceites e média dos ratings por candidatura
 *
 * @author G29
 */
public class PercentagemCandAceitesMediaRatingsController {

    /**
     * Centro de exposições atual
     */
    private final CentroExposicoes centroExposicoes;

    /**
     * Registo de exposições do centro de exposições atual
     */
    private RegistoExposicoes re;

    /**
     * Exposição selecionada na UI
     */
    private Exposicao m_exposicaoSelecionada;

    /**
     * Registo de candidaturas à exposição selecionada na UI
     */
    private RegistoCandidaturasAExposicao rce;

    /**
     * Registo das atribuições geradas da candidatura selecionada
     */
    private RegistoAtribuicoes rAtrib;

    /**
     * Registo de demonstrações da exposição selecionada
     */
    private RegistoDemonstracoes rd;

    /**
     * Construtor recebendo como parametro apenas o centro de exposições atual
     *
     * @param ce centro de exposições atual
     */
    public PercentagemCandAceitesMediaRatingsController(CentroExposicoes ce) {
        this.centroExposicoes = ce;
    }

    /**
     * Guarda o registo de exposições do centro de exposições do centro de
     * exposições
     */
    public void getRegistoExposicoes() {
        this.re = this.centroExposicoes.getRegistoExposicoes();
    }

    /**
     * Devolve a lista de exposições que se encontram no estado decididas
     *
     * @return lista de exposições no estado decididas
     */
    public List<Exposicao> getListaExposicoesEstadoDecididas() {
        return this.re.getListaExposicoesEstadoCandidaturasDecididas();
    }

    /**
     * Define uma exposição como a selecionada (pretendida pelo utilizador) e
     * sobre a qual irá ser executado o UC (cálculos)
     *
     * @param e exposição
     */
    public void setM_exposicaoSelecionada(Exposicao e) {
        this.m_exposicaoSelecionada = e;
    }

    /**
     * Guarda o registo das candidaturas da exposição selecionada
     */
    public void getRegistoCandidaturas() {
        this.rce = this.m_exposicaoSelecionada.getRegistoCandidaturasAExposicao();
    }

    /**
     * Devolve a lista de candidaturas à exposição selecionada
     *
     * @return lista de candidaturas à exposição
     */
    public List<CandidaturaAExposicao> getListaCandidaturas() {
        return this.rce.getListaCandidaturas();
    }

    public void getRegistoDemonstrações() {
        this.rd = this.m_exposicaoSelecionada.getRegistoDemonstracoes();
    }

    /**
     * Devolve a percentagem de candidaturas à exposição de um expositor que
     * foram aceites. O expositor é identificado passando como parametro o seu
     * email
     *
     * @param emailExpositor email do expositor
     * @return percentagem de candidaturas de um expositor aceites
     */
    public float getPercentagemCandidaturasAExposicaoAceitesDoExpositor(String emailExpositor) {
        return this.rce.getPercentagemCandidaturasAceites(emailExpositor);

    }

    /**
     * Devolve a percentagem de candidaturas às demonstrações de um expositor
     * que foram aceites. O expositor é identificado passando como parametro o
     * seu email
     *
     * @param emailExpositor email do expositor
     * @return percentagem de candidaturas de um expositor aceites
     */
    public float getPercentagemCandidaturasAsDemonstracoesAceitesDoExpositor(String emailExpositor) {
        return this.rd.getPercentagemCandidaturasAceites(emailExpositor);
    }

    /**
     * Guarda o registo de atribuições da exposição selecionada
     */
    public void getRegistoAtribuicoes() {
        this.rAtrib = this.m_exposicaoSelecionada.getRegistoAtribuicoes();
    }

    /**
     * Devolve um vetor com, em cada posição, a média dos ratings da candidatura
     * na mesma posição no registo de candidaturas dados por todos os FAE
     * designados para avaliarem-na
     *
     * @return vetor com a média dos ratings dos FAE
     */
    public float[] getMediaRatingsTodasCandidaturas() {
        return this.rAtrib.getMediaRatingsTodasCandidaturas();
    }
}
