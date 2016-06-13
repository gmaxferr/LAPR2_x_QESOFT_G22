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
        return false;
    }

    @Override
    public boolean setEstadoCandidaturaCriada() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturaAtribuida() {
        return false;
    }
    
     @Override
    public boolean setEstadoCandidaturaAvaliada() {
        if (valida()){
            m_cand.setEstado(new EstadoCandidaturaADemonstracaoAvaliada(m_cand));
        return true;
        } else return false;
    }

    @Override
    public boolean isEstadoCandidaturaInstanciada() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturaCriada() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturaAtribuida() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturaAvaliada() {
        return true;
    }

    private boolean valida() {
        //valida se tem as coisas todas necessárias para passar ao próximo estado (verificação de atributos)
        return true;
    }
}
