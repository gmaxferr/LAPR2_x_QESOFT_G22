package lapr.project.estados.CandidaturaADemonstracao;

import lapr.project.estados.Estado;
import lapr.project.model.CandidaturaADemonstracao;

/**
 *
 * @author guima
 */
public abstract class EstadoCandidaturaADemonstracao implements Estado {

    final CandidaturaADemonstracao m_cand;

    public EstadoCandidaturaADemonstracao(CandidaturaADemonstracao cand) {
        this.m_cand = cand;
    }

    public boolean setEstadoCandidaturaADemonstracaoInstanciada() {
        return false;
    }

    public boolean setEstadoCandidaturaADemonstracaoCriada() {
        return false;
    }

    public boolean setEstadoCandidaturaADemonstracaoAtribuida() {
        return false;
    }

    public boolean setEstadoCandidaturaADemonstracaoAvaliada() {
        return false;
    }

    public boolean isEstadoCandidaturaADemonstracaoInstanciada() {
        return false;
    }

    public boolean isEstadoCandidaturaADemonstracaoCriada() {
        return false;
    }

    public boolean isEstadoCandidaturaADemonstracaoAtribuida() {
        return false;
    }

    public boolean isEstadoCandidaturaADemonstracaoAvaliada() {
        return false;
    }

    public boolean isEstadoCandidaturaADemonstracaoRemovida() {
        return false;
    }

    public boolean isEstadoCandidaturaADemonstracaoAceite() {
        return false;
    }

    public boolean isEstadoCandidaturaADemonstracaoRecusada() {
        return false;
    }

    public boolean setEstadoCandidaturaADemonstracaoRemovida() {
        return false;
    }
    
    public boolean setEstadoCandidaturaADemonstracaoProntaAAtribuicao() {
        return false;
    }

    public boolean isEstadoCandidaturaADemonstracaoProntaAAtribuicao() {
        return false;
    }

    public boolean setEstadoCandidaturaADemonstracaoAceite() {
        return false;
    }

    public boolean setEstadoCandidaturaADemonstracaoRecusada() {
        return false;
    }
}
