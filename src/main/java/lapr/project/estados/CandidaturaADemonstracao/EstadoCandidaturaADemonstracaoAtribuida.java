package lapr.project.estados.CandidaturaADemonstracao;

import lapr.project.model.CandidaturaADemonstracao;

/**
 *
 * @author Ana Leite
 */
public class EstadoCandidaturaADemonstracaoAtribuida extends EstadoCandidaturaADemonstracao {

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
=======

    public EstadoCandidaturaADemonstracaoAtribuida(CandidaturaADemonstracao cand) {
        super(cand);
    }

    @Override
    public boolean setEstadoCandidaturaAtribuida() {
>>>>>>> 38cedc43da7d43e3e5342cc9e1874a1488891bbe
        return true;
    }

    @Override
<<<<<<< HEAD
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
=======
    public boolean setEstadoCandidaturaAvaliada() {
        if (valida()) {
            m_cand.setEstado(new EstadoCandidaturaADemonstracaoAvaliada(m_cand));
            return true;
        } else {
            return false;
        }
    }

    private boolean valida() {
        //valida se tem as coisas todas necessárias para passar ao próximo estado (verificação de atributos)
        return true;
    }

    @Override
    public boolean isEstadoCandidaturaAtribuida() {
        return true;
>>>>>>> 38cedc43da7d43e3e5342cc9e1874a1488891bbe
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
