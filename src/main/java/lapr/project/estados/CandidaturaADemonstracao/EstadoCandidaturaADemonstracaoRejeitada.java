package lapr.project.estados.CandidaturaADemonstracao;

import lapr.project.model.CandidaturaADemonstracao;

/**
 *
 * @author guilherme
 */
public class EstadoCandidaturaADemonstracaoRejeitada implements EstadoCandidaturaADemonstracao {

    private CandidaturaADemonstracao m_cand;

    public EstadoCandidaturaADemonstracaoRejeitada(CandidaturaADemonstracao cand) {
        this.m_cand = cand;
    }

    @Override
    public boolean setEstadoCandidaturaADemonstracaoInstanciada() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturaADemonstracaoCriada() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturaADemonstracaoAtribuida() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturaADemonstracaoAvaliada() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturaADemonstracaoInstanciada() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturaADemonstracaoCriada() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturaADemonstracaoAtribuida() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturaADemonstracaoAvaliada() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturaADemonstracaoAceite() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturaADemonstracaoRecusada() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturaADemonstracaoProntaAAtribuicao() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturaADemonstracaoAceite() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturaADemonstracaoRecusada() {
        return true;
    }

    @Override
    public boolean isEstadoCandidaturaADemonstracaoProntaAAtribuicao() {
        return false;
    }

        @Override
    public boolean setEstadoCandidaturaADemonstracaoRemovida() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturaADemonstracaoRemovida() {
        return false;
    }

}
