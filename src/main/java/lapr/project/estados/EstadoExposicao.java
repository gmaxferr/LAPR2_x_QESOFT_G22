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

}
