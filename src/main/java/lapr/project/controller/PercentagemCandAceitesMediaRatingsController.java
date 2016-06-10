package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.registos.RegistoAtribuicoes;
import lapr.project.registos.RegistoCandidaturasAExposicao;
import lapr.project.registos.RegistoExposicoes;

/**
 *
 * @author Ricardo Osorio
 */
public class PercentagemCandAceitesMediaRatingsController {

    private final CentroExposicoes centroExposicoes;
    private RegistoExposicoes re;
    private Exposicao exposicaoSelecionada;
    private RegistoCandidaturasAExposicao rc;
    private RegistoAtribuicoes rAtrib;

    public PercentagemCandAceitesMediaRatingsController(CentroExposicoes ce) {
        this.centroExposicoes = ce;
    }

    public void getRegistoExposicoes() {
        this.re = this.centroExposicoes.getRegistoExposicoes();
    }

    public List<Exposicao> getListaExposicoesEstadoDecididas() {
        return this.re.getListaExposicoesEstadoCandidaturasDecididas();
    }

    public void setExposicaoSelecionada(Exposicao e) {
        this.exposicaoSelecionada = e;
    }

    public void getRegistoCandidaturas() {
        this.rc = this.exposicaoSelecionada.getRegistoCandidaturasAExposicao();
    }

    public List<CandidaturaAExposicao> getListaCandidaturas() {
        return this.rc.getListaCandidaturas();
    }

    public float getPercentagemCandidaturasAceites() {
        return this.rc.getPercentagemCandidaturasAceites();
    }

    public void getRegistoAtribuicoes() {
        this.rAtrib = this.exposicaoSelecionada.getRegistoAtribuicoes();
    }

    public float[] getMediaRatingsTodasCandidaturas() {
        return this.rAtrib.getMediaRatingsTodasCandidaturas();
    }
}
