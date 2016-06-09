package lapr.project.estados.Exposicao;

import lapr.project.model.Exposicao;

/**
 *
 * @author Ana Leite RicardoOsório
 */
public class EstadoExposicaoCriada implements EstadoExposicao {

    private Exposicao m_exposicao;

    public EstadoExposicaoCriada(Exposicao exposicao) {
        this.m_exposicao = exposicao;
    }

    @Override
    public boolean setEstadoCriada() {
        return false;
    }

    @Override
    public boolean setEstadoFAEDefinidosSemDemos() {
        if (valida()) {
            this.m_exposicao.setEstado(new EstadoExposicaoFAEDefinidosSemDemos(this.m_exposicao));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean setEstadoDemosDefinidasSemFAE() {
        if (valida()) {
            this.m_exposicao.setEstado(new EstadoExposicaoDemosDefinidasSemFAE(this.m_exposicao));
            return true;
        } else {
            return false;
        }
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
        return true;
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
    public boolean setEstadoStandsAtribuidos() {
        return false;
    }

    @Override
    public boolean setEstadoDemonstracoesDecididas() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturasDemonstracaoAbertas() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturasDemonstracaoFechadas() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturasDecididas() {
        return false;
    }

    private boolean valida() {
        //valida se tem as coisas todas necessárias para passar ao próximo estado (verificação de atributos)
        return true;
    }

    @Override
    public boolean isEstadoCriada() {
        return true;
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
        return false;
    }

    @Override
    public boolean isEstadoCandidaturasAvaliadas() {
        return false;
    }

    @Override
    public boolean isEstadoStandsAtribuidos() {
        return false;
    }

    @Override
    public boolean isEstadoDemonstracoesDecididas() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturasDemonstracaoAbertas() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturasDemonstracaoFechadas() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturasDecididas() {
        return false;
    }

}
