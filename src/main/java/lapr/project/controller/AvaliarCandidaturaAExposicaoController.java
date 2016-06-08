package lapr.project.controller;

import java.util.ArrayList;
import lapr.project.model.*;
import lapr.project.registos.*;

/**
 *
 * @author Ricardo Osorio
 */
public class AvaliarCandidaturaAExposicaoController {

    private CentroExposicoes m_centroExposicoesAtual;
    private final String m_usernameFAE;
    private RegistoExposicoes m_re;
    private Exposicao m_exposicaoSelecionada;
    private RegistoAtribuicoes m_ra;
    private AtribuicoesCandidatura m_atribuicaoEscolhida;
    private Avaliacao m_avaliacaoDoFae;
    private RegistoFaeAvaliacao m_rFaeAvalicao;

    public AvaliarCandidaturaAExposicaoController(CentroExposicoes centroExposicoes, String usernameFAE) {
        this.m_centroExposicoesAtual = centroExposicoes;
        this.m_usernameFAE = usernameFAE;
    }

    public void getRegistoExposicoes() {
        this.m_re = this.m_centroExposicoesAtual.getRegistoExposicoes();
    }

    public ArrayList<Exposicao> getListaExposicoesEstadoCandidaturasAtribuidasDoFAE() {
        return this.m_re.getListaExposicoesEstadoCandidaturasAtribuidasDoFAE(this.m_usernameFAE);
    }

    public void setExposicao(Exposicao exposicao) {
        this.m_exposicaoSelecionada = exposicao;
    }

    public void getRegistoAtribuicoes() {
        this.m_ra = this.m_exposicaoSelecionada.getRegistoAtribuicoes();
    }

    public ArrayList<AtribuicoesCandidatura> getListaAtribuicoesDoAE() {
        return this.m_ra.getListaAtribuicoesDoFAE(this.m_usernameFAE);
    }

    public void getRegistoFaeAvalicao() {
        this.m_rFaeAvalicao = this.m_atribuicaoEscolhida.getRegistoFaeAvaliacao();
    }

    public void setAtribuicao(AtribuicoesCandidatura atribuicao) {
        this.m_atribuicaoEscolhida = atribuicao;
    }

    public String getDadosCandidaturaNomeEmpresa() {
        return this.m_atribuicaoEscolhida.getCandidaturaAssociada().getNomeEmpresa();
    }

    public String getDadosCandidaturaMoradaEmpresa() {
        return this.m_atribuicaoEscolhida.getCandidaturaAssociada().getMoradaEmpresa();
    }

    public int getDadosCandidaturaTelemovel() {
        return this.m_atribuicaoEscolhida.getCandidaturaAssociada().getTelemovel();
    }

    public int getDadosCandidaturaArea() {
        return this.m_atribuicaoEscolhida.getCandidaturaAssociada().getArea();
    }

    public int getDadosCandidaturaNumConvites() {
        return this.m_atribuicaoEscolhida.getCandidaturaAssociada().getNumConvites();
    }

    public Avaliacao getAvaliacaoDoFae() {
        this.m_avaliacaoDoFae = this.m_atribuicaoEscolhida.getRegistoFaeAvaliacao().getAvaliacaoDoFae(this.m_usernameFAE);
        return this.m_avaliacaoDoFae;
    }

    public boolean verificaAvalicaoJaTomada() {
        return this.m_avaliacaoDoFae.verificaAvaliacaoJaTomada();
    }

    public boolean getAvaliacao() {
        return this.m_avaliacaoDoFae.getAvaliacao();
    }

    public String getJustificacao() {
        return this.m_avaliacaoDoFae.getJustificacao();
    }

    public int getRatingConhecimentoSobreTema() {
        return this.m_avaliacaoDoFae.getRatingConhecimentoSobreOTema();
    }

    public int getRatingAdequacaoAExposicao() {
        return this.m_avaliacaoDoFae.getRatingAdequacaoAExposicao();
    }

    public int getRatingAdequacaoAsDemos() {
        return this.m_avaliacaoDoFae.getRatingAdequacaoAsDemos();
    }

    public int getRatingAdequacaoNumConvites() {
        return this.m_avaliacaoDoFae.getRatingAdequacaoNumConvites();
    }

    public int getRatingRecomendacaoGlobal() {
        return this.m_avaliacaoDoFae.getRatingRecomendacaoGlobal();
    }

    public void setAvalicao(boolean avaliacao, String justificacao, int ratingConhecimentoSobreTema, int ratingAdequacaoAExposicao, int ratingAdequacaoAsDemos, int ratingAdequacaoNumConvites, int ratingRecomendacaoGlobal) {
        this.m_avaliacaoDoFae.setAvalicao(avaliacao, justificacao, ratingConhecimentoSobreTema, ratingAdequacaoAExposicao, ratingAdequacaoAsDemos, ratingAdequacaoNumConvites, ratingRecomendacaoGlobal);
    }

}
