package lapr.project.controller;

import java.util.List;
import lapr.project.estados.Exposicao.EstadoExposicao;
import lapr.project.model.*;
import lapr.project.registos.RegistoTipoConflitos;

/**
 * Representação do controller do UC Detetar Conflito
 * 
 * @author G29
 */
public class DetetarConflitoController {

    /**
     * Centro de Exposições.
     */
    private final CentroExposicoes m_centroExposicoes;

    /**
     * Construtor de objetos do tipo DetetarConflitoController com o parametro
     * centro de exposições
     *
     * @param centroExposicoes Centro de Exposições
     */
    public DetetarConflitoController(CentroExposicoes centroExposicoes) {
        this.m_centroExposicoes = centroExposicoes;
    }

    /**
     * Deteta os conflitos existentes para uma exposição e regista-os no
     * RegistoConflitos da Exposição.
     *
     * @param e Exposição onde se pretende detetar os conflitos
     */
    public void detetaConflitos(Exposicao e) {
        RegistoTipoConflitos rtc = m_centroExposicoes.getRegistoTiposConflitos();
        List<TipoConflito> ltc = rtc.getListaTipoConflitos();
        for (TipoConflito tc : ltc) {
            MecanismoDetecaoConflito mec = tc.getMecanismoDetecaoConflito();
            mec.detetaConflitos(e);
        }
        EstadoExposicao state = e.getEstado();
        state.setEstadoConflitosDetetados();
    }

}
