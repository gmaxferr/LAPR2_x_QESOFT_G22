package lapr.project.estados.CandidaturaADemonstracao;

import lapr.project.estados.Estado;

/**
 *
 * @author guima
 */
public interface EstadoCandidaturaADemonstracao extends Estado{

    boolean setEstadoCandidaturaADemonstracaoInstanciada();

    boolean setEstadoCandidaturaADemonstracaoCriada();
    
    boolean setEstadoCandidaturaADemonstracaoAtribuida();
    
    boolean setEstadoCandidaturaADemonstracaoAvaliada();
    
    boolean setEstadoCandidaturaADemonstracaoAceite();
    
    boolean setEstadoCandidaturaADemonstracaoRecusada();
    
    boolean setEstadoCandidaturaADemonstracaoProntaAAtribuicao();

    boolean setEstadoCandidaturaADemonstracaoRemovida();
    
    boolean isEstadoCandidaturaADemonstracaoInstanciada();
    
    boolean isEstadoCandidaturaADemonstracaoCriada();
    
    boolean isEstadoCandidaturaADemonstracaoAtribuida();
    
    boolean isEstadoCandidaturaADemonstracaoAvaliada();
    
    boolean isEstadoCandidaturaADemonstracaoAceite();
    
    boolean isEstadoCandidaturaADemonstracaoRecusada();
    
    boolean isEstadoCandidaturaADemonstracaoProntaAAtribuicao();
    
    boolean isEstadoCandidaturaADemonstracaoRemovida();
    

}
