package lapr.project.controller;

import java.util.List;
import lapr.project.model.*;
import lapr.project.registos.*;

/**
 * Representação do controller do UC PercentagemCandAceitesMediaRatingsController
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
    private RegistoAtribuicoesCandidaturasExposicao m_rAtribExpos;

    /**
     * Registo de demonstrações da exposição selecionada
     */
    private RegistoDemonstracoes rd;

    /**
     * Registo de atribuições das demonstrações pelo FAE
     */
    private RegistoAtribuicoesCandidaturasDemonstracao m_rAtribDemos;

    /**
     * Construtor de objetos do tipo PercentagemCandAceitesMediaRatingsController 
     * recebendo como parametro o centro de exposições atual
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
     * Define uma exposição como a selecionada (pretendida pelo utilizador) e
     * sobre a qual irá ser executado o UC (cálculos)
     *
     * @param e exposição
     */
    public void setExposicaoSelecionada(Exposicao e) {
        this.m_exposicaoSelecionada = e;
    }

    /**
     * Guarda o registo das candidaturas da exposição selecionada
     */
    public void getRegistoCandidaturasAExposicao() {
        this.rce = this.m_exposicaoSelecionada.getRegistoCandidaturasAExposicao();
    }

    /**
     * Devolve a lista de candidaturas à exposição selecionada
     *
     * @return lista de candidaturas à exposição
     */
    public List<CandidaturaAExposicao> getListaCandidaturasAExposicao() {
        return this.rce.getListaCandidaturas();
    }

    /**
     * Guarda o registo de demonstrações
     */
    public void getRegistoDemonstracoes() {
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
    public void getRegistoAtribuicoesExposicao() {
        this.m_rAtribExpos = this.m_exposicaoSelecionada.getRegistoAtribuicoesExposicao();
    }

    /**
     * Devolve um vetor com, em cada posição, a média dos ratings da candidatura
     * à exposição na mesma posição no registo de candidaturas à exposição dados
     * por todos os FAE designados para avaliarem-na
     *
     * @return vetor com a média dos ratings dos FAE
     */
    public float[] getMediaRatingsTodasCandidaturasAExposicao() {
        return this.m_rAtribExpos.getMediaRatingsTodasCandidaturasAExposicao();
    }

    /**
     * Devolve um vetor com, em cada posição, a média dos ratings da candidatura
     * à demonstração na mesma posição no registo de demonstrações dados por
     * todos os FAE designados para avaliarem-na
     *
     * @return vetor com a média dos ratings dos FAE
     */
    public float[] getMediaRatingsTodasCandidaturasAsDemonstracoes() {
        return this.m_rAtribDemos.getMediaRatingsTodasCandidaturasAsDemonstracoes();
    }

    /**
     * Guarda o registo de atribuições da
     */
    public void getRegistoAtribuicoesDemonstracoes() {
        this.m_rAtribDemos = this.m_exposicaoSelecionada.getRegistoAtribuicoesDemonstracao();
    }

    /**
     * Devolve a lista de atribuições das demonstrações da exposição selecionada
     *
     * @return lista de atribuições das demonstrações
     */
    public List<AtribuicaoCandidaturaDemonstracao> getListaAtribuicoesDemonstracoes() {
        return this.m_rAtribDemos.getListaAtribuicoes();
    }

    /**
     * Devolve um vetor em que, em cada posição, contém as médias dos ratings
     * pela mesma ordem que são mostrados aos FAE. Isto é, na posição 0
     * (primeira posição) estará a média dos ratings sobre o conhecimento do
     * tema.
     *
     * @return vetor com média dos ratings por cada posição
     */
    public float[][] getMediaRatingsPorCriterioDasCandidaturasAExposicao() {
        return this.m_rAtribExpos.getMediaRatingsPorCriterioDasCandidaturas();
    }

    /**
     * Devolve um vetor em que, em cada posição, contém as médias dos ratings
     * pela mesma ordem que são mostrados aos FAE. Isto é, na posição 0
     * (primeira posição) estará a média dos ratings sobre o conhecimento do
     * tema.
     *
     * @return vetor com média dos ratings por cada posição
     */
    public float[][] getMediaRatingsPorCriterioDasCandidaturasAsDemonstracoes() {
        return this.m_rAtribDemos.getMediaRatingsPorCriterioDasCandidaturas();
    }

    /**
     * Devolve uma lista com as candidaturas à exposição selecionada no estado
     * avaliadas de forma a que seja possível calcular-se as médias dos ratings
     *
     * @return lista das candidaturas da exposição selecionada no estado
     * Avaliadas
     */
    public List<CandidaturaAExposicao> getListaCandidaturasAExposicaoEstadoAvaliadasOuSuperior() {
        return this.rce.getListaCandidaturasEstadoAvaliadasOuSuperior();
    }

    /**
     * Devolve uma lista com as exposições que se encontrem no estado avaliadas
     *
     * @return lista com as exposições no estado avaliadas
     */
    public List<Exposicao> getListaExposicoesEstadoAvaliadasOuSuperior() {
        return this.re.getListaExposicoesEstadoAvaliadasOuPosterior();
    }
}
