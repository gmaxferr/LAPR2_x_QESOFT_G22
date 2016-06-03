package lapr.project.estados;

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

}
