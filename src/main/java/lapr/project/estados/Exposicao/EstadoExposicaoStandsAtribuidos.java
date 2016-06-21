package lapr.project.estados.Exposicao;

import java.util.List;
import lapr.project.model.Demonstracao;
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
            List<Demonstracao> listDemos = m_exposicao.getRegistoDemonstracoes().getListaDemonstracoes();
            if (!listDemos.isEmpty()) {
                Demonstracao d = listDemos.get(0);
                m_exposicao.schedule(new AlterarParaCandDemoAberta(m_exposicao), d.getDataInicioCand());
                m_exposicao.schedule(new AlterarParaCandDemoFechada(m_exposicao), d.getDataFimCand());
            }
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
