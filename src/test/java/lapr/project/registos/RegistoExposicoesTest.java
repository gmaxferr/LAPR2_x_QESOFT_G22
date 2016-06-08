/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Exposicao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ricardo Catalao
 */
public class RegistoExposicoesTest {
    
    public RegistoExposicoesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getListaExposicoes method, of class RegistoExposicoes.
     */
    @Test
    public void testGetListaExposicoes() {
        System.out.println("getListaExposicoes");
        RegistoExposicoes instance = new RegistoExposicoes();
        List<Exposicao> expResult = null;
        List<Exposicao> result = instance.getListaExposicoes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of novaExposicao method, of class RegistoExposicoes.
     */
    @Test
    public void testNovaExposicao() {
        System.out.println("novaExposicao");
        RegistoExposicoes instance = new RegistoExposicoes();
        Exposicao expResult = null;
        Exposicao result = instance.novaExposicao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registaExposicao method, of class RegistoExposicoes.
     */
    @Test
    public void testRegistaExposicao() {
        System.out.println("registaExposicao");
        Exposicao e = null;
        RegistoExposicoes instance = new RegistoExposicoes();
        boolean expResult = false;
        boolean result = instance.registaExposicao(e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validaExposicao method, of class RegistoExposicoes.
     */
    @Test
    public void testValidaExposicao() {
        System.out.println("validaExposicao");
        Exposicao e = null;
        RegistoExposicoes instance = new RegistoExposicoes();
        boolean expResult = false;
        boolean result = instance.validaExposicao(e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaExposicoesValidas method, of class RegistoExposicoes.
     */
    @Test
    public void testGetListaExposicoesValidas() {
        System.out.println("getListaExposicoesValidas");
        RegistoExposicoes instance = new RegistoExposicoes();
        ArrayList<Exposicao> expResult = null;
        ArrayList<Exposicao> result = instance.getListaExposicoesValidas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaExposicoesEstadoCandidaturasAbertas method, of class RegistoExposicoes.
     */
    @Test
    public void testGetListaExposicoesEstadoCandidaturasAbertas() {
        System.out.println("getListaExposicoesEstadoCandidaturasAbertas");
        RegistoExposicoes instance = new RegistoExposicoes();
        ArrayList<Exposicao> expResult = null;
        ArrayList<Exposicao> result = instance.getListaExposicoesEstadoCandidaturasAbertas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getlistaExposicoesDoOrganizadorEstadoCriadaOuDemosDefinidasSemFAE method, of class RegistoExposicoes.
     */
    @Test
    public void testGetlistaExposicoesDoOrganizadorEstadoCriadaOuDemosDefinidasSemFAE() {
        System.out.println("getlistaExposicoesDoOrganizadorEstadoCriadaOuDemosDefinidasSemFAE");
        String usernameOrganizador = "";
        RegistoExposicoes instance = new RegistoExposicoes();
        ArrayList<Exposicao> expResult = null;
        ArrayList<Exposicao> result = instance.getlistaExposicoesDoOrganizadorEstadoCriadaOuDemosDefinidasSemFAE(usernameOrganizador);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removerExposiçõesRepetidas method, of class RegistoExposicoes.
     */
    @Test
    public void testRemoverExposiçõesRepetidas() {
        System.out.println("removerExposi\u00e7\u00f5esRepetidas");
        ArrayList array = null;
        RegistoExposicoes instance = new RegistoExposicoes();
        instance.removerExposiçõesRepetidas(array);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaExposicoesComCanditaturasAceitesRepresentante method, of class RegistoExposicoes.
     */
    @Test
    public void testGetListaExposicoesComCanditaturasAceitesRepresentante() {
        System.out.println("getListaExposicoesComCanditaturasAceitesRepresentante");
        String username = "";
        RegistoExposicoes instance = new RegistoExposicoes();
        List<Exposicao> expResult = null;
        List<Exposicao> result = instance.getListaExposicoesComCanditaturasAceitesRepresentante(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExposicoesDoRepresentante method, of class RegistoExposicoes.
     */
    @Test
    public void testGetExposicoesDoRepresentante() {
        System.out.println("getExposicoesDoRepresentante");
        String username = "";
        RegistoExposicoes instance = new RegistoExposicoes();
        List<Exposicao> expResult = null;
        List<Exposicao> result = instance.getExposicoesDoRepresentante(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaExposicoesEstadoCandidaturasAvaliadas method, of class RegistoExposicoes.
     */
    @Test
    public void testGetListaExposicoesEstadoCandidaturasAvaliadas() {
        System.out.println("getListaExposicoesEstadoCandidaturasAvaliadas");
        RegistoExposicoes instance = new RegistoExposicoes();
        ArrayList<Exposicao> expResult = null;
        ArrayList<Exposicao> result = instance.getListaExposicoesEstadoCandidaturasAvaliadas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getlistaExposicoesEstadoCandidaturasAbertas method, of class RegistoExposicoes.
     */
    @Test
    public void testGetlistaExposicoesEstadoCandidaturasAbertas() {
        System.out.println("getlistaExposicoesEstadoCandidaturasAbertas");
        RegistoExposicoes instance = new RegistoExposicoes();
        List<Exposicao> expResult = null;
        List<Exposicao> result = instance.getlistaExposicoesEstadoCandidaturasAbertas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaExposicoesEstadoCandidaturasAtribuidasDoFAE method, of class RegistoExposicoes.
     */
    @Test
    public void testGetListaExposicoesEstadoCandidaturasAtribuidasDoFAE() {
        System.out.println("getListaExposicoesEstadoCandidaturasAtribuidasDoFAE");
        String usernameFAE = "";
        RegistoExposicoes instance = new RegistoExposicoes();
        ArrayList<Exposicao> expResult = null;
        ArrayList<Exposicao> result = instance.getListaExposicoesEstadoCandidaturasAtribuidasDoFAE(usernameFAE);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getlistaExposicoesDoOrganizadorComDemos method, of class RegistoExposicoes.
     */
    @Test
    public void testGetlistaExposicoesDoOrganizadorComDemos() {
        System.out.println("getlistaExposicoesDoOrganizadorComDemos");
        String usernameOrganizador = "";
        RegistoExposicoes instance = new RegistoExposicoes();
        List<Exposicao> expResult = null;
        List<Exposicao> result = instance.getlistaExposicoesDoOrganizadorComDemos(usernameOrganizador);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFaeExpos method, of class RegistoExposicoes.
     */
    @Test
    public void testGetFaeExpos() {
        System.out.println("getFaeExpos");
        String usernameFae = "";
        RegistoExposicoes instance = new RegistoExposicoes();
        List<Exposicao> expResult = null;
        List<Exposicao> result = instance.getFaeExpos(usernameFae);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaExposicoesEstadoCandidaturasDecididas method, of class RegistoExposicoes.
     */
    @Test
    public void testGetListaExposicoesEstadoCandidaturasDecididas() {
        System.out.println("getListaExposicoesEstadoCandidaturasDecididas");
        RegistoExposicoes instance = new RegistoExposicoes();
        List<Exposicao> expResult = null;
        List<Exposicao> result = instance.getListaExposicoesEstadoCandidaturasDecididas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
