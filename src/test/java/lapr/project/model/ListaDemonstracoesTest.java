/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author guima
 */
public class ListaDemonstracoesTest {
    
    public ListaDemonstracoesTest() {
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
     * Test of getSize method, of class ListaDemonstracoes.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        ListaDemonstracoes instance = new ListaDemonstracoes();
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaDemonstracoesAdicionadas method, of class ListaDemonstracoes.
     */
    @Test
    public void testGetListaDemonstracoesAdicionadas() {
        System.out.println("getListaDemonstracoesAdicionadas");
        ListaDemonstracoes instance = new ListaDemonstracoes();
        List<Demonstracao> expResult = null;
        List<Demonstracao> result = instance.getListaDemonstracoesAdicionadas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDemonstracaoAt method, of class ListaDemonstracoes.
     */
    @Test
    public void testGetDemonstracaoAt() {
        System.out.println("getDemonstracaoAt");
        int index = 0;
        ListaDemonstracoes instance = new ListaDemonstracoes();
        Demonstracao expResult = null;
        Demonstracao result = instance.getDemonstracaoAt(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of adicionarDemonstracao method, of class ListaDemonstracoes.
     */
    @Test
    public void testAdicionarDemonstracao() {
        System.out.println("adicionarDemonstracao");
        Demonstracao demonstracao = null;
        ListaDemonstracoes instance = new ListaDemonstracoes();
        boolean expResult = false;
        boolean result = instance.adicionarDemonstracao(demonstracao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeDemonstracao method, of class ListaDemonstracoes.
     */
    @Test
    public void testRemoveDemonstracao() {
        System.out.println("removeDemonstracao");
        String codigoIdentificacao = "";
        ListaDemonstracoes instance = new ListaDemonstracoes();
        int expResult = 0;
        int result = instance.removeDemonstracao(codigoIdentificacao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of localizarDemonstracaoParaRemover method, of class ListaDemonstracoes.
     */
    @Test
    public void testLocalizarDemonstracaoParaRemover() {
        System.out.println("localizarDemonstracaoParaRemover");
        String codigoIdentificacao = "";
        ListaDemonstracoes instance = new ListaDemonstracoes();
        int expResult = 0;
        int result = instance.localizarDemonstracaoParaRemover(codigoIdentificacao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
