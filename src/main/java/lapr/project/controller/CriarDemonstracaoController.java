/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;

/**
 *
 * @author osori
 */
public class CriarDemonstracaoController {

    private RegistoExposicoes re;
    private RegistoRecursos rr;
    private RegistoDemonstracoes rd;
    private CentroExposicoes centroExpo;
    private Exposicao exposicao;
    private Demonstracao demoCriada;
    private RegistoRecursos rrr;
    private EstadoExposicao estado;
    private EstadoExposicaoCriada estadoExposicaoCriada;
    private EstadoExposicaoDemosDefinidasSemFAE estadoExposicaoDemosDef;
    
    void getRegistoExposicoes() {
        this.re = centroExpo.getRegistoExposicoes();

    }

    ArrayList<Exposicao> getListaExposicoesDoOrganizador() {
        return re.getlistaExposicoesDoOrganizador();
    }

    void setExposicao(Exposicao e) {
        this.exposicao = e;
    }

    void getRegistoRecursos() {
        this.rr = centroExpo.getRegistoRecursos();
    }

    void novaDemonstracao(String descricaoIntroduzidaPeloUtilizador) {
        this.demoCriada = rd.novaDemonstracao(descricaoIntroduzidaPeloUtilizador);
    }

    void getRegistoDemonstracoes() {
        this.rd = exposicao.getRegistoDemonstracoes();
    }

    ArrayList<Recurso> getListaDeRecursos() {
        return rr.getListaDeRecursos();
    }

    void setRecurso(Recurso rec) {
        this.rrr.setRecurso(rec);
    }

    void getRegistoRecursosDemo() {
        this.rrr = this.demoCriada.getRegistoRecursosDemo();
    }

    void confirma() {
        rd.confirma(this.demoCriada);
    }
    
    public void setEstado(){

    estado = this.exposicao.getEstadoExposicao();
    if(estado instanceof EstadoExposicaoFAEDefinidosSemDemos){
        estadoExposicaoDemosDef.setEstadoCompleta();
    } else if (estado instanceof EstadoExposicaoCriada){ 
        estadoExposicaoCriada.setEstadoDemosDefinidasSemFAE();  
    
    }
    }

}
