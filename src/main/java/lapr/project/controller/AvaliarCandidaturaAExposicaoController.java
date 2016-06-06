package lapr.project.controller;

import java.util.ArrayList;
import lapr.project.model.AtribuicoesCandidatura;
import lapr.project.model.Avaliacao;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.registos.RegistoAtribuicoes;
import lapr.project.registos.RegistoExposicoes;

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

    public Avaliacao getAvaliacaoDoFae() {
        this.avaliacaoDoFae = this.atribuicaoEscolhida.getRegistoFaeAvaliacao().getAvaliacaoDoFae(this.usernameFAE);
    return this.avaliacaoDoFae;
    }

    public boolean verificaAvalicaoJaTomada() {
        return this.avaliacaoDoFae.verificaAvaliacaoJaTomada();
    }

}
