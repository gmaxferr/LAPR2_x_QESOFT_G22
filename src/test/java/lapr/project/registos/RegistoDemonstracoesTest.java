/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.registos;

import java.util.List;
import lapr.project.model.Demonstracao;
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
public class RegistoDemonstracoesTest {
    
    public RegistoDemonstracoesTest() {
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
     * Test of getListaDemonstracoes method, of class RegistoDemonstracoes.
     */
    @Test
    public void testGetListaDemonstracoes() {
        System.out.println("getListaDemonstracoes");
        RegistoDemonstracoes instance = new RegistoDemonstracoes();
        List<Demonstracao> expResult = null;
        List<Demonstracao> result = instance.getListaDemonstracoes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of adicionaDemonstracaoACandidatura method, of class RegistoDemonstracoes.
     */
    @Test
    public void testAdicionaDemonstracao() {
        System.out.println("adicionaDemonstracao");
        Demonstracao demonstracao = null;
        RegistoDemonstracoes instance = new RegistoDemonstracoes();
        instance.adicionaDemonstracaoACandidatura(demonstracao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of novaDemonstracao method, of class RegistoDemonstracoes.
     */
    @Test
    public void testNovaDemonstracao() {
        System.out.println("novaDemonstracao");
        String descricaoIntroduzidaPeloUtilizador = "";
        RegistoDemonstracoes instance = new RegistoDemonstracoes();
        Demonstracao expResult = null;
        Demonstracao result = instance.novaDemonstracao(descricaoIntroduzidaPeloUtilizador);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaDemonstracoes method, of class RegistoDemonstracoes.
     */
    @Test
    public void testSetListaDemonstracoes() {
        System.out.println("setListaDemonstracoes");
        List<Demonstracao> listaDemonstracoes = null;
        RegistoDemonstracoes instance = new RegistoDemonstracoes();
        instance.setListaDemonstracoes(listaDemonstracoes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDemonstracoesPendentes method, of class RegistoDemonstracoes.
     */
    @Test
    public void testGetDemonstracoesPendentes() {
        System.out.println("getDemonstracoesPendentes");
        RegistoDemonstracoes instance = new RegistoDemonstracoes();
        List<Demonstracao> expResult = null;
        List<Demonstracao> result = instance.getDemonstracoesPendentes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
