/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.timerTasks;

import java.util.TimerTask;
import lapr.project.controller.DetetarConflitoController;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public class AlterarParaFechadaCandidaturas extends TimerTask {

    private Exposicao m_exposicao;
    private CentroExposicoes m_ce;

    /**
     * 
     * @param e - exposição
     * @param ce - centro de exposições
     */
    public AlterarParaFechadaCandidaturas(Exposicao e, CentroExposicoes ce) {
        m_exposicao = e;
        m_ce = ce;
    }

    @Override
    public void run() {
        m_exposicao.getEstado().setEstadoCandidaturasFechadas();
        DetetarConflitoController ctrl = new DetetarConflitoController(m_ce);
        ctrl.detetaConflitos(m_exposicao);
    }
}
