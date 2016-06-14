package lapr.project.estados.CandidaturaADemonstracao;

import lapr.project.model.CandidaturaADemonstracao;

/**
 *
 * @author guima
 */
public class EstadoCandidaturaADemonstracaoCriada extends EstadoCandidaturaADemonstracao {

    CandidaturaADemonstracao m_cand;

    public EstadoCandidaturaADemonstracaoCriada(CandidaturaADemonstracao cand) {
        this.m_cand = cand;
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
    public boolean isEstadoCandidaturaCriada() {
        return true;
    }

    private boolean valida() {
        //valida se tem as coisas todas necessárias para passar ao próximo estado (verificação de atributos)
        return true;
    }
}
