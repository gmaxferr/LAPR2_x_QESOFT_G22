/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Demonstracao;
import lapr.project.model.Exposicao;
import lapr.project.registos.RegistoDemonstracoes;
import lapr.project.registos.RegistoExposicoes;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public class DecidirDemonstracaoController {


    private final CentroExposicoes ce;
    private final String usernameOrganizador;
    private final RegistoExposicoes re;
    private RegistoDemonstracoes rd;
    private List<Demonstracao> lstDemonstracoes;
    private boolean[] decisoesTemp;

    private final CentroExposicoes m_ce;
    private String m_usernameOrganizador;
    private RegistoExposicoes m_re;
    private RegistoDemonstracoes m_rd;
    private List<Demonstracao> m_listDemonstracoes;
    private boolean[] m_decisoesTemp;


    public DecidirDemonstracaoController(CentroExposicoes ce, String username) {
        this.m_ce = ce;
        m_re = ce.getRegistoExposicoes();
        m_usernameOrganizador = username;
    }

    /**
     *
     * @return lista de decisões para as demonstrações pendentes da exposição
     * selecionada
     */
    public boolean[] getDecisoesTemp() {
        return m_decisoesTemp;
    }

    public List<Exposicao> getListaExposOrganizador() {
        return m_re.getlistaExposicoesDoOrganizadorComDemos(m_usernameOrganizador);
    }

    /**
     * Seleciona a exposição pretendida e devolve demonstrações pendentes da
     * mesma
     *
     * @param e - exposição selecionada
     * @return demonstrações pendentes da exposição selecionada
     */
    public List<Demonstracao> setExposicao(Exposicao e) {
        m_rd = e.getRegistoDemonstracoes();
        List<Demonstracao> demosPendentes = m_rd.getDemonstracoesPendentes();
        m_decisoesTemp = new boolean[demosPendentes.size()];
        return demosPendentes;
    }

    /**
     * Regista decisões para as demonstrações pendentes da exposição
     */
    public void registarDecisoes() {
        for (int i = 0; i < m_listDemonstracoes.size(); i++) {
            if (m_decisoesTemp[i]) {
                m_listDemonstracoes.get(i).getEstadoDemo().setEstadoDemonstracaoConfirmada();
            } else {
                m_listDemonstracoes.get(i).getEstadoDemo().setEstadoDemonstracaoCancelada();
            }
        }
    }
}
