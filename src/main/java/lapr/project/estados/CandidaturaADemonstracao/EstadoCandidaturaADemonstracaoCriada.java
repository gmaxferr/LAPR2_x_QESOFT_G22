package lapr.project.estados.CandidaturaADemonstracao;

import lapr.project.model.CandidaturaADemonstracao;

/**
 *
 * @author guima
 */
public class EstadoCandidaturaADemonstracaoCriada implements EstadoCandidaturaADemonstracao{

    CandidaturaADemonstracao m_cand;
    
    public EstadoCandidaturaADemonstracaoCriada(CandidaturaADemonstracao cand) {
        this.m_cand = cand;
    }


    @Override
    public boolean setEstadoCandidaturaInstanciada() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturaCriada() {
        return false;
    }

     @Override
    public boolean setEstadoCandidaturaAtribuida() {
        m_cand.setEstado(new EstadoCandidaturaADemonstracaoAtribuida(m_cand));
        return true;
    }
    
    @Override
    public boolean isEstadoCandidaturaInstanciada() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturaCriada() {
        return true;
    }

    @Override
    public boolean isEstadoCandidaturaAtribuida() {
        return false;
    }
    
}
