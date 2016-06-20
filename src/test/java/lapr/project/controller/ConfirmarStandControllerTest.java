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
    private List<AtribuicaoStand> listAtrib;
    
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
        listAtrib = new ArrayList<AtribuicaoStand>();
        ce = new CentroExposicoes();
        e = new Exposicao(ce);
        re = ce.getRegistoExposicoes();
        ras = e.getRegistoAtribuicoesStands();
        instance = new ConfirmarStandController(ce);
        u = new Utilizador();
        decisao = true;
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
        List<AtribuicaoStand> expResult = new ArrayList<>();
        List<AtribuicaoStand> result = instance.getAtribuicao(email);
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
        instance.getAtribuicao(u.getEmail());
        decisao = true;
        instance.setDecisao(decisao);
    }

    
}
