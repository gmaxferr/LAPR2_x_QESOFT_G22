package lapr.project.estados.CandidaturaADemonstracao;

import lapr.project.model.CandidaturaADemonstracao;

/**
 *
 * @author Ana Leite
 */
public class EstadoCandidaturaADemonstracaoAtribuida extends EstadoCandidaturaADemonstracao {


    public EstadoCandidaturaADemonstracaoAtribuida(CandidaturaADemonstracao cand) {
        super(cand);
    }

    @Override
    public boolean setEstadoCandidaturaAtribuida() {
        return true;
    }

    @Override
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
    }
}
