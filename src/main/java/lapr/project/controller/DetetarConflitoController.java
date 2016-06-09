package lapr.project.controller;

import java.util.List;
import lapr.project.estados.Exposicao.EstadoExposicao;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.model.MecanismoDetecaoConflito;
import lapr.project.model.TipoConflito;
import lapr.project.registos.RegistoExposicoes;
import lapr.project.registos.RegistoTipoConflitos;

/**
 *
 * @author osori
 */
public class DetetarConflitoController {

    /**
     * Centro de Exposições.
     */
    private final CentroExposicoes m_centroExposicoes;

    /**
     * Construtor padrão de DetetarConflitoController.
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
