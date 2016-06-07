/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import lapr.project.estados.*;
import lapr.project.model.*;
import lapr.project.registos.*;

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

    public void getRegistoExposicoes() {
        this.re = centroExpo.getRegistoExposicoes();

    }

    public ArrayList<Exposicao> getListaExposicoesDoOrganizador() {
        //passar parametro username
        return re.getlistaExposicoesDoOrganizador();
    }

    public void setExposicao(Exposicao e) {
        this.exposicao = e;
    }

    public void getRegistoRecursos() {
        this.rr = centroExpo.getRegistoRecursos();
    }

    public void novaDemonstracao(String descricaoIntroduzidaPeloUtilizador) {
        this.demoCriada = rd.novaDemonstracao(descricaoIntroduzidaPeloUtilizador);
    }

    public void getRegistoDemonstracoes() {
        this.rd = exposicao.getRegistoDemonstracoes();
    }

    public ArrayList<Recurso> getListaDeRecursos() {
        return rr.getListaDeRecursos();
    }

    public void setRecurso(Recurso rec) {
        this.rrr.setRecurso(rec);
    }

    public void getRegistoRecursosDemo() {
        this.rrr = this.demoCriada.getRegistoRecursos();
    }

    public void confirma() {
        rd.confirma(this.demoCriada);
    }

    public void setEstado() {

        estado = this.exposicao.getEstado();
        if (estado instanceof EstadoExposicaoFAEDefinidosSemDemos) {
            estadoExposicaoDemosDef.setEstadoCompleta();
        } else if (estado instanceof EstadoExposicaoCriada) {
            estadoExposicaoCriada.setEstadoDemosDefinidasSemFAE();

        }
    }

}
