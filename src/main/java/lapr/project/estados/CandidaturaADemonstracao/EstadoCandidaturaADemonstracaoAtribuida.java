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
    public boolean setEstadoCandidaturaADemonstracaoAvaliada() {
        EstadoCandidaturaADemonstracao ne = new EstadoCandidaturaADemonstracaoAvaliada(m_cand);
        m_cand.setEstado(ne);
        return true;
    }

    @Override
    public boolean isEstadoCandidaturaADemonstracaoAtribuida() {
        return true;
    }
}
