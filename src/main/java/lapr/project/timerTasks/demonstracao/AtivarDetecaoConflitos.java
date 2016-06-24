package lapr.project.timerTasks.demonstracao;

import java.util.TimerTask;
import lapr.project.controller.DetetarConflitosDemonstracaoController;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Demonstracao;

/**
 * Representação de um timer AtivarDetecaoConflitos
 * 
 * @author G29
 */
public class AtivarDetecaoConflitos extends TimerTask {

    /**
     * Centro de exposições
     */
    private CentroExposicoes ce;
    
    /**
     * Demonstração
     */
    private Demonstracao d;
    
    /**
     * Construtor de objetos do tipo AtivarDetecaoConflitos com os paramentros
     * centro de exposições e demonstração
     * 
     * @param ce centro de exposições
     * @param d demonstração
     */
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
