/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.timerTasks.demonstracao;

import java.util.TimerTask;
import lapr.project.model.Demonstracao;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public class AlterarParaCandidaturasAbertas extends TimerTask{

    private final Demonstracao m_demo;

    /**
     *
     * @param e - exposição
     */
    public AlterarParaCandidaturasAbertas(Demonstracao d) {
        m_demo = d;
    }

    @Override
    public void run() {
        m_demo.getEstadoDemo().setEstadoDemonstracaoCandidaturasAbertas();
    }
    
}
