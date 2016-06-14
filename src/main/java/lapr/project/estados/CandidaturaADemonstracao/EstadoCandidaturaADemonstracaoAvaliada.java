package lapr.project.estados.CandidaturaADemonstracao;

import lapr.project.model.CandidaturaADemonstracao;

/**
 *
 * @author Ana Leite
 */
public class EstadoCandidaturaADemonstracaoAvaliada extends EstadoCandidaturaADemonstracao {

    public EstadoCandidaturaADemonstracaoAvaliada(CandidaturaADemonstracao cand) {
        super(cand);
    }

    @Override
    public boolean isEstadoCandidaturaADemonstracaoAvaliada() {
        return true;
    }

    @Override
    public boolean setEstadoCandidaturaADemonstracaoAceite() {
        EstadoCandidaturaADemonstracao ne = new EstadoCandidaturaADemonstracaoAceite(m_cand);
        m_cand.setEstado(ne);
        return true;
    }

    @Override
    public boolean setEstadoCandidaturaADemonstracaoRecusada() {
        EstadoCandidaturaADemonstracaoRecusada ne = new EstadoCandidaturaADemonstracaoRecusada(m_cand);
        m_cand.setEstado(ne);
        return true;
    }
}
