package lapr.project.estados.CandidaturaADemonstracao;

import lapr.project.model.CandidaturaADemonstracao;

/**
 * Represnetação do EstadoCandidaturaADemonstracaoCriada
 * 
 * @author G29
 */
public class EstadoCandidaturaADemonstracaoCriada extends EstadoCandidaturaADemonstracao {

    public EstadoCandidaturaADemonstracaoCriada(CandidaturaADemonstracao cand) {
        super(cand);
    }

    @Override
    public boolean isEstadoCandidaturaADemonstracaoCriada() {
        return true;
    }

    @Override
    public boolean setEstadoCandidaturaADemonstracaoProntaAAtribuicao() {
        EstadoCandidaturaADemonstracao ne = new EstadoCandidaturaADemonstracaoProntaAAtribuicao(m_cand);
        m_cand.setEstado(ne);
        return true;
    }

    @Override
    public boolean setEstadoCandidaturaADemonstracaoRemovida() {
        EstadoCandidaturaADemonstracao ne = new EstadoCandidaturaADemonstracaoRemovida(m_cand);
        m_cand.setEstado(ne);
        return true;
    }
}
