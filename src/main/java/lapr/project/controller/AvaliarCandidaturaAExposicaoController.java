package lapr.project.controller;

import java.util.ArrayList;
import lapr.project.model.*;
import lapr.project.registos.*;

/**
 *
 * @author Ricardo Osorio
 */
public class AvaliarCandidaturaAExposicaoController {

    private CentroExposicoes centroExposicoesAtual;
    private final String usernameFAE;
    private RegistoExposicoes re;
    private Exposicao exposicaoSelecionada;
    private RegistoAtribuicoes ra;
    private AtribuicoesCandidatura atribuicaoEscolhida;
    private Avaliacao avaliacaoDoFae;
    private RegistoFaeAvaliacao rFaeAvalicao;

    public AvaliarCandidaturaAExposicaoController(CentroExposicoes centroExposicoes, String usernameFAE) {
        this.centroExposicoesAtual = centroExposicoes;
        this.usernameFAE = usernameFAE;
    }

    public void getRegistoExposicoes() {
        this.re = this.centroExposicoesAtual.getRegistoExposicoes();
    }

    public ArrayList<Exposicao> getListaExposicoesEstadoCandidaturasAtribuidasDoFAE() {
        return this.re.getListaExposicoesEstadoCandidaturasAtribuidasDoFAE(this.usernameFAE);
    }

    public void setExposicao(Exposicao exposicao) {
        this.exposicaoSelecionada = exposicao;
    }

    public void getRegistoAtribuicoes() {
        this.ra = this.exposicaoSelecionada.getRegistoAtribuicoes();
    }

    public ArrayList<AtribuicoesCandidatura> getListaAtribuicoesComOFAE() {
        return this.ra.getListaAtribuicoesComOFAE(this.usernameFAE);
    }

    public void getRegistoFaeAvalicao() {
        this.rFaeAvalicao = this.atribuicaoEscolhida.getRegistoFaeAvaliacao();
    }

    public void setAtribuicao(AtribuicoesCandidatura atribuicao) {
        this.atribuicaoEscolhida = atribuicao;
    }

    public String getDadosCandidaturaNomeEmpresa() {
        return this.atribuicaoEscolhida.getCandidaturaAssociada().getM_StrNomeEmpresa();
    }

    public String getDadosCandidaturaMoradaEmpresa() {
        return this.atribuicaoEscolhida.getCandidaturaAssociada().getM_StrMoradaEmpresa();
    }

    public int getDadosCandidaturaTelemovel() {
        return this.atribuicaoEscolhida.getCandidaturaAssociada().getM_intTelemovel();
    }

    public int getDadosCandidaturaArea() {
        return this.atribuicaoEscolhida.getCandidaturaAssociada().getM_intArea();
    }

    public int getDadosCandidaturaNumConvites() {
        return this.atribuicaoEscolhida.getCandidaturaAssociada().getM_intNumConvites();
    }

    public void getAvaliacaoDoFae() {
        this.avaliacaoDoFae = this.atribuicaoEscolhida.getRegistoFaeAvaliacao().getAvaliacaoDoFae(this.usernameFAE);
    }

    public boolean verificaAvalicaoJaTomada() {
        return this.avaliacaoDoFae.verificaAvaliacaoJaTomada();
    }

    public boolean getAvaliacao() {
        return this.avaliacaoDoFae.getAvaliacao();
    }

    public String getJustificacao() {
        return this.avaliacaoDoFae.getJustificacao();
    }

    public int getRatingConhecimentoSobreTema() {
        return this.avaliacaoDoFae.getRatingConhecimentoSobreOTema();
    }

    public int getRatingAdequacaoAExposicao() {
        return this.avaliacaoDoFae.getRatingAdequacaoAExposicao();
    }

    public int getRatingAdequacaoAsDemos() {
        return this.avaliacaoDoFae.getRatingAdequacaoAsDemos();
    }

    public int getRatingAdequacaoNumConvites() {
        return this.avaliacaoDoFae.getRatingAdequacaoNumConvites();
    }

    public int getRatingRecomendacaoGlobal() {
        return this.avaliacaoDoFae.getRatingRecomendacaoGlobal();
    }

    public void setAvalicao(boolean avaliacao, String justificacao, int ratingConhecimentoSobreTema, int ratingAdequacaoAExposicao, int ratingAdequacaoAsDemos, int ratingAdequacaoNumConvites, int ratingRecomendacaoGlobal) {
        this.avaliacaoDoFae.setAvalicao(avaliacao, justificacao, ratingConhecimentoSobreTema, ratingAdequacaoAExposicao, ratingAdequacaoAsDemos, ratingAdequacaoNumConvites, ratingRecomendacaoGlobal);
    }

}
