/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.model.CandidaturaADemonstracao;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Demonstracao;
import lapr.project.model.Exposicao;
import lapr.project.registos.RegistoDemonstracoes;
import lapr.project.registos.RegistoExposicoes;

/**
 *
 * @author guima
 */
public class RegistarCandidaturaADemonstracaoController {

    private Exposicao e; //exposição selecionada
    private Demonstracao d; //demonstração selecionada
    private String dados; //dados do formulário

    private CentroExposicoes ce;
    private String usernameRep; //username do representante

    private RegistoExposicoes re;
    private RegistoDemonstracoes rd;
    private lapr.project.registos.RegistoCandidaturaADemonstracoes rcd;

    private List<Demonstracao> listDemos; //lista de demonstrações da exposição selecionada

    private EstadoCandidaturaADemonstracao ecd;
    
    public RegistarCandidaturaADemonstracaoController(CentroExposicoes ce, String usernameRep) {
        this.ce = ce;
        this.usernameRep = usernameRep;
    }

    /**
     * @return lista de exposiçoes (nas quais o representante foi integradp) do
     * registo de exposições do centro de exposições. selecionada previamente
     */
    public List<Exposicao> getListaDeExposicoes() {
        re = ce.getRegistoExposicoes();
        return re.getListaExposicoesComCandidaturasAceitesRepresentante(usernameRep);
    }

    /**
     * Guarda a exposição selecionada pelo representante
     *
     * @param e - exposição selecionada
     */
    public void setExpo(Exposicao e) {
        this.e = e;
    }

    /**
     * Guarda a demonstração selecionada pelo representante
     *
     * @param d - demonstração selecionada
     */
    public void setDemo(Demonstracao d) {
        this.d = d;
    }

    /**
     * @return lista de demonstrações do registo de demonstrações da exposição
     * selecionada previamente
     */
    public List<Demonstracao> getListaDemos() {
        rd = e.getRegistoDemonstracoes();
        listDemos = rd.getListaDemonstracoes();
        return listDemos;
    }

    /**
     * Valida os dados conforme estes estejam ou não preenchidos. (Ainda não
     * temos outra forma de validar estes dados)
     *
     * @param dados - dados do formulário
     * @return true se forem válidos; false caso contrário
     */
    public boolean isValidDados(String dados) {
        return !dados.isEmpty();
    }

    /**
     * Armazena os dados do formulário, introduzidos pelo utilizador (se forem
     * válidos).
     *
     * @param dados - daods do formulário, introduzidos pelo utilizador
     * @return true se forem válidos e, por tanto, armazenados com sucesso;
     * false caso contrário.
     */
    public boolean setFormularioDados(String dados) {
        boolean valido = false;
        if (isValidDados(dados)) {
            this.dados = dados;
            valido = true;
        }
        return valido;
    }

    public void RegistaCandADemo() {
        CandidaturaADemonstracao cand = new CandidaturaADemonstracao(dados);
        if(rcd.adiciona(cand)){
            ecd =  cand.getEstado();
            ecd.setCriada();
        }
    }
}