package lapr.project.estados.Exposicao;

import java.util.TimerTask;
import lapr.project.model.Exposicao;
import lapr.project.timerTasks.expo.AlterarParaAbertaCandidaturas;
import lapr.project.utils.Data;

/**
 *
 * @author Ana Leite RicardoOsório
 */
public class EstadoExposicaoCompleta extends EstadoExposicao {

    public EstadoExposicaoCompleta(Exposicao exposicao) {
        super(exposicao);
    }

    @Override
    public boolean setEstadoCandidaturasAbertas() {
        if (valida()) {
            this.m_exposicao.setEstado(new EstadoExposicaoCandidaturasAbertas(this.m_exposicao));
            Data currentDate = new Data();
            if(currentDate.isMaior(this.m_exposicao.getDataInicioSubCand())){
                TimerTask task = new AlterarParaAbertaCandidaturas(m_exposicao);
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
    public boolean isEstadoCompleta() {
        return true;
    }

}
