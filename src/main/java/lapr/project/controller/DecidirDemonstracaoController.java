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
import lapr.project.utils.Data;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public class DecidirDemonstracaoController {

    private String m_usernameOrganizador;
    private RegistoExposicoes m_re;
    private RegistoDemonstracoes m_rd;
    private List<Demonstracao> m_listDemonstracoes;
    private boolean[] m_decisoesTemp;
    private Exposicao m_expo;
    
    Data dataInicioCandDemo;
    Data dataFimCandDemo;
    Data dataFimDetecaoConflitos;
    
    public DecidirDemonstracaoController(CentroExposicoes ce, String username) {
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
        m_expo = e;
        m_rd = e.getRegistoDemonstracoes();
        List<Demonstracao> demosPendentes = m_rd.getDemonstracoesPendentes();
        m_decisoesTemp = new boolean[demosPendentes.size()];
        return demosPendentes;
    }

    /**
     * Define as datas da demonstração
     * @param dataInicioSubCand - data de inicio de submissao de candidaturas
     * @param dataFimSubCand - data de fim de submissao de candidaturas
     * @param dataFimDetecaoConflitos  - data de inicio de detecao de conflitos
     */
    public void setDatas(Data dataInicioSubCand, Data dataFimSubCand, Data dataFimDetecaoConflitos){
        this.dataInicioCandDemo = dataInicioSubCand;
        this.dataFimCandDemo = dataFimSubCand;
        this.dataFimDetecaoConflitos = dataFimDetecaoConflitos;
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
            
            this.m_expo.setDataInicioCandDemo(dataInicioCandDemo);
            this.m_expo.setDataFimCandDemo(dataFimCandDemo);
            this.m_expo.setDataFimDetecaoConflitosDemo(dataFimDetecaoConflitos);
        }
    }
}
