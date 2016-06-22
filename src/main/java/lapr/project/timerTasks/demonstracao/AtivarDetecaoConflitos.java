/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.timerTasks.demonstracao;

import java.util.TimerTask;
import lapr.project.controller.DetetarConflitosDemonstracaoController;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Demonstracao;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public class AtivarDetecaoConflitos extends TimerTask {

    private CentroExposicoes ce;
    private Demonstracao d;
    
    public AtivarDetecaoConflitos(CentroExposicoes ce, Demonstracao d){
        this.ce = ce;
        this.d = d;
    }
    
    @Override
    public void run() {
        DetetarConflitosDemonstracaoController controller = new DetetarConflitosDemonstracaoController(ce);
        controller.detetaConflitos(d);
    }
    
}
