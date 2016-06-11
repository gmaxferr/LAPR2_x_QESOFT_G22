/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.model.CandidaturaADemonstracao;
import lapr.project.model.Demonstracao;
import lapr.project.model.Exposicao;
import lapr.project.registos.RegistoDemonstracoes;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public class RemoverCandidaturaADemonstracaoController {
    
    private Exposicao m_e;
    private String m_emailExpositor;
    private Demonstracao m_demo;
    private CandidaturaADemonstracao m_candARemover;
    
    /**
     * Construtor do UC29
     * @param e - exposição selecionada
     * @param email - email do expositor
     */
    public RemoverCandidaturaADemonstracaoController(Exposicao e, String email){
        m_e = e;
        m_emailExpositor = email;
    }
    
    /**
     * Permite obter uma lista das demonstrações do expositor que se encontrar dentro do período de submissão de candidaturas
     * @return lista das demonstrações do expositor que se encontrar dentro do período de submissão de candidaturas
     */
    public List<Demonstracao>getListaDemonstracoesExpositor(){
        RegistoDemonstracoes m_rd = m_e.getRegistoDemonstracoes();
        return m_rd.getDemonstracoesAbertas();
    }
    
    /**
     * Seleciona a demonstração pretendida
     * @param d - demonstração pretendida
     */
    public List<CandidaturaADemonstracao> setDemo(Demonstracao d){
        m_demo = d;
        return d.getCandidaturasDemoExpositor(m_emailExpositor);
    }
    
    /**
     * Seleciona a candidatura a demonstração a remover
     * @param cd - candidatura a demonstração a remover
     */
    public void setCandidaturaARemover(CandidaturaADemonstracao cd){
        m_candARemover = cd;
    }
    
    /**
     * Remove efetivamente a candidatura selecionada para remover
     */
    public void removerCandidatura(){
        
    }
    
}
