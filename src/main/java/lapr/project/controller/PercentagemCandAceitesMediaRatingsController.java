package lapr.project.controller;

import java.util.List;
import lapr.project.model.*;
import lapr.project.registos.*;

/**
 *
 * @author G29
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

    public float getPercentagemCandidaturasAceitesDoExpositor(String emailExpositor) {
        return this.rc.getPercentagemCandidaturasAceites(emailExpositor);
    }

    public void getRegistoAtribuicoes() {
        this.rAtrib = this.exposicaoSelecionada.getRegistoAtribuicoes();
    }

    public float[] getMediaRatingsTodasCandidaturas() {
        return this.rAtrib.getMediaRatingsTodasCandidaturas();
    }
}
