/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.dados;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.CandidaturaADemonstracao;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Demonstracao;
import lapr.project.model.Exposicao;
import lapr.project.model.Expositor;
import lapr.project.model.Local;
import lapr.project.model.Utilizador;
import lapr.project.registos.RegistoCandidaturaADemonstracoes;
import lapr.project.registos.RegistoDemonstracoes;
import lapr.project.registos.RegistoRecursos;
import lapr.project.utils.Data;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public class DadosInstanciados {

    private CentroExposicoes ce;
    private String email1;
    private Exposicao expo1;
    private Expositor representante1;
    private Utilizador user1;
    private List<CandidaturaADemonstracao> candidaturasAbertasRepresentante1 = new ArrayList();
    private char[] pass = {'p', 'a', 's', 's'};
    
    public DadosInstanciados() {
        email1 = "a@iol.com";
        ce = new CentroExposicoes();
        expo1 = inicializarNovaExposicao("titulo", "descricao", new Data(2016, 6, 20), new Data(2016, 6, 30), new Data(2016, 6, 13), new Data(2016, 6, 18), new Data(2016, 6, 19), new Local("local"), getCe());
        user1 = new Utilizador("user1name", "user1", getPass(), getEmail1());
        representante1 = new Expositor(getUser1());
    }

    public Exposicao inicializarNovaExposicao(String titulo, String descricao, Data dataInicio, Data dataFim, Data dataInicioSubCand, Data dataFimSubCand, Data dataFimDetecaoConflitos, Local local, CentroExposicoes ce) {
        Exposicao e = new Exposicao(titulo, descricao, dataInicio, dataFim, dataInicioSubCand, dataFimSubCand, dataFimDetecaoConflitos, local, ce);
        RegistoDemonstracoes rd = e.getRegistoDemonstracoes();
        Demonstracao d = new Demonstracao("descricao");
        RegistoRecursos rr = d.getRegistoRecursosNecessarios();
        rr.criarRecurso("recurso1");
        rr.criarRecurso("recurso2");
        rd.addDemo(d);
        RegistoCandidaturaADemonstracoes rcd = d.getRegistoCandidaturasADemonstracao();
        CandidaturaADemonstracao cd1Aberta = new CandidaturaADemonstracao("dados1", getEmail1());
        getCandidaturasAbertasRepresentante1().add(cd1Aberta);
        CandidaturaADemonstracao cd2Fechada = new CandidaturaADemonstracao("dados2", getEmail1());
        CandidaturaADemonstracao cd3Aberta = new CandidaturaADemonstracao("dados3", getEmail1());
        getCandidaturasAbertasRepresentante1().add(cd3Aberta);
        CandidaturaADemonstracao cd4 = new CandidaturaADemonstracao("dados4", "andgg");
        CandidaturaADemonstracao cd5 = new CandidaturaADemonstracao("dados5", "abcde");
        rcd.adiciona(cd1Aberta);
        rcd.adiciona(cd2Fechada);
        rcd.adiciona(cd3Aberta);
        rcd.adiciona(cd4);
        rcd.adiciona(cd5);
        return e;
    }

    /**
     * Cria um novo utilizador de testes
     * @return novo utilizador de testes
     */
    public Utilizador inicializarUtilizador(String nome, String username, char[]password,String email){
        Utilizador user = new Utilizador(nome, username, password, email);
        return user;
    }
    
    /**
     * 
     * @return candidaturas a demonstração do representante 1 
     */
    public List<CandidaturaADemonstracao>getCandsAbertasRepresentante1(){
        return getCandidaturasAbertasRepresentante1();
    }
    
    /**
     * @return the ce
     */
    public CentroExposicoes getCe() {
        return ce;
    }

    /**
     * @return the expo
     */
    public Exposicao getExpo1() {
        return expo1;
    }

    /**
     * @return the email1
     */
    public String getEmail1() {
        return email1;
    }

    /**
     * @return the representante1
     */
    public Expositor getRepresentante1() {
        return representante1;
    }

    /**
     * @return the user1
     */
    public Utilizador getUser1() {
        return user1;
    }

    /**
     * @return the candidaturasAbertasRepresentante1
     */
    public List<CandidaturaADemonstracao> getCandidaturasAbertasRepresentante1() {
        return candidaturasAbertasRepresentante1;
    }

    /**
     * @return the pass
     */
    public char[] getPass() {
        return pass;
    }

    
}