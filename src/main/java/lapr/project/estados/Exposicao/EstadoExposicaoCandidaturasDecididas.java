package lapr.project.estados.Exposicao;

import lapr.project.model.Exposicao;

/**
 * Representação do EstadoExposicaoCandidaturasDecididas
 * 
 * @author G29
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

    @Override
    public boolean setEstadoCandidaturasDecididas(){
        return true;
    }
    
    @Override
    public boolean setEstadoDemosDecididas(){
        m_exposicao.setEstado(new EstadoExposicaoDemonstracoesDecididas(m_exposicao));
        return true;
    }
}
