package lapr.project.estados.Exposicao;

import lapr.project.model.Exposicao;

/**
 *
 * @author Ricardo Catalao
 */
public class EstadoExposicaoCandidaturasDecididas extends EstadoExposicao {

    private final Exposicao m_exposicao;

    public EstadoExposicaoCandidaturasDecididas(Exposicao exposicao) {
        this.m_exposicao = exposicao;
        m_exposicao.getKeywordRanking().setReady();
    }

    @Override
    public boolean setEstadoCandidaturasDecididas() {
        return true;
    }

    @Override
    public boolean setEstadoStandsAtribuidos() {
        if (valida()) {
            this.m_exposicao.setEstado(new EstadoExposicaoStandsAtribuidos(m_exposicao));
            return true;
        }
        return false;
    }

    public boolean valida() {
        // TODO
        return true;
    }

    @Override
    public boolean isEstadoCandidaturasDecididas() {
        return true;
    }

}
