package lapr.project.controller;

import java.util.List;
import lapr.project.estados.Demonstracao.EstadoDemonstracao;
import lapr.project.model.*;
import lapr.project.registos.RegistoTiposConflitoDemonstracao;

/**
 * Representação do controller do UC Detetar Conflitos Demonstracao
 * 
 * @author G29
 */
public class DetetarConflitosDemonstracaoController {

    /**
     * Centro de exposições
     */
    private CentroExposicoes m_ce;

    /**
     * Construtor de objetos do tipo DetetarConflitosDemonstracaoController
     * com o parametro centro de exposições
     * 
     * @param ce centro de exposições
     */
    public DetetarConflitosDemonstracaoController(CentroExposicoes ce) {
        m_ce = ce;
    }

    /**
     * Deteta os conflitos existentes para uma exposição e regista-os no
     * RegistoConflitos da Exposição.
     *
     * @param d demonstração onde serão procurados conflitos
     */
    public void detetaConflitos(Demonstracao d) {
        RegistoTiposConflitoDemonstracao rtcd = m_ce.getRegistoTiposConflitosDemonstracao();
        List<TipoConflitoDemonstracao> ltcd = rtcd.getListaTipoConflitos();
        for (TipoConflitoDemonstracao tc : ltcd) {
            MecanismoDetecaoConflitoDemonstracao mec = tc.getMecanismoDetecaoConflito();
            mec.detetaConflitos(d);
        }
        EstadoDemonstracao state = d.getEstadoDemo();
        state.setEstadoDemonstracaoConflitosDetetados();
    }
}
