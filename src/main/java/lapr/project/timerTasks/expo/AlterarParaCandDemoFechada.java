package lapr.project.timerTasks.expo;

import java.util.TimerTask;
import javax.swing.JOptionPane;
import lapr.project.model.*;

/**
 *
 * @author G29
 */
public class AlterarParaCandDemoFechada extends TimerTask {
    
    private final Exposicao m_exposicao;

    public AlterarParaCandDemoFechada(Exposicao m_exposicao) {
        this.m_exposicao = m_exposicao;
    }

    @Override
    public void run() {
        boolean changedState = true;
        for(Demonstracao demo : m_exposicao.getRegistoDemonstracoes().getListaDemonstracoes()){
            if(!demo.getEstadoDemo().setEstadoDemonstracaoCandidaturasFechadas()){
                changedState = false;
            }
        }
        if(!changedState){
            JOptionPane.showMessageDialog(null, "A data de encerramento de candudaturas a exposição passou, no entanto, não foi possível a algumas exposições mudar de estado.", "ERRO", JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "A data de encerramento de candudaturas a exposição passou e todas as demonstrações conseguiram mudar de estado bem sucedidamente.", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
