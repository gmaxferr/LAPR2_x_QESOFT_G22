package lapr.project.estados.CandidaturaADemonstracao;

import lapr.project.model.CandidaturaADemonstracao;

/**
 *
 * @author guima
 */
public class EstadoCandidaturaADemonstracaoInstanciada extends  EstadoCandidaturaADemonstracao {

    public EstadoCandidaturaADemonstracaoInstanciada(CandidaturaADemonstracao cand){
        super(cand);
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
