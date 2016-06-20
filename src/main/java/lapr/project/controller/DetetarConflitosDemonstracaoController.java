package lapr.project.controller;

import java.util.List;
import lapr.project.estados.Demonstracao.EstadoDemonstracao;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Demonstracao;
import lapr.project.model.MecanismoDetecaoConflitoDemonstracao;
import lapr.project.model.TipoConflitoDemonstracao;
import lapr.project.registos.RegistoTiposConflitoDemonstracao;

/**
 *
 * @author G29
 */
public class DetetarConflitosDemonstracaoController {

    private CentroExposicoes m_ce;

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
