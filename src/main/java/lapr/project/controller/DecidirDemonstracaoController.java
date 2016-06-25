package lapr.project.controller;

import java.util.List;
import lapr.project.model.*;
import lapr.project.registos.*;
import lapr.project.utils.Data;

/**
 * represnetação co controller do UC Decidir Demonstracao
 * 
 * @author G29
 */
public class DecidirDemonstracaoController {

    /**
     * Username do organizador
     */
    private String m_usernameOrganizador;
    
    /**
     * Registo de exposições
     */
    private RegistoExposicoes m_re;
    
    /**
     * Registo de demonstrações
     */
    private RegistoDemonstracoes m_rd;
    
    /**
     * Lista de demonstrações
     */
    private List<Demonstracao> m_listDemonstracoes;
    
    /**
     * Lista de decisões para as demonstrações pendentes da exposição
     * selecionada
     */
    private boolean[] m_decisoesTemp;
    
    /**
     * Exposição selecionda
     */
    private Exposicao m_expo;

    /**
     * Data de inicio da candidatura a demonstração
     */
    Data dataInicioCandDemo;
    
    /**
     * Data de dim da candidatura a demonstração
     */
    Data dataFimCandDemo;
    
    /**
     * Data de fim de deteção de conflitos
     */
    Data dataFimDetecaoConflitos;

    /**
     * Construtor de objetos do tipo DecirdirDemonstracaoController com os 
     * parametros centro de exposições e username do organizador
     * 
     * @param ce centro de exposições
     * @param username username do organizador
     */
    public DecidirDemonstracaoController(CentroExposicoes ce, String username) {
        m_re = ce.getRegistoExposicoes();
        m_usernameOrganizador = username;
    }

    /**
     * Devolve lista de decisões para as demonstrações pendentes da exposição
     * selecionada
     * 
     * @return lista de decisões para as demonstrações pendentes da exposição
     * selecionada
     */
    public boolean[] getDecisoesTemp() {
        return m_decisoesTemp;
    }

    /**
     * Devolve a lista de exposições do organizador
     * 
     * @return lista de exposições do organizador
     */
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
     *
     * @param dataInicioSubCand - data de inicio de submissao de candidaturas
     * @param dataFimSubCand - data de fim de submissao de candidaturas
     * @param dataFimDetecaoConflitos - data de inicio de detecao de conflitos
     */
    public void setDatas(Data dataInicioSubCand, Data dataFimSubCand, Data dataFimDetecaoConflitos) {
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
        }
        this.m_expo.setDataInicioCandDemo(dataInicioCandDemo);
        this.m_expo.setDataFimCandDemo(dataFimCandDemo);
        this.m_expo.setDataFimDetecaoConflitosDemo(dataFimDetecaoConflitos);
        this.m_expo.getEstado().setEstadoDemosDecididas();
    }

}
