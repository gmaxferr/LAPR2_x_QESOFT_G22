/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.model.Local;
import lapr.project.registos.RegistoCandidaturasRemovidas;
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
public class ListarCandidaturasRemovidasControllerTest {
    
    private ListarCandidaturasRemovidasController instance;
    private CentroExposicoes ce;
    private RegistoCandidaturasRemovidas rcr;
    private RegistoExposicoes re;
    private Exposicao e;
    
    public ListarCandidaturasRemovidasControllerTest() {
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
        rcr = e.getRegistoCandidaturasRemovidas();
        instance = new ListarCandidaturasRemovidasController(ce);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getRegistoExposicoes method, of class 
     * ListarCandidaturasRemovidasController.
     */
    @Test
    public void testGetRegistoExposicoes() {
        System.out.println("getRegistoExposicoes");
        instance.getRegistoExposicoes();
    }

    /**
     * Test of getListaExposicoesDoOrganizador method, of class 
     * ListarCandidaturasRemovidasController.
     */
    @Test
    public void testGetListaExposicoesDoOrganizador() {
        System.out.println("getListaExposicoesDoOrganizador");
        instance.setExposicao(e);
        instance.getRegistoExposicoes();
        re.registaExposicao(e);
        List<Exposicao> expResult = new ArrayList<Exposicao>();
        List<Exposicao> result = instance.getListaExposicoesDoOrganizador("");
        assertEquals(expResult, result);
    }

    /**
     * Test of setExposicao method, of class 
     * ListarCandidaturasRemovidasController.
     */
    @Test
    public void testSetExposicao() {
        System.out.println("setExposicao");
        Exposicao e = new Exposicao("a", "b", new Data("16/06/10"), new Data("16/06/10"), new Data("16/06/10"), new Data("16/06/10"), new Data("16/06/10"),new Local ("l"), ce);
        instance.setExposicao(e);
    }

    /**
     * Test of getRegistoCandidaturasRemovidas method, of class 
     * ListarCandidaturasRemovidasController.
     */
    @Test
    public void testGetRegistoCandidaturasRemovidas() {
        System.out.println("getRegistoCandidaturasRemovidas");
        instance.setExposicao(e);
        instance.getRegistoCandidaturasRemovidas();
    }

    /**
     * Test of getListaCandidaturasRemovidas method, of class 
     * ListarCandidaturasRemovidasController.
     */
    @Test
    public void testGetListaCandidaturasRemovidas() {
        System.out.println("getListaCandidaturasRemovidas");
        instance.setExposicao(e);
        instance.getRegistoExposicoes();
        instance.getRegistoCandidaturasRemovidas();
        List<CandidaturaAExposicao> expResult = new ArrayList<CandidaturaAExposicao>();
        List<CandidaturaAExposicao> result = instance.getListaCandidaturasRemovidas();
        assertEquals(expResult, result);
    }
    
}
