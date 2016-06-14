package lapr.project.estados.Exposicao;

import lapr.project.estados.Estado;
import lapr.project.model.Exposicao;

/**
 *
 * @author Ricardo Osório e Ana Leite
 */
public abstract class EstadoExposicao implements Estado {

    final Exposicao m_exposicao;

    public EstadoExposicao(Exposicao exposicao) {
        this.m_exposicao = exposicao;
    }
    
    public boolean setEstadoCriada() {
        return false;
    }

    public boolean setEstadoFAEDefinidosSemDemos() {
        return false;
    }

    public boolean setEstadoDemosDefinidasSemFAE() {
        return false;
    }

    public boolean setEstadoCompleta() {
        return false;
    }

    public boolean setEstadoCandidaturasAbertas() {
        return false;
    }

    public boolean setEstadoCandidaturasFechadas() {
        return false;
    }

    public boolean setEstadoConflitosDetetados() {
        return false;
    }

    public boolean setEstadoConflitosAlterados() {
        return false;
    }

    public boolean setEstadoCandidaturasAtribuidas() {
        return false;
    }

    public boolean setEstadoCandidaturasAvaliadas() {
        return false;
    }

    public boolean setEstadoCandidaturasDecididas() {
        return false;
    }

    public boolean setEstadoStandsAtribuidos() {
        return false;
    }

    public boolean setEstadoDemonstracoesDecididas() {
        return false;
    }

    public boolean setEstadoCandidaturasDemonstracaoAbertas() {
        return false;
    }

    public boolean setEstadoCandidaturasDemonstracaoFechadas() {
        return false;
    }

    public boolean isEstadoInicial() {
        return false;
    }

    public boolean isEstadoCriada() {
        return false;
    }

    public boolean isEstadoFAEDefinidosSemDemos() {
        return false;
    }

    public boolean isEstadoDemosDefinidasSemFAE() {
        return false;
    }

    public boolean isEstadoCompleta() {
        return false;
    }

    public boolean isEstadoCandidaturasAbertas() {
        return false;
    }

    public boolean isEstadoCandidaturasFechadas() {
        return false;
    }

    public boolean isEstadoConflitosDetetados() {
        return false;
    }

    public boolean isEstadoConflitosAlterados() {
        return false;
    }

    public boolean isEstadoCandidaturasAtribuidas() {
        return false;
    }

    public boolean isEstadoCandidaturasAvaliadas() {
        return false;
    }

    public boolean isEstadoCandidaturasDecididas() {
        return false;
    }

    public boolean isEstadoStandsAtribuidos() {
        return false;
    }

    public boolean isEstadoDemonstracoesDecididas() {
        return false;
    }

    public boolean isEstadoCandidaturasDemonstracaoAbertas() {
        return false;
    }

    public boolean isEstadoCandidaturasDemonstracaoFechadas() {
        return false;
    }

}
