package lapr.project.estados.Exposicao;

import lapr.project.timerTasks.expo.*;
import java.util.TimerTask;
import lapr.project.model.*;
import lapr.project.utils.Data;

/**
 * Representação do EstadoExposicaoInicial
 *
 * @author G29
 */
public class EstadoExposicaoInicial extends EstadoExposicao {

    private final CentroExposicoes m_ce;

    private TimerTask inicioSubCand;
    private TimerTask fimSubCand;
    private TimerTask fimDetecaoConflitos;
    private TimerTask fimAvaliacoes;

    private Data data1;
    private Data data2;
    private Data data3;
    private Data data4;

    public EstadoExposicaoInicial(Exposicao exposicao, CentroExposicoes ce) {
        super(exposicao);
        this.m_ce = ce;
    }

    @Override
    public boolean setEstadoCriada() {

        data1 = m_exposicao.getDataInicioSubCand();

        data2 = m_exposicao.getDataFimSubCand();

        data3 = m_exposicao.getDataFimDetecaoConflitos();

        data4 = m_exposicao.getDataFimAvaliacoes();

        m_exposicao.setEstado(new EstadoExposicaoCriada(m_exposicao));

        inicioSubCand = new AlterarParaAbertaCandidaturas(m_exposicao);
        m_exposicao.schedule(inicioSubCand, data1);

        fimSubCand = new AlterarParaFechadaCandidaturas(m_exposicao, m_ce);
        m_exposicao.schedule(fimSubCand, data2);

        fimDetecaoConflitos = new AlterarParaConflitosAtualizados(m_exposicao);
        m_exposicao.schedule(fimDetecaoConflitos, data3);

        fimAvaliacoes = new AlterarParaFimAvaliacoes(m_exposicao);
        m_exposicao.schedule(fimAvaliacoes, data4);

        return true;
    }

    @Override
    public boolean isEstadoInicial() {
        return true;
    }
}
