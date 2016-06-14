package lapr.project.estados.CandidaturaADemonstracao;

import lapr.project.model.CandidaturaADemonstracao;

/**
 *
 * @author guima
 */
public class EstadoCandidaturaADemonstracaoInstanciada extends  EstadoCandidaturaADemonstracao {

<<<<<<< HEAD
    CandidaturaADemonstracao m_cand;

    public EstadoCandidaturaADemonstracaoInstanciada(CandidaturaADemonstracao c) {
        m_cand = c;
=======
    public EstadoCandidaturaADemonstracaoInstanciada(CandidaturaADemonstracao cand){
        super(cand);
>>>>>>> 38cedc43da7d43e3e5342cc9e1874a1488891bbe
    }

    @Override
<<<<<<< HEAD
    public boolean setEstadoCandidaturaADemonstracaoInstanciada() {
        return false;
=======
    public boolean setEstadoCandidaturaInstanciada() {
        return true;
>>>>>>> 38cedc43da7d43e3e5342cc9e1874a1488891bbe
    }

    @Override
    public boolean setEstadoCandidaturaADemonstracaoCriada() {
        EstadoCandidaturaADemonstracao ne = new EstadoCandidaturaADemonstracaoCriada(m_cand);
        m_cand.setEstado(ne);
        return true;
    }

<<<<<<< HEAD
    @Override
    public boolean setEstadoCandidaturaADemonstracaoAtribuida() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturaADemonstracaoAvaliada() {
        return false;
    }

=======
>>>>>>> 38cedc43da7d43e3e5342cc9e1874a1488891bbe
    @Override
    public boolean isEstadoCandidaturaADemonstracaoInstanciada() {
        return true;
    }

<<<<<<< HEAD
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
        return false;
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

=======
>>>>>>> 38cedc43da7d43e3e5342cc9e1874a1488891bbe
}
