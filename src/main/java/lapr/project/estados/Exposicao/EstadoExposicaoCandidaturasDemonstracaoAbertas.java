package lapr.project.estados.Exposicao;

import lapr.project.model.Exposicao;

/**
 *
 * @author Ricardo Catalao
 */
public class EstadoExposicaoCandidaturasDemonstracaoAbertas extends EstadoExposicao {

    public EstadoExposicaoCandidaturasDemonstracaoAbertas(Exposicao exposicao) {
        super(exposicao);
    }

    @Override
    public boolean setEstadoCandidaturasDemonstracaoAbertas() {
        return true;
    }

    @Override
    public boolean setEstadoCandidaturasDemonstracaoFechadas() {
        if (valida()) {
            this.m_exposicao.setEstado(new EstadoExposicaoCandidaturasDemonstracaoFechadas(m_exposicao));
            return true;
        }
        return false;
    }

    public boolean valida() {
        // TODO
        return true;
    }

    @Override
    public boolean isEstadoCandidaturasDemonstracaoAbertas() {
        return true;
    }

}
