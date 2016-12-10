package lapr.project.estados.Exposicao;

import java.util.TimerTask;
import lapr.project.model.Exposicao;
import lapr.project.timerTasks.expo.AlterarParaConflitosAtualizados;
import lapr.project.timerTasks.expo.AlterarParaFimAvaliacoes;
import lapr.project.utils.Data;

/**
 * Representação do EstadoExposicaoCandidaturasAtribuidas
 * 
 * @author G29
 */
public class EstadoExposicaoCandidaturasAtribuidas extends EstadoExposicao {

    public EstadoExposicaoCandidaturasAtribuidas(Exposicao exposicao) {
        super(exposicao);
    }


    @Override
    public boolean setEstadoCandidaturasAvaliadas() {
        if (valida()) {
            this.m_exposicao.setEstado(new EstadoExposicaoCandidaturasAvaliadas(this.m_exposicao));
            Data currentDate = new Data();
            if (currentDate.isMaior(this.m_exposicao.getDataFimAvaliacoes())) {
                TimerTask task = new AlterarParaFimAvaliacoes(m_exposicao);
                task.run();
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean valida() {
        //valida se tem as coisas todas necessárias para passar ao próximo estado (verificação de atributos)
        return true;
    }

    @Override
    public boolean isEstadoCandidaturasAtribuidas() {
        return true;
    }

}
