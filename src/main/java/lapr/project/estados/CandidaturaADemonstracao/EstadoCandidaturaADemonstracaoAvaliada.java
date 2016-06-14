package lapr.project.estados.CandidaturaADemonstracao;

import lapr.project.model.CandidaturaADemonstracao;

/**
 *
 * @author Ana Leite
 */
<<<<<<< HEAD
public class EstadoCandidaturaADemonstracaoAvaliada implements EstadoCandidaturaADemonstracao {

    CandidaturaADemonstracao m_cand;

    public EstadoCandidaturaADemonstracaoAvaliada(CandidaturaADemonstracao c) {
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
        EstadoCandidaturaADemonstracao ne = new EstadoCandidaturaADemonstracaoAceite(m_cand);
        m_cand.setEstado(ne);
        return true;
    }

    @Override
    public boolean setEstadoCandidaturaADemonstracaoRecusada() {
        EstadoCandidaturaADemonstracao ne = new EstadoCandidaturaADemonstracaoRejeitada(m_cand);
        m_cand.setEstado(ne);
        return true;
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
=======
public class EstadoCandidaturaADemonstracaoAvaliada extends EstadoCandidaturaADemonstracao {

    public EstadoCandidaturaADemonstracaoAvaliada(CandidaturaADemonstracao cand) {
        super(cand);
    }

    @Override
    public boolean setEstadoCandidaturaAvaliada() {
        return true;
    }

    @Override
    public boolean isEstadoCandidaturaAvaliada() {
        return true;
>>>>>>> 38cedc43da7d43e3e5342cc9e1874a1488891bbe
    }

}
