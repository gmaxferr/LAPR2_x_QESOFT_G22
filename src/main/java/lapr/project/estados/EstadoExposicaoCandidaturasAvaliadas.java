package lapr.project.estados;

import lapr.project.model.CandidaturaAExposicao;
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
        if (valida()) {
            this.m_exposicao.setEstado(new EstadoExposicaoCandidaturasDecididas(this.m_exposicao));
            return true;
        }
        return false;
    }

    /**
     * @return Retorna TRUE se for possível passar para o estado de Candidaturas
     * decididas e FALSE caso contrário
     */
    public boolean valida() {
        for (CandidaturaAExposicao c : this.m_exposicao.getRegistoCandidaturasAExposicao().getListaCandidaturas()) {
            if (!c.getEstado().isEstadoCandidaturaAceite() && !c.getEstado().isEstadoCandidaturaRejeitada()) {
                return false;
            }
        }
        return true;
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
