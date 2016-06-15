package lapr.project.estados.Exposicao;

import lapr.project.model.Exposicao;
import lapr.project.timerTasks.expo.AlterarParaCandDemoAberta;
import lapr.project.timerTasks.expo.AlterarParaCandDemoFechada;

/**
 *
 * @author Ricardo Catalao
 */
public class EstadoExposicaoStandsAtribuidos extends EstadoExposicao {

    public EstadoExposicaoStandsAtribuidos(Exposicao exposicao) {
        super(exposicao);
    }

    @Override
    public boolean setEstadoDemonstracoesDecididas() {
        if (valida()) {
            m_exposicao.setEstado(new EstadoExposicaoDemonstracoesDecididas(m_exposicao));
            m_exposicao.schedule(new AlterarParaCandDemoAberta(m_exposicao), m_exposicao.getDataInicioCandDemo());
            m_exposicao.schedule(new AlterarParaCandDemoFechada(m_exposicao), m_exposicao.getDataFimCandDemo());
            return true;
        }
        return false;
    }

    public boolean valida() {
        // TODO
        return true;
    }

    @Override
    public boolean isEstadoStandsAtribuidos() {
        return true;
    }

}
