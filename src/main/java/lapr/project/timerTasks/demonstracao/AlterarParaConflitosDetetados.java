/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.timerTasks.demonstracao;

import java.util.TimerTask;
import lapr.project.estados.Demonstracao.EstadoDemonstracao;
import lapr.project.estados.Demonstracao.EstadoDemonstracaoConflitosDetetados;
import lapr.project.model.Demonstracao;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public class AlterarParaConflitosDetetados extends TimerTask{

    private Demonstracao m_demo;
    
    public AlterarParaConflitosDetetados(Demonstracao d){
        m_demo = d;
    }
    
    @Override
    public void run() {
        EstadoDemonstracao e = m_demo.getEstadoDemo();
        e = new EstadoDemonstracaoConflitosDetetados(m_demo);
    }
    
    
}
