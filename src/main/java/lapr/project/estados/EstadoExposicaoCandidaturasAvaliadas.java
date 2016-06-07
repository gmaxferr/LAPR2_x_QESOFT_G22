package lapr.project.estados;

import lapr.project.model.Exposicao;


/**
 *
 * @author Ana Leite
 */
public class EstadoExposicaoCandidaturasAvaliadas implements EstadoExposicao {

    private Exposicao m_exposicao;

    public EstadoExposicaoCandidaturasAvaliadas(Exposicao exposicao) {
        this.m_exposicao = exposicao;
    }

    @Override
    public boolean setEstadoCriada() {
        return false;
    }

    @Override
    public boolean setEstadoFAEDefinidosSemDemos() {
        return false;
    }

    @Override
    public boolean setEstadoDemosDefinidasSemFAE() {
        return false;
    }

    @Override
    public boolean setEstadoCompleta() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturasAbertas() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturasFechadas() {
        return false;
    }

    @Override
    public boolean setEstadoConflitosDetetados() {
        return false;
    }

    @Override
    public boolean setEstadoConflitosAlterados() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturasAtribuidas() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturasAvaliadas() {
        return false;
    }
    @Override
    public boolean isEstadoCriada() {
        return false;
    }

    @Override
    public boolean isEstadoFAEDefinidosSemDemos() {
         return false;
    }

    @Override
    public boolean isEstadoDemosDefinidasSemFAE() {
         return false;
    }

    @Override
    public boolean isEstadoCompleta() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturasAbertas() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturasFechadas() {
         return false;
    }

    @Override
    public boolean isEstadoConflitosDetetados() {
         return false;
    }

    @Override
    public boolean isEstadoConflitosAlterados() {
         return false;
    }

    @Override
    public boolean isEstadoCandidaturasAtribuidas() {
         return true;
    }

    @Override
    public boolean isEstadoCandidaturasAvaliadas() {
         return false;
    }

}
