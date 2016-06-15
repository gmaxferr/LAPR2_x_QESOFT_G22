package lapr.project.estados.Exposicao;

import lapr.project.model.Exposicao;

/**
 *
 * @author Ana Leite Ricardo Osório
 */
public class EstadoExposicaoCandidaturasAbertas extends EstadoExposicao {

    public EstadoExposicaoCandidaturasAbertas(Exposicao exposicao) {
        super(exposicao);
    }

    @Override
    public boolean setEstadoCandidaturasFechadas() {
            this.m_exposicao.setEstado(new EstadoExposicaoCandidaturasFechadas(this.m_exposicao));
            return true;
    }

    @Override
    public boolean isEstadoCandidaturasAbertas() {
        return true;
    }
}
