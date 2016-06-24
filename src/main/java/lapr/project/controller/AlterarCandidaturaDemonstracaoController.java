package lapr.project.controller;

import java.util.*;
import lapr.project.model.*;
import lapr.project.registos.*;

/**
 * Representação do controller Alterar Candidatura Demosntracao
 * 
 * @author G29
 */
public class AlterarCandidaturaDemonstracaoController {

    /**
     * Exposição selecionada
     */
    private Exposicao m_e;
    
    /**
     * Candidatura a demonstração
     */
    private CandidaturaADemonstracao m_cd;
    
    /**
     * Email do representante
     */
    private String m_emailExpositor;
    
    /**
     * Dados da candidatura ademonstração
     */
    private String m_novosDados;
    
    /**
     * Registo de demosntrações
     */
    private RegistoDemonstracoes m_rd;

    /**
     * Construtor da de objetos do tipo AlterarCandidaturaDemonstracaoController
     * com os parametros email do representante e exposição
     *
     * @param email - email do representante
     * @param e - exposição selecionada
     */
    public AlterarCandidaturaDemonstracaoController(String email, Exposicao e) {
        m_e = e;
        m_emailExpositor = email;
    }

    /**
     * Devolve os novos dados
     * 
     * @return - novos dados temporários
     */
    public String getNovosDados() {
        return m_novosDados;
    }

    /**
     * Devolve a candidatura a demonstração alterada
     * 
     * @return - candidatura a demonstracao alterada
     */
    public CandidaturaADemonstracao getCandidaturaDemonstracao() {
        return m_cd;
    }

    /**
     * Permite selecionar temporariamente a candidatura a alterar
     *
     * @param c - candidatura a alterar
     */
    public void selectCand(CandidaturaADemonstracao c) {
        m_cd = c;
    }

    /**
     * Define novos dados da candidatura a demonstração
     *
     * @param dados - novos dados da candidatura a demonstração
     */
    public void setDados(String dados) {
        m_novosDados = dados;
    }

    /**
     * Altera efetivamente os dados da candidatura após confirmação
     */
    public void alterarCandidatura() {
        m_cd.setDados(m_novosDados);
    }

    /**
     * Procura e devolve lista das candidaturas a demonstrações do expositor
     *
     * @return - lista das candidaturas a demonstrações do expositor
     */
    public List<CandidaturaADemonstracao> getCandidaturasRepresentante() {
        m_rd = m_e.getRegistoDemonstracoes();
        List<Demonstracao> lstDemos = m_rd.getListaDemonstracoesEstadoCandidaturasAbertas();
        List<CandidaturaADemonstracao> lstCands = new ArrayList<>();
        for (Demonstracao d : lstDemos) {
            RegistoCandidaturasADemonstracao rcd = d.getRegistoCandidaturasADemonstracao();
            lstCands.addAll(rcd.getListaCandidaturasADemonstracaoRep(d,m_emailExpositor));
        }
        return lstCands;
    }
}
