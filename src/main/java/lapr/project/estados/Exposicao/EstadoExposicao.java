package lapr.project.estados.Exposicao;

import lapr.project.estados.Estado;

/**
 *
 * @author Ricardo Osório e Ana Leite
 */
public interface EstadoExposicao extends Estado{

    boolean setEstadoCriada();

    boolean setEstadoFAEDefinidosSemDemos();

    boolean setEstadoDemosDefinidasSemFAE();

    boolean setEstadoCompleta();

    boolean setEstadoCandidaturasAbertas();

    boolean setEstadoCandidaturasFechadas();

    boolean setEstadoConflitosDetetados();

    boolean setEstadoConflitosAlterados();

    boolean setEstadoCandidaturasAtribuidas();

    boolean setEstadoCandidaturasAvaliadas();
    
    boolean setEstadoCandidaturasDecididas();
    
    boolean setEstadoStandsAtribuidos();
    
    boolean setEstadoDemonstracoesDecididas();
    
    boolean setEstadoCandidaturasDemonstracaoAbertas();
    
    boolean setEstadoCandidaturasDemonstracaoFechadas();
    
    boolean isEstadoCriada();

    boolean isEstadoFAEDefinidosSemDemos();

    boolean isEstadoDemosDefinidasSemFAE();

    boolean isEstadoCompleta();

    boolean isEstadoCandidaturasAbertas();

    boolean isEstadoCandidaturasFechadas();

    boolean isEstadoConflitosDetetados();

    boolean isEstadoConflitosAlterados();

    boolean isEstadoCandidaturasAtribuidas();

    boolean isEstadoCandidaturasAvaliadas();

    boolean isEstadoCandidaturasDecididas();
    
    boolean isEstadoStandsAtribuidos();
    
    boolean isEstadoDemonstracoesDecididas();
    
    boolean isEstadoCandidaturasDemonstracaoAbertas();
    
    boolean isEstadoCandidaturasDemonstracaoFechadas();
    
}
