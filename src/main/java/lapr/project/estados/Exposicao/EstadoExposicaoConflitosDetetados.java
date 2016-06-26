package lapr.project.estados.Exposicao;

import java.util.TimerTask;
import lapr.project.model.Exposicao;
import lapr.project.timerTasks.expo.AlterarParaConflitosAtualizados;
import lapr.project.utils.Data;

/**
 * Representação do EstadoExposicaoConflitosDetetados
 *
 * @author G29
 */
public class EstadoExposicaoConflitosDetetados extends EstadoExposicao {

    public EstadoExposicaoConflitosDetetados(Exposicao exposicao) {
        super(exposicao);
    }

    @Override
    public boolean setEstadoConflitosAlterados() {
        if (valida()) {
            this.m_exposicao.setEstado(new EstadoExposicaoConflitosAlterados(this.m_exposicao));
            Data currentDate = new Data();
            if (currentDate.isMaior(this.m_exposicao.getDataFimDetecaoConflitos())) {
                TimerTask task = new AlterarParaConflitosAtualizados(m_exposicao);
                Thread myThread = new Thread(task);
                myThread.start();
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
    public boolean isEstadoConflitosDetetados() {
        return true;
    }

}
