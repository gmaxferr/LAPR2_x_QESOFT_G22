/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.estados;

import java.util.TimerTask;
import lapr.project.controller.DetetarConflitoController;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;

/**
 *
 * @author osori
 */
public class EstadoExposicaoInicial implements EstadoExposicao {

    private final Exposicao m_exposicao;
    private final CentroExposicoes m_ce;

    public EstadoExposicaoInicial(Exposicao exposicao, CentroExposicoes ce) {
        this.m_exposicao = exposicao;
        this.m_ce = ce;
    }

    @Override
    public boolean setEstadoCriada() {

        TimerTask inicioSubCand = new TimerTask() {
            @Override
            public void run() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        m_exposicao.schedule(inicioSubCand, m_exposicao.getDataInicioSubCand());
        TimerTask fimSubCand = new TimerTask() {
            @Override
            public void run() {
                m_exposicao.getEstado().setEstadoCandidaturasFechadas();
                DetetarConflitoController ctrl = new DetetarConflitoController(m_ce);
                ctrl.detetaConflitos(m_exposicao);
            }

        };
        m_exposicao.schedule(fimSubCand, m_exposicao.getDataFimSubCand());
        TimerTask fimDetecaoConflitos = new TimerTask() {
            @Override
            public void run() {
                m_exposicao.getEstado().setEstadoConflitosDetetados();
            }
        };
        m_exposicao.schedule(fimDetecaoConflitos, m_exposicao.getDataFimDetecaoConflitos());
        this.m_exposicao.setEstado(new EstadoExposicaoCriada(this.m_exposicao));
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
