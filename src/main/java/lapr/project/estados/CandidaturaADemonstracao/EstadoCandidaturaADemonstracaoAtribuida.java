package lapr.project.estados.CandidaturaADemonstracao;

import lapr.project.model.CandidaturaADemonstracao;

/**
 *
 * @author Ana Leite
 */
public class EstadoCandidaturaADemonstracaoAtribuida implements EstadoCandidaturaADemonstracao {

    CandidaturaADemonstracao m_cand;

    public EstadoCandidaturaADemonstracaoAtribuida(CandidaturaADemonstracao c) {
        m_cand = c;
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
        EstadoCandidaturaADemonstracao ne = new EstadoCandidaturaADemonstracaoAvaliada(m_cand);
        m_cand.setEstado(ne);
        return true;
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
        return true;
    }

    @Override
    public boolean isEstadoCandidaturaADemonstracaoAvaliada() {
        return true;
    }

    @Override
    public boolean isEstadoCandidaturaADemonstracaoAceite() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturaADemonstracaoRecusada() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturaADemonstracaoProntaAAtribuicao() {
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
    public boolean setEstadoCandidaturaADemonstracaoRemovida() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturaADemonstracaoRemovida() {
        return false;
    }

}
