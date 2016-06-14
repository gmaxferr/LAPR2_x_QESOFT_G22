package lapr.project.estados.Exposicao;

import lapr.project.model.Exposicao;

/**
 *
 * @author Ricardo Catalao
 */
public class EstadoExposicaoDemonstracoesDecididas extends EstadoExposicao {

    private final Exposicao m_exposicao;

    public EstadoExposicaoDemonstracoesDecididas(Exposicao exposicao) {
        this.m_exposicao = exposicao;
    }

    @Override
    public boolean setEstadoDemonstracoesDecididas() {
        return true;
    }

    @Override
    public boolean setEstadoCandidaturasDemonstracaoAbertas() {
        this.m_exposicao.setEstado(new EstadoExposicaoCandidaturasDemonstracaoAbertas(m_exposicao));
        return true;
    }

    @Override
    public boolean isEstadoDemonstracoesDecididas() {
        return true;
    }

}
