/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.AtribuicaoStand;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.model.Expositor;
import lapr.project.model.Local;
import lapr.project.model.Stand;
import lapr.project.model.Utilizador;
import lapr.project.registos.RegistoAtribuicoesStands;
import lapr.project.registos.RegistoExposicoes;
import lapr.project.utils.Data;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ana
 */
public class ConfirmarStandControllerTest {
    
    private ConfirmarStandController instance;
    private CentroExposicoes  ce;
    private RegistoExposicoes re;
    private RegistoAtribuicoesStands ras;
    private boolean decisao;
    private AtribuicaoStand atribuicaoStand;
    private Exposicao e;   
    private Utilizador u;
    private Expositor expositor;
    
    public ConfirmarStandControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ce = new CentroExposicoes();
        e = new Exposicao(ce);
        re = ce.getRegistoExposicoes();
        ras = e.getRegistoAtribuicoesStands();
        instance = new ConfirmarStandController(ce);
        u = new Utilizador();
        expositor = new Expositor(u);
        decisao = true;
        atribuicaoStand = new AtribuicaoStand(new Stand("a", 2, "descricao"),new CandidaturaAExposicao(expositor),decisao);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getRegistoExposicoes method, of class 
     * ConfirmarStandController.
     */
    @Test
    public void testGetRegistoExposicoes() {
        System.out.println("getRegistoExposicoes");
        instance.getRegistoExposicoes();
    }

    /**
     * Test of getListaExposicoesDoRepresentante method, of class 
     * ConfirmarStandController.
     */
    @Test
    public void testGetListaExposicoesDoRepresentante() {
        System.out.println("getListaExposicoesDoRepresentante");
        instance.setExposicao(e);
        instance.getRegistoExposicoes();
        re.registaExposicao(e);
        List<Exposicao> expResult = new ArrayList<Exposicao>();
        List<Exposicao> result = instance.getListaExposicoesDoRepresentante("");
        assertEquals(expResult, result);
    }

    /**
     * Test of setExposicao method, of class ConfirmarStandController.
     */
    @Test
    public void testSetExposicao() {
        System.out.println("setExposicao");
        Exposicao e = new Exposicao("a", "b", new Data(2017,06,10), new Data(2017,06,11), new Data(2017,06,12), new Data(2017,06,13), new Data(2017,06,14),new Local ("l"), ce);
        instance.setExposicao(e);
        
    }

    /**
     * Test of getRegistoAtribuicoesStands method, of class 
     * ConfirmarStandController.
     */
    @Test
    public void testGetRegistoAtribuicoesStands() {
        System.out.println("getRegistoAtribuicoesStands");
        instance.setExposicao(e);
        instance.getRegistoAtribuicoesStands();
    }

    /**
     * Test of getAtribuicao method, of class 
     * ConfirmarStandController.
     */
    @Test
    public void testGetAtribuicao() {
        System.out.println("getAtribuicao");
        String email = "";
        instance.setExposicao(e);
        instance.getRegistoAtribuicoesStands();
        AtribuicaoStand expResult = atribuicaoStand;
        AtribuicaoStand result = instance.getAtribuicao(email, new CandidaturaAExposicao(new Expositor(u)));
        assertEquals(expResult, result);
    }
    
    /**
     * Test of setDecisao method, of class ConfirmarStandController.
     */
    @Test
    public void testSetDecisao() {
        /**
         * Neste método, a atribuição não é inicializada, daí o erro
         */
        System.out.println("setDecisao");
        
        atribuicaoStand = new AtribuicaoStand(new Stand("stand", 10, "descricao"),
                new CandidaturaAExposicao(new Expositor(u)),
                true);
        e.getRegistoAtribuicoesStands().getListaAtribuicoesStand().add(atribuicaoStand);
        instance.getRegistoExposicoes();
        instance.getListaExposicoesDoRepresentante(u.getUsername());
        instance.setExposicao(e);
        instance.getRegistoAtribuicoesStands();
        instance.getAtribuicao(u.getEmail(), new CandidaturaAExposicao(new Expositor(u)));
        decisao = true;
        instance.setDecisao(decisao);
    }

    /**
     * Test of getRegistoCandidaturasAExposicao method, of class ConfirmarStandController.
     */
    @Test
    public void testGetRegistoCandidaturasAExposicao() {
        System.out.println("getRegistoCandidaturasAExposicao");
        ConfirmarStandController instance = null;
        instance.getRegistoCandidaturasAExposicao();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaCandidaturasDoRepresentante method, of class ConfirmarStandController.
     */
    @Test
    public void testGetListaCandidaturasDoRepresentante() {
        System.out.println("getListaCandidaturasDoRepresentante");
        String email = "";
        ConfirmarStandController instance = null;
        List<CandidaturaAExposicao> expResult = null;
        List<CandidaturaAExposicao> result = instance.getListaCandidaturasDoRepresentante(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCandidaturaAExposicao method, of class ConfirmarStandController.
     */
    @Test
    public void testSetCandidaturaAExposicao() {
        System.out.println("setCandidaturaAExposicao");
        CandidaturaAExposicao candidatura = null;
        ConfirmarStandController instance = null;
        instance.setCandidaturaAExposicao(candidatura);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
}
