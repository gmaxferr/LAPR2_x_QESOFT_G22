package lapr.project.controller;

import java.util.List;
import lapr.project.model.*;
import lapr.project.registos.RegistoDemonstracoes;

/**
 * Representação do controller do UC Remover candidatura à demonstração
 *
 * @author G29
 */
public class RemoverCandidaturaADemonstracaoController {

    /**
     * Exposição selecionada
     */
    private Exposicao m_e;

    /**
     * Email do expositor
     */
    private String m_emailExpositor;

    /**
     * Demonstração selecionada na UI. Sobre a qual serão removidas candidaturas
     */
    private Demonstracao m_demo;

    /**
     * Candidatura selecionada na UI para ser removida
     */
    private CandidaturaADemonstracao m_candARemover;

    /**
     * Construtor do UC29
     *
     * @param e - exposição selecionada
     * @param email - email do expositor
     */
    public RemoverCandidaturaADemonstracaoController(Exposicao e, String email) {
        m_e = e;
        m_emailExpositor = email;
    }

    /**
     * Permite obter uma lista das demonstrações do expositor que se encontrar
     * dentro do período de submissão de candidaturas
     *
     * @return lista das demonstrações do expositor que se encontrar dentro do
     * período de submissão de candidaturas
     */
    public List<Demonstracao> getListaDemonstracoesExpositor() {
        RegistoDemonstracoes m_rd = m_e.getRegistoDemonstracoes();
        return m_rd.getDemonstracoesAbertas();
    }

    /**
     * Seleciona a demonstração pretendida
     *
     * @param d - demonstração pretendida
     */
    public List<CandidaturaADemonstracao> setDemo(Demonstracao d) {
        m_demo = d;
        return d.getCandidaturasDemoExpositor(m_emailExpositor);
    }

    /**
     * Seleciona a candidatura a demonstração a remover
     *
     * @param cd - candidatura a demonstração a remover
     */
    public void setCandidaturaARemover(CandidaturaADemonstracao cd) {
        m_candARemover = cd;
    }

    /**
     * Remove efetivamente a candidatura selecionada para remover
     */
    public void removerCandidatura() {
        m_demo.getRegistoCandidaturasADemonstracao().getListaCandidaturasADemonstracao().remove(m_candARemover);
        m_demo.getRegistoCandidaturasADemonstracaoRemovidas().adicionarCandidatura(m_candARemover);
    }

}
