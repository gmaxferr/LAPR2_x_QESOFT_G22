package lapr.project.controller;

import java.util.ArrayList;
import lapr.project.model.*;
import lapr.project.registos.*;

/**
 * Representação do controller do UC Avaliar Candidatura A Exposição
 *
 * @author G29
 */
public class AvaliarCandidaturaAExposicaoController {

    /**
     * Centro de exposições atual
     */
    private CentroExposicoes m_centroExposicoesAtual;

    /**
     * Username do FAE a executar este UC
     */
    private final String m_usernameFAE;

    /**
     * Registo de exposições - irá guardar todas as exposições do centro de
     * exposições atual
     */
    private RegistoExposicoes m_re;

    /**
     * Exposição selecionada pelo FAE na UI
     */
    private Exposicao m_exposicaoSelecionada;

    /**
     * Registo de atribuições associado à exposição escolhida pelo FAE na UI
     */
    private RegistoAtribuicoesCandidaturasExposicao m_ra;

    /**
     * Atribuição escolhida pelo FAE na UI
     */
    private AtribuicaoCandidatura m_atribuicaoEscolhida;

    /**
     * Objecto Avaliação associado ao FAE a executar este UC e à candidatura
     * escolhida na UI
     */
    private Avaliacao m_avaliacaoDoFae;

    /**
     * Construtor de objetos do tipo AvaliarCandidaturaAExposicaoController com
     * os parametros centro de exposições e username do FAE
     *
     * @param centroExposicoes centro de exposições
     * @param usernameFAE username do FAE a executar este UC
     */
    public AvaliarCandidaturaAExposicaoController(CentroExposicoes centroExposicoes, String usernameFAE) {
        this.m_centroExposicoesAtual = centroExposicoes;
        this.m_usernameFAE = usernameFAE;
    }

    /**
     * Busca e guarda o registo de exposições associado ao centro de exposições
     * atual
     */
    public void getRegistoExposicoes() {
        this.m_re = this.m_centroExposicoesAtual.getRegistoExposicoes();
    }

    /**
     * Devolve a lista de exposições que estejam no estado
     * candidaturasAtribuidas e que o utilizador detenha o cargo de FAE sobre
     * estas
     *
     * @return lista de exposições válidas sobre as quais se pode executar este
     * UC
     */
    public ArrayList<Exposicao> getListaExposicoesEstadoCandidaturasAtribuidasDoFAE() {
        return this.m_re.getListaExposicoesEstadoCandidaturasAtribuidasDoFAE(this.m_usernameFAE);
    }

    /**
     * Guarda o registo de atribuições da exposição selecionada
     */
    public void getRegistoAtribuicoes() {
        this.m_ra = this.m_exposicaoSelecionada.getRegistoAtribuicoesExposicao();
    }

    /**
     * Devolve a lista de atribuições (candidatura-fae) realizadas com o FAE a
     * executar este UC
     *
     * @return lista de atribuiçoes do FAE a executar este UC
     */
    public ArrayList<AtribuicaoCandidatura> getListaAtribuicoesDoFAE() {
        return this.m_ra.getListaAtribuicoesDoFAE(this.m_usernameFAE);
    }

    /**
     * Devolve o nome da empresa guardado na candidatura selecionada na UI pelo
     * FAE
     *
     * @return nome da empresa da candidatura selecionada
     */
    public String getDadosCandidaturaNomeEmpresa() {
        return this.m_atribuicaoEscolhida.getCandidaturaAssociada().getNomeEmpresa();
    }

    /**
     * Devolve a morada da empresa guardada na candidatura selecionada na UI
     * pelo FAE
     *
     * @return morada da empresa da candidatura selecionada
     */
    public String getDadosCandidaturaMoradaEmpresa() {
        return this.m_atribuicaoEscolhida.getCandidaturaAssociada().getMoradaEmpresa();
    }

    /**
     * Devolve o número de telemóvel da candidatura selecionada pelo FAE na UI
     *
     * @return número de telemóvel da candidatura seleciona
     */
    public int getDadosCandidaturaTelemovel() {
        return this.m_atribuicaoEscolhida.getCandidaturaAssociada().getTelemovel();
    }

    /**
     * Devolve a área da candidatura selecionada na UI pelo FAE
     *
     * @return área da candidatura selecionada
     */
    public int getDadosCandidaturaArea() {
        return this.m_atribuicaoEscolhida.getCandidaturaAssociada().getArea();
    }

    /**
     * Devolve o número de convites da candidatura selecionada na UI pelo FAE
     *
     * @return número de convites da candidatura selecionada
     */
    public int getDadosCandidaturaNumConvites() {
        return this.m_atribuicaoEscolhida.getCandidaturaAssociada().getNumConvites();
    }

    /**
     * Devolve a Avaliação - objecto que guarda a avaliação, ratings e
     * justificação - do FAE sobre a candidatura selecionada
     *
     * @return o objecto Avaliação deste FAE e a candidatura selecionada
     */
    public Avaliacao getAvaliacaoDoFae() {
        this.m_avaliacaoDoFae = this.m_atribuicaoEscolhida.getRegistoFaeAvaliacao().getAvaliacaoDoFae(this.m_usernameFAE);
        return this.m_avaliacaoDoFae;
    }

    /**
     * Devolve o rating dado pelo FAE relativo ao conhecimento pelo tema da
     * candidatura
     *
     * @return ratings relativo ao conhecimento pelo tema
     */
    public int getRatingConhecimentoSobreTema() {
        return this.m_avaliacaoDoFae.getRatingConhecimentoSobreOTema();
    }

    /**
     * Devolve o rating dado pelo FAE relativo à adequação da candidatura à
     * exposição
     *
     * @return rating relativo à adequação da candidatura à exposição
     */
    public int getRatingAdequacaoAExposicao() {
        return this.m_avaliacaoDoFae.getRatingAdequacaoAExposicao();
    }

    /**
     * Devolve o rating dado pelo FAE relativo à adequação da candidatura às
     * demonstrações
     *
     * @return rating relativo à adequação da candidatura às demonstrações
     */
    public int getRatingAdequacaoAsDemos() {
        return this.m_avaliacaoDoFae.getRatingAdequacaoAsDemos();
    }

    /**
     * Devolve o rating dado pelo FAE relativo ao número de convites da
     * candidatura
     *
     * @return rating relativo ao número de convites da candidatura
     */
    public int getRatingAdequacaoNumConvites() {
        return this.m_avaliacaoDoFae.getRatingAdequacaoNumConvites();
    }

    /**
     * Devolve o rating dado pelo FAE relativo à recomendação global da
     * candidatura
     *
     * @return rating relativo à recomendação global da candidatura
     */
    public int getRatingRecomendacaoGlobal() {
        return this.m_avaliacaoDoFae.getRatingRecomendacaoGlobal();
    }

    /**
     * Define uma atribuição como a escolhida pelo FAE na UI
     *
     * @param atribuicao atribuição escolhida pelo FAE
     */
    public void setAtribuicao(AtribuicaoCandidatura atribuicao) {
        this.m_atribuicaoEscolhida = atribuicao;
    }

    /**
     * Define novos parametros a serem guardados no objecto Avaliação deste FAE
     * sobre a candidatura escolhida
     *
     * @param ratingConhecimentoSobreTema inteiro de 0-5 que representa o
     * conhecimento do FAE sobre o tema da candidatura/exposição
     * @param ratingAdequacaoAExposicao inteiro de 0-5 que representa a opinião
     * do FAE relativamente à adequação da candidatura à exposição
     * @param ratingAdequacaoAsDemos inteiro de 0-5 que representa a opinião do
     * FAE relativamente à adequação da candidatura às demonstrações
     * @param ratingAdequacaoNumConvites inteiro de 0-5 que representa a opinião
     * do FAE relativamente à adequação do número de convites à candidatura
     * @param ratingRecomendacaoGlobal inteiro de 0-5 que representa a
     * recomendação do FAE para a candidatura
     */
    public void setAvalicao(int ratingConhecimentoSobreTema, int ratingAdequacaoAExposicao, int ratingAdequacaoAsDemos, int ratingAdequacaoNumConvites, int ratingRecomendacaoGlobal) {
        this.m_avaliacaoDoFae.setAvaliacaoCandidaturaAExposicao(ratingConhecimentoSobreTema, ratingAdequacaoAExposicao, ratingAdequacaoAsDemos, ratingAdequacaoNumConvites, ratingRecomendacaoGlobal);
    }

    /**
     * Define uma exposição como a selecionada pelo FAE na UI
     *
     * @param exposicao exposição selecionada pelo FAE
     */
    public void setExposicao(Exposicao exposicao) {
        this.m_exposicaoSelecionada = exposicao;
    }

    public void setEstadoCandidaturaAvaliada() {
        this.m_atribuicaoEscolhida.getCandidaturaAssociada().getEstado().setEstadoCandidaturaAvaliada();
    }

}
