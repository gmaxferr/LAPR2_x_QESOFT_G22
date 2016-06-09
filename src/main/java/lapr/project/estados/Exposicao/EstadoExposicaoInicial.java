/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.estados.Exposicao;

import java.util.TimerTask;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.timerTasks.*;
import lapr.project.utils.Data;

/**
 *
 * @author osori
 */
public class EstadoExposicaoInicial implements EstadoExposicao {

    private final Exposicao m_exposicao;
    private final CentroExposicoes m_ce;

    private TimerTask inicioSubCand;
    private TimerTask fimSubCand;
    private TimerTask fimDetecaoConflitos;

    private Data data1;
    private Data data2;
    private Data data3;
    
    public EstadoExposicaoInicial(Exposicao exposicao, CentroExposicoes ce) {
        this.m_exposicao = exposicao;
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

    @Override
    public boolean setEstadoFAEDefinidosSemDemos() {
        return false;
    }

    @Override
    public boolean setEstadoDemosDefinidasSemFAE() {
        return false;
    }

    @Override
    public boolean setEstadoCompleta() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturasAbertas() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturasFechadas() {
        return false;
    }

    @Override
    public boolean setEstadoConflitosDetetados() {
        return true;
    }

    @Override
    public boolean setEstadoConflitosAlterados() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturasAtribuidas() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturasAvaliadas() {
        return false;
    }

    @Override
    public boolean setEstadoStandsAtribuidos() {
        return false;
    }

    @Override
    public boolean setEstadoDemonstracoesDecididas() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturasDemonstracaoAbertas() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturasDemonstracaoFechadas() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturasDecididas() {
        return false;
    }

    private boolean valida() {
        //valida se tem as coisas todas necessárias para passar ao próximo estado (verificação de atributos)
        return true;
    }

    @Override
    public boolean isEstadoCriada() {
        return false;
    }

    @Override
    public boolean isEstadoFAEDefinidosSemDemos() {
        return false;
    }

    @Override
    public boolean isEstadoDemosDefinidasSemFAE() {
        return false;
    }

    @Override
    public boolean isEstadoCompleta() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturasAbertas() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturasFechadas() {
        return false;
    }

    @Override
    public boolean isEstadoConflitosDetetados() {
        return false;
    }

    @Override
    public boolean isEstadoConflitosAlterados() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturasAtribuidas() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturasAvaliadas() {
        return false;
    }

    @Override
    public boolean isEstadoStandsAtribuidos() {
        return false;
    }

    @Override
    public boolean isEstadoDemonstracoesDecididas() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturasDemonstracaoAbertas() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturasDemonstracaoFechadas() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturasDecididas() {
        return false;
    }

}
