/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.estados.Exposicao.EstadoExposicaoCompleta;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.model.Expositor;
import lapr.project.model.FAE;
import lapr.project.model.TipoConflito;
import lapr.project.model.Utilizador;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author guima
 */
public class DetetarConflitoControllerTest {
    
    public DetetarConflitoControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    private CentroExposicoes ce;
    private DetetarConflitoController instance;
    private Exposicao expo;
    
    @Before
    public void setUp() {
        ce = new CentroExposicoes();
        expo = new Exposicao(ce);
        expo.setEstado(new EstadoExposicaoCompleta(expo));
        Utilizador u1 = new Utilizador("u1", "p", new char[]{'a', 'b', 'C', '.', '2'}, "1@2.3");
        Utilizador u2 = new Utilizador("u2", "y", new char[]{'a', 'b', 'C', '.', '2'}, "2@2.3");
        Utilizador u3 = new Utilizador("u3", "z", new char[]{'a', 'b', 'C', '.', '2'}, "3@2.3");
        Utilizador u4 = new Utilizador("u4", "t", new char[]{'a', 'b', 'C', '.', '2'}, "4@2.3");
        Utilizador u5 = new Utilizador("u5", "s", new char[]{'a', 'b', 'C', '.', '2'}, "5@2.3");
        CandidaturaAExposicao cand1 = new CandidaturaAExposicao(new Expositor(u4));
        CandidaturaAExposicao cand2 = new CandidaturaAExposicao(new Expositor(u5));
        TipoConflito tc1 = new TipoConflito("tipo1");
        TipoConflito tc2 = new TipoConflito("tipo2");
        TipoConflito tc3 = new TipoConflito("tipo3");
        ce.getRegistoUtilizadores().getListaUtilizadores().add(u1);
        ce.getRegistoUtilizadores().getListaUtilizadores().add(u2);
        ce.getRegistoUtilizadores().getListaUtilizadores().add(u3);
        ce.getRegistoUtilizadores().getListaUtilizadores().add(u4);
        ce.getRegistoUtilizadores().getListaUtilizadores().add(u5);
        ce.getRegistoTiposConflitos().getListaTipoConflitos().add(tc1);
        ce.getRegistoTiposConflitos().getListaTipoConflitos().add(tc2);
        ce.getRegistoTiposConflitos().getListaTipoConflitos().add(tc3);
        expo.getRegistoFAE().getListaFAE().add(new FAE(u1));
        expo.getRegistoFAE().getListaFAE().add(new FAE(u2));
        expo.getRegistoFAE().getListaFAE().add(new FAE(u3));
        expo.getRegistoCandidaturasAExposicao().getListaCandidaturas().add(cand1);
        expo.getRegistoCandidaturasAExposicao().getListaCandidaturas().add(cand2);
        
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of detetaConflitos method, of class DetetarConflitoController.
     */
    @Test
    public void testDetetaConflitos() {
        System.out.println("detetaConflitos");
        Exposicao e = expo;
        instance.detetaConflitos(e);
    }
    
}
