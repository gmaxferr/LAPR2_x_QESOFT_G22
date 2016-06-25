/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.timerTasks.expo;

import java.util.TimerTask;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.Exposicao;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public class AlterarParaFimAvaliacoes extends TimerTask{

    private Exposicao m_e;
    
    public AlterarParaFimAvaliacoes(Exposicao e){
        m_e = e;
    }
    
    @Override
    public void run() {
        m_e.getEstado().setEstadoCandidaturasAvaliadas();
        for(CandidaturaAExposicao c : m_e.getListaCandidaturasAExposicao()){
            if(c.getEstado().isEstadoCandidaturaAtribuida()){
                c.getEstado().setEstadoCandidaturaNaoAvaliada();
            }
        }
    }
    
}
