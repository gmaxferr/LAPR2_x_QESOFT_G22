package lapr.project.estados.CandidaturaADemonstracao;

import lapr.project.model.CandidaturaADemonstracao;

/**
 *
 * @author guima
 */
public class EstadoCandidaturaADemonstracaoInstanciada extends  EstadoCandidaturaADemonstracao {

    CandidaturaADemonstracao m_cand;
    
    public EstadoCandidaturaADemonstracaoInstanciada(CandidaturaADemonstracao c){
        m_cand = c;
    }
    
    @Override
    public boolean setEstadoCandidaturaInstanciada() {
        return true;
    }

    @Override
    public boolean setEstadoCandidaturaCriada() {
        m_cand.setEstado(new EstadoCandidaturaADemonstracaoCriada(m_cand));
        return true;
    }

    @Override
    public boolean isEstadoCandidaturaInstanciada() {
        return true;
    }

}
