/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.timerTasks;

import java.util.TimerTask;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.Exposicao;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public class AlterarParaConflitosAtualizados extends TimerTask {

    private Exposicao m_exposicao;

    /**
     *
     * @param e - exposição
     */
    public AlterarParaConflitosAtualizados(Exposicao e) {
        m_exposicao = e;
    }

    @Override
    public void run() {
        m_exposicao.getEstado().setEstadoConflitosDetetados();
        for (CandidaturaAExposicao c : m_exposicao.getRegistoCandidaturasAExposicao().getListaCandidaturas()) {
            c.getEstado().setEstadoCandidaturaProntaAtribuicoes();
        }
    }
}
