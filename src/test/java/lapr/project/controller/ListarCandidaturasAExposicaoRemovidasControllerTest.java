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
import lapr.project.registos.RegistoCandidaturasAExposicaoRemovidas;
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
public class ListarCandidaturasAExposicaoRemovidasControllerTest {
    
    private ListarCandidaturasAExposicaoRemovidasController instance;
    private CentroExposicoes ce;
    private RegistoCandidaturasAExposicaoRemovidas rcr;
    private RegistoExposicoes re;
    private Exposicao e;
    
    public ListarCandidaturasAExposicaoRemovidasControllerTest() {
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
        rcr = e.getRegistoCandidaturasAExposicaoRemovidas();
        instance = new ListarCandidaturasAExposicaoRemovidasController(ce);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getRegistoExposicoes method, of class 
 ListarCandidaturasAExposicaoRemovidasController.
     */
    @Test
    public void testGetRegistoExposicoes() {
        System.out.println("getRegistoExposicoes");
        instance.getRegistoExposicoes();
    }

    /**
     * Test of getListaExposicoesDoOrganizador method, of class 
 ListarCandidaturasAExposicaoRemovidasController.
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
 ListarCandidaturasAExposicaoRemovidasController.
     */
    @Test
    public void testSetExposicao() {
        System.out.println("setExposicao");
        Exposicao e = new Exposicao("a", "b", new Data(2015,05,03), new Data(2015,05,04),  new Data(2015,05,05),  new Data(2015,05,06),  new Data(2015,05,07),new Local ("l"), ce);
        instance.setExposicao(e);
    }

    /**
     * Test of getRegistoCandidaturasAExposicaoRemovidas method, of class 
 ListarCandidaturasAExposicaoRemovidasController.
     */
    @Test
    public void testGetRegistoCandidaturasRemovidas() {
        System.out.println("getRegistoCandidaturasRemovidas");
        instance.setExposicao(e);
        instance.getRegistoCandidaturasAExposicaoRemovidas();
    }

    /**
     * Test of getListaCandidaturasAExposicaoRemovidas method, of class 
 ListarCandidaturasAExposicaoRemovidasController.
     */
    @Test
    public void testGetListaCandidaturasRemovidas() {
        System.out.println("getListaCandidaturasRemovidas");
        instance.setExposicao(e);
        instance.getRegistoExposicoes();
        instance.getRegistoCandidaturasAExposicaoRemovidas();
        List<CandidaturaAExposicao> expResult = new ArrayList<CandidaturaAExposicao>();
        List<CandidaturaAExposicao> result = instance.getListaCandidaturasAExposicaoRemovidas();
        assertEquals(expResult, result);
    }
    
}
