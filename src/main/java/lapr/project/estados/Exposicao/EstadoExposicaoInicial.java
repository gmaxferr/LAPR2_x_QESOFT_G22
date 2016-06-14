/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.estados.Exposicao;

import lapr.project.timerTasks.expo.AlterarParaConflitosAtualizados;
import lapr.project.timerTasks.expo.AlterarParaAbertaCandidaturas;
import lapr.project.timerTasks.expo.AlterarParaFechadaCandidaturas;
import java.util.TimerTask;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.utils.Data;

/**
 *
 * @author osori
 */
public class EstadoExposicaoInicial extends EstadoExposicao {

    private final CentroExposicoes m_ce;

    private TimerTask inicioSubCand;
    private TimerTask fimSubCand;
    private TimerTask fimDetecaoConflitos;

    private Data data1;
    private Data data2;
    private Data data3;

    public EstadoExposicaoInicial(Exposicao exposicao, CentroExposicoes ce) {
        super(exposicao);
        this.m_ce = ce;
    }

    @Override
    public boolean setEstadoCriada() {

        data1 = m_exposicao.getDataInicioSubCand();

        data2 = m_exposicao.getDataFimSubCand();

        data3 = m_exposicao.getDataFimDetecaoConflitos();

        inicioSubCand = new AlterarParaAbertaCandidaturas(m_exposicao);
        m_exposicao.schedule(inicioSubCand, data1);

        fimSubCand = new AlterarParaFechadaCandidaturas(m_exposicao, m_ce);
        m_exposicao.schedule(fimSubCand, data2);

        fimDetecaoConflitos = new AlterarParaConflitosAtualizados(m_exposicao);
        m_exposicao.schedule(fimDetecaoConflitos, data3);

        m_exposicao.setEstado(new EstadoExposicaoCriada(m_exposicao));
        return true;
    }

    private boolean valida() {
        //valida se tem as coisas todas necessárias para passar ao próximo estado (verificação de atributos)
        return true;
    }

    @Override
    public boolean isEstadoInicial() {
        return true;
    }
}
