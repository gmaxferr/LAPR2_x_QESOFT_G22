package lapr.project.timerTasks.expo;

import java.util.TimerTask;
import javax.swing.JOptionPane;
import lapr.project.controller.DetetarConflitoController;
import lapr.project.model.*;

/**
 * Representação de um timer AlterarParaFechadaCandidaturas
 * 
 * @author G29
 */
public class AlterarParaFechadaCandidaturas extends TimerTask {

    /**
     * Exposição
     */
    private final Exposicao m_exposicao;
    
    /**
     * Centro de exposições
     */
    private final CentroExposicoes m_ce;

    /**
     * Construtor de objetos do tipo AlterarParaFechadaCandidaturas com os
     * parametros exposição e centro de exposições
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
        boolean change = true;
        for (CandidaturaAExposicao c : m_exposicao.getRegistoCandidaturasAExposicao().getListaCandidaturas()) {
            if (!c.getEstado().setEstadoCandidaturaAbertaAtualizacaoConflitos()) {
                change = false;
            }
        }
        DetetarConflitoController ctrl = new DetetarConflitoController(m_ce);
        ctrl.detetaConflitos(m_exposicao);
        if (!change) {
            JOptionPane.showMessageDialog(null, "Ocorreu a deteção de conflitos de interesse da exposição, no entanto algumas candidaturas não conseguiram mudar de estado.", "ERRO", JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Ocorreu a deteção de conflitos de interesse da exposição!", "SUCESSO", JOptionPane.ERROR_MESSAGE);
        }
    }
}
