package lapr.project.timerTasks.expo;

import java.util.TimerTask;
import lapr.project.model.*;

/**
 *
 * @author G29
 */
public class AlterarParaCandDemoAberta extends TimerTask {

    private final Exposicao m_exposicao;

    public AlterarParaCandDemoAberta(Exposicao m_exposicao) {
        this.m_exposicao = m_exposicao;
    }

    @Override
    public void run() {
        for(Demonstracao demo : m_exposicao.getRegistoDemonstracoes().getListaDemonstracoes()){
            demo.getEstadoDemo().setEstadoDemonstracaoCandidaturasAbertas();
        }
    }

}
