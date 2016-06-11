package lapr.project.estados.CandidaturaADemonstracao;

import lapr.project.model.CandidaturaADemonstracao;

/**
 *
 * @author Ana Leite
 */
public class EstadoCandidaturaADemonstracaoAtribuida implements EstadoCandidaturaADemonstracao {

    CandidaturaADemonstracao m_cand;
    
    public EstadoCandidaturaADemonstracaoAtribuida(CandidaturaADemonstracao c){
        m_cand = c;
    }
    
    @Override
    public boolean setEstadoCandidaturaInstanciada() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean setEstadoCandidaturaCriada() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean setEstadoCandidaturaAtribuida() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEstadoCandidaturaInstanciada() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEstadoCandidaturaCriada() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEstadoCandidaturaAtribuida() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
