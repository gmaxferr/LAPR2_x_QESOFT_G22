package lapr.project.estados.Exposicao;

import lapr.project.model.Exposicao;

/**
 *
 * @author Ricardo Catalao
 */
public class EstadoExposicaoCandidaturasDecididas extends EstadoExposicao {

    public EstadoExposicaoCandidaturasDecididas(Exposicao exposicao) {
        super(exposicao);
        m_exposicao.getKeywordRanking().setReady();
    }

    @Override
    public boolean isEstadoCandidaturasDecididas() {
        return true;
    }

}
