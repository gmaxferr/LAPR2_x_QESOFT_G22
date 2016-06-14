package lapr.project.estados.Exposicao;

import lapr.project.model.Exposicao;

/**
 *
 * @author Ricardo Catalao
 */
public class EstadoExposicaoCandidaturasDemonstracaoFechadas extends EstadoExposicao {

    private final Exposicao m_exposicao;

    public EstadoExposicaoCandidaturasDemonstracaoFechadas(Exposicao exposicao) {
        this.m_exposicao = exposicao;
    }

    @Override
    public boolean setEstadoCandidaturasDemonstracaoFechadas() {
        return true;
    }

    @Override
    public boolean setEstadoConflitosDetetados() {
        if (valida()) {
            this.m_exposicao.setEstado(new EstadoExposicaoConflitosDetetados(m_exposicao));
            return true;
        }
        return false;
    }

    public boolean valida() {
        // TODO
        return true;
    }

    @Override
    public boolean isEstadoCandidaturasDemonstracaoFechadas() {
        return true;
    }

}
