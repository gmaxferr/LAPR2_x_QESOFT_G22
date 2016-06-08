package lapr.project.timerTasks;

import java.util.TimerTask;
import lapr.project.model.Exposicao;

/**
 *
 * @author Ricardo Catalao
 */
public class AlterarParaCandDemoAberta extends TimerTask {

    private final Exposicao m_exposicao;

    public AlterarParaCandDemoAberta(Exposicao m_exposicao) {
        this.m_exposicao = m_exposicao;
    }

    @Override
    public void run() {
        m_exposicao.getEstado().setEstadoCandidaturasDemonstracaoAbertas();
    }

}
