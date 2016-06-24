package lapr.project.estados.Exposicao;

import java.util.TimerTask;
import lapr.project.model.Exposicao;
import lapr.project.timerTasks.expo.AlterarParaFechadaCandidaturas;
import lapr.project.utils.Data;

/**
 * Representação do EstadoExposicaoCandidaturasAbertas
 * 
 * @author G29
 */
public class EstadoExposicaoCandidaturasAbertas extends EstadoExposicao {

    public EstadoExposicaoCandidaturasAbertas(Exposicao exposicao) {
        super(exposicao);
    }

    @Override
    public boolean setEstadoCandidaturasFechadas() {
        this.m_exposicao.setEstado(new EstadoExposicaoCandidaturasFechadas(this.m_exposicao));
        Data currentDate = new Data();
        if (currentDate.isMaior(this.m_exposicao.getDataFimSubCand())) {
            TimerTask task = new AlterarParaFechadaCandidaturas(m_exposicao, m_exposicao.getCentroExposicoes());
            task.run();
        }
        return true;
    }

    @Override
    public boolean isEstadoCandidaturasAbertas() {
        return true;
    }
}
