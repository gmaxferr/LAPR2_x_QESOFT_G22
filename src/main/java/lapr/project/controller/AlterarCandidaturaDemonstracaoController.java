/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.CandidaturaADemonstracao;
import lapr.project.model.Demonstracao;
import lapr.project.model.Exposicao;
import lapr.project.registos.RegistoCandidaturaADemonstracoes;
import lapr.project.registos.RegistoDemonstracoes;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public class AlterarCandidaturaDemonstracaoController {
    
    private List<CandidaturaADemonstracao> m_lstCandsDemo;
    private Exposicao m_e;
    private CandidaturaADemonstracao m_cd;
    private String m_emailExpositor;
    private String m_novosDados;
    private RegistoDemonstracoes m_rd; 
    
    
    /**
     * Construtor da UC26
     * @param email - email do expositor
     * @param e - exposição selecionada
     */
    public AlterarCandidaturaDemonstracaoController(String email,Exposicao e){
           m_e = e;
           m_emailExpositor = email;
    }
    
    /**
     * Permite selecionar temporariamente a candidatura a alterar
     * @param c - candidatura a alterar
     */
    public void selectCand(CandidaturaADemonstracao c){
        m_cd = c;
    }
    
    /**
     * Define novos dados da candidatura a demonstração
     * @param dados - novos dados da candidatura a demonstração
     */
    public void setDados(String dados){
        m_novosDados = dados;
    }
    
    /**
     * Altera efetivamente os dados da candidatura após confirmação
     */
    public void alterarCandidatura(){
        m_cd.setDados(m_novosDados);
    }
    
    /**
     * Procura e devolve lista das candidaturas a demonstrações do expositor
     * @return - lista das candidaturas a demonstrações do expositor
     */
    public List<CandidaturaADemonstracao>getCandidaturasRepresentante(){
        m_rd = m_e.getRegistoDemonstracoes();
        List<Demonstracao>lstDemos= m_rd.getDemonstracoesAbertas();
        List<CandidaturaADemonstracao>lstCands = new ArrayList<>();
        for(Demonstracao d : lstDemos){
            RegistoCandidaturaADemonstracoes rcd = d.getRegistoCandidaturasADemonstracao();
            rcd.getListaCandidaturasADemonstracaoRep(m_emailExpositor);
            lstCands.addAll(rcd.getListaCandidaturasADemonstracaoRep(m_emailExpositor));
        }
        return lstCands;
    }
}
