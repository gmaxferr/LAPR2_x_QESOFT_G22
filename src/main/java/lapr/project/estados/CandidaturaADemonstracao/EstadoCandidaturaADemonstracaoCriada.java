package lapr.project.estados.CandidaturaADemonstracao;

import lapr.project.model.CandidaturaADemonstracao;

/**
 *
 * @author guima
 */
<<<<<<< HEAD
public class EstadoCandidaturaADemonstracaoCriada implements EstadoCandidaturaADemonstracao {

    CandidaturaADemonstracao m_cand;

    public EstadoCandidaturaADemonstracaoCriada(CandidaturaADemonstracao cand) {
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
        return true;
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
    public boolean setEstadoCandidaturaADemonstracaoRecusada() {
        return false;
=======
public class EstadoCandidaturaADemonstracaoCriada extends EstadoCandidaturaADemonstracao {

    public EstadoCandidaturaADemonstracaoCriada(CandidaturaADemonstracao cand) {
        super(cand);
    }

    @Override
    public boolean setEstadoCandidaturaCriada() {
        return true;
    }

    @Override
    public boolean setEstadoCandidaturaAtribuida() {
        if (valida()) {
            m_cand.setEstado(new EstadoCandidaturaADemonstracaoAtribuida(m_cand));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean setEstadoCandidaturaADemonstracaoProntaAAtribuicao() {
        EstadoCandidaturaADemonstracao ne = new EstadoCandidaturaADemonstracaoProntaAAtribuicao(m_cand);
        m_cand.setEstado(ne);
        return true;
    }

<<<<<<< HEAD
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
    public boolean setEstadoCandidaturaADemonstracaoRemovida() {
        EstadoCandidaturaADemonstracao ne = new EstadoCandidaturaADemonstracaoRemovida(m_cand);
        m_cand.setEstado(ne);
=======
    private boolean valida() {
        //valida se tem as coisas todas necessárias para passar ao próximo estado (verificação de atributos)
        return true;
    }

    @Override
    public boolean isEstadoCandidaturaADemonstracaoRemovida() {
        return false;
    }

}
