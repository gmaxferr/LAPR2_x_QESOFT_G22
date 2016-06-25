package lapr.project.timerTasks.expo;

import java.util.TimerTask;
import javax.swing.JOptionPane;
import lapr.project.model.*;

/**
 * Representação de um timer AlterarParaCandDemoAberta
 * 
 * @author G29
 */
public class AlterarParaCandDemoAberta extends TimerTask {

    /**
     * Exposição
     */
    private final Exposicao m_exposicao;

    /**
     * Construtor de objetos do tipo  AlterarParaCandDemoAberta com o 
     * parametro exposição
     * 
     * @param m_exposicao exposição
     */
    public AlterarParaCandDemoAberta(Exposicao m_exposicao) {
        this.m_exposicao = m_exposicao;
    }

    @Override
    public void run() {
        boolean changedState = true;
        for(Demonstracao demo : m_exposicao.getRegistoDemonstracoes().getListaDemonstracoes()){
            if(!demo.getEstadoDemo().setEstadoDemonstracaoCandidaturasAbertas()){
                changedState = false;
            }
        }
        if(!changedState){
            JOptionPane.showMessageDialog(null, "A data de abertura de candudaturas a exposição passou, no entanto, não foi possível a algumas exposições mudar de estado.", "ERRO", JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "A data de abertura de candudaturas a exposição passou e todas as demonstrações conseguiram mudar de estado bem sucedidamente.", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
