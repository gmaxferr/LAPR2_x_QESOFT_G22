package lapr.project.timerTasks.expo;

import java.util.TimerTask;
import javax.swing.JOptionPane;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.Exposicao;

/**
 * Representação de um timer AlterarParaConflitosAtualizados
 * 
 * @author G29
 */
public class AlterarParaConflitosAtualizados extends TimerTask {

    /**
     * Exposição
     */
    private final Exposicao m_exposicao;

    /**
     * Construtor de objetos do tipo AlterarParaConflitosAtualizados com o 
     * parametro exposição
     * 
     * @param e - exposição
     */
    public AlterarParaConflitosAtualizados(Exposicao e) {
        m_exposicao = e;
    }

    @Override
    public void run() {
        m_exposicao.getEstado().setEstadoConflitosAlterados();
        boolean change = true;
        for (CandidaturaAExposicao c : m_exposicao.getRegistoCandidaturasAExposicao().getListaCandidaturas()) {
            if (!c.getEstado().setEstadoCandidaturaProntaAtribuicoes()) {
                change = false;
            }
        }
        if (!change) {
            JOptionPane.showMessageDialog(null, "Terminou o período de atualização de conflitos de interesse mas algumas candidaturas não conseguiram mudar de estado.", "ERRO", JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Terminou o período de atualização de conflitos de interesse!", "SUCESSO", JOptionPane.ERROR_MESSAGE);
        }
    }
}
