package lapr.project.timerTasks.expo;

import java.util.TimerTask;
import lapr.project.model.Exposicao;

/**
 *
 * @author Ricardo Catalao
 */
public class AlterarParaCandDemoFechada extends TimerTask {
    
    private final Exposicao m_exposicao;

    public AlterarParaCandDemoFechada(Exposicao m_exposicao) {
        this.m_exposicao = m_exposicao;
    }

    @Override
    public void run() {
        m_exposicao.getEstado().setEstadoCandidaturasDemonstracaoFechadas();
    }
}
