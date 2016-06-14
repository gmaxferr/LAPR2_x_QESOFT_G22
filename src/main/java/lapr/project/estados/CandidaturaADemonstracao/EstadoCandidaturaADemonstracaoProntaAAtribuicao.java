package lapr.project.estados.CandidaturaADemonstracao;

import lapr.project.model.CandidaturaADemonstracao;

/**
 *
 * @author guilherme
 */
public class EstadoCandidaturaADemonstracaoProntaAAtribuicao extends EstadoCandidaturaADemonstracao {

    public EstadoCandidaturaADemonstracaoProntaAAtribuicao(CandidaturaADemonstracao cand) {
        super(cand);
    }

    @Override
    public boolean setEstadoCandidaturaADemonstracaoAtribuida() {
        EstadoCandidaturaADemonstracao ne = new EstadoCandidaturaADemonstracaoAtribuida(m_cand);
        m_cand.setEstado(ne);
        return true;
    }

    @Override
    public boolean isEstadoCandidaturaADemonstracaoProntaAAtribuicao() {
        return true;
    }
}
