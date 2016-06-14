package lapr.project.estados.CandidaturaADemonstracao;

import lapr.project.model.CandidaturaADemonstracao;

/**
 *
 * @author guilherme
 */
public class EstadoCandidaturaADemonstracaoInstanciada extends EstadoCandidaturaADemonstracao {

    public EstadoCandidaturaADemonstracaoInstanciada(CandidaturaADemonstracao cand) {
        super(cand);
    }

    @Override
    public boolean setEstadoCandidaturaADemonstracaoCriada() {
        EstadoCandidaturaADemonstracao ne = new EstadoCandidaturaADemonstracaoCriada(m_cand);
        m_cand.setEstado(ne);
        return true;
    }

    public boolean isEstadoCandidaturaADemonstracaoInstanciada() {
        return true;
    }
}
