package lapr.project.estados.CandidaturaADemonstracao;

import lapr.project.model.CandidaturaADemonstracao;

/**
 *
 * @author guima
 */
public class EstadoCandidaturaADemonstracaoInstanciada implements EstadoCandidaturaADemonstracao {

    CandidaturaADemonstracao m_cand;
    
    public EstadoCandidaturaADemonstracaoInstanciada(CandidaturaADemonstracao c){
        m_cand = c;
    }
    
    @Override
    public boolean setEstadoCandidaturaInstanciada() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturaCriada() {
        m_cand.setEstado(new EstadoCandidaturaADemonstracaoCriada(m_cand));
        return true;
    }

     @Override
    public boolean setEstadoCandidaturaAtribuida() {
        return false;
    }
    
    @Override
    public boolean isEstadoCandidaturaInstanciada() {
        return true;
    }

    @Override
    public boolean isEstadoCandidaturaCriada() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturaAtribuida() {
        return false;
    }
}
